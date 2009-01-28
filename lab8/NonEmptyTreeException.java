/**
 * File: NonEmptyTreeException.java
 *
 * Runtime exception thrown when one tries to add a root to a nonempty tree.
 */

public class NonEmptyTreeException extends RuntimeException {  
  public NonEmptyTreeException(String err) {
    super(err);
  }
}
