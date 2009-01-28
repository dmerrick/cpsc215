/**
 * File: Entry.java
 *
 * An interface for a key-value pair entry.
 *
 * @author Takunari Miyazaki
 * @see Entry
 * @see InvalidEntryException
 * @see InvalidKeyException
 * @see Iterable
 */

public interface Dictionary<K,V> {

  /** Returns the number of entries in the dictionary. */
  public int size();

  /** Tests whether the dictionary is empty. */
  public boolean isEmpty();

  /** Returns an entry whose key is equal to a given key k. */
  public Entry<K,V> find(K k) throws InvalidKeyException;

  /** Returns an iterable collection containing all entries whose keys are
   *  equal to a given key k. */
  public Iterable<Entry<K,V>> findAll(K k) throws InvalidKeyException;

  /** Insert an entry with a given key k and value x into the dictionary, 
   *  returning the entry created. */
  public Entry<K,V> insert(K k, V x) throws InvalidKeyException;

  /** Removes from the dictionary a given entry e, returning the removed
   *  entry. */
  public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException;

  /** Returns an iterable collection of all key-value entries in the 
   *  dictionary. */
  public Iterable<Entry<K,V>> entries();

}
