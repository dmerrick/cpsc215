import java.io.*;
/**
 * This class holds a menu driven interface for accessing a BST based
 *  phone directory.
 *
 *  @author Dana Merrick
 *
 */
public class MerrickP2 {

  // "instance variables"
  protected static Iterator<Entry<String,String>> iter;
  protected static BinarySearchTree<String,String> B;

  /**
   * Main program.
   */
  public static void main(String argv[]) {
    // initialize the tree
    B = new BinarySearchTree<String,String>();

    // show welcome message
    System.out.println("Welcome to the phone number database!");

    // display menu
    drawMenu();
  }

  /**
   * Show the menu.
   */
  public static void drawMenu() {
    System.out.println("");
    System.out.println("1) Search for an entry.");
    System.out.println("2) Add an entry.");
    System.out.println("3) Remove an entry.");
    System.out.println("4) List all entries.");
    System.out.println("5) Terminate the session.");
    System.out.println("");

    String input = userInput("Your selection: ");

    switch (new Integer(input)) {
      case 1: search(); break;
      case 2: add(); break;
      case 3: remove(); break;
      case 4: list(); break;
      case 5: System.exit(0); // terminate the session
      default: drawMenu();
    }
   

  }

  /**
   * Search an entry in the database; in particular, given a name of a student
   *  as an input, output his/her telephone number if his/her entry is in the 
   *  database. 
   */
  public static void search() {

    String key = userInput("Please enter a name to search for: ");

    System.out.println("Name\tNumber");
    Entry<String,String> next;

    // show all entries with key key
    iter = B.findAll(key).iterator();
    while (iter.hasNext()) {
      next = iter.next();
      System.out.println(next.getKey() + "\t" + next.getValue());
    }

    drawMenu();
  }

  /**
   * Add an entry to the database.
   */
  public static void add() {

    // get key/value information
    String key = userInput("Please enter the new person's name: ");
    String value = userInput("Now enter the new person's number: ");

    // actually insert into the database
    B.insert(key,value);

    drawMenu();
  }

  /**
   * Remove an entry from the database; in particular, given a name of a
   *  student as an input, remove his/her entry from the database. 
   */
  public static void remove() {

    // get key information
    String key = userInput("Please enter the person to removes name: ");

    // actually remove the entry
    B.remove(B.find(key));

    drawMenu();
  }

  /**
   * List all the entries of the database in the alphabetical order by their
   *  last names. 
   */
  public static void list() {

    // show heading
    System.out.println("Name\tNumber");
    Entry<String,String> next;

    // show all entries
    iter = B.entries().iterator();
    while (iter.hasNext()) {
      next = iter.next();
      System.out.println(next.getKey() + "\t" + next.getValue());
    }

    drawMenu();
  }

  /**
   * Helper function to ask for user input.
   *
   * @param a message to display as a prompt
   * @return the value the user entered
   */
  public static String userInput(String msg) {

    // show the prompt
    System.out.print(msg);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ret = null;

    // readline() requires error catching
    try {
       ret = br.readLine();
    } catch (IOException ioe) {
       System.exit(1);
    }

    return ret.trim();
  }
}
