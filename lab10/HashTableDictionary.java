/**
 * File: HashTableDictionary.java
 * 
 * A hash table with linear probing using the division method for the hash 
 * function.
 *
 * @author Dana Merrick
 */
public class HashTableDictionary<K,V> implements Dictionary<K,V> {

  /** Nested class for hash table entries */
  public static class HashEntry<K,V> implements Entry<K,V> {
    protected K key;
    protected V value;
    public HashEntry(K k, V v) { key = k; value = v; }
    public V getValue() { return value; }
    public K getKey() { return key; }
    public boolean equals(Entry<K,V> e) {
      HashEntry<K,V> he;
      try { he = (HashEntry<K,V>) e; }
      catch (ClassCastException ex) { return false; }
      return (he.getKey() == key) && (he.getValue() == value);
    }
  }

  /** Marker for deactivated buckets */
  protected Entry<K,V> AVAILABLE = new HashEntry<K,V>(null, null);
  /** Number of entries in the dictionary */
  protected int n = 0;
  /** Capacity of the bucket array */
  protected int capacity;
  /** Bucket array */
  protected Entry<K,V>[] H;

  /**
   * Creates a hash table with capacity 1023 
   */
  public HashTableDictionary() {
    this(1023);
  }
  
  /**
   * Creates a hash table with a given capacity cap
   *
   * @param capacity
   */
  public HashTableDictionary(int cap) {
    capacity = cap;
    H = (Entry<K,V>[]) new Entry[capacity];
  }
  
  // Auxiliary methods
  protected boolean available(int i) { return (H[i] == AVAILABLE); }
  protected boolean empty(int i) { return (H[i] == null); }
  protected K key(int i) { return H[i].getKey(); } 
  protected V value(int i) { return H[i].getValue(); }
  protected void checkKey(K k) throws InvalidKeyException {
    if (k == null) throw new InvalidKeyException("Invalid key: null.");
  }
  public int hashValue(K k) {
    return Math.abs(k.hashCode()) % capacity; // compression map
  }

  /**
   * Returns the number of entries in the dictionary. 
   *
   * @return int size
   */
  public int size() {
    return n;
  }

  /**
   * Tests whether the dictionary is empty. 
   *
   * @return boolean true if empty
   */
  public boolean isEmpty() {
    return (size() == 0);
  }

  /**
   * Helper search method 
   *
   * @param key to search
   * @return int index value of entry with key
   */
  private int findKey(K k) throws InvalidKeyException {
    checkKey(k);
    int i = hashValue(k);
    int j = i;
    do {
      if (empty(i)) return -1;  // item is not found
      if (available(i)) i = (i + 1) % capacity;  // bucket is deactivated
      else if (k.equals(key(i)))  // we have found our entry
        return i;
      else  // we must keep looking
        i = (i + 1) % capacity;
    } while (i != j);
    return -1;  // entry is not found
  }

  /** Returns an entry whose key is equal to a given key k. */
  public Entry<K,V> find(K k) throws InvalidKeyException {
    int i = findKey(k);  // helper method for finding a key
    if (i < 0) return null;
    return H[i];
  }

  /** Inserts an entry with a given key k and value x into the hash table, 
   *  returning the entry created. */
  public Entry<K,V> insert(K k, V x) 
      throws InvalidKeyException, FullHashTableException {
    checkKey(k);
    int i = hashValue(k);  // division method compression map
    int j = i;  // remember where we are starting
    do {
      if (empty(i) || available(i)) {  // this slot is available
        H[i] = new HashEntry(k, x);
        n++;
        return H[i];
      }
      i = (i + 1) % capacity;  // check next slot
    } while (i != j);  // repeat until we return to start
    throw new FullHashTableException("Hash table is full.");
  }


  /** Removes from the hash table a given entry e, returning the removed 
   *  entry. */
  public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException {
    int i = findKey(e.getKey());  // find this key first
    int j = i;
    if (i < 0)
      throw new InvalidEntryException("There is no such entry.");
    do {
      if (H[i].equals(e)) {
        Entry<K,V> toReturn = H[i];
        H[i] = AVAILABLE; // mark this slot as deactivated
        n--;
        return toReturn;
      }
      i = (i + 1) % capacity;
    } while ((!empty(i)) && (i != j));
    throw new InvalidEntryException("There is no such entry.");
  }

  /**
   * Returns an iterable collection of all key-value entries in the hash table.
   *
   * @return Iterable<Entry<K,V>> collection of entries
   */
  public Iterable<Entry<K,V>> entries() {

    // create a new Iterable
    ArrayIndexList<Entry<K,V>> S = new ArrayIndexList<Entry<K,V>>();

    // loop through each, adding them to S
    int cur = 0;
    while (S.size != n) {
      if (H[cur] != AVAILABLE && H[cur] != null)
        S.add(S.size(), H[cur]);
      cur++;
    }

    return S;

  }

  /**
   * Returns an iterable collection of all entries whose keys are equal to a given key k. 
   *
   * @param key to look up
   * @return Iterable<Entry<K,V>> collection of entries
   */
  public Iterable<Entry<K,V>> findAll(K k) throws InvalidKeyException {

    // create a new Iterable
    ArrayIndexList<Entry<K,V>> S = new ArrayIndexList<Entry<K,V>>();

    // loop through looking for each entry with key k
    // begins at the index returned by findKey(k)
    int first = findKey(k);

    if (first < 0)
      return S; // key not found
    else {
      int i = first;

      do {
        if (H[i] != AVAILABLE && H[i] != null)
          S.add(S.size(), H[i]);
        else if (H[i] == AVAILABLE)
          i = (i+1) % capacity;
        else
          break; // NOW we've seen all of the ks

        // increment i
        i = (i+1) % capacity;

      } while (i != first);
    }
    
    return S;

  }

  /**
   * Removes all entries whose keys are equal to a given key k and returns 
   * the removed entries in an iterable collection. 
   *
   * @param key to look up
   * @return Iterable<Entry<K,V>> collection of entries
   */
  public Iterable<Entry<K,V>> removeAll(K k) throws InvalidKeyException {

    // create a new Iterable
    ArrayIndexList<Entry<K,V>> S = new ArrayIndexList<Entry<K,V>>();

    // loop through looking for each entry with key k
    // begins at the index returned by findKey(k)
    Entry<K,V> e = find(k);
    while (e != null) {
      S.add(S.size(), e);
      remove(e);
      e = find(k);
    }
    
    return S;

  }

}
