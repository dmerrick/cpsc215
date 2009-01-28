/**
 * File: NodePositionList.java
 * 
 * This class implements the ADT node list using a doubly-linked list.
 *
 * @author Jessica Tait
 * @author Dana Merrick
 */
public class NodePositionList<E> implements PositionList<E> {

  protected int numElts;            	// Number of elements in the list
  protected DNode<E> header, trailer;	// Special sentinels

  /** 
   * Constructor that creates an empty list - O(1) time
   */
  public NodePositionList() {
    numElts = 0;
    header = new DNode<E>(null, null, null);
    trailer = new DNode<E>(header, null, null);
    header.setNext(trailer);
  }

  /** 
   * Checks if position is valid for this list and converts it to DNode if it
   * is valid - O(1) time
   *
   * @param the position to check
   * @return the valid DNode
   */
  protected DNode<E> checkPosition(Position<E> p)
    throws InvalidPositionException {
    if (p == null)
      throw new InvalidPositionException
	("Null position passed to NodeList");
    if (p == header)
	throw new InvalidPositionException
	  ("The header node is not a valid position");
    if (p == trailer)
	throw new InvalidPositionException
	  ("The trailer node is not a valid position");
    try {
      DNode<E> temp = (DNode<E>) p;
      if ((temp.getPrev() == null) || (temp.getNext() == null))
	throw new InvalidPositionException
	  ("Position does not belong to a valid NodeList");
      return temp;
    } catch (ClassCastException e) {
      throw new InvalidPositionException
	("Position is of wrong type for this list");
    }
  }

  /**
   * Returns the number of elements in the list - O(1) time
   *
   * @return int the size of the list
   */
  public int size() { return numElts; }

  /**
   * Returns whether the list is empty - O(1) time
   *
   * @return boolean true if the list is empty
   */
  public boolean isEmpty() { return (numElts == 0); }

  /**
   * Returns the first position in the list - O(1) time
   *
   * @return Position<E> the first element in the list
   */
  public Position<E> first() throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("List is empty");
    return header.getNext();
  }

  /**
   * Returns the last position in the list - O(1) time
   *
   * @return Position<E> the last element in the list
   */
  public Position<E> last() throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("List is empty");
    return trailer.getPrev();
  }

  /**
   * Returns the position after the given one - O(1) time
   *
   * @param the position we're looking at
   * @return Position<E> the element following the argument
   */
  public Position<E> next(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {
    DNode<E> v = checkPosition(p);
    DNode<E> next = v.getNext();
    if (next == trailer)
      throw new BoundaryViolationException
	("Cannot advance past the beginning of the list");
    return next;
  }

  /**
   * Returns the position before the given one - O(1) time
   *
   * @param the position we're looking at
   * @return Position<E> the element before the argument
   */
  public Position<E> prev(Position<E> p)
    throws InvalidPositionException, BoundaryViolationException {
    DNode<E> v = checkPosition(p);
    DNode<E> prev = v.getPrev();
    if (prev == header)
      throw new BoundaryViolationException
	("Cannot advance past the beginning of the list");
    return prev;
  }

  /**
   * Inserts the given element at the beginning of the list, returning the new
   * position - O(1) time
   *
   * @param the element to add
   */
  public void addFirst(E element) {
    numElts++;
    DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
    header.getNext().setPrev(newNode);
    header.setNext(newNode);
  }

  /**
   * Inserts the given element at the end of the list, returning the new 
   * position - O(1) time
   *
   * @param the element to add
   */
  public void addLast(E element) {
    numElts++;
    DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, element);
    trailer.getPrev().setNext(newNode);
    trailer.setPrev(newNode);
  }

  /** 
   * Inserts the given element after the given position, returning the new
   * position - O(1) time
   *
   * @param the position we're working with
   * @param the element to add after the given position
   */
  public void addAfter(Position<E> p, E element) 
      throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    numElts++;
    DNode<E> newNode = new DNode<E>(v, v.getNext(), element);
    v.getNext().setPrev(newNode);
    v.setNext(newNode);
  }

  /** 
   * Inserts the given element before the given position, returning the new
   * position - O(1) time
   *
   * @param the position we're working with
   * @param the element to add before the given position
   */
  public void addBefore(Position<E> p, E element) 
      throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    numElts++;
    DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
    v.getPrev().setNext(newNode);
    v.setPrev(newNode);
  }

  /**
   * Removes the given position from the list - O(1) time
   *
   * @param the position of the element to remove
   * @return E the value of the element removed
   */
  public E remove(Position<E> p) throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    numElts--;
    DNode<E> vPrev = v.getPrev();
    DNode<E> vNext = v.getNext();
    vPrev.setNext(vNext);
    vNext.setPrev(vPrev);
    E vElem = v.element();
    v.setNext(null);
    v.setPrev(null);
    return vElem;
  }

  /**
   * Replaces the element at the given position with the new element
   * and return the old element - O(1) time
   *
   * @param the position we're working with
   * @param the value we will be setting
   * @return E the previous value of the given position
   */
  public E set(Position<E> p, E element)
      throws InvalidPositionException {
    DNode<E> v = checkPosition(p);
    E oldElt = v.element();
    v.setElement(element);
    return oldElt;
  }

  /**
   * Returns an iterator of all the elements.
   *
   * @return Iterator<E> the basic iterator for the list
   */
  public Iterator<E> iterator() {
    return new ElementIterator<E>(this);
  }

  /**
   * Returns an iterator of every other element.
   *
   * @return EveryOtherElementIterator<E> the iterator that represents every other element in in the list
   */
  public Iterator<E> everyOtherElementIterator() {
    return new EveryOtherElementIterator<E>(this);
  }

  /**
   * Returns an iterator of all the elements in reverse order.
   *
   * @return ReverseElementIterator<E> the reverse iterator for the list
   */
  public Iterator<E> reverseElementIterator() {
    return new ReverseElementIterator<E>(this);
  }

}
