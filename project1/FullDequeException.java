/**
 * File: FullDequeException.java
 *
 * Runtime exception thrown when one tries to perform operation push on a 
 * full stack.
 */

public class FullDequeException extends RuntimeException {  
  public FullDequeException(String err) {
    super(err);
  }
}
