/**
 * File: Comparator.java
 *
 * An interface for the ADT comparator.
 *
 * @author Takunari Miyazaki
 * @see ClassCastException
 */

public interface Comparator<E> {
  public int compare(E a, E b) throws ClassCastException;
}
