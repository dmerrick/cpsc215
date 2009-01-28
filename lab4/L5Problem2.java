/** 
 * This class holds a method to check whether or not an arithmetic expression is well-formed.
 *
 * @author Dana Merrick
 * @author Clifton Berwise
 */
import java.io.*;

public class L5Problem2 {


  /**
   * This method returns true if a given expression is well-formed.
   *
   * We call an arithmetic expression involving parentheses well-formed if there 
   * is a closing “)” for each opening “(”. If such an expression has “[”, “]”, 
   * “{” and “}” in addition to parentheses, we call the expression well-formed 
   * if every opening “(”, “[” or “{” is closed by its matching “)”, “]” or “}” 
   * before a previously opened “(”, “[” or “{” is closed. For example, 
   * “{[(a+b)*c]+d}” is well-formed, but “{[(a+b}*c)+d]” is not.
   *
   * @param String A given expression
   * @return boolean
   */
  public static boolean isWellFormed(String str) {

	  Stack<Character> s;
	  s = new ArrayStack<Character>();

	  // loop through each char from left to right
	  for (int i=0; i < str.length(); i++) {

		  //System.out.println("DEBUG:\tLooking at: " + str.charAt(i));

		  // try to catch errors if the stack is empty
		  try {
		  	switch (str.charAt(i)) {
			  	case '(': s.push('('); break;
			  	case ')': if (s.pop() != '(') { return false; }; break;
			  	case '{': s.push('{'); break;
			  	case '}': if (s.pop() != '{') { return false; }; break;
			  	case '[': s.push('['); break;
			  	case ']': if (s.pop() != '[') { return false; }; break;
			  	default : break; // any other char
		  	}

		  } catch(EmptyStackException e) { return false; }
	  }

	  // tests passed for every char
	  return true;

  }

  /**
   * Start an input loop that checks expressions given via STDIN
   */
  public static void main(String args[]) {

	  BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	  String str = "";

	  while (true) { // ctrl-c to exit the loop
	  	try {
	  		System.out.print("Enter an expression (ctrl-c to exit): ");
	  		str = buff.readLine();
	  	} catch(IOException e) {
		  	System.out.println(e.getMessage());
	  	} finally {
	  		System.out.println("Is it well-formed? " + isWellFormed(str));
	  	}
	  }
  }

}
