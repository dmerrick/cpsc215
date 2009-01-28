/**
 * This class implements a set of strings using a linked list to support six 
 * operations, namely, testing emptiness, membership, insertion, removal, 
 * sorting and printing.
 *
 * @author Dana Merrick
 */

public class StringSet {
    
  private Node head;
  private int size; 

  /**
   * Creates an empty list and initializes the set's size to 0 (i.e., it 
   * creates an empty set).
   */
  public StringSet() {
    head = null;
    size = 0;
  } 

  /**
   * Returns true if the set contains no element.
   *
   * @return boolean if the set is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns true if this set contains a string s.
   *
   * @param String s
   * @return boolean if the set contains s
   */
  public boolean contains(String s) {

    if (this.isEmpty()) { return false; }

    Node cur = head;
    while (cur.getNext() != null) {

	    // compare cur and s
	    if (cur.getElement().equals(s)) {
		    return true;
	    } else {
		    // not the same; increment cur
		    cur = cur.getNext();
	    }
    }
    // s was never found! :-(
    return false;

  }

  /**
   * Inserts a string s into the list and increments size by 1.
   *
   * @param String s
   */
  public void insert(String s) {
    System.out.println("Inserting " + s + "...");

    // break if the set already contains s
	  if (this.contains(s)) { 
    	          //System.out.println("DEBUG:\tAlready has " + s + " breaking...");
		  return;
	  } 

	  Node newNode = new Node(s,head); // create a new first node
	  head = newNode;		   // set it as the head node
	  size++;                          // increment the size
  }

  /**
   * Removes a string s from the list and decrements size by 1.
   *
   * @param String s
   */
  public void remove(String s) {
    System.out.println("Removing " + s + "...");

	  if (size <= 2) {
		  // try the first element
		  if (head.getElement().equals(s)) {
			  head = head.getNext();
		  }

		  // try the second element
		  if (size ==2 && head.getNext().getElement().equals(s)) {
			  head.setNext(null);
		  }
	  }

	  Node prev = head;		// first element
	  Node cur = prev.getNext();	// second element

	  while (cur.getNext() != null) {
		  if (cur.getElement().equals(s)) {
			  prev.setNext(cur.getNext());
			  size--; // removed an item, so lower the size by one
		  } 
		  prev = cur;
		  cur = cur.getNext();
	  }
  }

  /**
   * Sorts all the Strings in the list in the alphabetical order.
   */
  public void sort() {
    System.out.println("Sorting...");

    if (size <= 1) { return; }

   Node cur = head; // the current element being looked at

   while (cur.getNext() != null) { // loop through each element
     Node next = cur.getNext();
     Node min = cur;               // a REFERENCE to the smallest value (i.e. not the element itself) 
     while (next != null) {
	    // compare the current minumum value to the next node
	    if (min.getElement().compareTo(next.getElement()) > 0) {
		    min = next;
	    }
	    next = next.getNext(); // move on to the next node
      }
      // swap the minimum element and the current element
      String temp = cur.getElement();
      cur.setElement(min.getElement());
      min.setElement(temp);
      // increment the current element
      cur = cur.getNext();
   }
 }


  /**
   * Prints all the strings in the list.
   */
  public void print() {
    Node n = head;
    while (n != null) {
      System.out.print(n.getElement() + " ");
      n = n.getNext();
    }
    System.out.println();
  }

}
