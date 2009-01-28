/**
 * File: Entry.java
 *
 * An interface for a key-value pair entry.
 *
 * @author Roberto Tamassia
 * @author Michael Goodrich
 */

public interface Entry<K,V> {

  /** Returns the key stored in this entry. */
  public K getKey();

  /** Returns the value stored in this entry. */
  public V getValue();

}
