package org.xtext.java.validation

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.xtext.validation.Check
import org.xtext.java.java.Arg_List
import org.xtext.java.java.Class_declaration
import org.xtext.java.java.Compilation_unit
import org.xtext.java.java.Expression
import org.xtext.java.java.Expression_aux
import org.xtext.java.java.Field_declaration
import org.xtext.java.java.Interface_declaration
import org.xtext.java.java.JavaPackage
import org.xtext.java.java.Literal_Expression
import org.xtext.java.java.Method_call
import org.xtext.java.java.Method_declaration
import org.xtext.java.java.Parameter
import org.xtext.java.java.Parameter_list
import org.xtext.java.java.Parameter_list_method_call
import org.xtext.java.java.Return_Statement
import org.xtext.java.java.Statement
import org.xtext.java.java.Type_declaration
import org.xtext.java.java.Variable_declaration
import org.xtext.java.java.Variable_declarator
import org.xtext.java.java.For_Statement

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class JavaValidator extends AbstractJavaValidator {

	public List<String> interfaces = new ArrayList<String>();

	public static Map<String, List<String>> classeExtends = new HashMap<String, List<String>>();

	public static Map<String, List<String>> classeImplements = new HashMap<String, List<String>>();

	public static Map<String, List<Method_declaration>> classeMetodos = new HashMap<String, List<Method_declaration>>();

	public static Map<String, List<Variable_declaration>> classeAtributos = new HashMap<String, List<Variable_declaration>>();

	public Method_declaration metodoSendoValidado;

	@Check
	def instanciaMapas(Compilation_unit cpu) {
		interfaces = new ArrayList<String>();
		classeExtends = new HashMap<String, List<String>>();
		classeImplements = new HashMap<String, List<String>>();
		classeMetodos = new HashMap<String, List<Method_declaration>>();
		classeAtributos = new HashMap<String, List<Variable_declaration>>();
		adicionaTipoString();
		for (Type_declaration td : cpu.type_declarations) {
			mapeiaClasses(td);
		}
		for (Type_declaration td : cpu.type_declarations) {
			if (td.name != null) {
				if (td.name instanceof Class_declaration) {
					var Class_declaration cd = td.name as Class_declaration;
					validarExtends(cd);
					mapeiaAtributos(cd);
					mapeiaMetodos(cd);
				}
			}
		}
	}

	def adicionaTipoString() {
		classeMetodos.put("String", new ArrayList<Method_declaration>());
		classeAtributos.put("String", new ArrayList<Variable_declaration>());
	}

	def mapeiaMetodos(Class_declaration cd) {
		for (Field_declaration field : cd.fields) {
			if (field.name instanceof Method_declaration) {
				var Method_declaration md = field.name as Method_declaration;
				if (hasNomeMetodoNaClasse(cd.className, md.name)) {
					error("Método " + md.name + " já existe na classe.", md,
						JavaPackage.Literals.METHOD_DECLARATION__NAME);
				}
				classeMetodos.get(cd.className).add(md);
			}
		}
		for (Method_declaration metodo : classeMetodos.get(cd.className)) {
			validarMetodo(metodo, cd.className);
		}
	}

	def validarMetodo(Method_declaration md, String nomeClasse) {
		metodoSendoValidado = md;
		var List<Variable_declaration> vds = new ArrayList<Variable_declaration>();
		if (md.statement == null) {
			return;
		}
		for (Statement st : md.statement.statements) {
			if (st.variable != null) {
				validaAtributoDoMetodo(vds, st.variable, md);
				vds.add(st.variable);
				if (st.variable.name != null) {
					validaAtributoComExpressaoAritmetica(vds, st.variable.name, nomeClasse);
				} else if (st.variable.names != null && st.variable.names.length != 0) {
					for (Variable_declarator declarator : st.variable.names) {
						validaAtributoComExpressaoAritmetica(vds, declarator, nomeClasse);
					}
				}
			} else if (st.forStatement != null) {
				validarForStatements(vds, nomeClasse, st.forStatement);
			} else if (st.variableDeclarator != null) {
				validaAtributoComExpressaoAritmetica(vds, st.variableDeclarator, nomeClasse);
			} else if (st.expressionx != null) {
				if (st.expressionx.name != null) {
					var Method_declaration metodo = buscaMetodoClasse(nomeClasse, st.expressionx.name);
					if (metodo != null) {
						validaChamadaMetodo(vds, nomeClasse, st.expressionx, metodo.type.name);
					} else {
						error("Identificador inválido. Insira um comando válido.", st,
							JavaPackage.Literals.STATEMENT__EXPRESSIONX);
					}
				} else {
					error("Insira uma declaração de variável ou método para completar a expressão.", st,
						JavaPackage.Literals.STATEMENT__EXPRESSIONX);
				}
			}
		}
		validaParametrosMethodDeclaration(md);
		validaRetornoVoidMetodo(md);
		validaRetornoMetodoComFuncao(md, nomeClasse, vds);
	}

	def validaAtributoComExpressaoAritmetica(List<Variable_declaration> vds, Variable_declarator declarator,
		String className) {
		if (declarator.initializer != null && declarator.initializer.expression != null) {
			var Expression exp = declarator.initializer.expression;
			var Expression_aux aux = null;
			var tipoVariavel = buscaTipoVariavel(vds, declarator.name, className);
			if (tipoVariavel == null) {
				error("Variável " + declarator.name + " não foi declarada.", declarator,
					JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
			} else {
				if ((exp.logicalExpression != null || exp.aux.testingSign != null) && !tipoVariavel.equals("boolean")) {
					error("Não é posível converter do tipo boolean para " + tipoVariavel, exp,
						JavaPackage.Literals.EXPRESSION__NAME);
					return;
				} else if (exp.name != null && !tipoVariavel.equals("boolean")) {
					if ((isNomeBooleano(exp.name) || exp.logicalExpression != null)
						&& !tipoVariavel.equals("boolean")) {
						error("Não é possível converter do tipo boolean para " + tipoVariavel, exp,
							JavaPackage.Literals.EXPRESSION__NAME);
						return;
					}
					var String tipo = buscaTipoVariavel(vds, exp.name, className);
					var Method_declaration method = buscaMetodoClasse(className, exp.name);
					if (tipo == null && method == null && !tipoVariavel.equals("boolean")) {
						error("Identificador inválido.", exp, JavaPackage.Literals.EXPRESSION__NAME);
						return;
					} else if (method != null) {
						validaChamadaMetodo(vds, className, exp, tipoVariavel);
						if (!isNomeClassIgualOuFilha(method.type.name, tipoVariavel)) {
							error("Não é possível converter de " + method.type.name + " para " + tipoVariavel, exp,
								JavaPackage.Literals.EXPRESSION__NAME);
							return;
						}
					} else if (!isNomeClassIgualOuFilha(tipo, tipoVariavel)) {
						error("Não é possível converter do tipo " + tipo + " para " + tipoVariavel, exp,
							JavaPackage.Literals.EXPRESSION__NAME);
						return;
					}
				}
			}
			if (tipoVariavel != 'int' && tipoVariavel != 'float') {
				if (tipoVariavel != 'char' && tipoVariavel != 'String' && exp.literalExpression != null
					&& exp.aux.testingSign == null) {
					error("Valor inválido para o tipo " + tipoVariavel, exp,
						JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
				} else if (exp.aux != null &&
					(exp.aux.sgin != null || (exp.aux.numericSign != null && tipoVariavel != "String"))) {
					error("Identificadores inválidos para o tipo " + tipoVariavel, exp,
						JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
				}
			}
			if (tipoVariavel == "String") {
				while (exp != null) {
					if (exp.literalExpression == null && exp.name == null) {
						error("Valor inválido para o tipo " + tipoVariavel, exp, JavaPackage.Literals.EXPRESSION__AUX);
					} else if (exp.name != null &&
						(buscaTipoVariavel(vds, exp.name, className) != "String" &&
							!validaChamadaMetodo(vds, className, exp, "String"))) {
							error("Variável " + exp.name + " deve ser do tipo String.", exp,
								JavaPackage.Literals.EXPRESSION__NAME);
						} else if (exp.literalExpression != null && exp.literalExpression.string == null) {
							error("Expressão inválida para o tipo " + tipoVariavel, exp,
								JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
						}
						if (aux != null) {
							if ((aux.numericSign != null && !aux.numericSign.equals("+")) ||
								(aux.stringSign != null && aux.stringSign.equals("+=")) ||
								(aux.stringSign == null && aux.numericSign == null)) {
								error("Expressão inválida para o tipo " + tipoVariavel, exp,
									JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
							}
						}
						aux = exp.aux;
						exp = aux.exp2;
					}
				} else if (tipoVariavel == "boolean") {
					// validar se é expressão relacional
					if (exp.logicalExpression == null && exp.name != "true" && exp.name != "!true" &&
						exp.name != "false" && exp.name != "!false" && exp.aux.testingSign == null) {
						error("Valor inválido para o tipo " + tipoVariavel, exp, JavaPackage.Literals.EXPRESSION__NAME);
					} else if (exp.aux.testingSign != null) {
						aux = exp.aux;
						if (exp.logicalExpression != null) {
							error("Não é possível converter do tipo boolean para int", exp,
								JavaPackage.Literals.EXPRESSION__NAME);
							return;
						}
						if (exp.literalExpression == null && exp.name != null) {
							if (isNomeBooleano(exp.name)) {
								error("Não é possível converter do tipo boolean para int", exp,
									JavaPackage.Literals.EXPRESSION__NAME);
								return;
							}
							var String tipo = buscaTipoVariavel(vds, exp.name, className);
							var Method_declaration metodo = buscaMetodoClasse(className, exp.name);
							if (tipo == null && metodo == null) {
								error("Identificador inválido", exp, JavaPackage.Literals.EXPRESSION__NAME);
							} else if (metodo != null) {
								validaChamadaMetodo(vds, className, exp, "int");
								if (!metodo.type.name.equals("int")) {
									error("Método inválido", exp, JavaPackage.Literals.EXPRESSION__NAME);
								}
							} else if (!"int".equals(tipo)) {
								error("Variável " + exp.name + " deve ser do tipo int", exp,
									JavaPackage.Literals.EXPRESSION__NAME);
							}
						}
						if (exp.literalExpression != null &&
							(exp.literalExpression.exp2 != null || exp.literalExpression.string != null ||
								exp.literalExpression.char != null)) {
								error("Os valores devem ser do tipo int", exp,
									JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
						}
						if (aux.exp1.literalExpression == null && aux.exp1.name != null) {
							if (isNomeBooleano(aux.exp1.name)) {
								error("Não é possível converter do tipo boolean para int", aux.exp1,
									JavaPackage.Literals.EXPRESSION__NAME);
								return;
							}
							var String tipo = buscaTipoVariavel(vds, aux.exp1.name, className);
							var Method_declaration metodo = buscaMetodoClasse(className, aux.exp1.name);
							if (tipo == null && metodo == null) {
								error("Identificador inválido", aux.exp1, JavaPackage.Literals.EXPRESSION__NAME);
							} else if (metodo != null) {
								validaChamadaMetodo(vds, className, aux.exp1, "int");
								if (!metodo.type.name.equals("int")) {
									error("Método inválido", aux.exp1, JavaPackage.Literals.EXPRESSION__NAME);
								}
							} else if (!"int".equals(tipo)) {
								error("Variável " + aux.exp1.name + " deve ser do tipo int", aux.exp1,
									JavaPackage.Literals.EXPRESSION__NAME);
							}
						}
						if (aux.exp1.literalExpression != null &&
							(aux.exp1.literalExpression.exp2 != null || aux.exp1.literalExpression.string != null ||
								aux.exp1.literalExpression.char != null)) {
								error("Os valores devem ser do tipo int", aux.exp1,
									JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
						}
						if (aux.exp1.aux.logicalSign != null || aux.exp1.aux.testingSign != null 
							|| aux.exp1.aux.numericSign != null) {
							error("Expressão relacional inválida", declarator.initializer,
									JavaPackage.Literals.VARIABLE_INITIALIZER__EXPRESSION);
						}
					}
				} else if (tipoVariavel == 'int') {
					while (exp != null) {
						var boolean validouMetodo = false;
						if (exp.logicalExpression != null) {
							error("Não é possível converter do tipo boolean para int", exp,
								JavaPackage.Literals.EXPRESSION__NAME);
							return;
						}
						if (exp.literalExpression == null && exp.name != null) {
							if (isNomeBooleano(exp.name)) {
								error("Não é possível converter do tipo boolean para int", exp,
									JavaPackage.Literals.EXPRESSION__NAME);
								return;
							}
							var String tipo = buscaTipoVariavel(vds, exp.name, className);
							var Method_declaration metodo = buscaMetodoClasse(className, exp.name);
							if (tipo == null && metodo == null) {
								error("Identificador inválido", exp, JavaPackage.Literals.EXPRESSION__NAME);
							} else if (metodo != null) {
								validaChamadaMetodo(vds, className, exp, "int");
								if (!metodo.type.name.equals("int")) {
									error("Método inválido", exp, JavaPackage.Literals.EXPRESSION__NAME);
								}
								validouMetodo = true;
							} else if (!"int".equals(tipo)) {
								error("Variável " + exp.name + " deve ser do tipo int", exp,
									JavaPackage.Literals.EXPRESSION__NAME);
							}
						}
						if (exp.literalExpression != null &&
							(exp.literalExpression.exp2 != null || exp.literalExpression.string != null ||
								exp.literalExpression.char != null)) {
								error("Os valores devem ser do tipo int", exp,
									JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
							}
							if (aux != null) {
								if (aux.numericSign == null) {
									error("Operação aritmética inválida.", exp,
										JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
								}
							}
							if (validouMetodo) {
								exp = exp.aux.aux.exp2;
							} else {
								aux = exp.aux;
								exp = exp.aux.exp2;
							}
						}
					}
				}
			}
			
			def boolean validaChamadaMetodo(List<Variable_declaration> vds, String nomeClasse, Expression exp,
				String tipo) {
				if (exp.aux != null && exp.aux.argList != null) {
					var Method_declaration md = buscaMetodoClasse(nomeClasse, exp.name);
					if (md == null) {
						error("Método " + exp.name + " não existe", exp, JavaPackage.Literals.EXPRESSION__NAME);
						return false;
					}
					if (!isNomeClassIgualOuFilha(md.type.name, tipo)) {
						error("Método " + md.name + " deve retornar um " + tipo, exp,
							JavaPackage.Literals.EXPRESSION__NAME);
						return false;
					}
					var List<String> tiposMetodo = getTiposParametrosDoMetodo(md);
					var List<String> tiposCall = new ArrayList<String>();
					if (exp.aux.argList != null) {
						var Arg_List arg = exp.aux.argList;
						var Expression expression = arg.expression;
						while (expression != null) {
							var String tipoExp = buscaTipoExpressao(expression, vds, nomeClasse, tipo);
							if (tipoExp == null) {
								return false;
							}
							expression = expression.aux.expressionComma;
							tiposCall.add(tipoExp);
						}
					}
					if (tiposMetodo.length != tiposCall.length) {
						error("Os parâmetros " + tiposCall.toString + " não são compatíveis com " +
							tiposMetodo.toString, exp.aux, JavaPackage.Literals.EXPRESSION_AUX__ARG_LIST);
						return false;
					}
					for (var int i = 0; i < tiposMetodo.length; i++) {
						if (!tiposMetodo.get(i).equals(tiposCall.get(i)) &&
							!isClasseFilha(tiposMetodo.get(i), tiposCall.get(i))) {
							error("Os parâmetros " + tiposCall.toString + " não são compatíveis com " +
								tiposMetodo.toString, exp.aux, JavaPackage.Literals.EXPRESSION_AUX__ARG_LIST);
							return false;
						}
					}
					return true;
				} else if (exp.aux.argList == null) {
					var Method_declaration md = buscaMetodoClasse(nomeClasse, exp.name);
					if (md == null) {
						error("Método não existe", exp, JavaPackage.Literals.EXPRESSION__NAME);
						return false;
					} else if (md.parameter == null) {
						return true;
					}
					var List<String> tiposMetodo = getTiposParametrosDoMetodo(md);
					error(
						"O método " + exp.name + " exige os parametros " + tiposMetodo.toString,
						exp,
						JavaPackage.Literals.EXPRESSION__NAME
					);
					return false;
				}
				return false;
			}

			def getTiposParametrosDoMetodo(Method_declaration md) {
				var List<String> tiposMetodo = new ArrayList<String>();
				if (md.parameter != null && md.parameter.parameter != null) {
					tiposMetodo.add(md.parameter.parameter.type.name);
					if (md.parameter.parameters != null) {
						for (Parameter param : md.parameter.parameters) {
							tiposMetodo.add(param.type.name);
						}
					}
				}
				return tiposMetodo;
			}

			def buscaTipoExpressao(Expression exp, List<Variable_declaration> vds, String nomeClasse, String tipo) {
				if (exp.name == null && exp.literalExpression == null) {
					error("Expressão inválida", exp.aux, JavaPackage.Literals.EXPRESSION_AUX__ARG_LIST);
					return null;
				}
				if (exp.literalExpression != null) {
					if (exp.literalExpression.exp2 != null) {
						return "float";
					} else if (exp.literalExpression.string != null) {
						return "String";
					} else if (exp.literalExpression.char != null) {
						return "char";
					} else {
						return "int";
					}
				} else if (exp.name != null) {
					if (buscaTipoVariavel(vds, exp.name, nomeClasse) == null &&
						buscaMetodoClasse(nomeClasse, exp.name) == null) {
						error("Identificador " + exp.name + " não encontrado.", exp.aux,
							JavaPackage.Literals.EXPRESSION_AUX__ARG_LIST);
						return null;
					} else if (buscaTipoVariavel(vds, exp.name, nomeClasse) != null) {
						return buscaTipoVariavel(vds, exp.name, nomeClasse);
					} else {
						if (validaChamadaMetodo(vds, nomeClasse, exp, tipo)) {
							return buscaMetodoClasse(nomeClasse, exp.name).type.name;
						} else {
							return null;
						}
					}
				}
			}

			def validaRetornoMetodoComFuncao(Method_declaration md, String nomeClasse, List<Variable_declaration> vds) {
				for (Statement st : md.statement.statements) {
					if (st.returnSmt != null) {
						var Return_Statement retorno = st.returnSmt;
						if (retorno.rv instanceof Method_call) {
							var Method_call call = retorno.rv as Method_call;
							if (!hasNomeMetodoNaClasse(nomeClasse, call.name)) {
								error("Método " + call.name + " não existe.", retorno,
									JavaPackage.Literals.RETURN_STATEMENT__RV);
							}
							var Method_declaration mdRetorno = buscaMetodoClasse(nomeClasse, call.name);
							var List<String> parametros;
							if (mdRetorno.parameter != null) {
								var int qtdParametros = 0;
								if (mdRetorno.parameter.parameters != null) {
									qtdParametros += mdRetorno.parameter.parameters.length;
								}
								if (call.parameter == null || call.parameter.parameters.length != qtdParametros) {
									error("Quantidade inválida de parâmetros.", retorno,
										JavaPackage.Literals.RETURN_STATEMENT__RV);
								}
								validaTiposParametrosCallMethod(vds, nomeClasse, mdRetorno.parameter, call);
							} else {
								if (call.parameter != null || call.parameter.parameters.length > 0) {
									error("Quantidade inválida de parâmetros.", retorno,
										JavaPackage.Literals.RETURN_STATEMENT__RV);
								}
							}
						} else if (retorno.rv instanceof Literal_Expression) {
							var Literal_Expression literal = retorno.rv as Literal_Expression;
							if (literal.exp2 == null && md.type.name == "float") {
								error("O método deve retornar um float.", retorno,
									JavaPackage.Literals.RETURN_STATEMENT__RV);
							} else if (literal.string == null && md.type.name == "String") {
								error("O método deve retornar uma String.", retorno,
									JavaPackage.Literals.RETURN_STATEMENT__RV);
							} else if (literal.char == null && md.type.name == "char") {
								error("O método deve retornar um char.", retorno,
									JavaPackage.Literals.RETURN_STATEMENT__RV);
							} else if (md.type.name != "float" && md.type.name != "String" && md.type.name != "char" &&
								(literal.exp2 != null || literal.string != null || literal.char != null)) {
								error("O método deve retornar um int.", retorno,
									JavaPackage.Literals.RETURN_STATEMENT__RV);
							}
						} else if (retorno.rv.name != null) {
							var String tipo = buscaTipoVariavel(vds, retorno.rv.name, nomeClasse);
							if (tipo == null) {
								error("Variável " + retorno.rv.name + " não existe.", retorno.rv,
									JavaPackage.Literals.RETURN_VALUE__NAME);
							} else if (!isNomeClassIgualOuFilha(tipo, md.type.name)) {
								error("Não é possível converter o tipo " + tipo + " para " + md.type.name, retorno.rv,
									JavaPackage.Literals.RETURN_VALUE__NAME);
							}
						}
					}
				}
			}

			def validaTiposParametrosCallMethod(List<Variable_declaration> declarations, String nomeClasse,
				Parameter_list listaMetodo, Method_call methodCall) {
				var Parameter_list_method_call parametrosCall = methodCall.parameter;
				var List<String> tiposMetodo = new ArrayList<String>();
				var List<String> tiposCall = new ArrayList<String>();
				tiposMetodo.add(listaMetodo.parameter.type.name);
				if (listaMetodo.parameters != null) {
					for (Parameter param : listaMetodo.parameters) {
						tiposMetodo.add(param.type.name);
					}
				}
				var String tipo = buscaTipoVariavel(declarations, parametrosCall.name, nomeClasse);
				if (tipo == null) {
					error("Variável " + parametrosCall.name + " não existe.", parametrosCall,
						JavaPackage.Literals.PARAMETER_LIST_METHOD_CALL__NAME);
				} else {
					tiposCall.add(tipo);
				}
				for (String variavel : parametrosCall.parameters) {
					tipo = buscaTipoVariavel(declarations, variavel, nomeClasse);

					if (tipo == null) {
						error("Variável " + variavel + " não existe.", parametrosCall,
							JavaPackage.Literals.PARAMETER_LIST_METHOD_CALL__PARAMETERS);
					} else {
						tiposCall.add(tipo);
					}
				}
				if (tiposMetodo.length != tiposCall.length) {
					error("Os parâmetros " + tiposCall.toString + " não são compatíveis com " + tiposMetodo.toString,
						methodCall, JavaPackage.Literals.METHOD_CALL__PARAMETER);
				}
				for (var int i = 0; i < tiposMetodo.length; i++) {
					if (!tiposMetodo.get(i).equals(tiposCall.get(i)) &&
						!isClasseFilha(tiposMetodo.get(i), tiposCall.get(i))) {
						error("Os parâmetros " + tiposCall.toString + " não são compatíveis com " +
							tiposMetodo.toString, methodCall, JavaPackage.Literals.METHOD_CALL__PARAMETER);
					}
				}
			}

			def validaRetornoVoidMetodo(Method_declaration md) {
				if (md.statement.statements != null && md.statement.statements.length > 0) {
					var boolean temReturn = false;
					for (Statement st : md.statement.statements) {
						if (st.returnSmt != null) {
							var Return_Statement retorno = st.returnSmt;
							if (retorno.rv != null) {
								temReturn = true;
							}
							if (md.type.name.equals("void") && retorno.rv != null) {
								error("Método void não pode retornar um valor.", retorno,
									JavaPackage.Literals.RETURN_STATEMENT__RV);
							}
						}
					}
					if (!md.type.name.equals("void") && !temReturn) {
						error("O método deve retornar um " + md.type.name + ".", md,
							JavaPackage.Literals.METHOD_DECLARATION__NAME);
					}
				} else {
					if (!md.type.name.equals("void")) {
						error("O método deve retornar um " + md.type.name + ".", md,
							JavaPackage.Literals.METHOD_DECLARATION__NAME);
					}
				}
			}

			def validaParametrosMethodDeclaration(Method_declaration md) {
				if (md.parameter != null) {
					var Parameter_list lista = md.parameter;
					if (!this.isTipoPrimitivo(lista.parameter.type.name) &&
						classeMetodos.get(lista.parameter.type.name) == null) {
						error("Classe " + lista.parameter.type.name + " não existe.", lista.parameter,
							JavaPackage.Literals.PARAMETER__TYPE);
					}
					for (Parameter parametro : lista.parameters) {
						if (!this.isTipoPrimitivo(parametro.type.name) &&
							classeMetodos.get(parametro.type.name) == null) {
							error("Classe " + parametro.type.name + " não existe.", parametro,
								JavaPackage.Literals.PARAMETER__TYPE);
						}
					}
				}
			}

			def validaAtributoDoMetodo(List<Variable_declaration> vds, Variable_declaration vd, Method_declaration md) {
				if (classeAtributos.get(vd.type.name) == null && !isTipoPrimitivo(vd.type.name)) {
					error("Classe " + vd.type.name + " não existe.", vd,
						JavaPackage.Literals.VARIABLE_DECLARATION__TYPE);
				}
				buscaNomeAtributo(vds, vd.name);
				validaNomeAtributoIgualParametro(md, vd.name);
				for (Variable_declarator declarator : vd.names) {
					buscaNomeAtributo(vds, declarator);
					validaNomeAtributoIgualParametro(md, declarator);
				}
			}

			def validaNomeAtributoIgualParametro(Method_declaration md, Variable_declarator vd) {
				if (md.parameter != null) {
					if (md.parameter.parameter.name.equals(vd.name)) {
						error("Campo " + vd.name + " duplicado.", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
					}
					if (md.parameter.parameters != null) {
						for (Parameter param : md.parameter.parameters) {
							if (param.name.equals(vd.name)) {
								error("Campo " + vd.name + " duplicado.", vd,
									JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
							}
						}
					}
				}
			}

			def buscaNomeAtributo(List<Variable_declaration> vds, Variable_declarator vd) {
				for (Variable_declaration declaration : vds) {
					if (declaration.name.name.equals(vd.name)) {
						error("Campo " + vd.name + " duplicado.", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
					} else if (isNomeBooleano(vd.name)) {
						error("Identificador inválido.", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
					}
					for (Variable_declarator declarator : declaration.names) {
						if (declarator.name.equals(vd.name)) {
							error("Campo " + vd.name + " duplicado.", vd,
								JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
						}
					}
				}
			}

			def mapeiaAtributos(Class_declaration cd) {
				for (Field_declaration field : cd.fields) {
					if (field.name instanceof Variable_declaration) {
						var Variable_declaration vd = field.name as Variable_declaration;
						validaAtributoDaClasse(cd, vd);
						classeAtributos.get(cd.className).add(vd);
					}
				}
				for (Variable_declaration dec : classeAtributos.get(cd.className)) {
					if (dec.name != null) {
						validaAtributoComExpressaoAritmetica(classeAtributos.get(cd.className), dec.name, cd.className);
					}
					if (dec.names != null) {
						for (Variable_declarator declarator : dec.names) {
							validaAtributoComExpressaoAritmetica(classeAtributos.get(cd.className), declarator,
								cd.className);
						}
					}
				}
			}

			def validaAtributoDaClasse(Class_declaration cd, Variable_declaration vd) {
				var List<String> nomesAtributos = new ArrayList<String>();
				if (vd.name != null) {
					var Variable_declarator declarator = vd.name;
					if (hasNomeAtributosClasse(cd, declarator.name)) {
						error("Campo " + declarator.name + " duplicado.", declarator,
							JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
					} else if (isNomeBooleano(declarator.name)) {
						error("Identificador inválido.", declarator, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
					} else if (classeAtributos.get(vd.type.name) == null && !isTipoPrimitivo(vd.type.name)) {
						error("Classe " + vd.type.name + " não existe.", declarator,
							JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
					}
					nomesAtributos.add(declarator.name);
				}
				if (vd.names != null) {
					for (Variable_declarator dec : vd.names) {
						if (hasNomeAtributosClasse(cd, dec.name) || nomesAtributos.contains(dec.name)) {
							error("Campo " + dec.name + " duplicado.", dec,
								JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
						}
						nomesAtributos.add(dec.name);
					}
				}
			}

			def mapeiaClasses(Type_declaration td) {
				if (td.name != null) {
					if (td.name instanceof Class_declaration) {
						var Class_declaration cd = td.name as Class_declaration;
						validarClasse(cd);
						classeExtends.put(cd.className.toString, new ArrayList<String>());
						classeImplements.put(cd.className.toString, new ArrayList<String>());
						classeMetodos.put(cd.className.toString, new ArrayList<Method_declaration>());
						classeAtributos.put(cd.className.toString, new ArrayList<Variable_declaration>());
					} else if (td.name instanceof Interface_declaration) {
						var Interface_declaration interfaceDec = td.name as Interface_declaration;
						interfaces.add(interfaceDec.interfaceName.toString);
						classeAtributos.put(interfaceDec.interfaceName.toString, new ArrayList<Variable_declaration>());
						classeMetodos.put(interfaceDec.interfaceName.toString, new ArrayList<Method_declaration>());
					}
				}
			}

			def validarClasse(Class_declaration cd) {
				if (classeMetodos.keySet.contains(cd.className.toString)) {
					error("A classe " + cd.className + " já existe.", cd,
						JavaPackage.Literals.CLASS_DECLARATION__CLASS_NAME);
				}
				var List<String> modifiers = new ArrayList<String>();
				if (cd.modifiers != null) {
					for (var int i = 0; i < cd.modifiers.length; i++) {
						modifiers.add(cd.modifiers.get(i).toString);
					}
				}
				if (modifiers.length > 0 &&
					!(modifiers.contains('public') || modifiers.contains('abstract') || modifiers.contains('final'))) {
					error("Os identificadores válidos para classe são: public, abstract e final", cd,
						JavaPackage.Literals.CLASS_DECLARATION__MODIFIERS);
				} else if (modifiers.contains('abstract') && modifiers.contains('final')) {
					error("Apenas um dos identificadores pode ser usado: abstract ou final. Não ambos.", cd,
						JavaPackage.Literals.CLASS_DECLARATION__MODIFIERS);
				}
			}

			def validarExtends(Class_declaration cd) {
				if (cd.extend != null) {
					if (interfaces.contains(cd.extend)) {
						error(cd.extend + " é uma interface, não uma classe.", cd,
							JavaPackage.Literals.CLASS_DECLARATION__EXTEND);
					} else if (!classeExtends.keySet.contains(cd.extend)) {
						error("A classe " + cd.extend + " não existe. ", cd,
							JavaPackage.Literals.CLASS_DECLARATION__EXTEND);
					} else if (classeExtends.get(cd.className).contains(cd.extend)) {
						error("A classe " + cd.extend + " já está sendo estendida.", cd,
							JavaPackage.Literals.CLASS_DECLARATION__EXTEND);
					}
					classeExtends.get(cd.className).add(cd.extend);
				}
				if (cd.implement != null) {
					validarImplements(cd.implement, cd);
					classeImplements.get(cd.className).add(cd.implement);
				}
				if (cd.implements != null && cd.implements.length > 0) {
					var List<String> implements = new ArrayList<String>();
					for (var int i = 0; i < cd.implements.length; i++) {
						implements.add(cd.implements.get(i).toString);
					}
					for (var int i = 0; i < implements.length; i++) {
						validarImplements(implements.get(i), cd);
						classeImplements.get(cd.className).add(implements.get(i));
					}
				}
			}

			def validarImplements(String interfaceName, Class_declaration classImplements) {
				if (classeExtends.keySet.contains(interfaceName)) {
					error(interfaceName + " é uma classe, não uma interface.", classImplements,
						JavaPackage.Literals.CLASS_DECLARATION__CLASS_NAME);
				} else if (!interfaces.contains(interfaceName)) {
					error("A interface " + interfaceName + " não existe.", classImplements,
						JavaPackage.Literals.CLASS_DECLARATION__CLASS_NAME);
				} else if (classeImplements.get(classImplements.className).contains(interfaceName)) {
					error("A interface " + interfaceName + " já está sendo implementada.", classImplements,
						JavaPackage.Literals.CLASS_DECLARATION__CLASS_NAME);
				}
			}

			def isTipoPrimitivo(String tipo) {
				return tipo.equals("int") || tipo.equals("boolean") || tipo.equals("byte") || tipo.equals("char") ||
					tipo.equals("short") || tipo.equals("float") || tipo.equals("double") || tipo.equals("long") ||
					tipo.equals("void");
			}

			def hasNomeAtributosClasse(Class_declaration cd, String nome) {
				for (Variable_declaration dec : classeAtributos.get(cd.className)) {
					if (dec.name.name.equals(nome)) {
						return true;
					} else {
						for (Variable_declarator decInside : dec.names) {
							if (decInside.name.equals(nome)) {
								return true;
							}
						}
					}
				}
				return false;
			}

			def hasNomeMetodoNaClasse(String nomeClasse, String nome) {
				for (Method_declaration md : classeMetodos.get(nomeClasse)) {
					if (md.name.equals(nome)) {
						return true;
					}
				}
				return false;
			}

			def buscaMetodoClasse(String nomeClasse, String nomeMetodo) {
				for (Method_declaration md : classeMetodos.get(nomeClasse)) {
					if (md.name.equals(nomeMetodo)) {
						return md;
					}
				}
				return null;
			}

			def buscaTipoVariavel(List<Variable_declaration> varsMetodo, String nomeVar, String nomeClasse) {
				for (Variable_declaration varMetodo : varsMetodo) {
					if (varMetodo.name.name.equals(nomeVar)) {
						return varMetodo.type.name;
					}
					if (varMetodo.names != null) {
						for (Variable_declarator declarator : varMetodo.names) {
							if (declarator.name.equals(nomeVar)) {
								return varMetodo.type.name;
							}
						}
					}
				}
				if (metodoSendoValidado != null) {
					for (Variable_declaration varMetodo : classeAtributos.get(nomeClasse)) {
						if (varMetodo.name.name.equals(nomeVar)) {
							return varMetodo.type.name;
						}
						if (varMetodo.names != null) {
							for (Variable_declarator declarator : varMetodo.names) {
								if (declarator.name.equals(nomeVar)) {
									return varMetodo.type.name;
								}
							}
						}
					}
				}
				if (metodoSendoValidado != null && metodoSendoValidado.parameter != null) {
					if (metodoSendoValidado.parameter.parameter.name.equals(nomeVar)) {
						return metodoSendoValidado.parameter.parameter.type.name;
					}
					if (metodoSendoValidado.parameter.parameters != null) {
						for (Parameter param : metodoSendoValidado.parameter.parameters) {
							if (param.name.equals(nomeVar)) {
								return param.type.name;
							}
						}
					}
				}
				return null;
			}

			def isClasseFilha(String classePai, String classeFilha) {
				if (classeExtends.get(classeFilha) != null) {
					return classeExtends.get(classeFilha).contains(classePai);
				} else if (classeFilha == "int") {
					return classePai == "float" || classePai == "long";
				} else if (classeFilha == "float") {
					return classePai == "long";
				}
				return false;
			}

			def isNomeBooleano(String nome) {
				return "true".equals(nome) || "!true".equals(nome) || "false".equals(nome) || "!false".equals(nome);
			}

			def validarForStatements(List<Variable_declaration> vds, String className, For_Statement fs) {
				var List<Variable_declaration> vdsFor = vds;
				if (fs.variable != null) {
					if (buscaTipoVariavel(vdsFor, fs.variable.name.name, className) != null) {
						error("Variável " + fs.variable.name.name + "já existe", fs.variable.name,
							JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
						return;
					} else {
						vdsFor.add(fs.variable);
					}
					validaAtributoComExpressaoAritmetica(vdsFor, fs.variable.name, className);
				}
				if (fs.expression2 != null) {
					if (fs.expression2.name == null) {
						error("Condição inválida", fs, JavaPackage.Literals.FOR_STATEMENT__EXPRESSION2);
					} else {
						if (buscaTipoVariavel(vdsFor, fs.expression2.name, className) == null) {
							error("Variável " + fs.expression2.name + " não existe.", fs.expression2,
								JavaPackage.Literals.EXPRESSION__NAME);
						} else if (buscaTipoVariavel(vdsFor, fs.expression2.name, className) != "int") {
							error("Variável " + fs.expression2.name + " deve ser do tipo int.", fs.expression2,
								JavaPackage.Literals.EXPRESSION__NAME);
						} else {
							if (fs.expression2.aux.testingSign == null) {
								error("Expressão inválida", fs, JavaPackage.Literals.FOR_STATEMENT__EXPRESSION3);
							} else if (fs.expression2.aux.exp1.name == null &&
								fs.expression2.aux.exp1.literalExpression == null) {
								error("Condição inválida", fs.expression2.aux.exp1,
									JavaPackage.Literals.EXPRESSION__NAME);
							} else if (fs.expression2.aux.exp1.name != null &&
								buscaTipoVariavel(vdsFor, fs.expression3.aux.exp1.name, className) == null) {
								error("Variável não existe", fs.expression2.aux.exp1,
									JavaPackage.Literals.EXPRESSION__NAME);
							} else if (fs.expression2.aux.exp1.name != null &&
								buscaTipoVariavel(vdsFor, fs.expression3.aux.exp1.name, className) != "int") {
								error("Variável deve ser do tipo int", fs.expression2.aux.exp1,
									JavaPackage.Literals.EXPRESSION__NAME);
							} else if (fs.expression2.aux.exp1.literalExpression != null &&
								(fs.expression2.aux.exp1.literalExpression.exp2 != null ||
									fs.expression2.aux.exp1.literalExpression.string != null ||
									fs.expression2.aux.exp1.literalExpression.char != null)) {
									error("Literal inválido", fs.expression2.aux.exp1,
										JavaPackage.Literals.EXPRESSION__LITERAL_EXPRESSION);
								}
								if (fs.expression2.aux.exp1.aux.testingSign != null) {
									error("Condição inválida", fs, JavaPackage.Literals.FOR_STATEMENT__EXPRESSION2);
								}
							}
						}
					}
					if (fs.expression3 != null) {
						if (fs.expression3.name == null) {
							error("Expressão inválida", fs, JavaPackage.Literals.FOR_STATEMENT__EXPRESSION3);
						} else {
							if (buscaTipoVariavel(vdsFor, fs.expression3.name, className) == null) {
								error("Variável " + fs.expression3.name + " não existe.", fs.expression3,
									JavaPackage.Literals.EXPRESSION__NAME);
							} else if (buscaTipoVariavel(vdsFor, fs.expression3.name, className) != "int") {
								error("Variável " + fs.expression3.name + " deve ser do tipo int.", fs.expression3,
									JavaPackage.Literals.EXPRESSION__NAME);
							} else {
								if (fs.expression3.aux.sgin == null) {
									error("Expressão inválida", fs, JavaPackage.Literals.FOR_STATEMENT__EXPRESSION3);
								}
							}
						}
					}
				}

				def boolean isNomeClassIgualOuFilha(String className, String classePai) {
					if (className.equals(classePai)) {
						return true;
					} else if (!isTipoPrimitivo(className)) {
						return (classeExtends.get(className) != null &&
							classeExtends.get(className).contains(classePai)) ||
								(classeImplements.get(className) != null &&
									classeImplements.get(className).contains(classePai));
							}
							return false;
						}
					}
