/** 
 * File: ArrayDeque.java
 *
 * This class contains an array based implementation of the ADT deque.
 * 
 * @author Dana Merrick
 */
public class ArrayDeque<E> implements Deque<E>{

  public static final int CAPACITY = 1000; // maxiumum size
  protected E D[]; // the array
  protected int size, first, rear; // size, first element, and first empty element

  /**
   * This nonparametric constructor simply creates an empty deque.
   */
  public ArrayDeque() {
    D = (E[]) new Object[CAPACITY];
    size = first = rear = 0;
  }

  /**
   * Returns the number of elements in the deque.
   *
   * @return int size of deque
   */
  public int size() {
    return size;
  }

  /** 
   * Returns whether the deque is empty.
   *
   * @return boolean true if deque is empty
   */
  public boolean isEmpty() {
    return first == rear;
  }

  /** 
   * Returns the first element; an exception is thrown if deque is empty.
   *
   * @return E the first element
   */
  public E getFirst() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Empty!");
    return D[first];
  }

  /** 
   * Returns the last element; an exception is thrown if deque is empty.
   *
   * @return E the last element
   */
  public E getLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Empty!");
    // we need a special case because we are working with a circular array
    if (rear == 0)
      return D[D.length-1];
    return D[rear-1];
  }

  /**
   * Inserts an element to be the first in the deque.
   *
   * @param E element
   */
  public void addFirst (E element) throws FullDequeException {
    if (rear+1 == first)
      throw new FullDequeException("Full!");

    // deal with special case
    if (first != 0) {
      D[--first]=element;

    } else { // first equals zero
      first=D.length-1;
      D[first]=element;
    }

    size++;
  }

  /**
   * Inserts an element to be the last in the deque.
   *
   * @param E element
   */
  public void addLast (E element) throws FullDequeException {
    if (rear+1 == first)
      throw new FullDequeException("Full!");

    // check that rear is not the last element
    if (rear != D.length - 1) {
      D[rear++]=element;
    } else { // rear is the last element
      rear = 0;
      D[rear]=element;
    }

    size++;
  }

  /** 
   * Removes the first element; an exception is thrown if deque is empty.
   *
   * @return E the first element
   */
  public E removeFirst() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Empty!");

    // the value to be returned
    E temp = D[first];

    if (first+1 != D.length) {
      D[first++]=null;
    } else { // first is the last element
      first = 0;
      D[first]=null;
    }

    size--;
    return temp;
  }

  /** 
   * Removes the last element; an exception is thrown if deque is empty.
   *
   * @return E the last element
   */
  public E removeLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Empty!");
    
    // the value to be returned
    E temp;

    if (rear != 0) {
      temp = D[rear-1];
      D[rear--]=null;

    } else { // rear is zero
      temp = D[D.length-1];
      D[D.length-1]=null;
      rear--;
    }

    size--;
    return temp;
  }

}
