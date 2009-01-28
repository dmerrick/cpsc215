/**
 * File: L10Driver.java
 *
 * This is a driver program to test your implementation of the class HeapPQ.
 *
 * @author Dana Merrick
 */
public class L10Driver {

  /**
   * This method takes an array list L of objects and heap-sorts the objects
   *  of L in the increasing order. 
   *
   * @param a list of objects to sort
   */
  public static <E> void heapSort(IndexList<E> L) {
    HeapPQ<E,E> P = new HeapPQ<E,E>();
    E e;

    // loop through adding each element in L to P
    while (!L.isEmpty()) {
      e = L.remove(L.size()-1);
      P.insert(e,e);
    }

    while (!P.isEmpty()) {
      Entry<E,E> min = P.removeMin();
      e = P.value(min);
      L.add(L.size(),e);
    }
  }

  /**
   * This method prints the elements of a given array list L. 
   *
   * @param a list of objects
   */
  public static <E> void printIndexList(IndexList<E> L) {
    Iterator<E> i = L.iterator();
    while (i.hasNext())
      System.out.print(i.next().toString() + " ");
    System.out.println();
  }

  /**
   * This method declares four index lists of Integer objects and calls the
   *  method heapSort() on each one of them. 
   */
  public static void main(String args[]) {

    // Declares four array lists.
    java.util.Random r = new java.util.Random();
    IndexList<Integer> L1 = new ArrayIndexList<Integer>();
    IndexList<Integer> L2 = new ArrayIndexList<Integer>();
    IndexList<Integer> L3 = new ArrayIndexList<Integer>();
    IndexList<Integer> L4 = new ArrayIndexList<Integer>();
    for (int i = 0; i < 20; i++)
      L1.add(i, new Integer(i));
    for (int i = 0; i < 20; i++)
      L2.add(i, new Integer(19 - i));
    for (int i = 0; i < 20; i++)
      L3.add(i, new Integer(0));
    for (int i = 0; i < 20; i++)
      L4.add(i, new Integer(Math.abs(r.nextInt()) % 20));

    // The following performs four tests.
    System.out.println("Testing heapsort...");
    System.out.println();

    // Testing with L1.
    System.out.println("Test 1");
    System.out.print("Input:  ");
    printIndexList(L1);
    heapSort(L1);
    System.out.print("Output: ");
    printIndexList(L1);
    System.out.println();

    // Testing with L2.
    System.out.println("Test 2");
    System.out.print("Input:  ");
    printIndexList(L2);
    heapSort(L2);
    System.out.print("Output: ");
    printIndexList(L2);
    System.out.println();

    // Testing with L3.
    System.out.println("Test 3");
    System.out.print("Input:  ");
    printIndexList(L3);
    heapSort(L3);
    System.out.print("Output: ");
    printIndexList(L3);
    System.out.println();

    // Testing with L4.
    System.out.println("Test 4");
    System.out.print("Input:  ");
    printIndexList(L4);
    heapSort(L4);
    System.out.print("Output: ");
    printIndexList(L4);

  }

}
