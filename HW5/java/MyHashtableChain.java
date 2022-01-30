


import java.util.*;



/** Hash table implementation using chaining. */
public class MyHashtableChain<K extends Comparable<K>, V extends Comparable<V>> implements KWHashMap<K, V> {
	// Insert inner class Entry<K, V> here.
	/** The table */
	private Set<Entry<K, V>>[] table;
	/** The number of keys */
	private int numKeys;
	 /** The capacity */
    private static final int CAPACITY = 101;
	/** The maximum load factor */
	private static final double LOAD_THRESHOLD = 3.0;
	// Constructor
	public MyHashtableChain() {
		table = new TreeSet[CAPACITY];
	}
	 
/** Contains key/value pairs for a hash table. */
	  private static class Entry<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Entry>{
		  /** The key */
		  private K key;
		  /** The value */
		  private V value;
		  /** Creates a new key/value pair.
		  @param key The key
		  @param value The value
		  */
		  public Entry(K key, V value) {
			  this.key = key;
			  this.value = value;
		  }
		  /** Retrieves the key.
		  @return The key
		  */
		  public K getKey() {
			  return key;
		  }
		  /** Retrieves the value.
		  @return The value
		  */
		  public V getValue() {
			  return value;
		  }
		  /** Sets the value.
		  @param val The new value
		  @return The old value
		  */
		  public V setValue(V val) {
			  V oldVal = value;
			  value = val;
			  return oldVal;
		  }
		  @Override
		  public boolean equals(Object o) {
			  Entry<K, V> item = (Entry<K, V>) o;
			  if(item.getKey().equals(this.getKey()) && item.getValue().equals(this.getValue())) {
				  return true;
			  }
			  return false;
		  }
		@Override
		public int compareTo(MyHashtableChain.Entry o) {
			
			return this.getKey().compareTo((K) o.getKey());
		}

		  
	 }
	  
	  /** Method get for class MyHashtableChain.
	  @param key The key being sought
	  @return The value associated with this key if found;
	  otherwise, null
	  */
	 @Override
	 public V get(Object key) {
		 int index = key.hashCode() % table.length;
		 if (index < 0)
			 index += table.length;
		 if (table[index] == null)
			 return null; // key is not in the table.
		 // Search the list at table[index] to find the key.
		 for (Entry<K, V> nextItem : table[index]) {
			 if (nextItem.getKey().equals(key))
			 	return nextItem.getValue();
		 }
		 // assert: key is not in the table.
		 return null;
	 }

	@Override
	public boolean isEmpty() {
		if(numKeys == 0)
			return true;
		return false;
	}

	/** Method put for class MyHashtableChain.
	 @post This key/value pair is inserted in the
	 table and numKeys is incremented. If the key is already
	 in the table, its value is changed to the argument
	 value and numKeys is not changed.
	 @param key The key of item being inserted
	 @param value The value for this key
	 @return The old value associated with this key if
	 found; otherwise, null
	*/
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if (table[index] == null) {
		 // Create a new linked list at table[index].
			table[index] = new TreeSet<>();
		}
		 
		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
		// If the search is successful, replace the old value.
			if (nextItem.getKey().equals(key)) {
			// Replace value for this key.
				V oldVal = nextItem.getValue();
				nextItem.setValue(value);
				return oldVal; 
			}
		}
		// assert: key is not in the table, add new item.
		table[index].add(new Entry<>(key, value));
		numKeys++;
		if (numKeys > (LOAD_THRESHOLD * table.length))
			rehash();
		return null;
	}
	
	/** Method remove for class MyHashtableChain.
	 @post This key/value pair is removed.
	 @param key The key of item being inserted
	 @param value The value for this key
	 @return The old value associated with this key if
	 found; otherwise, null
	*/
	@Override
	public V remove(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if(table[index] == null)
			return null;
		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
		// If the search is successful, replace the old value.
			if (nextItem.getKey().equals(key)) {
			// Replace value for this key.
				V oldVal = nextItem.getValue();
				if(table[index].remove(new Entry((Comparable) key,oldVal))) {
					numKeys--;
					if(table[index].isEmpty()) {
						table[index] = null;
					}
					return oldVal; 					
				}

			}
		}
		
		return null;
	}

	@Override
	public int size() {
		
		return numKeys;
	}
	/** Expands table size when loadFactor exceeds LOAD_THRESHOLD
	 @post The size of the table is doubled and is an odd integer.
	 Each nondeleted entry from the original table is
	 reinserted into the expanded table.
	 The value of numKeys is reset to the number of items
	 actually inserted; numDeletes is reset to 0.
	*/
	private void rehash() {
		// Save a reference to oldTable.
		Set<Entry<K, V>>[] oldTable = table;
		// Double capacity of this table.
		table = new TreeSet[2 * oldTable.length + 1];
		// Reinsert all items in oldTable into expanded table.
		numKeys = 0;
		for (int i = 0; i < oldTable.length; i++) {
			if ((oldTable[i] != null)) {
				// Insert entry in expanded table
				for(Entry<K, V> j:oldTable[i])
					put(j.getKey(), j.getValue());
				
			}
		}
	}
}
