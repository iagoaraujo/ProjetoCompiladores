package org.xtext.java.validation;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
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
import org.xtext.java.validation.AbstractJavaValidator;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class JavaValidator extends AbstractJavaValidator {
  public List<Method_declaration> metodosDeclarados;
  
  @Check
  public void runChecks(final Class_declaration cd) {
    ArrayList<Method_declaration> _arrayList = new ArrayList<Method_declaration>();
    this.metodosDeclarados = _arrayList;
    EList<Field_declaration> _fields = cd.getFields();
    for (final Field_declaration fd : _fields) {
      EObject _name = fd.getName();
      if ((_name instanceof Method_declaration)) {
        EObject _name_1 = fd.getName();
        this.addMetodos(((Method_declaration) _name_1));
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
      this.error("O método ainda não foi declarado", JavaPackage.Literals.METHOD_CALL__NAME);
      return;
    }
    if ((!mesmaQuantidadeDeParametros)) {
      this.error("Números de parâmetros incorreto", JavaPackage.Literals.METHOD_CALL__PARAMETER);
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
    for (final Statement smt : statements) {
      if ((smt instanceof Return_Statement)) {
        Type _type = md.getType();
        String _name = _type.getName();
        String _string = _name.toString();
        boolean _equals = Objects.equal(_string, "void");
        if (_equals) {
          String _string_1 = ((Return_Statement)smt).toString();
          String _plus = ("@@@@@@@@@@@@@@@" + _string_1);
          String _plus_1 = (_plus + " ************ ");
          Return_value _value = ((Return_Statement)smt).getValue();
          String _plus_2 = (_plus_1 + _value);
          this.error(_plus_2, null);
          Return_value _value_1 = ((Return_Statement)smt).getValue();
          boolean _notEquals = (!Objects.equal(_value_1, null));
          if (_notEquals) {
            this.error("Métodos void não deve retornar nada", JavaPackage.Literals.METHOD_DECLARATION__NAME);
          }
        }
      }
    }
  }
}
