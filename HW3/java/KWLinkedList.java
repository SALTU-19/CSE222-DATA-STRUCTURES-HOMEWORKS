import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Class KWLinkedList implements a double linked list and
 * a ListIterator.
 **/
public class KWLinkedList<E> {
	 /** A reference to the head of the list. */
	private Node<E> head;
	 /** A reference to the tail of the list. */
	private Node<E> tail;
    /** The size of the list. */
	private int size;
	public KWLinkedList() {
		head = null;
		tail = null;
		size = 0;
	
	}
	 /**
     * return size of the list
     */
	public int size() {
		return size;
	}
	private static class Node<E>{
		private E data;
		private Node<E> next;
		private Node<E> prev;
		private Node(E data) {
			this.data = data;
			next = null;
			prev = null;
		}
		private Node(E data,Node<E> ref) {
			this.data = data;
			next = ref;
		}
	}
	private class KWListIter implements ListIterator<E>{
		private Node<E> nextItem;
		private Node<E>	lastItemReturned;
		private int index;
		
		public KWListIter(int i) {
			if(i< 0 || i > size) {
				throw new IndexOutOfBoundsException(Integer.toString(index));
			}
			lastItemReturned = null;
			
			if(i == size) {
				index = size;
				nextItem=null;
			}
			else {
				nextItem = head;
				
				for(index=0;index<i;index++) {
					
					nextItem = nextItem.next;
				}
				
			}
		}

		@Override
		public boolean hasNext() {

			return nextItem != null;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}

		@Override
		public boolean hasPrevious() {
			return (size != 0 ||  nextItem.prev != null );
			
		}

		@Override
		public E previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(nextItem == null) {
				nextItem = tail;
			}
			else {
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}

		@Override
		public int nextIndex() {
			
			return index;
		}

		@Override
		public int previousIndex() {
			
			return index-1;
		}

		@Override
		public void remove() {
			if(head == null) {
				throw new IllegalStateException();
			}
			else if(nextItem == head) {
				head = nextItem.next;
				nextItem = nextItem.next;
				
				size--;
				index--;
			}
			else if(nextItem.next == null) {
				
				tail = nextItem.prev;
				nextItem = nextItem.prev;
				nextItem.next = null;
				size--;
				index--;
			}
			else {
				
				nextItem = nextItem.prev;
				nextItem.next = nextItem.next.next;
				size--;
				index--;
				
			}
			
		}

		@Override
		public void set(E e) {
			nextItem.prev.data = e;
			
		}

		@Override
		public void add(E e) {
			if(head == null) {
				Node<E> node = new Node<E>(e);
				head = node;
				tail = head;
				size++;
			}
			else if(nextItem == head) {
				Node<E> node = new Node<E>(e);
				node.next = nextItem;
				nextItem.prev = node;
				head = node;
				size++;
				index++;
			}
			else if(nextItem == null) {
				Node<E> node = new Node<E>(e);
				tail.next = node;
				node.prev = tail;
				tail = node;
				size++;
				index++;
			}
			else {
				Node<E> node = new Node<E>(e);
				node.prev = nextItem.prev;
				nextItem.prev.next = node;
				node.next = nextItem;
				nextItem.prev = node;
				size++;
				index++;
			}
			
			
		}
		 
	}
	/**
	 * Inserts object obj into the list at position index
	 * @param index - The position of the add operation
	 * @param obj - the item to be added
	 */
	public void add(int index, E obj) 
	{
		listIterator(index).add(obj);
	}
	/**
	 * Returns the item at position index
	 * @param index - The position of the item
	 * @return -the item at position index
	 */
	public E get(int index) {
		return listIterator(index).next();
	}
    /**
     * Insert an object at the beginning of the list.
     * @param item - the item to be added
     */
	public void addFirst(E item) {
		add(0, item);
	}
	   /**
     * Insert an object at the end of the list.
     * @param item - the item to be added
     */
	public void addLast(E item) {
		add(size, item);
	}
    /**
     * Get the first element in the list.
     * @return The first element in the list.
     */
	public E getFirst() {
		return head.data;
	}
    /**
     * Get the last element in the list.
     * @return The last element in the list.
     */
	public E getLast() {
		return tail.data;
	}
    /**
     * Return a ListIterator to the list
     * @return a ListItertor to the list
     */
	public KWListIter listIterator() {
		return new KWListIter(0);
	}
    /** Return a ListIterator that begins at index
     * @param index - The position the iteration is to begin
     * @return a ListIterator that begins at index
     */
	public KWListIter listIterator(int index) {
		return new KWListIter(index);
	}
	private int indexOf(E obj) {
		ListIterator<E> temp = listIterator(0);
		for(int i=0;i<size();i++) {
			if(temp.next().equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Removes the first occurrence of object obj from the list. 
	 * @param obj - it is object which will be deleted.
	 * @return - true if the list contained object obj; otherwise, returns false
	 */
	public boolean remove(E obj) {
		int index;
		index = indexOf(obj);
	
		if(index == -1) {
			return false;
		}
		
		listIterator(index).remove();
		return true;
	}


}
