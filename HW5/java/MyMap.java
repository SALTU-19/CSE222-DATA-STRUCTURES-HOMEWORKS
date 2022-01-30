import java.util.NoSuchElementException;

/**
 * 
 * @author alien
 *
 * @param <K>
 * @param <V>
 */
public class MyMap<K, V> extends java.util.HashMap<K, V> {
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public MapIterator<K> iterator(K key){
		
		return new MapIterator<K>(key);
	}
	
	private class MapIterator<K>  implements MyIter<K>{
		private K lastItemReturned;
		private K nextValue;
		private int traveled;
		private int index;
		
		public MapIterator (K key){
			index=0;
			for(Object i: keySet()) {
				nextValue = (K)i;
				lastItemReturned = nextValue;
				if(key.equals(i)) {
					break;
				}
				index++;
			}
		}
		
		public K next() {
			if(!hasNext()) {
			
				throw new NoSuchElementException();
			}
				
			
			int count=0;
			lastItemReturned = nextValue;
			for(Object i: keySet()) {
				nextValue = (K)i;
				if(count == index+1) {
					break;
				}
				count++;
			}
			index = (index+1) % size();
			if(index == size() -1 )
				index = -1;
			traveled++;
			return lastItemReturned;
		}
		public K prev() {
			if(!hasPrev()) {
				throw new NoSuchElementException();
			}
			int count=0;
			lastItemReturned = nextValue;
			for(Object i: keySet()) {
				nextValue = (K)i;
				if(count == index-1)
					break;
				count++;
			}
			index--;
			return lastItemReturned;
		}
		public boolean hasNext() {
			
			if(traveled != size() ) {
				//traveled--;
				return true;
			}
				
			
			return false;
		}
		public boolean hasPrev() {

			if(index < 0)
				return false;
			
			return true;
		}

	}

}
