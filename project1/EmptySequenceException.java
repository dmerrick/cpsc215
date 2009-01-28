/**
 * File: EmptySequenceException.java
 *
 * Runtime exception thrown when one tries to perform operation getFirst,
 * getLast, removeFirst or removeLast on an empty deque.
 */

public class EmptySequenceException extends RuntimeException {  
  public EmptySequenceException(String err) {
    super(err);
  }
}
