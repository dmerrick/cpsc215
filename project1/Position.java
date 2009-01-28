/**
 * File: Position.java
 *
 * Interface for a position that supports a single operation to return the 
 * element stored at the given position.
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 */

public interface Position<E> {

  /** Return the element stored at this position. */
  E element();

}
