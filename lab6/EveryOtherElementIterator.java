/**
 * File: EveryOtherElementIterator.java
 *
 * This class contains an iterator that will iterate over every other object in a list.
 *
 * @author Dana Merrick
 * @author Jessica Tait
 */
public class EveryOtherElementIterator<E> implements Iterator<E> {

  protected PositionList<E> list;  // the underlying list
  protected Position<E> cursor;    // the next position

  /**
   * Creates an element iterator over the given list.
   *
   * @param the PositionList to iterate upon
   */
  public EveryOtherElementIterator(PositionList<E> L) {
    list = L;
    if (list.isEmpty())
      cursor = null
    else
      cursor = list.first()
  }

  /** 
   * Tests whether there are elements left in the iterator. 
   * 
   * @return boolean true if there are elements left in the iterator
   */
  public boolean hasNext() {
    return (cursor != null && list.next(cursor) != null); 
  }

  /**
   * Returns the next element in the iterator.
   *
   * @return E the element contained by the cursor
   */
  public E next() throws NoSuchElementException {
    if (cursor == null)
      throw new NoSuchElementException("No next element");
    E toReturn = cursor.element();

    if (cursor == list.last() || list.next(cursor) == list.last())
      cursor = null;
    else
      cursor = list.next(list.next(cursor));
    return toReturn;
  }

}
