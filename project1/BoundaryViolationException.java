/**
 * File: BoundaryViolationException.java
 *
 * Runtime exception thrown when one tries to access an element at a special
 * boundary index or position (such as a header or trailer position).
 */

public class BoundaryViolationException extends RuntimeException {  
  public BoundaryViolationException(String err) {
    super(err);
  }
}
