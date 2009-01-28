/**
 * File: TestBST.java
 *
 * This class is a simple driver program to test your BinarySearchTree class.
 * It should perform the following operations:
 * 1. Insert all the strings contained in the array S into the binary search 
 *    tree myBST using the strings themselves as keys.
 * 2. Print out all the strings in the alphabetical order using the method 
 *    entries().
 * 3. Print out all the strings sharing the same key using the method 
 *    findAll().
 * 4. Delete some strings from the tree and then print out the remaining 
 *    strings again using the method entries(). 
 */

public class TestBST {

  public static void main(String args[]) {
    BinarySearchTree<String,String> myBST =
      new BinarySearchTree<String,String>();
    String S[] = {"gamma", "phi", "beta", "alpha", "delta", "phi", "beta", 
      "epsilon" };

    // 1
    System.out.println("Now inserting all strings as key value pairs.\n");
    for (int i=0; i<S.length; i++)
      myBST.insert(S[i],S[i]);
    
    // 2
    System.out.println("Now using entries() to print the list in alphabetical order.");

    // print all
    Iterator<Entry<String,String>> iter = myBST.entries().iterator();

    while (iter.hasNext())
      System.out.println(iter.next().getKey());

    // 3
    System.out.println("\nNow using findAll() to search for \"phi\"...");
    iter = myBST.findAll("phi").iterator();

    // print all the phis
    while (iter.hasNext())
      System.out.println(iter.next().getKey());

    System.out.println("\n...and \"gamma\".");
    iter = myBST.findAll("gamma").iterator();

    // print all the gammas
    while (iter.hasNext())
      System.out.println(iter.next().getKey());

    // 4
    System.out.println("\nNow removing \"gamma\" and \"phi\"...");

    // remove gamma
    while (iter.hasNext())
      myBST.remove(iter.next());
    // and phis
    iter = myBST.findAll("phi").iterator();
    while (iter.hasNext())
      myBST.remove(iter.next());

    System.out.println("\nmyBST now looks like this:");

    // print all
    iter = myBST.entries().iterator();
    while (iter.hasNext())
      System.out.println(iter.next().getKey());
  }

}
