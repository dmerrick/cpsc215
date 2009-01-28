/**
 * File: HeapPQ.java
 *
 * Realization of a priority queue by means of a heap.  The heap is directly 
 * built on the ADT array list.
 *
 * @author Dana Merrick
 */
public class HeapPQ<K,V> implements PriorityQueue<K,V> {

  protected IndexList<Entry<K,V>> heap;
  protected Comparator<K> comp;
  protected int size;

  /**
   * Inner class for entries
   */
  protected static class MyEntry<K,V> implements Entry<K,V> {
    protected K k;
    protected V v;
    public MyEntry(K key, V value) {
      k = key;
      v = value;
    }
    public K getKey() { return k; }
    public V getValue() { return v; }
  }

  /**
   * Creates an empty heap with the default comparator. 
   */ 
  public HeapPQ() {
    heap = new ArrayIndexList<Entry<K,V>>();
    comp = new DefaultComparator<K>();
    heap.add(0, null);
    size = 0;
  }

  /**
   * Creates an empty heap with the given comparator. 
   *
   * @param a comparator
   */
  public HeapPQ(Comparator<K> c) {
    heap = new ArrayIndexList<Entry<K,V>>();
    comp = c;
    heap.add(0, null);
    size = 0;
  }

  /**
   * Returns the size of the heap.
   *
   * @return int the size of the heap
   */
  public int size() {
    return size;
  }

  /**
   * Returns whether the heap is empty. 
   *
   * @return boolean true if heap is empty
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns but does not remove an entry with minimum key. 
   *
   * @return Entry<K,V> the entry with the smallest key
   */
  public Entry<K,V> min() throws EmptyPriorityQueueException {
    if (isEmpty()) 
      throw new EmptyPriorityQueueException("Priority queue is empty.");
    return heap.get(1);
  }

  /**
   * Inserts a key-value pair and return the entry created.
   *
   * @param a key to insert
   * @param a value to insert
   * @return Entry<K,V> the new entry
   */
  public Entry<K,V> insert(K k, V x) throws InvalidKeyException {
    // check the key to insert
    checkKey(k);

    // create the entry to add
    Entry<K,V> entry = new MyEntry<K,V>(k,x);
    // add the entry to the first available slot
    heap.add(size+1,entry);

    // start our loop
    int i = size + 1;
    // up-heap bubbling
    while (i > 1) {
      if (comp.compare(key(heap.get(i)), key(heap.get(i/2))) < 0) { // <
        swap(i,i/2);
        i /= 2;
      } else {
        // everything is in place
        break;
      }
    }

    size++;
    return entry;
  }

  /**
   * Removes and returns an entry with minimum key.
   *
   * @return Entry<K,V> the entry with the smallest key
   */
  public Entry<K,V> removeMin() throws EmptyPriorityQueueException {
    // define a variable which we will return
    Entry<K,V> x;

    if (size > 1)
      x = heap.set(1, heap.remove(size));
    else // heap is trivial
      x = heap.remove(1);

    // start our loop
    int j;
    int i = 1;
    // down-heap bubbling
    while (2*i <= size-1) {
      j = 2*i;

      if ((j<size-1) && (comp.compare(key(heap.get(j)), key(heap.get(j+1))) > 0)) // j > j+1
        j++;
      if (comp.compare(key(heap.get(i)), key(heap.get(j))) > 0) { // i > j
        swap(i,j);
        i=j;
      } else {
        // everything is in place
        break;
      }
    }

    size--;
    return x;
  }

  /**
   * Returns the key stored in an entry.
   *
   * @param the entry to look at
   * @return K the value of the key
   */
  protected K key(Entry<K,V> e) {
    return e.getKey();
  }

  /**
   * Returns the value stored in an entry. 
   * 
   * @param the entry to look at
   * @param V the value of the entry
   */
  protected V value(Entry<K,V> e) {
    return e.getValue();
  }

  /**
   * Determines whether a given key is valid. 
   *
   * @param a key to check
   */
  protected void checkKey(K key) throws InvalidKeyException {
    try {
      comp.compare(key, key);
    }
    catch(Exception e) {
      throw new InvalidKeyException("Invalid key");
    }
  }

  /**
   * Swaps the entries of the two given indices. 
   *
   * @param the first index to swap
   * @param the second index to swap
   */
  protected void swap(int i, int j) {
    Entry<K,V> temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

}
