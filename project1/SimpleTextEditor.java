/**
 * File: SimpleTextEditor.java
 *
 * This is a simple text editor interface, which assumes a text editor 
 * is built for lines of text.  Each line of text is to be viewed as a 
 * separate string.  In addition, this editor has a cursor associated 
 * with some line in the text.  Initially, the cursor is set to the the 
 * line -1 just before the first line in the text.  The methods of the 
 * text editor are designed to update and print the text file using the 
 * cursor.
 *
 * @author Takunari Miyazaki
 * @version 1.1, 03/10/2007
 * @see BoundaryViolationException
 * @see String
 */

public interface SimpleTextEditor {

  /** 
   * Returns true if the text is completely empty (and cursor is at line -1).
   */
  public boolean isEmpty();

  /** 
   * Returns the current number of lines of text. 
   */
  public int size();

  /** 
   * Returns true if the cursor is at the last line in the text or the text 
   * is empty.
   */
  public boolean isCursorAtLastLine();

  /** 
   * Sets the cursor to be the text line after its current position.
   */
  public void cursorDown() throws BoundaryViolationException;

  /** 
   * Sets the cursor to be the text line before its current position.
   */
  public void cursorUp() throws BoundaryViolationException;

  /** 
   * Sets the cursor to be the line ranked i (the first line is line 0).
   */
  public void moveCursorToLine(int i) throws BoundaryViolationException;

  /**
   * Returns the line number (rank) of the current cursor line.
   */
  public int cursorLineNum();

  /**
   * Inserts a string s in the line after the current cursor, moving the
   * cursor to the line inserted.
   */
  public void insertAfterCursor(String s);

  /**
   * Inserts a string s in the line before the current cursor, moving the
   * cursor to the line inserted.
   */
  public void insertBeforeCursor(String s) throws BoundaryViolationException;

  /**
   * Replaces the string at the current cursor with the String s, keeping
   * the cursor at this line.
   */
  public void replaceAtCursor(String s) throws BoundaryViolationException;

  /**
   * Removes the entire line at the current cursor, setting the cursor to now
   * be the position of the next line, unless the cursor was the last line, 
   * in which case the cursor should move to the new last line.
   */
  public void removeAtCursor() throws BoundaryViolationException;

  /**
   * Prints the entire text to the console.
   */
  public void print();

}
