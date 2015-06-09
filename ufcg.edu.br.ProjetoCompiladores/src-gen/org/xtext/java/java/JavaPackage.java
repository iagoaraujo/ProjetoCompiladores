/**
 */
package org.xtext.java.java;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.java.java.JavaFactory
 * @model kind="package"
 * @generated
 */
public interface JavaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "java";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/java/Java";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "java";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JavaPackage eINSTANCE = org.xtext.java.java.impl.JavaPackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.HeadImpl <em>Head</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.HeadImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getHead()
   * @generated
   */
  int HEAD = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEAD__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Head</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEAD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Compilation_unitImpl <em>Compilation unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Compilation_unitImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getCompilation_unit()
   * @generated
   */
  int COMPILATION_UNIT = 1;

  /**
   * The feature id for the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPILATION_UNIT__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPILATION_UNIT__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Type declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPILATION_UNIT__TYPE_DECLARATIONS = 2;

  /**
   * The number of structural features of the '<em>Compilation unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPILATION_UNIT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Type_declarationImpl <em>Type declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Type_declarationImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getType_declaration()
   * @generated
   */
  int TYPE_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATION__DOC = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATION__NAME = 1;

  /**
   * The number of structural features of the '<em>Type declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Interface_declarationImpl <em>Interface declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Interface_declarationImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getInterface_declaration()
   * @generated
   */
  int INTERFACE_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Interface Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION__INTERFACE_NAME = 1;

  /**
   * The feature id for the '<em><b>Extend</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION__EXTEND = 2;

  /**
   * The feature id for the '<em><b>Extends</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION__EXTENDS = 3;

  /**
   * The number of structural features of the '<em>Interface declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Class_declarationImpl <em>Class declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Class_declarationImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getClass_declaration()
   * @generated
   */
  int CLASS_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DECLARATION__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DECLARATION__CLASS_NAME = 1;

  /**
   * The feature id for the '<em><b>Extend</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DECLARATION__EXTEND = 2;

  /**
   * The feature id for the '<em><b>Implement</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DECLARATION__IMPLEMENT = 3;

  /**
   * The feature id for the '<em><b>Implements</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DECLARATION__IMPLEMENTS = 4;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DECLARATION__FIELDS = 5;

  /**
   * The number of structural features of the '<em>Class declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DECLARATION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Field_declarationImpl <em>Field declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Field_declarationImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getField_declaration()
   * @generated
   */
  int FIELD_DECLARATION = 5;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_DECLARATION__DOC = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Debug</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_DECLARATION__DEBUG = 2;

  /**
   * The number of structural features of the '<em>Field declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Method_declarationImpl <em>Method declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Method_declarationImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getMethod_declaration()
   * @generated
   */
  int METHOD_DECLARATION = 6;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATION__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATION__NAME = 2;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATION__PARAMETER = 3;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATION__STATEMENT = 4;

  /**
   * The feature id for the '<em><b>Debug</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATION__DEBUG = 5;

  /**
   * The number of structural features of the '<em>Method declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Constructor_declarationImpl <em>Constructor declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Constructor_declarationImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getConstructor_declaration()
   * @generated
   */
  int CONSTRUCTOR_DECLARATION = 7;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_DECLARATION__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_DECLARATION__PARAMETERS = 2;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_DECLARATION__STATEMENT = 3;

  /**
   * The number of structural features of the '<em>Constructor declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Parameter_listImpl <em>Parameter list</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Parameter_listImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getParameter_list()
   * @generated
   */
  int PARAMETER_LIST = 8;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST__PARAMETERS = 1;

  /**
   * The number of structural features of the '<em>Parameter list</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.ParameterImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 9;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Variable_declarationImpl <em>Variable declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Variable_declarationImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getVariable_declaration()
   * @generated
   */
  int VARIABLE_DECLARATION = 10;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__NAME = 2;

  /**
   * The feature id for the '<em><b>Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__NAMES = 3;

  /**
   * The number of structural features of the '<em>Variable declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Variable_declaratorImpl <em>Variable declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Variable_declaratorImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getVariable_declarator()
   * @generated
   */
  int VARIABLE_DECLARATOR = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR__NAME = 0;

  /**
   * The number of structural features of the '<em>Variable declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.TypeImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getType()
   * @generated
   */
  int TYPE = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = 0;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Static_initializerImpl <em>Static initializer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Static_initializerImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getStatic_initializer()
   * @generated
   */
  int STATIC_INITIALIZER = 13;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_INITIALIZER__STATIC = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_INITIALIZER__NAME = 1;

  /**
   * The number of structural features of the '<em>Static initializer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_INITIALIZER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.StatementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 15;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>If Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__IF_STATEMENT = 1;

  /**
   * The feature id for the '<em><b>Do Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__DO_STATEMENT = 2;

  /**
   * The feature id for the '<em><b>While Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__WHILE_STATEMENT = 3;

  /**
   * The feature id for the '<em><b>For Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__FOR_STATEMENT = 4;

  /**
   * The feature id for the '<em><b>Switch Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__SWITCH_STATEMENT = 5;

  /**
   * The feature id for the '<em><b>Try</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__TRY = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__NAME = 7;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STATEMENT = 8;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Statement_blockImpl <em>Statement block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Statement_blockImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getStatement_block()
   * @generated
   */
  int STATEMENT_BLOCK = 14;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__VARIABLE = STATEMENT__VARIABLE;

  /**
   * The feature id for the '<em><b>If Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__IF_STATEMENT = STATEMENT__IF_STATEMENT;

  /**
   * The feature id for the '<em><b>Do Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__DO_STATEMENT = STATEMENT__DO_STATEMENT;

  /**
   * The feature id for the '<em><b>While Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__WHILE_STATEMENT = STATEMENT__WHILE_STATEMENT;

  /**
   * The feature id for the '<em><b>For Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__FOR_STATEMENT = STATEMENT__FOR_STATEMENT;

  /**
   * The feature id for the '<em><b>Switch Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__SWITCH_STATEMENT = STATEMENT__SWITCH_STATEMENT;

  /**
   * The feature id for the '<em><b>Try</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__TRY = STATEMENT__TRY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__NAME = STATEMENT__NAME;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__STATEMENT = STATEMENT__STATEMENT;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Statement block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Switch_StatementImpl <em>Switch Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Switch_StatementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getSwitch_Statement()
   * @generated
   */
  int SWITCH_STATEMENT = 16;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_STATEMENT__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Switch Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_STATEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.For_StatementImpl <em>For Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.For_StatementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getFor_Statement()
   * @generated
   */
  int FOR_STATEMENT = 17;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Pv</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__PV = 1;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__STATEMENT = 2;

  /**
   * The number of structural features of the '<em>For Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.While_StatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.While_StatementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getWhile_Statement()
   * @generated
   */
  int WHILE_STATEMENT = 18;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__STATEMENT = 0;

  /**
   * The number of structural features of the '<em>While Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Do_StatementImpl <em>Do Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Do_StatementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getDo_Statement()
   * @generated
   */
  int DO_STATEMENT = 19;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT__STATEMENT = 0;

  /**
   * The number of structural features of the '<em>Do Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_STATEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.If_StatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.If_StatementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getIf_Statement()
   * @generated
   */
  int IF_STATEMENT = 20;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__STATEMENT = 0;

  /**
   * The feature id for the '<em><b>Else Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE_STATEMENT = 1;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Try_statementImpl <em>Try statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Try_statementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getTry_statement()
   * @generated
   */
  int TRY_STATEMENT = 21;

  /**
   * The feature id for the '<em><b>Try</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__TRY = 0;

  /**
   * The feature id for the '<em><b>Try Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__TRY_STATEMENT = 1;

  /**
   * The feature id for the '<em><b>Catchs</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__CATCHS = 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__PARAMETERS = 3;

  /**
   * The feature id for the '<em><b>Catch Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__CATCH_STATEMENTS = 4;

  /**
   * The feature id for the '<em><b>Finally</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__FINALLY = 5;

  /**
   * The feature id for the '<em><b>Finally Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT__FINALLY_STATEMENT = 6;

  /**
   * The number of structural features of the '<em>Try statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_STATEMENT_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Package_statementImpl <em>Package statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Package_statementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getPackage_statement()
   * @generated
   */
  int PACKAGE_STATEMENT = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_STATEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Package statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_STATEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.java.java.impl.Import_statementImpl <em>Import statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.java.java.impl.Import_statementImpl
   * @see org.xtext.java.java.impl.JavaPackageImpl#getImport_statement()
   * @generated
   */
  int IMPORT_STATEMENT = 23;

  /**
   * The feature id for the '<em><b>Classname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STATEMENT__CLASSNAME = 0;

  /**
   * The feature id for the '<em><b>Packagename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STATEMENT__PACKAGENAME = 1;

  /**
   * The number of structural features of the '<em>Import statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STATEMENT_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Head <em>Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Head</em>'.
   * @see org.xtext.java.java.Head
   * @generated
   */
  EClass getHead();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Head#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.xtext.java.java.Head#getElements()
   * @see #getHead()
   * @generated
   */
  EReference getHead_Elements();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Compilation_unit <em>Compilation unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compilation unit</em>'.
   * @see org.xtext.java.java.Compilation_unit
   * @generated
   */
  EClass getCompilation_unit();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Compilation_unit#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Package</em>'.
   * @see org.xtext.java.java.Compilation_unit#getPackage()
   * @see #getCompilation_unit()
   * @generated
   */
  EReference getCompilation_unit_Package();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Compilation_unit#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.xtext.java.java.Compilation_unit#getImports()
   * @see #getCompilation_unit()
   * @generated
   */
  EReference getCompilation_unit_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Compilation_unit#getType_declarations <em>Type declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type declarations</em>'.
   * @see org.xtext.java.java.Compilation_unit#getType_declarations()
   * @see #getCompilation_unit()
   * @generated
   */
  EReference getCompilation_unit_Type_declarations();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Type_declaration <em>Type declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type declaration</em>'.
   * @see org.xtext.java.java.Type_declaration
   * @generated
   */
  EClass getType_declaration();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Type_declaration#getDoc <em>Doc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Doc</em>'.
   * @see org.xtext.java.java.Type_declaration#getDoc()
   * @see #getType_declaration()
   * @generated
   */
  EAttribute getType_declaration_Doc();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Type_declaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.xtext.java.java.Type_declaration#getName()
   * @see #getType_declaration()
   * @generated
   */
  EReference getType_declaration_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Interface_declaration <em>Interface declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface declaration</em>'.
   * @see org.xtext.java.java.Interface_declaration
   * @generated
   */
  EClass getInterface_declaration();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Interface_declaration#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Modifiers</em>'.
   * @see org.xtext.java.java.Interface_declaration#getModifiers()
   * @see #getInterface_declaration()
   * @generated
   */
  EAttribute getInterface_declaration_Modifiers();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Interface_declaration#getInterfaceName <em>Interface Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface Name</em>'.
   * @see org.xtext.java.java.Interface_declaration#getInterfaceName()
   * @see #getInterface_declaration()
   * @generated
   */
  EAttribute getInterface_declaration_InterfaceName();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Interface_declaration#getExtend <em>Extend</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extend</em>'.
   * @see org.xtext.java.java.Interface_declaration#getExtend()
   * @see #getInterface_declaration()
   * @generated
   */
  EAttribute getInterface_declaration_Extend();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Interface_declaration#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Extends</em>'.
   * @see org.xtext.java.java.Interface_declaration#getExtends()
   * @see #getInterface_declaration()
   * @generated
   */
  EAttribute getInterface_declaration_Extends();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Class_declaration <em>Class declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class declaration</em>'.
   * @see org.xtext.java.java.Class_declaration
   * @generated
   */
  EClass getClass_declaration();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Class_declaration#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Modifiers</em>'.
   * @see org.xtext.java.java.Class_declaration#getModifiers()
   * @see #getClass_declaration()
   * @generated
   */
  EAttribute getClass_declaration_Modifiers();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Class_declaration#getClassName <em>Class Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class Name</em>'.
   * @see org.xtext.java.java.Class_declaration#getClassName()
   * @see #getClass_declaration()
   * @generated
   */
  EAttribute getClass_declaration_ClassName();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Class_declaration#getExtend <em>Extend</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extend</em>'.
   * @see org.xtext.java.java.Class_declaration#getExtend()
   * @see #getClass_declaration()
   * @generated
   */
  EAttribute getClass_declaration_Extend();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Class_declaration#getImplement <em>Implement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Implement</em>'.
   * @see org.xtext.java.java.Class_declaration#getImplement()
   * @see #getClass_declaration()
   * @generated
   */
  EAttribute getClass_declaration_Implement();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Class_declaration#getImplements <em>Implements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Implements</em>'.
   * @see org.xtext.java.java.Class_declaration#getImplements()
   * @see #getClass_declaration()
   * @generated
   */
  EAttribute getClass_declaration_Implements();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Class_declaration#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.xtext.java.java.Class_declaration#getFields()
   * @see #getClass_declaration()
   * @generated
   */
  EReference getClass_declaration_Fields();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Field_declaration <em>Field declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field declaration</em>'.
   * @see org.xtext.java.java.Field_declaration
   * @generated
   */
  EClass getField_declaration();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Field_declaration#getDoc <em>Doc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Doc</em>'.
   * @see org.xtext.java.java.Field_declaration#getDoc()
   * @see #getField_declaration()
   * @generated
   */
  EAttribute getField_declaration_Doc();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Field_declaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.xtext.java.java.Field_declaration#getName()
   * @see #getField_declaration()
   * @generated
   */
  EReference getField_declaration_Name();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Field_declaration#getDebug <em>Debug</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Debug</em>'.
   * @see org.xtext.java.java.Field_declaration#getDebug()
   * @see #getField_declaration()
   * @generated
   */
  EAttribute getField_declaration_Debug();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Method_declaration <em>Method declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method declaration</em>'.
   * @see org.xtext.java.java.Method_declaration
   * @generated
   */
  EClass getMethod_declaration();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Method_declaration#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Modifiers</em>'.
   * @see org.xtext.java.java.Method_declaration#getModifiers()
   * @see #getMethod_declaration()
   * @generated
   */
  EAttribute getMethod_declaration_Modifiers();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Method_declaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.java.java.Method_declaration#getType()
   * @see #getMethod_declaration()
   * @generated
   */
  EReference getMethod_declaration_Type();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Method_declaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.java.java.Method_declaration#getName()
   * @see #getMethod_declaration()
   * @generated
   */
  EAttribute getMethod_declaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Method_declaration#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter</em>'.
   * @see org.xtext.java.java.Method_declaration#getParameter()
   * @see #getMethod_declaration()
   * @generated
   */
  EReference getMethod_declaration_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Method_declaration#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see org.xtext.java.java.Method_declaration#getStatement()
   * @see #getMethod_declaration()
   * @generated
   */
  EReference getMethod_declaration_Statement();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Method_declaration#getDebug <em>Debug</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Debug</em>'.
   * @see org.xtext.java.java.Method_declaration#getDebug()
   * @see #getMethod_declaration()
   * @generated
   */
  EAttribute getMethod_declaration_Debug();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Constructor_declaration <em>Constructor declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor declaration</em>'.
   * @see org.xtext.java.java.Constructor_declaration
   * @generated
   */
  EClass getConstructor_declaration();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Constructor_declaration#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Modifiers</em>'.
   * @see org.xtext.java.java.Constructor_declaration#getModifiers()
   * @see #getConstructor_declaration()
   * @generated
   */
  EAttribute getConstructor_declaration_Modifiers();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Constructor_declaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.java.java.Constructor_declaration#getName()
   * @see #getConstructor_declaration()
   * @generated
   */
  EAttribute getConstructor_declaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Constructor_declaration#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameters</em>'.
   * @see org.xtext.java.java.Constructor_declaration#getParameters()
   * @see #getConstructor_declaration()
   * @generated
   */
  EReference getConstructor_declaration_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Constructor_declaration#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see org.xtext.java.java.Constructor_declaration#getStatement()
   * @see #getConstructor_declaration()
   * @generated
   */
  EReference getConstructor_declaration_Statement();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Parameter_list <em>Parameter list</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter list</em>'.
   * @see org.xtext.java.java.Parameter_list
   * @generated
   */
  EClass getParameter_list();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Parameter_list#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter</em>'.
   * @see org.xtext.java.java.Parameter_list#getParameter()
   * @see #getParameter_list()
   * @generated
   */
  EReference getParameter_list_Parameter();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Parameter_list#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.xtext.java.java.Parameter_list#getParameters()
   * @see #getParameter_list()
   * @generated
   */
  EReference getParameter_list_Parameters();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.xtext.java.java.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Parameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.java.java.Parameter#getType()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Type();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.java.java.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Variable_declaration <em>Variable declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable declaration</em>'.
   * @see org.xtext.java.java.Variable_declaration
   * @generated
   */
  EClass getVariable_declaration();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Variable_declaration#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Modifiers</em>'.
   * @see org.xtext.java.java.Variable_declaration#getModifiers()
   * @see #getVariable_declaration()
   * @generated
   */
  EAttribute getVariable_declaration_Modifiers();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Variable_declaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.java.java.Variable_declaration#getType()
   * @see #getVariable_declaration()
   * @generated
   */
  EReference getVariable_declaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Variable_declaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.xtext.java.java.Variable_declaration#getName()
   * @see #getVariable_declaration()
   * @generated
   */
  EReference getVariable_declaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Variable_declaration#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Names</em>'.
   * @see org.xtext.java.java.Variable_declaration#getNames()
   * @see #getVariable_declaration()
   * @generated
   */
  EReference getVariable_declaration_Names();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Variable_declarator <em>Variable declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable declarator</em>'.
   * @see org.xtext.java.java.Variable_declarator
   * @generated
   */
  EClass getVariable_declarator();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Variable_declarator#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.java.java.Variable_declarator#getName()
   * @see #getVariable_declarator()
   * @generated
   */
  EAttribute getVariable_declarator_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.xtext.java.java.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Type#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.java.java.Type#getName()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Static_initializer <em>Static initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Static initializer</em>'.
   * @see org.xtext.java.java.Static_initializer
   * @generated
   */
  EClass getStatic_initializer();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Static_initializer#getStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.xtext.java.java.Static_initializer#getStatic()
   * @see #getStatic_initializer()
   * @generated
   */
  EAttribute getStatic_initializer_Static();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Static_initializer#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.xtext.java.java.Static_initializer#getName()
   * @see #getStatic_initializer()
   * @generated
   */
  EReference getStatic_initializer_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Statement_block <em>Statement block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement block</em>'.
   * @see org.xtext.java.java.Statement_block
   * @generated
   */
  EClass getStatement_block();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Statement_block#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.xtext.java.java.Statement_block#getStatements()
   * @see #getStatement_block()
   * @generated
   */
  EReference getStatement_block_Statements();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.xtext.java.java.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.xtext.java.java.Statement#getVariable()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getIfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Statement</em>'.
   * @see org.xtext.java.java.Statement#getIfStatement()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_IfStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getDoStatement <em>Do Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Do Statement</em>'.
   * @see org.xtext.java.java.Statement#getDoStatement()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_DoStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getWhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>While Statement</em>'.
   * @see org.xtext.java.java.Statement#getWhileStatement()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_WhileStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>For Statement</em>'.
   * @see org.xtext.java.java.Statement#getForStatement()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_ForStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getSwitchStatement <em>Switch Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Switch Statement</em>'.
   * @see org.xtext.java.java.Statement#getSwitchStatement()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_SwitchStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getTry <em>Try</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Try</em>'.
   * @see org.xtext.java.java.Statement#getTry()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Try();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Statement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.java.java.Statement#getName()
   * @see #getStatement()
   * @generated
   */
  EAttribute getStatement_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Statement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see org.xtext.java.java.Statement#getStatement()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Statement();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Switch_Statement <em>Switch Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Switch Statement</em>'.
   * @see org.xtext.java.java.Switch_Statement
   * @generated
   */
  EClass getSwitch_Statement();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Switch_Statement#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.xtext.java.java.Switch_Statement#getStatements()
   * @see #getSwitch_Statement()
   * @generated
   */
  EReference getSwitch_Statement_Statements();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.For_Statement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Statement</em>'.
   * @see org.xtext.java.java.For_Statement
   * @generated
   */
  EClass getFor_Statement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.For_Statement#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.xtext.java.java.For_Statement#getVariable()
   * @see #getFor_Statement()
   * @generated
   */
  EReference getFor_Statement_Variable();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.For_Statement#getPv <em>Pv</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pv</em>'.
   * @see org.xtext.java.java.For_Statement#getPv()
   * @see #getFor_Statement()
   * @generated
   */
  EAttribute getFor_Statement_Pv();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.For_Statement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see org.xtext.java.java.For_Statement#getStatement()
   * @see #getFor_Statement()
   * @generated
   */
  EReference getFor_Statement_Statement();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.While_Statement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Statement</em>'.
   * @see org.xtext.java.java.While_Statement
   * @generated
   */
  EClass getWhile_Statement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.While_Statement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see org.xtext.java.java.While_Statement#getStatement()
   * @see #getWhile_Statement()
   * @generated
   */
  EReference getWhile_Statement_Statement();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Do_Statement <em>Do Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Do Statement</em>'.
   * @see org.xtext.java.java.Do_Statement
   * @generated
   */
  EClass getDo_Statement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Do_Statement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see org.xtext.java.java.Do_Statement#getStatement()
   * @see #getDo_Statement()
   * @generated
   */
  EReference getDo_Statement_Statement();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.If_Statement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see org.xtext.java.java.If_Statement
   * @generated
   */
  EClass getIf_Statement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.If_Statement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see org.xtext.java.java.If_Statement#getStatement()
   * @see #getIf_Statement()
   * @generated
   */
  EReference getIf_Statement_Statement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.If_Statement#getElseStatement <em>Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Statement</em>'.
   * @see org.xtext.java.java.If_Statement#getElseStatement()
   * @see #getIf_Statement()
   * @generated
   */
  EReference getIf_Statement_ElseStatement();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Try_statement <em>Try statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Try statement</em>'.
   * @see org.xtext.java.java.Try_statement
   * @generated
   */
  EClass getTry_statement();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Try_statement#getTry <em>Try</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Try</em>'.
   * @see org.xtext.java.java.Try_statement#getTry()
   * @see #getTry_statement()
   * @generated
   */
  EAttribute getTry_statement_Try();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Try_statement#getTryStatement <em>Try Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Try Statement</em>'.
   * @see org.xtext.java.java.Try_statement#getTryStatement()
   * @see #getTry_statement()
   * @generated
   */
  EReference getTry_statement_TryStatement();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.java.java.Try_statement#getCatchs <em>Catchs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Catchs</em>'.
   * @see org.xtext.java.java.Try_statement#getCatchs()
   * @see #getTry_statement()
   * @generated
   */
  EAttribute getTry_statement_Catchs();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Try_statement#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.xtext.java.java.Try_statement#getParameters()
   * @see #getTry_statement()
   * @generated
   */
  EReference getTry_statement_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.java.java.Try_statement#getCatchStatements <em>Catch Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Catch Statements</em>'.
   * @see org.xtext.java.java.Try_statement#getCatchStatements()
   * @see #getTry_statement()
   * @generated
   */
  EReference getTry_statement_CatchStatements();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Try_statement#getFinally <em>Finally</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Finally</em>'.
   * @see org.xtext.java.java.Try_statement#getFinally()
   * @see #getTry_statement()
   * @generated
   */
  EAttribute getTry_statement_Finally();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.java.java.Try_statement#getFinallyStatement <em>Finally Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Finally Statement</em>'.
   * @see org.xtext.java.java.Try_statement#getFinallyStatement()
   * @see #getTry_statement()
   * @generated
   */
  EReference getTry_statement_FinallyStatement();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Package_statement <em>Package statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package statement</em>'.
   * @see org.xtext.java.java.Package_statement
   * @generated
   */
  EClass getPackage_statement();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Package_statement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.java.java.Package_statement#getName()
   * @see #getPackage_statement()
   * @generated
   */
  EAttribute getPackage_statement_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.java.java.Import_statement <em>Import statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import statement</em>'.
   * @see org.xtext.java.java.Import_statement
   * @generated
   */
  EClass getImport_statement();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Import_statement#getClassname <em>Classname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Classname</em>'.
   * @see org.xtext.java.java.Import_statement#getClassname()
   * @see #getImport_statement()
   * @generated
   */
  EAttribute getImport_statement_Classname();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.java.java.Import_statement#getPackagename <em>Packagename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Packagename</em>'.
   * @see org.xtext.java.java.Import_statement#getPackagename()
   * @see #getImport_statement()
   * @generated
   */
  EAttribute getImport_statement_Packagename();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  JavaFactory getJavaFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.HeadImpl <em>Head</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.HeadImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getHead()
     * @generated
     */
    EClass HEAD = eINSTANCE.getHead();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HEAD__ELEMENTS = eINSTANCE.getHead_Elements();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Compilation_unitImpl <em>Compilation unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Compilation_unitImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getCompilation_unit()
     * @generated
     */
    EClass COMPILATION_UNIT = eINSTANCE.getCompilation_unit();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPILATION_UNIT__PACKAGE = eINSTANCE.getCompilation_unit_Package();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPILATION_UNIT__IMPORTS = eINSTANCE.getCompilation_unit_Imports();

    /**
     * The meta object literal for the '<em><b>Type declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPILATION_UNIT__TYPE_DECLARATIONS = eINSTANCE.getCompilation_unit_Type_declarations();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Type_declarationImpl <em>Type declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Type_declarationImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getType_declaration()
     * @generated
     */
    EClass TYPE_DECLARATION = eINSTANCE.getType_declaration();

    /**
     * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DECLARATION__DOC = eINSTANCE.getType_declaration_Doc();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DECLARATION__NAME = eINSTANCE.getType_declaration_Name();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Interface_declarationImpl <em>Interface declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Interface_declarationImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getInterface_declaration()
     * @generated
     */
    EClass INTERFACE_DECLARATION = eINSTANCE.getInterface_declaration();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_DECLARATION__MODIFIERS = eINSTANCE.getInterface_declaration_Modifiers();

    /**
     * The meta object literal for the '<em><b>Interface Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_DECLARATION__INTERFACE_NAME = eINSTANCE.getInterface_declaration_InterfaceName();

    /**
     * The meta object literal for the '<em><b>Extend</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_DECLARATION__EXTEND = eINSTANCE.getInterface_declaration_Extend();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_DECLARATION__EXTENDS = eINSTANCE.getInterface_declaration_Extends();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Class_declarationImpl <em>Class declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Class_declarationImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getClass_declaration()
     * @generated
     */
    EClass CLASS_DECLARATION = eINSTANCE.getClass_declaration();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_DECLARATION__MODIFIERS = eINSTANCE.getClass_declaration_Modifiers();

    /**
     * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_DECLARATION__CLASS_NAME = eINSTANCE.getClass_declaration_ClassName();

    /**
     * The meta object literal for the '<em><b>Extend</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_DECLARATION__EXTEND = eINSTANCE.getClass_declaration_Extend();

    /**
     * The meta object literal for the '<em><b>Implement</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_DECLARATION__IMPLEMENT = eINSTANCE.getClass_declaration_Implement();

    /**
     * The meta object literal for the '<em><b>Implements</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_DECLARATION__IMPLEMENTS = eINSTANCE.getClass_declaration_Implements();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DECLARATION__FIELDS = eINSTANCE.getClass_declaration_Fields();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Field_declarationImpl <em>Field declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Field_declarationImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getField_declaration()
     * @generated
     */
    EClass FIELD_DECLARATION = eINSTANCE.getField_declaration();

    /**
     * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_DECLARATION__DOC = eINSTANCE.getField_declaration_Doc();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_DECLARATION__NAME = eINSTANCE.getField_declaration_Name();

    /**
     * The meta object literal for the '<em><b>Debug</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_DECLARATION__DEBUG = eINSTANCE.getField_declaration_Debug();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Method_declarationImpl <em>Method declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Method_declarationImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getMethod_declaration()
     * @generated
     */
    EClass METHOD_DECLARATION = eINSTANCE.getMethod_declaration();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD_DECLARATION__MODIFIERS = eINSTANCE.getMethod_declaration_Modifiers();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_DECLARATION__TYPE = eINSTANCE.getMethod_declaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD_DECLARATION__NAME = eINSTANCE.getMethod_declaration_Name();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_DECLARATION__PARAMETER = eINSTANCE.getMethod_declaration_Parameter();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_DECLARATION__STATEMENT = eINSTANCE.getMethod_declaration_Statement();

    /**
     * The meta object literal for the '<em><b>Debug</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD_DECLARATION__DEBUG = eINSTANCE.getMethod_declaration_Debug();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Constructor_declarationImpl <em>Constructor declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Constructor_declarationImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getConstructor_declaration()
     * @generated
     */
    EClass CONSTRUCTOR_DECLARATION = eINSTANCE.getConstructor_declaration();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRUCTOR_DECLARATION__MODIFIERS = eINSTANCE.getConstructor_declaration_Modifiers();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRUCTOR_DECLARATION__NAME = eINSTANCE.getConstructor_declaration_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_DECLARATION__PARAMETERS = eINSTANCE.getConstructor_declaration_Parameters();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_DECLARATION__STATEMENT = eINSTANCE.getConstructor_declaration_Statement();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Parameter_listImpl <em>Parameter list</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Parameter_listImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getParameter_list()
     * @generated
     */
    EClass PARAMETER_LIST = eINSTANCE.getParameter_list();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_LIST__PARAMETER = eINSTANCE.getParameter_list_Parameter();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_LIST__PARAMETERS = eINSTANCE.getParameter_list_Parameters();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.ParameterImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Variable_declarationImpl <em>Variable declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Variable_declarationImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getVariable_declaration()
     * @generated
     */
    EClass VARIABLE_DECLARATION = eINSTANCE.getVariable_declaration();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION__MODIFIERS = eINSTANCE.getVariable_declaration_Modifiers();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariable_declaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__NAME = eINSTANCE.getVariable_declaration_Name();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__NAMES = eINSTANCE.getVariable_declaration_Names();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Variable_declaratorImpl <em>Variable declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Variable_declaratorImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getVariable_declarator()
     * @generated
     */
    EClass VARIABLE_DECLARATOR = eINSTANCE.getVariable_declarator();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATOR__NAME = eINSTANCE.getVariable_declarator_Name();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.TypeImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__NAME = eINSTANCE.getType_Name();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Static_initializerImpl <em>Static initializer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Static_initializerImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getStatic_initializer()
     * @generated
     */
    EClass STATIC_INITIALIZER = eINSTANCE.getStatic_initializer();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATIC_INITIALIZER__STATIC = eINSTANCE.getStatic_initializer_Static();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATIC_INITIALIZER__NAME = eINSTANCE.getStatic_initializer_Name();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Statement_blockImpl <em>Statement block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Statement_blockImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getStatement_block()
     * @generated
     */
    EClass STATEMENT_BLOCK = eINSTANCE.getStatement_block();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT_BLOCK__STATEMENTS = eINSTANCE.getStatement_block_Statements();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.StatementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__VARIABLE = eINSTANCE.getStatement_Variable();

    /**
     * The meta object literal for the '<em><b>If Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__IF_STATEMENT = eINSTANCE.getStatement_IfStatement();

    /**
     * The meta object literal for the '<em><b>Do Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__DO_STATEMENT = eINSTANCE.getStatement_DoStatement();

    /**
     * The meta object literal for the '<em><b>While Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__WHILE_STATEMENT = eINSTANCE.getStatement_WhileStatement();

    /**
     * The meta object literal for the '<em><b>For Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__FOR_STATEMENT = eINSTANCE.getStatement_ForStatement();

    /**
     * The meta object literal for the '<em><b>Switch Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__SWITCH_STATEMENT = eINSTANCE.getStatement_SwitchStatement();

    /**
     * The meta object literal for the '<em><b>Try</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__TRY = eINSTANCE.getStatement_Try();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATEMENT__NAME = eINSTANCE.getStatement_Name();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STATEMENT = eINSTANCE.getStatement_Statement();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Switch_StatementImpl <em>Switch Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Switch_StatementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getSwitch_Statement()
     * @generated
     */
    EClass SWITCH_STATEMENT = eINSTANCE.getSwitch_Statement();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_STATEMENT__STATEMENTS = eINSTANCE.getSwitch_Statement_Statements();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.For_StatementImpl <em>For Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.For_StatementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getFor_Statement()
     * @generated
     */
    EClass FOR_STATEMENT = eINSTANCE.getFor_Statement();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__VARIABLE = eINSTANCE.getFor_Statement_Variable();

    /**
     * The meta object literal for the '<em><b>Pv</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR_STATEMENT__PV = eINSTANCE.getFor_Statement_Pv();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__STATEMENT = eINSTANCE.getFor_Statement_Statement();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.While_StatementImpl <em>While Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.While_StatementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getWhile_Statement()
     * @generated
     */
    EClass WHILE_STATEMENT = eINSTANCE.getWhile_Statement();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__STATEMENT = eINSTANCE.getWhile_Statement_Statement();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Do_StatementImpl <em>Do Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Do_StatementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getDo_Statement()
     * @generated
     */
    EClass DO_STATEMENT = eINSTANCE.getDo_Statement();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_STATEMENT__STATEMENT = eINSTANCE.getDo_Statement_Statement();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.If_StatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.If_StatementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getIf_Statement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIf_Statement();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__STATEMENT = eINSTANCE.getIf_Statement_Statement();

    /**
     * The meta object literal for the '<em><b>Else Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE_STATEMENT = eINSTANCE.getIf_Statement_ElseStatement();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Try_statementImpl <em>Try statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Try_statementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getTry_statement()
     * @generated
     */
    EClass TRY_STATEMENT = eINSTANCE.getTry_statement();

    /**
     * The meta object literal for the '<em><b>Try</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRY_STATEMENT__TRY = eINSTANCE.getTry_statement_Try();

    /**
     * The meta object literal for the '<em><b>Try Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_STATEMENT__TRY_STATEMENT = eINSTANCE.getTry_statement_TryStatement();

    /**
     * The meta object literal for the '<em><b>Catchs</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRY_STATEMENT__CATCHS = eINSTANCE.getTry_statement_Catchs();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_STATEMENT__PARAMETERS = eINSTANCE.getTry_statement_Parameters();

    /**
     * The meta object literal for the '<em><b>Catch Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_STATEMENT__CATCH_STATEMENTS = eINSTANCE.getTry_statement_CatchStatements();

    /**
     * The meta object literal for the '<em><b>Finally</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRY_STATEMENT__FINALLY = eINSTANCE.getTry_statement_Finally();

    /**
     * The meta object literal for the '<em><b>Finally Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_STATEMENT__FINALLY_STATEMENT = eINSTANCE.getTry_statement_FinallyStatement();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Package_statementImpl <em>Package statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Package_statementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getPackage_statement()
     * @generated
     */
    EClass PACKAGE_STATEMENT = eINSTANCE.getPackage_statement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_STATEMENT__NAME = eINSTANCE.getPackage_statement_Name();

    /**
     * The meta object literal for the '{@link org.xtext.java.java.impl.Import_statementImpl <em>Import statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.java.java.impl.Import_statementImpl
     * @see org.xtext.java.java.impl.JavaPackageImpl#getImport_statement()
     * @generated
     */
    EClass IMPORT_STATEMENT = eINSTANCE.getImport_statement();

    /**
     * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_STATEMENT__CLASSNAME = eINSTANCE.getImport_statement_Classname();

    /**
     * The meta object literal for the '<em><b>Packagename</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_STATEMENT__PACKAGENAME = eINSTANCE.getImport_statement_Packagename();

  }

} //JavaPackage
