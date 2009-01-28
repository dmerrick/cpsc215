/** 
 * File: DefaultComparator.java
 *
 * Comparator based on the natural ordering
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see ClassCastException
 * @see Comparable
 * @see Comparator
 */

public class DefaultComparator<E> implements Comparator<E> {

  /** Compares two given elements. */
  public int compare(E a, E b) throws ClassCastException { 
    return ((Comparable<E>) a).compareTo(b);
  }

}
