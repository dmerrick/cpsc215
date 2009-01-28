/**
 * File: InvalidPositionException.java
 *
 * Runtime exception thrown when one tries to access an element at an
 * invalid position.
 */

public class InvalidPositionException extends RuntimeException {  
  public InvalidPositionException(String err) {
    super(err);
  }
}
