
public interface MyIter<K> {
	/**
	 * 
	 * @return
	 */
	public K next();
	/**
	 * 
	 * @return
	 */
	public K prev();
	/**
	 * 
	 * @return
	 */
	public boolean hasNext();
	/**
	 * 
	 * @return
	 */
	public boolean hasPrev();
}
