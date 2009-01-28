/**
 * File: L9Driver.java
 *
 * This is a driver program to test your implementation of the class 
 * LinkedBinaryTree.
 *
 * @author Dana Merrick
 * @author Stevon Judd
 */

public class L9Driver {

  /**
   * This method constructs an arithmetic expression tree of an infix 
   * arithmetic expression s by simply calling the recursive version of the 
   * same method. 
   *
   * @param a linked binary tree of characters
   * @param a string
   */
  public static void preorderAET(LinkedBinaryTree<Character> T, String s) {
    preorderAET(T, T.addRoot(null), s);
  }

  /**
   * This method recursively constructs an arithmetic expression tree of an 
   * infix arithmetic expression s starting at a position v.
   * 
   * @param a linked binary tree of characters
   * @param a position
   * @param a string
   * @return String
   */
  public static String preorderAET(LinkedBinaryTree<Character> T, 
    Position<Character> v, String s) {
    if (s.length() == 0)
      return "";
    if (s.charAt(0) == ' ')
      return preorderAET(T, v, s.substring(1));  // Skip spaces.
    else if (Character.isDigit(s.charAt(0))) {
      T.replace(v, (new Character(s.charAt(0))));
      return s.substring(1);
    }
    else {
      T.replace(v, (new Character(s.charAt(0))));
      T.insertLeft(v, null);
      T.insertRight(v, null);
      String t = preorderAET(T, T.left(v), s.substring(1));
      return preorderAET(T, T.right(v), t);
    }
  }

  /**
   * This method prints all the elements of the tree T in preorder.
   *
   * @param a linked binary tree
   */
  public static <E> void preorderPrint(LinkedBinaryTree<E> T) {

    // call the element iterator
    Iterator<E> it = T.iterator();

    // print each element
    while(it.hasNext())
      System.out.println(it.next());

  }

  /**
   * This method returns the indented parenthetic string representation of 
   * the tree T.
   *
   * @param a tree
   * @return an indented parenthetic string representation of the parameter
   */
  public static <E> String IPSR(Tree<E> T) {
    return IPSR(T, T.root());
  }

  /**
   * This method returns the indented parenthetic string representation of 
   * a tree using positions.
   *
   * @param a tree
   * @param a position
   * @return an indented parenthetic string representation of the parameter
   */
  public static <E> String IPSR(Tree<E> T, Position<E> v) {

    // the return string
    String ret = "";

    int numParents = 0;
    Position<E> cur = v;

    while (!T.isRoot(cur)) {
      cur = T.parent(cur);
      numParents++;
    }

    //for (int i=0; i<numParents; i++)
      //ret += " ";
    
    ret += v.element().toString();

    if (T.isInternal(v)) {

      ret += "(\n";

      Iterator<Position<E>> children = T.children(v).iterator();

      // loop through each child
      while (children.hasNext()) {
        Position<E> child = children.next();
        ret += IPSR( T, child) ;

        if (T.isExternal(child))
          ret += "\n";
      }

      //for (int i=0; i<numParents; i++)
        //ret += " ";

      ret += ")\n";

    } else { // v is external
    }

    return ret;
  }

  /**
   * This main method tests the class LinkedBinaryTree using the example 
   * from Figure 7.11, p. 283, of our main textbook.
   */
  public static void main(String[] args) {
    LinkedBinaryTree<Character> bt = new LinkedBinaryTree<Character>();
    preorderAET(bt, "- / * + 3 1 3 + - 9 5 2 + * 3 - 7 4 6");
    
    // Test preorderPrint() with bt.
    System.out.println("DEBUG:\ttesting preorderPrint()...");
    preorderPrint(bt);

    // Test IPSR() with bt.
    System.out.println("\nDEBUG:\ttesting IPSR()...");
    System.out.println( IPSR(bt) );

  }

}
