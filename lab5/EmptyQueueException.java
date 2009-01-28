/**
 * File: EmptyQueueException.java
 *
 * Runtime exception thrown when one tries to perform operation front or
 * dequeue on an empty queue.
 */

public class EmptyQueueException extends RuntimeException {  
  public EmptyQueueException(String err) {
    super(err);
  }
}
