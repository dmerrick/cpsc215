/** 
 * Node of a singly linked list of strings.
 */
public class Node {
  
  private String element;
  private Node next;

  /** Creates a node with the given element and next node. */
  public Node(String e, Node n) {
    element = e;
    next = n;
  }

  /** Returns the element of this node. */
  public String getElement() { return element; }

  /** Returns the next node of this node. */
  public Node getNext() { return next; }

  // Modifier methods:

  /** Sets the element of this node. */
  public void setElement(String e) { element = e; }

  /** Sets the next node of this node. */
  public void setNext(Node n) { next = n; }

}
