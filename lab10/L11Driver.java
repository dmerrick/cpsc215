/** 
 * Driver program for HashTableDictionary.
 *
 * @author Dana Merrick
 */
public class L11Driver {
  
  public static void main(String args[]) {

    Entry<String, String> e;
    HashTableDictionary<String,String> h = 
      new HashTableDictionary<String,String>();

    // We use city names as keys and airport codes as values.
    String keys[] = { "Boston", "Chicago", "Chicago", "Frankfurt am Main", 
      "Hartford", "London", "London", "London", "Newark", "New York", 
      "New York", "Paris", "Paris", "San Francisco", "Tokyo", "Tokyo" };
    String values[] = { "BOS", "MDW", "ORD", "FRA", "BDL", "LGW", "LHR", 
      "STN", "EWR", "JFK", "LGA", "CDG", "ORY", "SFO", "HND", "NRT" };

    // We print the input list first.
    System.out.println("Input list:");
    System.out.println();
    for (int i = 0; i < keys.length; i++)
      System.out.println(values[i] + " - " + keys[i]);

    // Insert the given items.
    for (int i = 0; i < keys.length; i++)
      h.insert(keys[i], values[i]);

    e = h.find("London");
    System.out.println();
    System.out.println("There are three major airports in London, and ");
    System.out.println("find(London) gives the key-value pair (" + 
      e.getKey() + ", " + e.getValue() + ")");

    // Remove one airport in London.
    System.out.println();
    System.out.println("After removing the entry (" + e.getKey() + ", " + 
      e.getValue() + ")");                    
    e = h.remove(e);
    e = h.find("London");
    System.out.println("find(London) gives the key-value pair (" + 
      e.getKey() + ", " + e.getValue() + ")");
    


    // test entries()
    System.out.println("\nNow testing entries()...\n");
    Iterator<Entry<String,String>> A = h.entries().iterator();

    while (A.hasNext()) {
      e = A.next();
      System.out.println(e.getValue() + " - " + e.getKey());
    }

    // test findAll(k)
    System.out.println("\nNow testing findAll(k)...");

    // create new iterator for keys with "Tokyo"
    A = h.findAll("Tokyo").iterator();

    System.out.println("\nThese entries were found:\n");
    while (A.hasNext()) {
      e = A.next();
      System.out.println(e.getValue() + " - " + e.getKey());
    }


    // test removeAll(k)
    System.out.println("\nNow testing removeAll(k)...");

    // create new iterator for keys with "New York"
    A = h.removeAll("New York").iterator();

    System.out.println("\nThese entries were removed:\n");
    while (A.hasNext()) {
      e = A.next();
      System.out.println(e.getValue() + " - " + e.getKey());
    }

    // finally, print the entire dictionary
    System.out.println("\nNow the dictionary looks like this:\n");
    A = h.entries().iterator();
    while (A.hasNext()) {
      e = A.next();
      System.out.println(e.getValue() + " - " + e.getKey());
    }
  }

}
