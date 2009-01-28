/**
 * File: Iterable.java
 *
 * Interface for iterable classes that support the method iterator().
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 */

public interface Iterable<E> {

  /** Return the element stored at this position. */
  Iterator<E> iterator();

}
