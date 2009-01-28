/**
 * This class will execute the sort() method defined in Problem 2 of lab 8.
 *
 * @author Dana Merrick
 */
public class L8Problem2 {
  public static void main(String argv[]) {
    ComparableArrayIndexList<Integer> L =
      new ComparableArrayIndexList<Integer>();

    System.out.println("DEBUG:\tMaking a list of Integers...");

    // add some values to our list
    for(int i=0; i<10; i++) {
      Integer j = new Integer(i);
      L.add(i,j);
    }

    L.reverse();
    L.add(L.size(),new Integer(1));

    System.out.println("DEBUG:\tList now contains:");

    Iterator<Integer> i = L.iterator();
    while(i.hasNext())
      System.out.println(i.next());

    System.out.println("DEBUG:\tNow testing sort() and re-running iterator().");

    L.sort();
    i = L.iterator();
    while(i.hasNext())
      System.out.println(i.next());


    // let's try sorting strings...

    System.out.println("DEBUG:\tMaking a list of Strings...");
    ComparableArrayIndexList<String> S =
      new ComparableArrayIndexList<String>();

    // just some random text
    S.add(S.size(), "Hello,");
    S.add(S.size(), "World,");
    S.add(S.size(), "how");
    S.add(S.size(), "are");
    S.add(S.size(), "you");
    S.add(S.size(), "my");
    S.add(S.size(), "name");
    S.add(S.size(), "is");
    S.add(S.size(), "Dana!");

    System.out.println("DEBUG:\tList now contains:");

    Iterator<String> j = S.iterator();
    while(j.hasNext())
      System.out.println(j.next());

    System.out.println("DEBUG:\tNow testing sort() and re-running iterator().");

    S.sort();
    j = S.iterator();
    while(j.hasNext())
      System.out.println(j.next());

  }
}
