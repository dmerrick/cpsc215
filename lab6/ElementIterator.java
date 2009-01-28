/**
 * File: ElementIterator.java
 *
 * This class implements an iterator for the ADT node list.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see NoSuchElementException
 */

public class ElementIterator<E> implements Iterator<E> {

  protected PositionList<E> list;  // the underlying list
  protected Position<E> cursor;    // the next position

  /** Creates an element iterator over the given list. */
  public ElementIterator(PositionList<E> L) {
    list = L;
    cursor = (list.isEmpty())? null : list.first();
  }

  /** Tests whether there are elements left in the iterator. */
  public boolean hasNext() { return (cursor != null); }

  /** Returns the next element in the iterator. */
  public E next() throws NoSuchElementException {
    if (cursor == null)
      throw new NoSuchElementException("No next element");
    E toReturn = cursor.element();
    cursor = (cursor == list.last())? null : list.next(cursor);
    return toReturn;
  }

}
