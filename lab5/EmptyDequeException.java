/**
 * File: EmptyDequeException
 *
 * Runtime exception thrown when one tries to perform operation getFirst,
 * getLast, removeFirst or removeLast on an empty deque.
 */

public class EmptyDequeException extends RuntimeException {  
  public EmptyDequeException(String err) {
    super(err);
  }
}
