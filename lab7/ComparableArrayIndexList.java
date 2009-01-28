/** 
 * File: ComparableArrayIndexList.java
 *
 * Realization of an indexed list for comparable objects such as integers 
 * and strings.
 *
 * @author Dana Merrick
 * @see ArrayIndexList
 * @see IndexOutOfBoundsException
 */

public class ComparableArrayIndexList<E> extends ArrayIndexList<E> {

  /**
   * Sorts the elements of the list in the increasing order. 
   */
  public void sort() {

    // sort circuit the method if the list is trivial
    if (size() <= 1)
      return;

    // bubble sort
    for (int i=0;   i < size()-1;   i++) {
      for (int j=0; j < size()-1-i; j++) {
        if (((Comparable) A[j]).compareTo((Comparable) A[j+1]) > 0) {
          // swap the two elements
          E temp = A[j];
          A[j]   = A[j+1];
          A[j+1] = temp;     
        }
      }
    }
  }
}
