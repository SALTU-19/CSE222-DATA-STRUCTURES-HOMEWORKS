import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class MaxHeap<E> {
	private ArrayList<Datas<E>> array;
	private int maxNumber;
	/**
	 * constructer
	 */
	public MaxHeap() {
		array = new ArrayList<Datas<E>>();
		maxNumber=-1;
	}
	/**
	 * constructer
	 * @param max 
	 */
	public MaxHeap(int max) {
		array = new ArrayList<Datas<E>>();
		maxNumber=max;		
	}
	/**
	 * 
	 * @return size
	 */
	public int size() {
		return array.size();
	}
	private int parent(int index) {
		return (index-1)/2;
	}
	private int LeftChild(int index) {
		return index*2 +1;
	}
	private boolean hasLeftChild(int index) {
		return index*2 +1 < array.size();
	}
	private int RightChild(int index) {
		return index*2 +2;
	}
	private boolean hasRightChild(int index) {
		return index*2 +2 < array.size();
	}
	private void swap(int index,int index2) {
		Datas<E> temp = array.get(index);
		array.set(index, array.get(index2));
		array.set(index2, temp);
	}
	/**
	 * 
	 * @param index which index
	 * @return true or false
	 */
	public boolean isLeaf(int index) {
		return !(hasRightChild(index) && hasLeftChild(index));
	}
	@SuppressWarnings("unchecked")
	private void MaxHeapify(int index) {

		if(!isLeaf(index) && ((Comparable<E>) array.get(RightChild(index)).getItem()).compareTo(array.get(LeftChild(index)).getItem()) < 0) {
			if(hasLeftChild(index) && ((Comparable<E>) array.get(index).getItem()).compareTo(array.get(LeftChild(index)).getItem()) < 0) {
				swap(index,LeftChild(index));
				MaxHeapify(LeftChild(index));
			}
			else {
				return;
			}
		}
		else if(!isLeaf(index) && ((Comparable<E>) array.get(RightChild(index)).getItem()).compareTo(array.get(LeftChild(index)).getItem()) > 0){
			if(hasRightChild(index) && ((Comparable<E>) array.get(index).getItem()).compareTo(array.get(RightChild(index)).getItem()) < 0) {
				swap(index,RightChild(index));
				MaxHeapify(RightChild(index));
			}
			else {
				return;
			}
		}
		else {
			if(hasLeftChild(index) && ((Comparable<E>) array.get(index).getItem()).compareTo(array.get(LeftChild(index)).getItem()) < 0) {
				swap(index,LeftChild(index));
				MaxHeapify(LeftChild(index));
			}
			else {
				return;
			}
			
		}
	}
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param item inserting item
	 * @return true or false
	 */
	public boolean insert(E item) {
		int i= search(item);
		if(i!= -1) {
			
			array.get(i).increase();
			return true;
		}
		if(array.size()  == maxNumber) {
			
			return false;
		}
		array.add(new Datas<E>(item));
		
		int index = array.size()-1;
		while(((Comparable<E>) array.get(index).getItem()).compareTo(array.get(parent(index)).getItem()) > 0) {
			swap(index,parent(index));
			index = parent(index);
		}	
		return true;
	}
	/**
	 * 
	 * @return remove 0. element
	 */
	public E remove() {
		if(array.isEmpty() == true){
			return null;
		}

		Datas<E> temp = array.get(0);
		array.set(0,array.get(array.size()-1));
		array.remove(array.size()-1);
		MaxHeapify(0);
		return temp.getItem();
	}
	/**
	 * print
	 */
	public void print(){
		for (int i = 0; i <= (array.size()-2) / 2; i++) {
			System.out.print(" PARENT : " + array.get(i).getItem() + "," + array.get(i).getCount());
			if(hasLeftChild(i))
				System.out.print( " LEFT CHILD : " + array.get(LeftChild(i)).getItem() + "," + array.get(LeftChild(i)).getCount());
			if(hasRightChild(i))
				System.out.print(" RIGHT CHILD :" + array.get(RightChild(i)).getItem() + "," + array.get(RightChild(i)).getCount());
	        System.out.println();
		}
	}
	/**
	 * 
	 * @param item
	 * @return
	 */
	public int search(E item) {
		for(int i=0;i<array.size();i++)
			if(array.get(i).getItem().equals(item))
				return i;
		return -1;
				
	}
	/**
	 * 
	 * @param other
	 * @return
	 */
	public boolean merge(MaxHeap<E> other) {
		Iterator<E> iter = other.Iterator();
		
		while(iter.hasNext() != false) {
			this.insert(iter.next());
		}
		
		return true;
	}
	private class iter implements Iterator<E>{
		int index;
		public iter(int index) {
			this.index = index;
		}
		@Override
		public boolean hasNext() {
			
			return index < array.size();
		}
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return array.get(index++).getItem();
		}
	
	
	}
	/**
	 * 
	 * @return iterator
	 */
	public iter Iterator() {
		return new iter(0);
	}
	public void copyOf(MaxHeap<E> other) {
		array.clear();
		merge(other);
	}
	/**
	 * 
	 * @param index removing largest eleent value
	 * @return largest i. element
	 */
	public E removeLargest(int index) {
		
		E returnedValue = null;
	
		MaxHeap<E> other = new MaxHeap<E>();
		E temp = (E) this.remove();
		int count=0;
		while(temp != null) {
			if(count != index-1) {
				other.insert(temp);
			}
			else {
				returnedValue = temp;
			}
			temp = (E) this.remove();
			count++;
		}
		
		this.copyOf(other);
		return returnedValue;
		
	}
	/**
	 * 
	 * @return get 0. element
	 */
	public E getRootValue() {
		if(array.size() > 0)
			return array.get(0).getItem();
		return null;
	}
	/**
	 * 
	 * @param index which index
	 * @return get frequnces of index
	 */
	public int getNumberOccurences(int index) {
		return array.get(index).getCount();
	}

	/**
	 * 
	 * @param item removing item
	 * @return element 
	 */
	public int remove(E item) {
		
		int index = search(item);
		if(index == -1) {
			return -1;
		}
		if(getNumberOccurences(index) == 1) {
			array.remove(index);
			MaxHeapify(0);	
			return 0;
		}
		array.get(index).decrease();
		
		return getNumberOccurences(index);
		
	
	}
	

}
