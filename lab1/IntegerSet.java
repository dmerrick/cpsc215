/**
 * This class implements an integer set that supports six operations, namely, 
 * testing emptiness, membership, insertion, removal, sorting and printing.
 *
 * @author Dana Merrick; Stevon Judd
 */

public class IntegerSet {
    
  public static final int MAX_SIZE = 1000; // Maximum capacity

  private int elements[];
  private int size;                       // The actual size

  /**
   * Creates an array of MAX_SIZE capacity and initializes the set's size to
   * 0 (i.e., it creates an empty set).
   */
  public IntegerSet() {
    elements = new int[MAX_SIZE];
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   * 
   * @return boolean whether or not the set is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns true if this set contains the integer n.
   *
   * @param n the value to check for
   * @return boolean whether or not the set contains the given arguement
   */
  public boolean contains(int n) {
	  // return false if the set is empty
	  if (isEmpty())
		  return false;

	  // loop through and look for the given arguement
    for (int i=0; i<size; i++) {
      if (elements[i]==n)
	      return true; // we found one!
    }
    // no match found :-(
    return false;
  }

  /**
   * Inserts an integer n into the array elements[] and increments size by 1.
   *
   * @param n the value to insert into the set
   */
  public void insert(int n) {

	  // check to see if we already have n
            if (contains(n))
		    return;

	  size += 1; // our new array will have a size one bigger

	  // short circuit the method if we have a trivial set
	  if (size == 1) {
		  elements[0] = n;
		  return;
	  }
	 
	  // set up new array
	  int newElements[] = new int[size];

	  // copy old elements to to the newElements array
	  for (int i=0; i<size-1; i++) {
		newElements[i] = elements[i];
	  }

	  // append n to the end of our new array
	  newElements[size-1]=n;

	  // set up the elements variable with its new size...
	  elements = new int[size];
	  // ...and copy the new array into it.
	  elements = newElements;

    System.out.println("Inserting " + n + "..." );
  }

  /**
   * Removes an integer n from the array elements[] and decrements size by 1.
   *
   * @param the value to remove from the set
   */
  public void remove(int n) {

    size -= 1;
    // set up our new sandbox array
    int newElements[] = new int[size];

    // loop through the array looking for n...
    for (int i=0; i<size; i++) {
	    if (elements[i] == n ) {
		    // ...and put n at the end of the array
		    int temp = elements[size];
		    elements[size] = elements[i];
		    elements[i]=temp;
	    }
	    
    }

    // copy elements into the new array, leaving off the last element
    for (int i=0; i<size; i++) {
	    newElements[i] = elements[i];
    }

          // move newElements into elements like we did in insert()
	  elements = new int[size];
	  elements = newElements;

    System.out.println("Removing " + n + "...");
  }

  /**
   * Sorts the integer of the array elements[] in the increasing order.
   */
  public void sort() {

    // short circuit if we have a trivial array
    if (size <= 1)
	    return;

    // bubble sort
    for (int i=0; i<size-1; i++) {
	    for (int j=0; j<size-1-i; j++){
	    if (elements[j] > elements[j+1]) {
		    // swap the two elements
		    int temp = elements[j];
		    elements[j]=elements[j+1];
		    elements[j+1]= temp;
	    }
	    }
    }
    /* my attempt to implement quicksort without being able to truely use recursion
     * (because of void methods) or concatenation (because elements is private).
     * (untested, so dont grade me on it ;-) 
    IntegerSet bigger = new IntegerSet();
    IntegerSet smaller = new IntegerSet();

    int pivot = 1;
    for (int i=0; i<size; i++) {
      if (elements[i]<=elements[pivot]) {
        smaller.insert(elements[i]);
      } else {
        bigger.insert(elements[i]);
      }
      smaller.sort();
      bigger.sort();
      elements = smaller + elements[pivot] + bigger;
    }
    */

    System.out.println("Sorting...");
  }

  /**
   * Prints all the elements of the array elements[].  Note that it uses 
   * the size as the loop bound.
   */
  public void print() {
    for (int i = 0; i < size; i++)
      System.out.print(elements[i] + " ");
    System.out.println();
  }

}
