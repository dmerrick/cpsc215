/**
 * File: EmptyStackException.java
 *
 * Runtime exception thrown when one tries to perform operation getFirst,
 * getLast, removeFirst or removeLast on an empty deque.
 */

public class EmptyStackException extends RuntimeException {  
  public EmptyStackException(String err) {
    super(err);
  }
}
