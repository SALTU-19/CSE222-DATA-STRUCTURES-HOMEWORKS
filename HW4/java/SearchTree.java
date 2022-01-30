public interface SearchTree<E>{
	/**
	 * 
	 * @param element
	 * @return
	 */
    public int add(E element);
    /**
     * 
     * @param element
     * @return
     */
    public int find(E element);
    /**
     * 
     * @param element
     * @return
     */
    public int remove(E element);
}