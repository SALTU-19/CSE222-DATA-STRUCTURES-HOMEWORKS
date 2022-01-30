/**
 * 
 * @author alien
 * interface KWHashMap interface
 * @param <K> key 
 * @param <V> value
 */
public interface KWHashMap<K, V> {
	/**
	 * Returns the value associated with the specified key
	 * @param key
	 * @return null if the key is not present
	 */
	V get(Object key);
	/**
	 * 
	 * @return true if this table contains no key/value mappings
	 */
	boolean isEmpty();
	/**
	 * Associates the specified value with the specified key.
	 * @param key key 
	 * @param value value 
	 * @return Returns the previous value associated with the specified key, or null if there was no mapping for the key
	 */
	V put(K key, V value);
	/**
	 * Removes the mapping for this key from this table if it is present (optional operation).
	 * @param key key
	 * @return s the previous value associated with the specified key, or null if there was no mapping
	 */
	V remove(Object key);
	/**
	 * 
	 * @return the size of the table
	 */
	int size();
}
