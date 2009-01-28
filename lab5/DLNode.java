/**
 * File: DLNode.java
 *
 * Node of a doubly linked list 
 */
public class DLNode <E> {

  protected E element;	           // The element stored by a node
  protected DLNode<E> next, prev;  // Pointers to next and previous nodes

  /** Constructor that creates a node with null references */
  public DLNode() {
    this(null, null, null);
  }

  /** Constructor that creates a node with given fields */
  public DLNode(E e, DLNode<E> p, DLNode<E> n) {
    element = e;
    prev = p;
    next = n;
  }

  /** Returns the element of this node */
  public E getElement() { return element; }

  /** Returns the previous node of this node */
  public DLNode<E> getPrev() { return prev; }

  /** Returns the next node of this node */
  public DLNode<E> getNext() { return next; }

  /** Sets the element of this node */
  public void setElement(E e) { element = e; }

  /** Sets the previous node of this node */
  public void setPrev(DLNode<E> p) { prev = p; }

  /** Sets the next node of this node */
  public void setNext(DLNode<E> n) { next = n; }

}
