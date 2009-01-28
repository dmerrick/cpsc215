/**
 * File: EmptyTreeException.java
 *
 * Runtime exception thrown when one tries to perform access operation on an 
 * empty tree.
 */

public class EmptyTreeException extends RuntimeException {  
  public EmptyTreeException(String err) {
    super(err);
  }
}
