/**
 * File: ArrayElementIterator.java
 *
 * An iterator class for an array list.
 *
 * @author Takunari Miyazaki
 * @see IndexList
 * @see NoSuchElementException
 * @see Iterator
 */
 
public class ArrayElementIterator<E> implements Iterator<E> {

  protected IndexList<E> list;  // the underlying list
  protected int i;              // the next index

  /** Creates an element iterator over the given list. */
  public ArrayElementIterator(IndexList<E> L) {
    list = L;
    i = 0;
  }

  /** Returns whether the iterator has the next element. */
  public boolean hasNext() { return (i < list.size());  }

  /** Returns the next element. */
  public E next() throws NoSuchElementException {
    if (i >= list.size())
      throw new NoSuchElementException("No next element");
    E toReturn = list.get(i);
    i++;
    return toReturn;
  }

}
