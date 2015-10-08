/**
 */
package org.xtext.java.java;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.java.java.Statement_block#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.xtext.java.java.JavaPackage#getStatement_block()
 * @model
 * @generated
 */
public interface Statement_block extends Statement
{
  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.java.java.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see org.xtext.java.java.JavaPackage#getStatement_block_Statements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getStatements();

} // Statement_block
