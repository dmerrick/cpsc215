/**
 * File: EmptyPriorityQueueException.java
 *
 * Runtime exception thrown when one tries to access an entry in an empty
 * priority queue.
 */

public class EmptyPriorityQueueException extends RuntimeException {  
  public EmptyPriorityQueueException(String err) {
    super(err);
  }
}
