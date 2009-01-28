/**
 * File: NoSuchElementException.java
 *
 * Runtime exception thrown when one tries to perform next operation on an 
 * iterator that has no more elements to be scanned.
 */

public class NoSuchElementException extends RuntimeException {  
  public NoSuchElementException(String err) {
    super(err);
  }
}
