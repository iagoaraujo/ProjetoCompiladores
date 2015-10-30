package org.xtext.java.validation

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.xtext.validation.Check
import org.xtext.java.java.Class_declaration
import org.xtext.java.java.Interface_declaration
import org.xtext.java.java.JavaPackage
import org.xtext.java.java.Method_declaration
import org.xtext.java.java.Type
import org.xtext.java.java.Type_declaration
import org.xtext.java.java.Variable_declaration
import org.xtext.java.java.Compilation_unit
import org.xtext.java.java.Field_declaration
import org.xtext.java.java.Variable_declarator

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class JavaValidator extends AbstractJavaValidator {

//  public static val INVALID_NAME = 'invalidName'
//
//	@Check
//	def checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
//			warning('Name should start with a capital', 
//					MyDslPackage.Literals.GREETING__NAME,
//					INVALID_NAME)
//		}
//	}
//	public List<Method_declaration> metodosDeclarados;
//
//	public Map<String, Type> tipos;

	public List<String> interfaces = new ArrayList<String>();

	public static Map<String, List<String>> classeExtends = new HashMap<String, List<String>>();

	public static Map<String, List<String>> classeImplements = new HashMap<String, List<String>>();

	public static Map<String, List<Method_declaration>> classeMetodos = new HashMap<String, List<Method_declaration>>();

	public static Map<String, List<Variable_declaration>> classeAtributos = new HashMap<String, List<Variable_declaration>>();

	@Check
	def instanciaMapas(Compilation_unit cpu) {
		interfaces = new ArrayList<String>();
		classeExtends = new HashMap<String, List<String>>();
		classeImplements = new HashMap<String, List<String>>();
		classeMetodos = new HashMap<String, List<Method_declaration>>();
		classeAtributos = new HashMap<String, List<Variable_declaration>>();
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
	
	def mapeiaMetodos(Class_declaration cd) {
		for (Field_declaration field: cd.fields) {
			if (field.name instanceof Method_declaration) {
				var Method_declaration md = field.name as Method_declaration;
				if (hasNomeMetodoNaClasse(cd, md.name)) {
					error("Método " + md.name + " já existe na classe.", md,
						JavaPackage.Literals.METHOD_DECLARATION__NAME);
				}
				classeMetodos.get(cd.className).add(md);
			}
		}
	}
	
	def mapeiaAtributos(Class_declaration cd) {
		for (Field_declaration field: cd.fields) {
			if (field.name instanceof Variable_declaration) {
				var Variable_declaration vd = field.name as Variable_declaration;
				validaAtributoDaClasse(cd, vd);
				classeAtributos.get(cd.className).add(vd);
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
			} else if (classeAtributos.get(vd.type.name) == null
				&& !isTipoPrimitivo(vd.type.name)) {
				error("Classe " + vd.type.name + " não existe.", declarator,
					JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
			}
			nomesAtributos.add(declarator.name);
		}
		if (vd.names != null) {
			for(Variable_declarator dec: vd.names) {
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
			error("A classe " + cd.className + " já existe.", cd, JavaPackage.Literals.CLASS_DECLARATION__CLASS_NAME);
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
				error("A classe " + cd.extend + " não existe. ", cd, JavaPackage.Literals.CLASS_DECLARATION__EXTEND);
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
		return tipo.equals("int") || tipo.equals("boolean") || tipo.equals("byte") || 
			tipo.equals("char") || tipo.equals("short") || tipo.equals("float") || 
			tipo.equals("double") || tipo.equals("long") || tipo.equals("void");
	}
	
	def hasNomeAtributosClasse(Class_declaration cd, String nome) {
		for (Variable_declaration dec: classeAtributos.get(cd.className)) {
			if (dec.name.name.equals(nome)) {
				return true;
			} else {
				for (Variable_declarator decInside: dec.names) {
					if (decInside.name.equals(nome)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	def hasNomeMetodoNaClasse(Class_declaration cd, String nome) {
		for (Method_declaration md: classeMetodos.get(cd.className)) {
			if (md.name.equals(nome)) {
				return true;
			}
		}
		return false;
	}

//	
//	@Check 
//	def runChecks(Class_declaration cd) {
//		metodosDeclarados = new ArrayList<Method_declaration>();
//		tipos = new HashMap<String, Type>();
//		for (Field_declaration fd : cd.fields) {
//			if (fd.name instanceof Method_declaration) {
//				addMetodos(fd.name as Method_declaration);
//			}
//			addTipos(fd, tipos);
//			if (fd.name instanceof Variable_declarator) {
//				checarTiposVariaveis(fd.name as Variable_declarator, tipos);
//			}
//		}
//	}
//	
//	def addMetodos(Method_declaration method) {
//		metodosDeclarados.add(method);
//	}
//	
//	@Check
//	def checkForStatements(For_Statement fs) {
//		if (fs.variable.type.name.toString != "int") {
//			error("Variável iterativa inválida", fs, JavaPackage.Literals.FOR_STATEMENT__VARIABLE);
//		} 
//		if (fs.expression2.aux == null
//			|| fs.expression2.aux.testingSign == null
//		) {
//			error("Condição inválida", fs, JavaPackage.Literals.FOR_STATEMENT__EXPRESSION2);
//		}
//		if (fs.expression3.aux == null
//			||( fs.expression3.aux.sgin == null
//			&& fs.expression3.aux.numericSign == null
//			)
//		) {
//			error("Iteração inválida", fs, JavaPackage.Literals.FOR_STATEMENT__EXPRESSION3);
//		}
//	}
//	
//	@Check
//	def verificaExistenciaDeMetodo(Method_call method) {
//		var Parameter_list_method_call pc = method.getParameter();
//		var int parametrosChamada;
//		if (pc != null) {
//			parametrosChamada = 1;
//			parametrosChamada += pc.getParameters().size();
//		} else {
//			parametrosChamada = 0;
//		}
//		var boolean existeMetodo = false;
//		var boolean mesmaQuantidadeDeParametros = false;
//		for (Method_declaration m : metodosDeclarados) {
//			if (m.name == method.name) {
//				existeMetodo = true;
//				if (verificaQuantidadeDeParametros(m, parametrosChamada)) {
//					mesmaQuantidadeDeParametros = true;
//				}
//			}
//		}
//		if (!existeMetodo) {
//			error("O método ainda não foi declarado", method, JavaPackage.Literals.METHOD_CALL__PARAMETER)
//			return;
//		}
//		if(!mesmaQuantidadeDeParametros) {
//			error("Números de parâmetros incorreto", method, JavaPackage.Literals.METHOD_CALL__PARAMETER);
//			return;
//		}
//	}
//	
//	def verificaQuantidadeDeParametros(Method_declaration method, int parametrosChamada) {
//		var Parameter_list pd = method.getParameter();
//		var int parametrosDeclaracao;
//		if (pd != null) {
//			parametrosDeclaracao = 1;
//			parametrosDeclaracao += pd.getParameters().size();
//		} else {
//			parametrosDeclaracao = 0;
//		}
//		return parametrosDeclaracao == parametrosChamada;
//	}
//	
//	@Check
//	def checaRetornoDosMetodos(Method_declaration md) {
//		var EList<Statement> statements = md.statement.statements;
//		var Map<String, Type> tiposMetodo = new HashMap<String, Type>();
//		var boolean temReturn = false;
//		for (Statement smt : statements) {
//			addTiposMetodo(smt, tiposMetodo);
//			if (smt.variable.name instanceof Variable_declarator) {
//				checarTiposVariaveis(smt.variable.name, tiposMetodo);
//			}
//			if (smt.returnSmt != null) {
//				error(smt.toString, smt, JavaPackage.Literals.STATEMENT__STATEMENT);
//				temReturn = true;
//				if (md.type.name.toString == "void") {
//					if (smt.returnSmt.rv.name != null) {
//						error("Métodos void não devem retornar nada", smt.returnSmt, JavaPackage.Literals.RETURN_STATEMENT__RV);
//					}
//				} else {
//					if (smt.returnSmt.rv == null) {
//						error("O método deve retornar " + md.type.name.toString, smt.returnSmt, JavaPackage.Literals.RETURN_STATEMENT__RV);
//					}
//					var retorno = tipos.get(smt.returnSmt.rv.name.toString);
//					var retorno2 = tiposMetodo.get(smt.returnSmt.rv.name.toString);
//					if (retorno == null && retorno2 == null) {
//						error("A variável de retorno ainda não foi declarada", smt.returnSmt, JavaPackage.Literals.RETURN_STATEMENT__RV);
//					} else if ((retorno == null && retorno2.name.toString != md.type.name.toString)
//						|| (retorno2 == null && retorno.name.toString != md.type.name.toString)
//					) {
//						error("O tipo do retorno e o tipo do método são diferentes", smt.returnSmt, JavaPackage.Literals.RETURN_STATEMENT__RV);
//					} else if (retorno2 != null && retorno != null
//						&& retorno2.name.toString != md.type.name.toString
//						&& retorno.name.toString != md.type.name.toString
//					) {
//						error("O tipo do retorno e o tipo do método são diferentes", smt.returnSmt, JavaPackage.Literals.RETURN_STATEMENT__RV);
//					}
//				}	 
//			}
//		}
//		if (!temReturn && md.type.name.toString != "void") {
//			error("O método deve retornar " + md.type.name.toString, md, JavaPackage.Literals.METHOD_DECLARATION__NAME);
//		}
//		for (Statement smt : statements) {
//			if (smt.ifStatement != null) {
//				checarCondicaoDoIf(smt.ifStatement, tiposMetodo);
//			}
//		}
//	} 
//
//	def addTipos(Field_declaration fd, Map<String, Type> tipos) {
//		if (fd.name instanceof Variable_declaration) {
//			var Variable_declaration vd = fd.name as Variable_declaration;
//			var Type nome = tipos.get(vd.name.name.toString);
//			if (nome != null) {
//				error("Já existe uma variável com o mesmo identificador", vd, JavaPackage.Literals.VARIABLE_DECLARATION__NAME);
//			} else {
//				tipos.put(vd.name.name.toString, vd.type);	
//				checarTiposVariaveis(vd.name, tipos);			
//			}
//		} else if (fd.name instanceof Method_declaration) {
//			var Method_declaration md = fd.name as Method_declaration;
//			tipos.put(md.name.toString, md.type);
//		} 
//	}
//	
//	def addTiposMetodo(Statement smt, Map<String, Type> tipos) {
//		if (smt.variable instanceof Variable_declaration) {
//			var Variable_declaration v = smt.variable as Variable_declaration;
//			var Type nome = tipos.get(v.name.name.toString);
//			if (nome != null) {
//				error("Já existe uma variável com o mesmo identificador", smt.variable, JavaPackage.Literals.VARIABLE_DECLARATION__NAME);
//			}
//			tipos.put(v.name.name.toString, v.type);
//			checarTiposVariaveis(smt.variable.name, tipos);
//		} 
//	}
//	
//	def checarTiposVariaveis(Variable_declarator vd, Map<String, Type> tipos) {
//		var Type tipo = tipos.get(vd.name.toString);
//		if (vd.initializer != null
//			&& vd.initializer.expression != null
//		) {
//			if (vd.initializer.expression.literalExpression instanceof Literal_Expression) {
//				if (tipo.name.toString == "String" && vd.initializer.expression.literalExpression.string == null
//				) {
//					error("O valor da variável não casa com seu tipo", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
//				} else if (tipo.name.toString == "int" && vd.initializer.expression.literalExpression.string != null
//				) {
//					error("O valor da variável não casa com seu tipo", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
//				} else if (vd.initializer.expression.literalExpression.string != null
//					&& vd.initializer.expression.aux != null
//					&& vd.initializer.expression.aux.stringSign != null
//				) {
//					if (vd.initializer.expression.aux.exp1.literalExpression instanceof Literal_Expression
//						&& vd.initializer.expression.aux.exp1.literalExpression.string != null)
//					{
//					} else {
//						error("Operação inválida", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
//					}
//				} else if (vd.initializer.expression.literalExpression.string == null
//					&& vd.initializer.expression.aux != null
//					&& vd.initializer.expression.aux.numericSign != null
//				) {
//					if (vd.initializer.expression.aux.exp2.literalExpression instanceof Literal_Expression
//						&& vd.initializer.expression.aux.exp2.literalExpression.string == null) {					
//					} else {
//						error("Operação inválida", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
//					}
//				}
//			} 
//			if (!(vd.initializer.expression.logicalExpression instanceof Logical_Expression_NR)) {
//				if (tipo.name.toString == "boolean" && vd.initializer.expression.aux.testingSign == null) {
//					error("O valor da variável não casa com seu tipo", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
//				}
//			} else {
//				if (tipo.name.toString != "boolean") {
//					error("O valor da variável não casa com seu tipo", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
//				}
//			}
//			if (vd.initializer.expression.aux != null
//				&& vd.initializer.expression.aux.testingSign != null
//				&& tipo.name.toString != "boolean") {
//					error("A variável deve ser do tipo boolean", vd, JavaPackage.Literals.VARIABLE_DECLARATOR__NAME);
//			}
//		}
//	}
//
//	@Check
//	def checarInstanciaEntreClasses(Variable_declaration vdc) {
//		if (vdc.name != null) {
//			var Variable_declarator vd = vdc.name as Variable_declarator;
//			if (vd.initializer != null && vd.initializer.expression != null) {
//				if (vd.initializer.expression.creatingExpression instanceof Creating_Expression) {
//					var Creating_Expression creatingExp = vd.initializer.expression.creatingExpression;
//					if (creatingExp.className.toString != vdc.type.name.toString &&
//						!classeExtends.get(creatingExp.className.toString).contains(vdc.type.name.toString)) {
//						error("A classe " + classeExtends.toString + creatingExp.className.toString + " não herda ou implementa " +
//							vdc.type.name.toString, creatingExp, JavaPackage.Literals.CREATING_EXPRESSION__CLASS_NAME);
//					}
//				}
//			}
//		}
//	}
//	
//	def checarCondicaoDoIf(If_Statement ifStatement, Map<String, Type> tiposMetodo) {
//		if (ifStatement.expression != null) {
//			if (ifStatement.expression.name != null) {
//				var Type type = tipos.get(ifStatement.expression.name);
//				var Type typeMetodo = tiposMetodo.get(ifStatement.expression.name);
//				if (type == null && typeMetodo == null) {
//					error("Variável " + ifStatement.expression.name + " não existe", ifStatement, 
//						JavaPackage.Literals.IF_STATEMENT__EXPRESSION);
//				}
//				else if ((type !== null && type != 'boolean' && type != 'Boolean')
//					|| (typeMetodo !== null && typeMetodo != 'boolean' && typeMetodo != 'Boolean')) {
//					if (ifStatement.expression.aux.testingSign == null) {
//						error("Deve ser passado um boolean como parâmetro", ifStatement, 
//							JavaPackage.Literals.IF_STATEMENT__EXPRESSION);
//					}
//				} else {
//					if (ifStatement.expression.aux.logicalSign != null) {
//						type = tipos.get(ifStatement.expression.aux.exp1.name);
//						typeMetodo = tiposMetodo.get(ifStatement.expression.aux.exp1.name);
//						if (type == null && typeMetodo == null) {
//							error("Variável " + ifStatement.expression.aux.exp1.name + " não existe", ifStatement, 
//							JavaPackage.Literals.IF_STATEMENT__EXPRESSION);
//						}
//						else if ((type !== null && type != 'boolean' && type != 'Boolean')
//								|| (typeMetodo !== null && typeMetodo != 'boolean' && typeMetodo != 'Boolean')) {
//							if (ifStatement.expression.aux.exp1.aux.testingSign == null) {
//								error("Deve ser passado um boolean como parâmetro2", ifStatement, 
//									JavaPackage.Literals.IF_STATEMENT__EXPRESSION);
//							}
//						}
//					}
//				}
//			} else if (ifStatement.expression.aux != null &&
//				ifStatement.expression.aux.testingSign == null) {
//				error("Condição inválida", ifStatement, 
//						JavaPackage.Literals.IF_STATEMENT__EXPRESSION);
//			}
//		} 
//	}
}
