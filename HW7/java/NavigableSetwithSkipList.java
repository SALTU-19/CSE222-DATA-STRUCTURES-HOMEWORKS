import java.util.ArrayList;
import java.util.Collections;


/**
 * 
 * @author alien
 *
 * @param <E>
 */
public class NavigableSetwithSkipList<E extends Comparable<E>> implements NavigableSet<E>{

	private SkipList<E> list;
	
	/**
	 * 
	 */
	public NavigableSetwithSkipList() {
		list = new SkipList<E>();
	}
	
	/**
	 * 
	 */
	@Override
	public java.util.Iterator<E> Iterator() {
		
		return list.iterator();
	}
	/**
	 * 
	 */
	@Override
	public java.util.Iterator<E> descendingIterator() {
		
		return new iter();
	}
	
	private class iter implements java.util.Iterator<E>{
		private ArrayList<E> tempList;
		private int index;
		
		public iter() {
			tempList = new ArrayList<>();
			java.util.Iterator<E> iter = list.iterator();
			
			while(iter.hasNext() != false) {
				tempList.add(iter.next());
			}
			
			Collections.sort(tempList, Collections.reverseOrder());
			index = 0;
		}
		@Override
		public boolean hasNext() {
			
			return index < tempList.size();
		}

		@Override
		public E next() {
			
			return tempList.get(index++);
		}
		
	}
	@Override
	/**
	 * 
	 */
	public boolean insert(E item) {
		list.add(item);
		return true;
	}

	@Override
	/**
	 * 
	 */
	public E delete(E item) {
		
		return list.remove(item);
	}

	@Override
	/**
	 * 
	 */
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
	
		return null;
	}

	@Override
	/**
	 * 
	 */
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
