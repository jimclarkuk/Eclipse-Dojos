package org.eclipse.example.library;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface Book extends EObject
{
  /**
   * @model
   */
  String getTitle();

  /**
	 * Sets the value of the '{@link org.eclipse.example.library.Book#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

		/**
   * @model default="100"
   */
  int getPages();

  /**
	 * Sets the value of the '{@link org.eclipse.example.library.Book#getPages <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pages</em>' attribute.
	 * @see #getPages()
	 * @generated
	 */
	void setPages(int value);

		/**
   * @model
   */
  BookCategory getCategory();

  /**
	 * Sets the value of the '{@link org.eclipse.example.library.Book#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see org.eclipse.example.library.BookCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(BookCategory value);

		/**
   * @model opposite="books"
   */
  Writer getAuthor();

		/**
	 * Sets the value of the '{@link org.eclipse.example.library.Book#getAuthor <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(Writer value);

		/**
	 * Returns the value of the '<em><b>Borrowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Borrowed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Borrowed</em>' attribute.
	 * @see #setBorrowed(boolean)
	 * @see org.eclipse.example.library.LibraryPackage#getBook_Borrowed()
	 * @model
	 * @generated
	 */
	boolean isBorrowed();

		/**
	 * Sets the value of the '{@link org.eclipse.example.library.Book#isBorrowed <em>Borrowed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Borrowed</em>' attribute.
	 * @see #isBorrowed()
	 * @generated
	 */
	void setBorrowed(boolean value);
}