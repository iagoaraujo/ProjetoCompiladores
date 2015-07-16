package org.xtext.java.validation;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.xtext.java.java.Class_declaration;
import org.xtext.java.java.Field_declaration;
import org.xtext.java.java.JavaPackage;
import org.xtext.java.java.Method_call;
import org.xtext.java.java.Method_declaration;
import org.xtext.java.java.Parameter;
import org.xtext.java.java.Parameter_list;
import org.xtext.java.java.Parameter_list_method_call;
import org.xtext.java.java.Return_Statement;
import org.xtext.java.java.Return_value;
import org.xtext.java.java.Statement;
import org.xtext.java.java.Statement_block;
import org.xtext.java.java.Type;
import org.xtext.java.java.Variable_declaration;
import org.xtext.java.java.Variable_declarator;
import org.xtext.java.validation.AbstractJavaValidator;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class JavaValidator extends AbstractJavaValidator {
  public List<Method_declaration> metodosDeclarados;
  
  public Map<String, Type> tipos;
  
  @Check
  public void runChecks(final Class_declaration cd) {
    ArrayList<Method_declaration> _arrayList = new ArrayList<Method_declaration>();
    this.metodosDeclarados = _arrayList;
    HashMap<String, Type> _hashMap = new HashMap<String, Type>();
    this.tipos = _hashMap;
    EList<Field_declaration> _fields = cd.getFields();
    for (final Field_declaration fd : _fields) {
      {
        EObject _name = fd.getName();
        if ((_name instanceof Method_declaration)) {
          EObject _name_1 = fd.getName();
          this.addMetodos(((Method_declaration) _name_1));
        }
        this.addTipos(fd, this.tipos);
      }
    }
  }
  
  public boolean addMetodos(final Method_declaration method) {
    return this.metodosDeclarados.add(method);
  }
  
  @Check
  public void verificaExistenciaDeMetodo(final Method_call method) {
    Parameter_list_method_call pc = method.getParameter();
    int parametrosChamada = 0;
    boolean _notEquals = (!Objects.equal(pc, null));
    if (_notEquals) {
      parametrosChamada = 1;
      int _parametrosChamada = parametrosChamada;
      EList<String> _parameters = pc.getParameters();
      int _size = _parameters.size();
      parametrosChamada = (_parametrosChamada + _size);
    } else {
      parametrosChamada = 0;
    }
    boolean existeMetodo = false;
    boolean mesmaQuantidadeDeParametros = false;
    for (final Method_declaration m : this.metodosDeclarados) {
      String _name = m.getName();
      String _name_1 = method.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        existeMetodo = true;
        boolean _verificaQuantidadeDeParametros = this.verificaQuantidadeDeParametros(m, parametrosChamada);
        if (_verificaQuantidadeDeParametros) {
          mesmaQuantidadeDeParametros = true;
        }
      }
    }
    if ((!existeMetodo)) {
      this.error("O método ainda não foi declarado", method, JavaPackage.Literals.METHOD_CALL__PARAMETER);
      return;
    }
    if ((!mesmaQuantidadeDeParametros)) {
      this.error("Números de parâmetros incorreto", method, JavaPackage.Literals.METHOD_CALL__PARAMETER);
      return;
    }
  }
  
  public boolean verificaQuantidadeDeParametros(final Method_declaration method, final int parametrosChamada) {
    Parameter_list pd = method.getParameter();
    int parametrosDeclaracao = 0;
    boolean _notEquals = (!Objects.equal(pd, null));
    if (_notEquals) {
      parametrosDeclaracao = 1;
      int _parametrosDeclaracao = parametrosDeclaracao;
      EList<Parameter> _parameters = pd.getParameters();
      int _size = _parameters.size();
      parametrosDeclaracao = (_parametrosDeclaracao + _size);
    } else {
      parametrosDeclaracao = 0;
    }
    return (parametrosDeclaracao == parametrosChamada);
  }
  
  @Check
  public void checaRetornoDosMetodos(final Method_declaration md) {
    Statement_block _statement = md.getStatement();
    EList<Statement> statements = _statement.getStatements();
    Map<String, Type> tiposMetodo = new HashMap<String, Type>();
    boolean temReturn = false;
    for (final Statement smt : statements) {
      {
        this.addTiposMetodo(smt, tiposMetodo);
        if ((smt instanceof Return_Statement)) {
          temReturn = true;
          Type _type = md.getType();
          String _name = _type.getName();
          String _string = _name.toString();
          boolean _equals = Objects.equal(_string, "void");
          if (_equals) {
            Return_Statement _returnSmt = ((Return_Statement)smt).getReturnSmt();
            Return_value _rv = _returnSmt.getRv();
            String _name_1 = _rv.getName();
            boolean _notEquals = (!Objects.equal(_name_1, null));
            if (_notEquals) {
              Return_Statement _returnSmt_1 = ((Return_Statement)smt).getReturnSmt();
              this.error("Métodos void não devem retornar nada", _returnSmt_1, JavaPackage.Literals.RETURN_STATEMENT__RV);
            }
          } else {
            Return_Statement _returnSmt_2 = ((Return_Statement)smt).getReturnSmt();
            Return_value _rv_1 = _returnSmt_2.getRv();
            boolean _equals_1 = Objects.equal(_rv_1, null);
            if (_equals_1) {
              Type _type_1 = md.getType();
              String _name_2 = _type_1.getName();
              String _string_1 = _name_2.toString();
              String _plus = ("O método deve retornar " + _string_1);
              Return_Statement _returnSmt_3 = ((Return_Statement)smt).getReturnSmt();
              this.error(_plus, _returnSmt_3, JavaPackage.Literals.RETURN_STATEMENT__RETURN_SMT);
            }
            Return_Statement _returnSmt_4 = ((Return_Statement)smt).getReturnSmt();
            Return_value _rv_2 = _returnSmt_4.getRv();
            String _name_3 = _rv_2.getName();
            String _string_2 = _name_3.toString();
            Type retorno = this.tipos.get(_string_2);
            Return_Statement _returnSmt_5 = ((Return_Statement)smt).getReturnSmt();
            Return_value _rv_3 = _returnSmt_5.getRv();
            String _name_4 = _rv_3.getName();
            String _string_3 = _name_4.toString();
            Type retorno2 = tiposMetodo.get(_string_3);
            boolean _and = false;
            boolean _equals_2 = Objects.equal(retorno, null);
            if (!_equals_2) {
              _and = false;
            } else {
              boolean _equals_3 = Objects.equal(retorno2, null);
              _and = _equals_3;
            }
            if (_and) {
              Return_Statement _returnSmt_6 = ((Return_Statement)smt).getReturnSmt();
              this.error("A variável de retorno ainda não foi declarada", _returnSmt_6, JavaPackage.Literals.RETURN_STATEMENT__RV);
            } else {
              boolean _or = false;
              boolean _and_1 = false;
              boolean _equals_4 = Objects.equal(retorno, null);
              if (!_equals_4) {
                _and_1 = false;
              } else {
                String _name_5 = retorno2.getName();
                String _string_4 = _name_5.toString();
                Type _type_2 = md.getType();
                String _name_6 = _type_2.getName();
                String _string_5 = _name_6.toString();
                boolean _notEquals_1 = (!Objects.equal(_string_4, _string_5));
                _and_1 = _notEquals_1;
              }
              if (_and_1) {
                _or = true;
              } else {
                boolean _and_2 = false;
                boolean _equals_5 = Objects.equal(retorno2, null);
                if (!_equals_5) {
                  _and_2 = false;
                } else {
                  String _name_7 = retorno.getName();
                  String _string_6 = _name_7.toString();
                  Type _type_3 = md.getType();
                  String _name_8 = _type_3.getName();
                  String _string_7 = _name_8.toString();
                  boolean _notEquals_2 = (!Objects.equal(_string_6, _string_7));
                  _and_2 = _notEquals_2;
                }
                _or = _and_2;
              }
              if (_or) {
                Return_Statement _returnSmt_7 = ((Return_Statement)smt).getReturnSmt();
                this.error("O tipo do retorno e o tipo do método são diferentes", _returnSmt_7, JavaPackage.Literals.RETURN_STATEMENT__RV);
              } else {
                boolean _and_3 = false;
                boolean _and_4 = false;
                boolean _and_5 = false;
                boolean _notEquals_3 = (!Objects.equal(retorno2, null));
                if (!_notEquals_3) {
                  _and_5 = false;
                } else {
                  boolean _notEquals_4 = (!Objects.equal(retorno, null));
                  _and_5 = _notEquals_4;
                }
                if (!_and_5) {
                  _and_4 = false;
                } else {
                  String _name_9 = retorno2.getName();
                  String _string_8 = _name_9.toString();
                  Type _type_4 = md.getType();
                  String _name_10 = _type_4.getName();
                  String _string_9 = _name_10.toString();
                  boolean _notEquals_5 = (!Objects.equal(_string_8, _string_9));
                  _and_4 = _notEquals_5;
                }
                if (!_and_4) {
                  _and_3 = false;
                } else {
                  String _name_11 = retorno.getName();
                  String _string_10 = _name_11.toString();
                  Type _type_5 = md.getType();
                  String _name_12 = _type_5.getName();
                  String _string_11 = _name_12.toString();
                  boolean _notEquals_6 = (!Objects.equal(_string_10, _string_11));
                  _and_3 = _notEquals_6;
                }
                if (_and_3) {
                  Return_Statement _returnSmt_8 = ((Return_Statement)smt).getReturnSmt();
                  this.error("O tipo do retorno e o tipo do método são diferentes", _returnSmt_8, JavaPackage.Literals.RETURN_STATEMENT__RV);
                }
              }
            }
          }
        }
      }
    }
    boolean _and = false;
    if (!(!temReturn)) {
      _and = false;
    } else {
      Type _type = md.getType();
      String _name = _type.getName();
      String _string = _name.toString();
      boolean _notEquals = (!Objects.equal(_string, "void"));
      _and = _notEquals;
    }
    if (_and) {
      Type _type_1 = md.getType();
      String _name_1 = _type_1.getName();
      String _string_1 = _name_1.toString();
      String _plus = ("O método deve retornar " + _string_1);
      this.error(_plus, md, JavaPackage.Literals.METHOD_DECLARATION__NAME);
    }
  }
  
  public Type addTipos(final Field_declaration fd, final Map<String, Type> tipos) {
    Type _xifexpression = null;
    EObject _name = fd.getName();
    if ((_name instanceof Variable_declaration)) {
      Type _xblockexpression = null;
      {
        EObject _name_1 = fd.getName();
        Variable_declaration vd = ((Variable_declaration) _name_1);
        Variable_declarator _name_2 = vd.getName();
        String _name_3 = _name_2.getName();
        String _string = _name_3.toString();
        Type nome = tipos.get(_string);
        Type _xifexpression_1 = null;
        boolean _notEquals = (!Objects.equal(nome, null));
        if (_notEquals) {
          this.error("Já existe uma variável com o mesmo identificador", vd, JavaPackage.Literals.VARIABLE_DECLARATION__NAME);
        } else {
          Variable_declarator _name_4 = vd.getName();
          String _name_5 = _name_4.getName();
          String _string_1 = _name_5.toString();
          Type _type = vd.getType();
          _xifexpression_1 = tipos.put(_string_1, _type);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      Type _xifexpression_1 = null;
      EObject _name_1 = fd.getName();
      if ((_name_1 instanceof Method_declaration)) {
        Type _xblockexpression_1 = null;
        {
          EObject _name_2 = fd.getName();
          Method_declaration md = ((Method_declaration) _name_2);
          String _name_3 = md.getName();
          String _string = _name_3.toString();
          Type _type = md.getType();
          _xblockexpression_1 = tipos.put(_string, _type);
        }
        _xifexpression_1 = _xblockexpression_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Type addTiposMetodo(final Statement smt, final Map<String, Type> tipos) {
    Type _xifexpression = null;
    Variable_declaration _variable = smt.getVariable();
    if ((_variable instanceof Variable_declaration)) {
      Type _xblockexpression = null;
      {
        Variable_declaration _variable_1 = smt.getVariable();
        Variable_declarator _name = _variable_1.getName();
        String _name_1 = _name.getName();
        String _string = _name_1.toString();
        Type nome = tipos.get(_string);
        boolean _notEquals = (!Objects.equal(nome, null));
        if (_notEquals) {
          Variable_declaration _variable_2 = smt.getVariable();
          this.error("Já existe uma variável com o mesmo identificador", _variable_2, JavaPackage.Literals.VARIABLE_DECLARATION__NAME);
        }
        Variable_declaration _variable_3 = smt.getVariable();
        Variable_declarator _name_2 = _variable_3.getName();
        String _name_3 = _name_2.getName();
        String _string_1 = _name_3.toString();
        Variable_declaration _variable_4 = smt.getVariable();
        Type _type = _variable_4.getType();
        _xblockexpression = tipos.put(_string_1, _type);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
