/**
 * File: PositionObject.java
 *
 * This class contains an object that holds an element and an index.
 *
 * @author Dana Merrick
 */
public class PositionObject<E> implements Position<E>{

  protected E element;
  protected int index;

  /**
   * Returns the element stored in the object.
   *
   * @return E the element stored in the object
   */
  public E element() { 
    return element;
  }

  /**
   * Returns the index of the stored object.
   *
   * @return the index of the object
   */
  public int index() {
    return index;
  }

  /**
   * Object constructor, creates an object with a specific index and a given
   * element.
   *
   * @param index of the object
   * @param element stored
   */
  public PositionObject(int i, E e) { 
    element = e;
    index = i;
  }


}
