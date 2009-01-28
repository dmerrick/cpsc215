/**
 * File: Sequence.java
 *
 * An interface for a sequence, a data structure supporting all
 * operations of a deque, indexed list and position list.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see Deque
 * @see IndexList
 * @see PositionList
 * @see BoundaryViolationException
 * @see InvalidPositionException
 */

public interface Sequence<E> 
  extends Deque<E>, IndexList<E>, PositionList<E> {

  /** Returns the position containing the element at the given index. */
  public Position<E> atIndex(int r) throws BoundaryViolationException;

  /** Returns the index of the element stored at the given position. */
  public int indexOf(Position<E> p) throws InvalidPositionException;

}
