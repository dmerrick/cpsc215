/**
 * File: InvalidKeyException.java
 *
 * Runtime exception thrown when one tries to access an invalid key.
 */

public class InvalidKeyException extends RuntimeException {  
  public InvalidKeyException(String err) {
    super(err);
  }
}
