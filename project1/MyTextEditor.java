/**
 * File: MyTextEditor.java
 *
 * A text editor implemented using the ArraySequence ADT.
 *
 * @author Dana Merrick
 */
public class MyTextEditor {

  // instance variables
  protected ArraySequence<String> S;
  protected int cursor;

  /**
   * Constructs a new MyTextEditor object.
   */
  public MyTextEditor() {
    S = new ArraySequence<String>();
    cursor = -1;
  }

  /** 
   * Returns true if the text is completely empty (and cursor is at line -1).
   *
   * @return boolean true if empty
   */
  public boolean isEmpty() {
    return S.isEmpty() && cursor == -1;
  }

  /** 
   * Returns the current number of lines of text. 
   *
   * @return int number of lines
   */
  public int size() {
    return S.size();
  }

  /** 
   * Returns true if the cursor is at the last line in the text or the text 
   * is empty.
   *
   * @return boolean true if cursor is at last line
   */
  public boolean isCursorAtLastLine() {
    return S.atIndex(cursor) == S.last();
  }

  /** 
   * Sets the cursor to be the text line after its current position.
   */
  public void cursorDown() throws BoundaryViolationException { 
    S.atIndex(++cursor);
  }

  /** 
   * Sets the cursor to be the text line before its current position.
   */
  public void cursorUp() throws BoundaryViolationException { 
    S.atIndex(--cursor);
  }

  /** 
   * Sets the cursor to be the line ranked i (the first line is line 0).
   *
   * @param the line to set
   */
  public void moveCursorToLine(int i) throws BoundaryViolationException {
    S.atIndex(cursor = i);
  }

  /**
   * Returns the line number (rank) of the current cursor line.
   *
   * @return int the line number
   */
  public int cursorLineNum() {
    // have to add one since line numbers start at 1
    return cursor+1;
  }

  /**
   * Inserts a string s in the line after the current cursor, moving the
   * cursor to the line inserted.
   *
   * @param the string to set after the cursor
   */
  public void insertAfterCursor(String s) {
    cursor++;
    S.add(cursor,s);
  }

  /**
   * Inserts a string s in the line before the current cursor, moving the
   * cursor to the line inserted.
   *
   * @param the string to set before the cursor
   */
  public void insertBeforeCursor(String s) throws BoundaryViolationException {
    S.atIndex(--cursor); // check boundaries
    S.add(cursor,s);
  }

  /**
   * Replaces the string at the current cursor with the String s, keeping
   * the cursor at this line.
   *
   * @pram the string to replace with
   */
  public void replaceAtCursor(String s) throws BoundaryViolationException {
    S.atIndex(cursor); // check boundaries
    S.set(cursor,s);
  }

  /**
   * Removes the entire line at the current cursor, setting the cursor to now
   * be the position of the next line, unless the cursor was the last line, 
   * in which case the cursor should move to the new last line.
   */
  public void removeAtCursor() throws BoundaryViolationException {
    if (S.atIndex(cursor) == S.last()) {
      S.remove(cursor);
      cursor--;
    } else {
      S.remove(cursor);
    }
  }

  /**
   * Prints the entire text to the console.
   */
  public void print() {
    for (int i=0; i<S.size(); i++) {
      System.out.println(S.atIndex(i).element());
    }
  }

}
