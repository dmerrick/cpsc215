/**
 * File: NodeDeque.java
 *
 * This class holds an implementation of an ADT deque using a doubly linked list.
 *
 * @author Dana Merrick
 * @author Chris Hawley
 */

public class NodeDeque<E> implements Deque<E> {

  protected DLNode<E> header, trailer;  // sentinels
  protected int size;                   // number of elements

  /**
   * The nonparametric constructor for the class. Simply creates two empty sentinel nodes.
   */
  public NodeDeque() {
    header = new DLNode<E>();
    trailer = new DLNode<E>();
    header.setNext(trailer);
    trailer.setPrev(header);
    size = 0;
  }

  /**
   * Returns the size of the deque.
   *
   * @return int size
   */
  public int size() {   
    return size;
  }

  /**
   * Returns true if the deque is empty.
   *
   * @return boolean
   */
  public boolean isEmpty() {    
    if (size == 0)
      return true;
    return false;
  }

  /**
   * Returns the value of the first element in the deque.
   *
   * @return E first
   */
  public E getFirst() throws EmptyDequeException {  
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return header.getNext().getElement();
  }

  /**
   * Returns the value of the last element in the deque.
   *
   * @return E last
   */
  public E getLast() throws EmptyDequeException {  
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    return trailer.getPrev().getElement();
  }

  /**
   * Prepends a given element to the deque.
   *
   * @param E the element to be added
   */
  public void addFirst(E o) {  
    DLNode<E> second = header.getNext();
    DLNode<E> first = new DLNode<E>(o, header, second);
    second.setPrev(first);
    header.setNext(first);
    size++;
  }

  /**
   * Adds a given element to the end of the deque.
   *
   * @param E the element to be added
   */
  public void addLast(E o) {  
    DLNode<E> secondtolast = trailer.getPrev();
    DLNode<E> last = new DLNode<E>(o, secondtolast, trailer);
    trailer.setPrev(last);
    secondtolast.setNext(last);
    size++;
  }

  /**
   * Removes the last element from the deque and returns its value.
   *
   * @return E the value of the last element
   */
  public E removeLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> last = trailer.getPrev();
    E o = last.getElement();
    DLNode<E> secondtolast = last.getPrev();
    trailer.setPrev(secondtolast);
    secondtolast.setNext(trailer);
    size--; 
    return o;
  }

  /**
   * Removes the first element from the deque and returns its value.
   *
   * @return E the value of the first element
   */
  public E removeFirst() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque is empty.");
    DLNode<E> first = header.getNext();
    E o = first.getElement();
    DLNode<E> second = first.getNext();
    header.setNext(second);
    second.setPrev(header);
    size--; 
    return o;
  }

}
