/**
 * File: InvalidEntryException.java
 *
 * Runtime exception thrown when one tries to access an invalid entry.
 */

public class InvalidEntryException extends RuntimeException {  
  public InvalidEntryException(String err) {
    super(err);
  }
}
