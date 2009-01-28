/** Test program for the Set class */

public class Driver {

  public static void main( String args[]) {
 
    int x = 16;
    int y = 11;
       
    IntegerSet A = new IntegerSet();
    A.insert(x);        // The integer x is inserted into A so that 
                        // A = {16}

    System.out.print("The set A = "); 
    A.print();

    A.insert(y);        // The integer y is inserted into A so that
                        // A = {16, 11}

    A.insert(23);       // The integer 23 is inserted into A so that
                        // A = {16, 11, 23}

    System.out.print("The set A = ");
    A.print();

    A.insert(11);       // The integer 11 is inserted into A but A 
                        // should remain unchanged.

    System.out.print("The set A = "); 
    A.print();

    System.out.println("A.contains(23) = " + A.contains(23));
    
    A.remove(11);       // The integer 11 is removed from A so that 
                        // A = {16, 23}

    System.out.print("The set A = "); 
    A.print();

    System.out.println("A.contains(11) = " + A.contains(11));

    IntegerSet B = new IntegerSet();

    for (int i = 0; i < 20; i++)
      B.insert(19 - i);

    B.remove(18);
    B.insert(55);

    System.out.print("The set B = ");
    B.print();

    B.sort();           // The integers of B are now sorted.

    System.out.print("The set B = ");
    B.print();

  }

}
