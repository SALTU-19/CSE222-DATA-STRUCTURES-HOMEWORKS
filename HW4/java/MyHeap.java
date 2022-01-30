import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.javadoc.ThrowsTag;

public class MyHeap<E> {
	private ArrayList<E> array;
	private int maxNumber;
	/**
	 * constructer
	 */
	public MyHeap() {
		array = new ArrayList<E>();
		maxNumber=-1;
	}
	/**
	 * constructer with maxumum value
	 * @param max
	 */
	public MyHeap(int max) {
		array = new ArrayList<E>();
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
		E temp = array.get(index);
		array.set(index, array.get(index2));
		array.set(index2, temp);
	}
	/**
	 * 
	 * @param index which index
	 * @return true isleaf
	 */
	public boolean isLeaf(int index) {
		return !(hasRightChild(index) && hasLeftChild(index));
	}
	
	@SuppressWarnings("unchecked")
	private void MaxHeapify(int index) {

		if(!isLeaf(index) && ((Comparable<E>) array.get(RightChild(index))).compareTo(array.get(LeftChild(index))) < 0) {
			if(hasLeftChild(index) && ((Comparable<E>) array.get(index)).compareTo(array.get(LeftChild(index))) < 0) {
				swap(index,LeftChild(index));
				MaxHeapify(LeftChild(index));
			}
			else {
				return;
			}
		}
		else if(!isLeaf(index) && ((Comparable<E>) array.get(RightChild(index))).compareTo(array.get(LeftChild(index))) > 0){
			if(hasRightChild(index) && ((Comparable<E>) array.get(index)).compareTo(array.get(RightChild(index))) < 0) {
				swap(index,RightChild(index));
				MaxHeapify(RightChild(index));
			}
			else {
				return;
			}
		}
		else {
			if(hasLeftChild(index) && ((Comparable<E>) array.get(index)).compareTo(array.get(LeftChild(index))) < 0) {
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
	 * @return true of false
	 */
	public boolean insert(E item) {
		
		if(array.size()  == maxNumber) {
			return false;
		}
		if(search(item) == true) {
			return false;
		}
		array.add(item);
		
		int index = array.size()-1;
		while(((Comparable<E>) array.get(index)).compareTo(array.get(parent(index))) > 0) {
			swap(index,parent(index));
			index = parent(index);
		}	
		return true;
	}
	/**
	 * 
	 * @return removing element
	 */
	public E remove() {
		if(array.isEmpty() == true){
			return null;
		}
		E temp = array.get(0);
		array.set(0,array.get(array.size()-1));
		array.remove(array.size()-1);
		MaxHeapify(0);
		return temp;
	}
	/**
	 * print heap
	 */
	public void print(){
		for (int i = 0; i <= (array.size()-2) / 2; i++) {
			System.out.print(" PARENT : " + array.get(i));
			if(hasLeftChild(i))
				System.out.print( " LEFT CHILD : " + array.get(LeftChild(i)));
			if(hasRightChild(i))
				System.out.print(" RIGHT CHILD :" + array.get(RightChild(i)));
	        System.out.println();
		}
	}
	/**
	 * 
	 * @param item searching item
	 * @return true or false
	 */
	public boolean search(E item) {
		for(int i=0;i<array.size();i++)
			if(array.get(i).equals(item))
				return true;
		return false;
				
	}
	/**
	 * 
	 * @param other merging value 
	 * @return true or false
	 */
	public boolean merge(MyHeap<E> other) {
	
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
			return array.get(index++);
		}
		public void set(E e) {
			array.set(index, e);
		}
	
	}
	/**
	 * 
	 * @return iterator
	 */
	public iter Iterator() {
		return new iter(0);
	}
	/**
	 * 
	 * @param other copy of other 
	 */
	public void copyOf(MyHeap<E> other) {
		array.clear();
		merge(other);
	}
	/**
	 * s
	 * @param index index of
	 * @return largesttelement 
	 */
	public E removeLargest(int index) {
		
		E returnedValue = null;
	
		MyHeap<E> other = new MyHeap<E>();
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
		return array.get(0);
	}

	

}
