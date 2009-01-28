/**
 * This class will execute the methods we had to create for lab 7.
 *
 * @author Dana Merrick
 */
public class L8Problem1 {
  public static void main(String argv[]) {
    ArrayIndexList<Integer> L = new ArrayIndexList<Integer>();

    // add some values to our list
    for(int i=0; i<10; i++) {
      Integer j = new Integer(i);
      L.add(i,j);
    }

    // test default iterator
    System.out.println("DEBUG:\tNow testing iterator().");

    Iterator<Integer> i = L.iterator();
    while(i.hasNext())
      System.out.println(i.next());

    System.out.println("DEBUG:\tNow testing reverse() and re-running iterator().");

    L.reverse();      // reverse
    i = L.iterator(); // and print
    while(i.hasNext())
      System.out.println(i.next());

  }
}
