/**
 * File: BinarySearchTree.java
 *
 * Realization of a dictionary by means of a binary search tree.
 *
 * @author Dana Merrick
 */
public class BinarySearchTree<K,V>
  extends LinkedBinaryTree<Entry<K,V>> implements Dictionary<K,V> {

  protected Comparator<K> C;
  protected Position<Entry<K,V>> actionPos;
  protected int numEntries = 0;

  /** Creates a BinarySearchTree with a default comparator. */
  public BinarySearchTree() { 
    C = new DefaultComparator<K>(); 
    addRoot(null);
  }

  /** Creates a BinarySearchTree with a given comparator c. */
  public BinarySearchTree(Comparator<K> c) { 
    C = c; 
    addRoot(null);
  }

  /** Nested class for location-aware binary search tree entries */
  protected static class BSTEntry<K,V> implements Entry<K,V> {
    protected K key;
    protected V value;
    protected Position<Entry<K,V>> pos;
    BSTEntry() { /* default constructor */ }
    BSTEntry(K k, V v, Position<Entry<K,V>> p) { 
      key = k; value = v; pos = p;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public Position<Entry<K,V>> position() { return pos; }
  }

  /** Extracts the key of the entry at a given node of the tree. */
  protected K key(Position<Entry<K,V>> position) {
    return position.element().getKey();
  }

  /** Extracts the value of the entry at a given node of the tree. */  
  protected V value(Position<Entry<K,V>> position) { 
    return position.element().getValue(); 
  }

  /** Extracts the entry at a given node of the tree. */  
  protected Entry<K,V> entry(Position<Entry<K,V>> position) { 
    return position.element();
  }

  /** Replaces an entry with a new entry (and reset the entry's location) */
  protected void replaceEntry(Position <Entry<K,V>> pos, Entry<K,V> ent) {
    ((BSTEntry<K,V>) ent).pos = pos;
    replace(pos, ent);
  }

  /** Checks whether a given key is valid. */  
  protected void checkKey(K key) throws InvalidKeyException {
    if(key == null)
      throw new InvalidKeyException("null key");
  }

  /** Checks whether a given entry is valid. */
  protected void checkEntry(Entry<K,V> ent) throws InvalidEntryException {
    if(ent == null || !(ent instanceof BSTEntry))
      throw new InvalidEntryException("invalid entry");
  }

  /** 
   * Auxiliary method for inserting an entry at an external node 
   *
   * @param position to use
   * @param entry to insert
   * @return Entry<K,V> entry added
   */
  protected Entry<K,V> insertAtExternal(Position<Entry<K,V>> v, Entry<K,V> e) {

    // throw exception if not given external node
    if (isInternal(v))
      throw new InvalidPositionException("given position is internal");

    // add empty external nodes
    insertLeft(v,null);
    insertRight(v,null);

    replaceEntry(v,e);

    numEntries++;
    return e;
  }

  /**
   * Auxiliary method for removing an external node and its parent 
   *
   * @param position to remove
   */
  protected void removeExternal(Position<Entry<K,V>> v) {

    // throw exception if not given external node
    if (isInternal(v))
      throw new InvalidPositionException("given position is internal");

    if (v != root()) {
      BTPosition<Entry<K,V>> par = (BTPosition) parent(parent(v));
      BTPosition<Entry<K,V>> sib = (BTPosition) sibling(v);

      sib.setParent(par);
    } else {
      replace(v,null);
    }

    numEntries--;
  }

  /** Auxiliary method used by find, insert, and remove. */
  protected Position<Entry<K,V>> treeSearch(K key, Position<Entry<K,V>> pos) {
    if (isExternal(pos)) 
      return pos;
    else {
      K curKey = key(pos);
      int comp = C.compare(key, curKey);
      if (comp < 0) 
        return treeSearch(key, left(pos));
      else if (comp > 0)
        return treeSearch(key, right(pos));
      return pos;
    }
  }

  /**
   * Adds to L all entries in the subtree rooted at v having keys equal to 
   *  k in inorder. 
   *
   * @param list to add to
   * @param position to use
   * @param key to search for
   */
  protected void addAll(IndexList<Entry<K,V>> L, 
    Position<Entry<K,V>> v, K k) {

    // inorder traversal
    if (checkPosition(v).getLeft() != null)
      addAll(L,left(v),k);
    if (entry(v) != null && key(v) == k)
      L.add(L.size(),entry(v));
    if (checkPosition(v).getRight() != null)
      addAll(L,right(v),k);

  }

  /**
   * Adds to L all entries in the subtree rooted at v.
   *
   * @param list to add to
   * @param position to use
   */
  protected void addAll(IndexList<Entry<K,V>> L, 
    Position<Entry<K,V>> v) {

    // inorder traversal
    if (checkPosition(v).getLeft() != null)
      addAll(L,left(v));
    if (entry(v) != null)
      L.add(L.size(),entry(v));
    if (checkPosition(v).getRight() != null)
      addAll(L,right(v));

  }

  // methods of the dictionary ADT
  /** Returns the number of entries in the dictionary. */
  public int size() { return numEntries; }

  /** Tests whether the dictionary is empty. */
  public boolean isEmpty() { return size() == 0; }

  /** Returns an entry whose key is equal to a given key. */
  public Entry<K,V> find(K key) throws InvalidKeyException {
    checkKey(key);
    Position<Entry<K,V>> curPos = treeSearch(key, root());
    actionPos = curPos;
    if (isInternal(curPos)) 
      return entry(curPos);
    return null;
  }

  /**
   * Returns an iterable collection of all entries whose keys are equal to a    
given key k. 
   *
   * @param key to look up
   * @return Iterable<Entry<K,V>> collection of entries
   */
  public Iterable<Entry<K,V>> findAll(K k) throws InvalidKeyException {

    // create a new Iterable
    ArrayIndexList<Entry<K,V>> S = new ArrayIndexList<Entry<K,V>>();

    // add all entries with key k to S
    addAll(S,root(),k);

    return S;

  }

  /** Insert an entry with a given key k and value x into the dictionary, 
   *  returning the entry created. */
  public Entry<K,V> insert(K k, V x) throws InvalidKeyException {
    checkKey(k);
    Position<Entry<K,V>> insPos = treeSearch(k, root());
    while (!isExternal(insPos))
      insPos = treeSearch(k, left(insPos));
    actionPos = insPos;
    return insertAtExternal(insPos, new BSTEntry<K,V>(k, x, insPos));
  }

  /** Remove from the dictionary a given entry ent, returning the removed
   *  entry. */
  public Entry<K,V> remove(Entry<K,V> ent) throws InvalidEntryException {
    checkEntry(ent);
    Position<Entry<K,V>> remPos = ((BSTEntry<K,V>) ent).position(); 
    Entry<K,V> toReturn = entry(remPos);
    if (isExternal(left(remPos))) 
      remPos = left(remPos);
    else if (isExternal(right(remPos))) 
      remPos = right(remPos);
    else {
      Position<Entry<K,V>> swapPos = remPos;
      remPos = right(swapPos);
      do
	remPos = left(remPos);
      while (isInternal(remPos));
      replaceEntry(swapPos, (Entry<K,V>) parent(remPos).element());
    }
    actionPos = sibling(remPos);
    removeExternal(remPos);
    return toReturn;
  }

  /**
   * Returns an iterable collection of all key-value entries in the hash table.
   *
   * @return Iterable<Entry<K,V>> collection of entries
   */
  public Iterable<Entry<K,V>> entries() {

    // create a new Iterable
    ArrayIndexList<Entry<K,V>> S = new ArrayIndexList<Entry<K,V>>();

    addAll(S,root());

    return S;

  }

}
