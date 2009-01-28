public class L6Problem1 {

  public static void main(String args[]) {

    Deque<Integer> deque = new NodeDeque<Integer>();  // Create an instance of NodeDeque

    for (int k = 0; k < 5; k++) {
      // Create an Integer object and insert it at the front of the deque.
      // Use the constructor Integer() for this.
      Integer object = new Integer(k);
      deque.addFirst(object);
    }

    while (!deque.isEmpty()) {
      // Remove an integer from the front of the deque and print its value. 
      System.out.println("Removed " + deque.removeFirst());
    }

    for (int k = 0; k < 5; k++) {
      // Create an integer object and insert it at the rear of the deque.
      Integer object = new Integer(k);
      deque.addLast(object);
    }

    while (!deque.isEmpty()) {
      // Remove an integer from the rear of the deque and print its value.
      System.out.println("Removed " + deque.removeLast());
    }

    // Design an algorithm to test the methods getFirst() and getLast().
    Integer first = new Integer(1000);
    Integer last = new Integer(9999);

    // actually add the elements to the deque
    deque.addFirst(first);
    deque.addLast(last);
    
    // check first
    if (deque.getFirst() == first) {
      System.out.println("Added correctly!");
    } else {
      System.out.println("ERROR: Was not added correctly!");
    }

    // check last
    if (deque.getLast() == last) {
      System.out.println("Added correctly!");
    } else {
      System.out.println("ERROR: Was not added correctly!");
    }


  }

}

