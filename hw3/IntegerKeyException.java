/**
 * Runtime exception to throw when a given integer is invalid.
 */
public class IntegerKeyException extends RuntimeException {
  public IntegerKeyException(String err) {
    super(err);
  }
}
