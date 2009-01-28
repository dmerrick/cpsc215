/**
	* File: ArraySequence.java
	*
	* This class implements the Sequence ADT using an array.
	*
	* @author Dana Merrick
	*/
public class ArraySequence<E> implements Sequence<E>{

	// instance variables
	public final static int CAPACITY = 16; 
	public int capacity; // this will expand/contract
	protected PositionObject<E> A[];
	protected int size;

	/**
		* Constructs a new ArraySeqence object.
		*/
	public ArraySequence() {
		A = (PositionObject<E>[]) new PositionObject[CAPACITY];
    // instansiate the array with empty objects
    for (int i=0;i<CAPACITY;i++)
      A[i] = new PositionObject<E>(i,null);
		size = 0;
    capacity = CAPACITY;
	}

	/**
		* Returns the number of elements in the sequence. 
		*
		* @return int number of elements in sequence
		*/
	public int size() { 
		return size;
	}

	/**
		* Returns whether the sequence is empty. 
		*
		* @return boolean true if the sequence is empty
		*/
	public boolean isEmpty() {
		return size() <= 0;
	}

	/**
		* Returns the first element; an exception is thrown if sequence is empty. 
		*
		* @return E the value of the first element
		*/
	public E getFirst() throws EmptySequenceException { 
		if (isEmpty())
			throw new EmptySequenceException("Empty!");

		return atIndex(0).element();
	}

	/**
		* Returns the last element; an exception is thrown if sequence is empty. 
		*
		* @return E the value of the last element
		*/
	public E getLast() throws EmptySequenceException {
		if (isEmpty())
			throw new EmptySequenceException("Empty!");

		return atIndex(size-1).element();
	}

	/**
		* Inserts an element to be the first in the sequence. 
		*
		* @param the element to be added
		*/
	public void addFirst(E element) { 
		add(0,element);
	} 

	/**
		* Inserts an element to be the last in the sequence. 
		*
		* @param the element to be added
		*/
	public void addLast(E element) { 
		add(size,element);
	}

	/**
		* Removes the first element; an exception is thrown if sequence is empty. 
		*
		* @return E the value of the element removed
		*/
	public E removeFirst() throws EmptySequenceException { 
		if (isEmpty())
			throw new EmptySequenceException("Empty!");

		return remove(0);
	}

	/**
		* Removes the last element; an exception is thrown if sequence is empty. 
		*
		* @return E the value of the element removed
		*/
	public E removeLast() throws EmptySequenceException { 
		if (isEmpty())
			throw new EmptySequenceException("Empty!");

		return remove(size()-1);
	}

	/**
		* Returns the position containing the element at the given index. 
    * This also serves as a checkBounds() method.
		*
		* @param r the index to look for
		* @return Position<E> the position object at the given index
		*/
	public Position<E> atIndex(int r) throws BoundaryViolationException { 
		if ((r < 0) || (r >= size()+1))
			throw new BoundaryViolationException("Given index is out of bounds");

		return A[r];
	}

	/**
		* Returns the index of the element stored at the given position. 
		*
		* @param the position object we're looking at
		* @return int the index of the given position
		*/
	public int indexOf(Position<E> p) throws InvalidPositionException { 
		// check position
		if (p == null)
			throw new InvalidPositionException("Null position passed to NodeList");

		try {
			PositionObject<E> temp = (PositionObject<E>) p;
			if (temp.element() == null)
				throw new InvalidPositionException("Position does not contain valid data.");
			return temp.index();

		} catch (ClassCastException e) {
			throw new InvalidPositionException("Position is of wrong type for this list");
		}
	}

	/**
		* This method sets the element at a given index to a given value, and
		* returns the previous value.
		*
		* @param the index to use
		* @param the value to set
		* @return E the previous value of index r
		*/
	public E set(int r, E e) {
		// extract the return value
		Position<E> ret = atIndex(r);
		E temp = ret.element();

    // replace the old PositionObject with a new one
    PositionObject<E> newElement = new PositionObject<E>(r,e);
    A[r] = newElement;

		return temp;
	}

	/**
		* This method sets the element at a given position to a given value, and
		* returns the previous value.
		*
		* @param the position to use
		* @param the value to set
		* @return E the previous value of the position
		*/
	public E set(Position<E> p, E e) {
		// save the return value
		E temp = p.element();

    // replace the PositionObject in A
    PositionObject<E> newElement = new PositionObject(indexOf(p),e);
    A[indexOf(p)] = newElement;

		return temp;
	}

	/**
		* Returns the value of the object at the given index.
		*
		* @param the index to look at
		* @return E the value of the element
		*/
	public E get(int r) {
		Position<E> temp = atIndex(r);
		return temp.element();
	}

	/**
		* Returns the object before the given position.
		*
		* @param an object to look at
		* @return Position<E> the preceding object
		*/
	public Position<E> prev(Position<E> p) {
		int i = indexOf(p);
		return atIndex(i-1);
	}

	/**
		* Returns the object following the given position.
		*
		* @param an object to look at
		* @return Position<E> the following object
		*/
	public Position<E> next(Position<E> p) {
		int i = indexOf(p);
		return atIndex(i+1);
	}

	/**
		* Returns the last object in the sequence.
		*
		* @return Position<E> the last object
		*/
	public Position<E> last() {
		return atIndex(size-1);
	}

	/**
		* Returns the first object in the sequence.
		*
		* @return Position<E> the last object
		*/
	public Position<E> first() {
		return atIndex(0);
	}

  /**
   * Adds a new element before the given position.
   *
   * @param the position to add before
   * @param the element to add
   */
	public void addBefore(Position<E> p, E e) {
		int cur = indexOf(p);
		add(cur-1,e);
	}

  /**
   * Adds a new element after the given position.
   *
   * @param the position to add after
   * @param the element to add
   */
	public void addAfter(Position<E> p, E e) {
		int cur = indexOf(p);
		add(cur+1,e);
	}

  /**
   * Adds a new element at a given index. Used in many other methods.
   *
   * @param the index at which to add
   * @param the element to add
   */
	public void add(int r, E e) {
		atIndex(r); // check index

		if (size == capacity) {        // an overflow
			capacity *= 2;
		  PositionObject<E>[] B =(PositionObject<E>[]) new PositionObject[capacity];
		  for (int i=0; i<size; i++) 
			  B[i] = A[i];
		  A = B;
	  }

	  for (int i=size-1; i>=r; i--) { // shift elements up
      // replace the PositionObject in A with updated index
      E old = atIndex(i).element();
      PositionObject<E> newElement = new PositionObject(i+1,old);
      A[i] = newElement;

      // shift array element 
		  A[i+1] = A[i];
    }

    PositionObject<E> newElement = new PositionObject<E>(r,e);
    A[r] = newElement;
    size++;
  }

  /**
   * Removes an element at a given index. Used in many other methods.
   *
   * @param the index of the element to remove
   */
	public E remove(int r) {
    // save the value for the return value
		Position<E> temp = atIndex(r);

		for (int i=r; i<size-1; i++) { // shift elements down
      // replace the PositionObject in A with updated index
      E old = atIndex(i+1).element();
      PositionObject<E> newElement = new PositionObject(i,old);
      A[i+1] = newElement;
      // shift array element over
			A[i] = A[i+1];
    }
		size--;

		return temp.element();
	}

  /**
   * Removes an element at a given position.
   *
   * @param the position of the element to remove
   */
	public E remove(Position<E> p) {
		E temp = p.element();

		for (int i=indexOf(p); i<size-1; i++) { // shift elements down
      // replace the PositionObject in A with updated index
      E old = atIndex(i+1).element();
      PositionObject<E> newElement = new PositionObject(i,old);
      A[i+1] = newElement;
      // shift array element over
			A[i] = A[i+1];
    }
		size--;

		return temp;
	}

}
