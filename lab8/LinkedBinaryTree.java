/**
 * File: LinkedBinaryTree.java
 *
 * An implementation of the BinaryTree interface by means of a linked 
 * structure.
 *
 * @author Stevon Judd
 * @author Dana Merrick
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {

  protected BTPosition<E> root;	// reference to the root
  protected int size;		// number of nodes

  /** 
   * Creates an empty binary tree.
   */
  public LinkedBinaryTree() { 		    
    root = null;                // start with an empty tree
    size = 0;
  }

  /** 
   * Returns the number of nodes in the tree. 
   *
   * @return int size
   */
  public int size() {
    return size; 
  }

  /**
   * Returns whether the tree is empty.
   *
   * @return boolean true if empty
   */
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * Returns whether a node is internal. 
   *
   * @param position to check
   * @return boolean true if parameter is internal
   */
  public boolean isInternal(Position<E> v) throws InvalidPositionException {
    checkPosition(v);           // auxiliary method
    return (hasLeft(v) || hasRight(v));
  }

  /**
   * Returns whether a node is external. 
   *
   * @param position to check
   * @return boolean true if parameter is external
   */
  public boolean isExternal(Position<E> v) throws InvalidPositionException {
    checkPosition(v);

    return (!hasLeft(v) && !hasRight(v));
  }

  /**
   * Returns whether a node is the root. 
   *
   * @param position to check
   * @return boolean true if parameter is root node
   */
  public boolean isRoot(Position<E> v) throws InvalidPositionException { 
    checkPosition(v);
    return (v == root()); 
  }

  /**
   * Returns whether a node has a left child. 
   *
   * @param position to check
   * @return boolean true if parameter has left child
   */
  public boolean hasLeft(Position<E> v) throws InvalidPositionException { 
    BTPosition<E> vv = checkPosition(v);
    return (vv.getLeft() != null);
  }

  /**
   * Returns whether a node has a right child.
   *
   * @param position to check
   * @return boolean true if parameter has right child
   */
  public boolean hasRight(Position<E> v) throws InvalidPositionException { 
    BTPosition<E> vv = checkPosition(v);
    return (vv.getRight() != null);
  }

  /**
   * Returns the root of the tree. 
   *
   * @return Position<E> the root node
   */
  public Position<E> root() throws EmptyTreeException {
    if (root == null)
      throw new EmptyTreeException("The tree is empty");
    return root;
  } 

  /**
   * Returns the left child of a node. 
   *
   * @param the position to check
   * @return Position<E> the node to the left of the paremeter
   */
  public Position<E> left(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException { 
    BTPosition<E> vv = checkPosition(v);
    Position<E> leftPos = vv.getLeft();
    if (leftPos == null)
      throw new BoundaryViolationException("No left child");
    return leftPos;
  }

  /**
   * Returns the right child of a node.
   *
   * @param the position to check
   * @return Position<E> the node to the right of the paremeter
   */
  public Position<E> right(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException {
    BTPosition<E> vv = checkPosition(v);
    Position<E> rightPos = vv.getRight();
    if (rightPos == null)
      throw new BoundaryViolationException("No right child");
    return rightPos;
  }  

  /**
   * Returns the parent of a node.
   *
   * @param the position to check
   * @return Position<E> the node above the paremeter
   */
  public Position<E> parent(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException { 
    BTPosition<E> vv = checkPosition(v);
    Position<E> parentPos = vv.getParent();
    if (parentPos == null)
      throw new BoundaryViolationException("No parent");
    return parentPos; 
  }

  /**
   * Returns an iterable collection of the children of a node. 
   *
   * @param the position to check
   * @return Iterable<Position<E> an iterable collection of children
   */
  public Iterable<Position<E>> children(Position<E> v) 
    throws InvalidPositionException, IndexOutOfBoundsException {
    BTPosition<E> vv = checkPosition(v);
    
    ArrayIndexList<Position<E>> A = new ArrayIndexList<Position<E>>();
    int cur = 0;

    if (hasLeft(vv)) {
      A.add(cur,left(vv));
      cur++;
    }

    if (hasRight(vv)) 
      A.add(cur,right(vv));

    return A;
  }

  /**
   * Returns an iterable collection of the tree nodes in preorder. 
   *
   * @return Iterable<Position<E> an iterable collection of tree nodes
   */
  public Iterable<Position<E>> positions() {

    // create an empty IndexList
    ArrayIndexList<Position<E>> A = new ArrayIndexList<Position<E>>();

    preorderPositions(root(),A); // this method fills A

    return A;
  }

  /**
   * Returns an iterator of the elements stored at the nodes in preorder. 
   *
   * @return Iterator<E> an iterator of elements stored in preorder
   */
  public Iterator<E> iterator() {

    // create and empty IndexList obhect
    ArrayIndexList<E> A = new ArrayIndexList<E>();

    // create an iterator of positions
    Iterator<Position<E>> positions = positions().iterator();

    // loop through each position in the tree and add it to A
    while (positions.hasNext())
      A.add(A.size(),positions.next().element());

    // return an iterator of the elements in A
    return A.iterator();

  }

  /**
   * Replaces the element at a node.
   *
   * @param a position to use
   * @param an object to replace with
   * @return E the previous value for the parameter position
   */
  public E replace(Position<E> v, E o) 
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    E temp = v.element();
    vv.setElement(o);
    return temp;
  }

  // Additional accessor method
  /**
   * Return the sibling of a node 
   *
   * @param a position to use
   * @return Position<E> the sibling of the parameter
   */
  public Position<E> sibling(Position<E> v) 
    throws InvalidPositionException, BoundaryViolationException {
      BTPosition<E> vv = checkPosition(v);
      BTPosition<E> parentPos = vv.getParent();
      if (parentPos != null) {
	BTPosition<E> sibPos;
	BTPosition<E> leftPos = parentPos.getLeft();
	if (leftPos == vv)
	  sibPos = parentPos.getRight();
	else
	  sibPos = parentPos.getLeft();
	if (sibPos != null)
	  return sibPos;
      }
      throw new BoundaryViolationException("No sibling");
  }

  // Additional update methods
  /**
   * Adds a root node to an empty tree 
   *
   * @param the element to add as root
   * @return Postion<E> the position created
   */
  public Position<E> addRoot(E e) throws NonEmptyTreeException {
    if(!isEmpty())
      throw new NonEmptyTreeException("Tree already has a root");
    size = 1;
    root = createNode(e,null,null,null);
    return root;
  }

  /**
   * Inserts a left child at a given node. 
   *
   * @param a position to use
   * @param the element to add
   * @return Position<E> the position created
   */
  public Position<E> insertLeft(Position<E> v, E e)
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    Position<E> leftPos = vv.getLeft();
    if (leftPos != null)
      throw new InvalidPositionException("Node already has a left child");
    BTPosition<E> ww = createNode(e, vv, null, null);
    vv.setLeft(ww);
    size++;
    return ww;
  }

  /**
   * Inserts a right child at a given node. 
   *
   * @param a position to use
   * @param the element to add
   * @return Position<E> the position created
   */
  public Position<E> insertRight(Position<E> v, E e)
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    Position<E> rightPos = vv.getRight();
    if (rightPos != null)
      throw new InvalidPositionException("Node already has a right child");
    BTPosition<E> ww = createNode(e, vv, null, null);
    vv.setRight(ww);
    size++;
    return ww;
  }

  /**
   * Removes a node with zero or one child. 
   *
   * @param the position to remove
   * @return E the value of the paremeter removed
   */
  public E remove(Position<E> v)
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    BTPosition<E> leftPos = vv.getLeft();
    BTPosition<E> rightPos = vv.getRight();
    if (leftPos != null && rightPos != null)
      throw new 
        InvalidPositionException("Cannot remove node with two children");
    BTPosition<E> ww; 	        // the only child of v, if any
    if (leftPos != null)
      ww = leftPos;
    else if (rightPos != null)
      ww = rightPos;
    else 		        // v is a leaf
      ww = null;
    if (vv == root) { 	        // v is the root
      if (ww != null)
	ww.setParent(null);
      root = ww;
    }
    else { 		        // v is not the root
      BTPosition<E> uu = vv.getParent();
      if (vv == uu.getLeft())
	uu.setLeft(ww);
      else
	uu.setRight(ww);
      if(ww != null)
	ww.setParent(uu);
    }
    size--;
    return v.element();
  }

  /**
   * Attaches two trees to be subtrees of an external node. 
   *
   * @param a position to attach to
   * @param the first tree to attach
   * @param the second tree to attach
   */
  public void attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) 
    throws InvalidPositionException {
    BTPosition<E> vv = checkPosition(v);
    if (isInternal(v))
      throw new InvalidPositionException("Cannot attach from internal node");
    if (!T1.isEmpty()) {
      BTPosition<E> r1 = checkPosition(T1.root());
      vv.setLeft(r1);
      r1.setParent(vv);		// T1 should be invalidated
    }
    if (!T2.isEmpty()) {
      BTPosition<E> r2 = checkPosition(T2.root());
      vv.setRight(r2);
      r2.setParent(vv);		// T2 should be invalidated
    }
  }

  /**
   * If v is a good node, cast to BTPosition, else throw exception. 
   * 
   * @param a position to check
   * @return BTPosition<E> the valid position
   */
  protected BTPosition<E> checkPosition(Position<E> v) 
    throws InvalidPositionException {
    if (v == null || !(v instanceof BTPosition))
      throw new InvalidPositionException("The position is invalid");
    return (BTPosition<E>) v;
  }

  /**
   * Creates a new binary tree node 
   * 
   * @param an element to create
   * @param a position to use as parent
   * @param a position to use as left child
   * @param a position to use as right child
   * @return BTPosition<E> the valid position
   */
  protected BTPosition<E> createNode(E element, BTPosition<E> parent, 
    BTPosition<E> left, BTPosition<E> right) {
    return new BTNode<E>(element,parent,left,right);
  }

  /**
   * Creates a list of the nodes in the subtree of a node in preorder. 
   *
   * @param a position to use
   * @param a list of positions that we will modify
   */
  protected void preorderPositions(Position<E> v, IndexList<Position<E>> pos) 
    throws InvalidPositionException, IndexOutOfBoundsException {
    BTPosition<E> vv = checkPosition(v);

    // add size variable to make it more clear
    int size = pos.size();

    // add the position to the first empty space in the IndexList
    pos.add(size,vv);

    // start the recursion:

    // look through left nodes
    if (hasLeft(vv))
      preorderPositions(left(vv),pos);

    // look through right nodes
    if (hasRight(vv))
      preorderPositions(right(vv),pos);

  }

}
