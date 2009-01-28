/**
 * File: DequeStack.java
 *
 * This class contains an array based deque based implementation of an ADT stack.
 * 
 * @author Dana Merrick
 */
public class DequeStack<E> implements Stack<E> {

  protected ArrayDeque<E> D; // the deque we will be using
  protected int size; // the size of the deque, since we dont have a method to access the size otherwise.

  /**
   * The nonparametric constructor, which simply initializes and empty DequeStack.
   */
  public DequeStack() {
    D = new ArrayDeque<E>();
    size = 0;
  }

  /**
   * Return the number of elements in the stack.
   * @return number of elements in the stack. 
   */
  public int size() {
    return size;
  }
 
  /** 
   * Return whether the stack is empty.
   * @return true if the stack is empty, false otherwise. 
   */
  public boolean isEmpty() {
    return D.isEmpty();
  }

  /** 
   * Inspect the element at the top of the stack.
   * @return top element in the stack.  
   */
  public E top() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException("Empty!");
    return D.getLast();
  }

  /**
   * Insert an element at the top of the stack.
   * @param element to be inserted.
   */
  public void push (E element) throws FullDequeException {
    D.addLast(element);
  }

  /** 
   * Remove the top element from the stack.
   * @return element removed.
   */
  public E pop() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException("Empty!");
    return D.removeLast();
  }

}
