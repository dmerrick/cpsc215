/** 
 * Test program for the AnotherStringSet class
 */
public class L4Driver {

  public static void main(String args[]) {
 
    String s = "BOS";
    String t = "JFK";
       
    AnotherStringSet A = new AnotherStringSet();
    A.insert(s);        // The string s is inserted into A so that 
                        // A = {"BOS"}.

    System.out.print("The set A = "); 
    A.print();

    A.insert(t);        // The string t is inserted into A so that
                        // A = {"JFK", "BOS"}.

    A.insert("BDL");    // The string "BDL" is inserted into A so that
                        // A = {"BDL", "JFK", "BOS"}.

    System.out.print("The set A = ");
    A.print();

    A.insert("BOS");    // The string "BOS" is inserted into A but A 
                        // should remain unchanged.

    System.out.print("The set A = "); 
    A.print();

    System.out.println("A.contains(\"JFK\") = " + A.contains("JFK"));

    A.remove("BOS");    // The string "BOS" is removed from A so that 
                        // A = {"BDL", "JFK"}.

    System.out.print("The set A = ");
    A.print();

    System.out.println("A.contains(\"BOS\") = " + A.contains("BOS"));

    AnotherStringSet B = new AnotherStringSet();

    for (int i = 0; i < 20; i++) {
      String u = "" + (char)('A' + i);
      B.insert(u);
    }

    B.remove("K");
    B.insert("Z");

    System.out.print("The set B = ");
    B.print();

    B.reverse();           // The set B is now reversed.

    System.out.print("The set B = ");
    B.print();

  }

}
