/**
 * This class contains a deque based implementation of the ADT queue.
 *
 * @author Dana Merrick
 * @author Chris Hawley
 */

public class DequeQueue<E> implements Queue<E> {

  protected Deque<E> Q; // the queue we will be working with

  /**
   * The nonparametric constructor, which simply creates and empty NodeQueue object.
   */
  public DequeQueue() {
    Q = new NodeDeque<E>();
  }

  /**
   * Returns the size of the queue.
   *
   * @return int size
   */
  public int size() {   
    return Q.size();
  }

  /**
   * Returns true if the queue is empty.
   *
   * @return boolean 
   */
  public boolean isEmpty() {    
    return Q.isEmpty();
  }

  /**
   * This method appends an element to the queue.
   *
   * @param E the element to be added
   */
  public void enqueue(E e) {  
    Q.addLast(e);
  }

  /**
   * Returns the value of the element at the end of the queue.
   *
   * @param E the value of the front element
   */
  public E front() throws EmptyQueueException {
    if (isEmpty())
      throw new EmptyQueueException("Empty.");
    return Q.getFirst();
  }

  /**
   * Removes the front element from the queue and returns its value
   *
   * @return E the value of the element removed
   */
  public E dequeue() throws EmptyQueueException {  
    if (isEmpty())
      throw new EmptyQueueException("Empty.");
    return Q.removeFirst();
  }

}
