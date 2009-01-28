/**
 * File: ReverseElementIterator.java
 *
 * This class holds an Iterator object that will iterate over a list in reverse order.
 *
 * @author Dana Merrick
 * @author Jessica Tait
 */
public class ReverseElementIterator<E> implements Iterator<E> {

  protected PositionList<E> list;  // the underlying list
  protected Position<E> cursor;    // the next position

  /**
   * Creates an element iterator over the given list. 
   *
   * @param the PositionList object to iterate
   */
  public ReverseElementIterator(PositionList<E> L) {
    list = L;
    if (list.isEmpty())
      cursor = null;
    else
      cursor = list.last();
  }

  /**
   * Tests whether there are elements left in the iterator.
   *
   * @return boolean true if there is another value to iterate upon
   */
  public boolean hasNext() {
    return (cursor != null);
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

    if (cursor == list.first())
      cursor = null;
    else
      cursor = list.prev(cursor);

    return toReturn;
  }

}
