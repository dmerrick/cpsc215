/**
 * File: ElementIterator.java
 *
 * This class implements an iterator for the ADT array index list.
 *
 * @author Dana Merrick
 */

public class ElementIterator<E> implements Iterator<E> {

  protected ArrayIndexList<E> list;  // the underlying list
  protected int cursor;    // the next position

  /**
   * Creates an element iterator over the given list. 
   *
   * @param L the list to use
   */
  public ElementIterator(ArrayIndexList<E> L) {
    list = L;
    cursor = (list.isEmpty()) ? null : 0;
  }

  /**
   * Tests whether there are elements left in the iterator. 
   *
   * @return boolean true if there is another element to iterate
   */
  public boolean hasNext() { 
    return (cursor < list.size() ); 
  }

  /**
   * Returns the next element in the iterator. 
   *
   * @return E the value of the next element
   */
  public E next() throws NoSuchElementException {
    if (!hasNext())
      throw new NoSuchElementException("No next element");
    E toReturn = list.get(cursor);
    cursor++;
    return toReturn;
  }

}
