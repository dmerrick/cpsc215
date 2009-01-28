/**
 * This class implements a program to test if a given parethetical 
 * expression is well-formed or not.
 *
 * @author Takunari Miyazaki (and barely changed by Dana Merrick)
 * @version 1.1, 02/20/2007
 * @see java.io.InputStreamReader
 * @see java.io.BufferedReader
 * @see String
 */

import java.io.*;

public class HW5Problem2 {

  /*
   * First, in main(), we read an input string s from the user.  Then 
   * it calls printIsWellformed() to test if s is well-formed or not.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader i = new BufferedReader 
      (new InputStreamReader(System.in));
    String s;
    System.out.print("Enter a parenthetical expression: ");
    s = i.readLine();
    printIsWellformed(s);
  }

  /*
   * printIsWellformed() takes a string s, tests if s is well-formed, 
   * and prints the result.
   *
   * @param s - a given string.
   */
  public static void printIsWellformed(String s) {

    boolean wellformed = true;
    char c;
    Object o;
    Stack<Character> stack = new DequeStack<Character>();

    // Scan the string s one character at a time.
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);

      // If we see (, [, or {, then perform push.
      if ((c == '(') || (c == '[') || (c == '{'))
        stack.push(new Character(c));

      // If we see ), then test if the top is (.
      else if (c == ')') {
        if (stack.isEmpty()) {
          wellformed = false;
          break;
        }
        else {
          o = stack.top();
          if (o.toString().charAt(0) == '(')
            o = stack.pop();
          else {
            wellformed = false;
            break;
          }
        }
      }

      // If we see }, then test if the top is {.
      else if (c == '}') {
        if (stack.isEmpty()) {
          wellformed = false;
          break;
        }
        else {
          o = stack.top();
          if (o.toString().charAt(0) == '{')
            o = stack.pop();
          else {
            wellformed = false;
            break;
          }
        }
      }

      // If we see ], then test if the top is [.
      else if (c == ']') {
        if (stack.isEmpty()) {
          wellformed = false;
          break;
        }
        else {
          o = stack.top();
          if (o.toString().charAt(0) == '[')
            o = stack.pop();
          else {
            wellformed = false;
            break;
          }
        }
      }
    }

    // If it is well-formed, the stack should be empty at the end.
    if (!stack.isEmpty())
      wellformed = false;

    // Print the result.
    if (wellformed)
      System.out.println(s + " is well-formed.");
    else
      System.out.println(s + " is not well-formed.");
  
  }

}
