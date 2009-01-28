/**
 * Runtime exception to throw when a given keyword is invalid.
 */
public class KeywordException extends RuntimeException {
  public KeywordException(String err) {
    super(err);
  }
}
