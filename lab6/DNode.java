/**
 * File: DNode.java
 *
 * This class defines nodes in doubly-linked lists.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see InvalidPositionException
 */

public class DNode<E> implements Position<E> {

  private DNode<E> prev, next;	// References to the nodes before and after
  private E element;	        // Element stored in this position

  // Constructors
  public DNode() {
    this(null, null, null);
  }
  public DNode(DNode<E> p, DNode<E> n, E e) {
    prev = p;
    next = n;
    element = e;
  }

  // Accessor methods
  public E element() throws InvalidPositionException {
    if ((prev == null) && (next == null))
      throw new InvalidPositionException("Position is not in a list!");
    return element;
  }
  public DNode<E> getNext() { return next; }
  public DNode<E> getPrev() { return prev; }

  // Update methods
  public void setNext(DNode<E> n) { next = n; }
  public void setPrev(DNode<E> p) { prev = p; }
  public void setElement(E e) { element = e; }

}
