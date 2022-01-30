import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author alien
 *
 * @param <E>
 */
public class NavigableSetwithAVLTree<E extends Comparable<E>> implements NavigableSet<E> {

	private AVLTree<E> tree;
	
	
	
	
	private class iter implements Iterator<E>{
		private ArrayList<E> list;
		private E nextItem;
		private int index;
		public iter() {
			list = new ArrayList<>();
			fill_list(tree);
			index=0;
		}

		private void fill_list(BinaryTree<E> node) {
			if(node == null) {
				return;
			}
			fill_list(node.getLeftSubtree());
			list.add(node.getData());
			fill_list(node.getRightSubtree());
			
			
		}
		@Override
		public boolean hasNext() {
			
			return index < list.size();
		}

		@Override
		public E next() {
			
			return list.get(index++);
		}

	}
	/**
	 * constructer
	 */
	public NavigableSetwithAVLTree() {
		tree = new AVLTree<E>();
		
	}
	@Override
	/**
	 * 
	 */
	public iter Iterator() {
		
		return new iter();
	}

	@Override
	/**
	 * @param item
	 */
	public boolean insert(E item) {
		boolean returned = tree.add(item);
		return returned;
	}

	@Override
	/**
	 * @param item
	 */
	public E delete(E item) {
		
		return tree.delete(item);
	}

	@Override
	/**
	 * 
	 */
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		NavigableSet<E> temp = new NavigableSetwithAVLTree<>();
		Iterator<E> iter;
		
		iter = Iterator();
		
		while(iter.hasNext() != false) {
			E item = iter.next();
			if(inclusive == true) {
				if(item.compareTo(toElement) ==  0) {
					temp.insert(item);
				}				
			}
			if(item.compareTo(toElement) < 0) {
				temp.insert(item);
			}
		}
		
		return temp;
	}

	@Override
	/**
	 * 
	 */
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		NavigableSet<E> temp = new NavigableSetwithAVLTree<>();
		Iterator<E> iter;
		
		iter = Iterator();
		
		while(iter.hasNext() != false) {
			E item = iter.next();
			if(inclusive == true) {
				if(item.compareTo(fromElement) ==  0) {
					temp.insert(item);
				}				
			}
			if(item.compareTo(fromElement) > 0) {
				temp.insert(item);
			}
		}
		
		return temp;
	}
	@Override
	/**
	 * 
	 */
	public java.util.Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
