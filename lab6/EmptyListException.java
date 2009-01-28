/**
 * File: EmptyListException.java
 *
 * Runtime exception thrown when one tries to perform access operation on an 
 * empty list.
 */

public class EmptyListException extends RuntimeException {  
  public EmptyListException(String err) {
    super(err);
  }
}
