/**
 * This class will execute the iterators we had to create for lab 6.
 *
 * @author Dana Merrick
 * @author Jessica Tait
 */
public class L7Driver {
  public static void main(String argv[]) {
    NodePositionList<Integer> L = new NodePositionList<Integer>();

    // tests from Example 6.3 on pg. 234
    L.addFirst(8);
    Position<Integer> p1 = L.first();
    L.addAfter(p1,5);
    Position<Integer> p2 = L.next(p1);
    L.addBefore(p2,3);
    Position<Integer> p3 = L.prev(p2);
    L.addFirst(9);
    p2 = L.last();
    L.remove(L.first());
    L.set(p3,7);
    L.addAfter(L.first(),2);


    // add some values to our list
    for(int i=0; i<10; i++) {
      Integer j = new Integer(i);
      L.addLast(j);
    }

    // declare the variable we will use for our iterators
    Iterator<Integer> i;

    // test default iterator
    System.out.println("DEBUG:\tNow testing default iterator.");

    i = L.iterator();
    while(i.hasNext())
      System.out.println(i.next());

    // test everyOtherElementIterator
    System.out.println("\nDEBUG:\tNow testing every other element iterator.");

    i = L.everyOtherElementIterator();
    while(i.hasNext())
      System.out.println(i.next());

    // test reverseElementIterator
    System.out.println("\nDEBUG:\tNow testing reverse iterator.");

    i = L.reverseElementIterator();
    while(i.hasNext())
      System.out.println(i.next());

  }
}
