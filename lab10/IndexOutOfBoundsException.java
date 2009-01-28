/**
 * File: IndexOutOfBoundsException.java
 *
 * Runtime exception thrown when one tries to access an element at an index 
 * that is out of bounds.
 */

public class IndexOutOfBoundsException extends RuntimeException {  
  public IndexOutOfBoundsException(String err) {
    super(err);
  }
}
