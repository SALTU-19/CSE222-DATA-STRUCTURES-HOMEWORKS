import java.util.Iterator;

/**
 * 
 * @author alien
 *
 * @param <E>
 */
public interface NavigableSet<E> {

	/**
	 * 
	 * @return
	 */
    Iterator<E> Iterator();
    /**
     * 
     * @return
     */
    Iterator<E> descendingIterator();
    /**
     * 
     * @param item
     * @return
     */
    boolean insert(E item);
    /**
     * 
     * @param item
     * @return
     */
    E delete(E item);
    /**
     * 
     * @param toElement
     * @param inclusive
     * @return
     */
    NavigableSet<E> headSet(E toElement,boolean inclusive);
    /**
     * 
     * @param fromElement
     * @param inclusive
     * @return
     */
    NavigableSet<E> tailSet(E fromElement,boolean inclusive);
}