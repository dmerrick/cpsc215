/**
 * File: Iterator.java
 *
 * Interface for the ADT iterator.
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 */

public interface Iterator<E> {

  /** Tests whether there are elements left in the iterator. */
  public boolean hasNext();

  /** Returns the next element in the iterator. */
  public E next();

}
