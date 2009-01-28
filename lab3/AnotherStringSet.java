/**
 * This class implements a set of strings using a doubly-linked list to 
 * support six operations, namely, testing emptiness, membership, insertion, 
 * removal, reversing and printing.
 *
 * @author Dana Merrick
 */
public class AnotherStringSet {

  private int size;			// the size of the list
  private DNode header, trailer;	// the beginning and ending nodes

  /**
   * Creates an empty list and initializes the set's size to 0 (i.e., it 
   * creates an empty set).
   */
  public AnotherStringSet() {
    size = 0;
    header = new DNode(null, null, null);
    trailer = new DNode(null, header, null);
    header.setNext(trailer);
  } 

  /**
   * Returns true if the set contains no element.
   *
   * @return boolean true if the list is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns true if this set contains a string s.
   *
   * @param String s
   * @return boolean true if the list contains the given arguement
   */
  public boolean contains(String s) {
	  DNode cur = header.getNext();
	  
	  // loop through the list looking for s
	  while (cur.getNext() != null) {
		  if (cur.getElement().equals(s))
			  return true; // we found it! :-)
		  cur = cur.getNext(); // try the next one...
	  }
	  return false; // we never found it :-(
  }

  /**
   * Inserts a string s into the list and increments size by 1.
   *
   * @param String s
   */
  public void insert(String s) {
    // break if we already have the given arguement
    if (this.contains(s))
	    return;

    System.out.println("Inserting " + s + "...");

    DNode cur = header.getNext();
    // find which element contains the given arguement
    while (cur.getNext() != null) {
	    if (cur.getElement().equals(s))
		    break; // we found it, so exit the loop with the current cur value
	    cur = cur.getNext();
    }
    size++;
    // create a new node to insert in
    DNode newest = new DNode(s,null,null);
    // link up our new node in between cur and cur.getNext()
    newest.setNext(cur);
    newest.setPrev(cur.getPrev());
    cur.getPrev().setNext(newest);
    cur.setPrev(newest);
  }

  /**
   * Removes a string s from the list and decrements size by 1.
   *
   * @param String s
   */
  public void remove(String s) {
    // break early if we dont have s to remove
    if (!this.contains(s))
	    return;

    System.out.println("Removing " + s + "...");

    // find which element contains the given arguement
    DNode cur = header.getNext();
    while (cur.getNext() != null) {
	    if (cur.getElement().equals(s))
		    break;
	    cur = cur.getNext();
    }
    size--;

    // set up the links
    cur.getPrev().setNext(cur.getNext());
    cur.getNext().setPrev(cur.getPrev());

    // null out the next and previous values
    cur.setNext(null);
    cur.setPrev(null);
  }

  /**
   * Rearranges the nodes of the list in the reverse order.
   */
  public void reverse() {
    if (this.isEmpty())
      return; // not much to do with an empty set

    System.out.println("Reversing...");

    DNode cur = header;
    DNode old;

    // loop through each element
    while (cur.getNext() != trailer.getPrev()) {
	    // set old to the second to last element
	    old = trailer.getPrev();

	    // set up the links to skip over old
	    trailer.setPrev(old.getPrev());
	    trailer.getPrev().setNext(trailer);

	    // connect old to cur
	    old.setNext(cur.getNext());
	    old.setPrev(cur);
	    cur.setNext(old);

	    // connect old's new next link to old
	    old.getNext().setPrev(old);

	    // move onto the next node
	    cur = cur.getNext();
    }
  }

  /**
   * Prints all the strings in the list.
   */
  public void print() {
    DNode v = header;
    while (v.getNext() != trailer) {
      System.out.print(v.getNext().getElement() + " ");
      v = v.getNext();
    }
    System.out.println();
  }

}
