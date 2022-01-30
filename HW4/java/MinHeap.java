import java.util.ArrayList;
import java.util.Iterator;

public class MinHeap<E> {
	private ArrayList<E> array;
	
	
	public MinHeap() {
		array = new ArrayList<E>();
	}
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
	public boolean isLeaf(int index) {
		return hasRightChild(index) && hasLeftChild(index);
	}
	private void MinHeapify(int index) {

		if(isLeaf(index) && ((Comparable<E>) array.get(RightChild(index))).compareTo(array.get(LeftChild(index))) > 0) {
			if(hasLeftChild(index) && ((Comparable<E>) array.get(index)).compareTo(array.get(LeftChild(index))) > 0) {
				swap(index,LeftChild(index));
				MinHeapify(LeftChild(index));
			}
			else {
				return;
			}
		}
		else if(isLeaf(index) && ((Comparable<E>) array.get(RightChild(index))).compareTo(array.get(LeftChild(index))) < 0){
			if(hasRightChild(index) && ((Comparable<E>) array.get(index)).compareTo(array.get(RightChild(index))) > 0) {
				swap(index,RightChild(index));
				MinHeapify(RightChild(index));
			}
			else {
				return;
			}
		}
		else {
			if(hasLeftChild(index) && ((Comparable<E>) array.get(index)).compareTo(array.get(LeftChild(index))) > 0) {
				swap(index,LeftChild(index));
				MinHeapify(LeftChild(index));
			}
			else {
				return;
			}
			
		}
	}
	public void insert(E item) {
		array.add(item);
		
		int index = array.size()-1;
		while(((Comparable<E>) array.get(index)).compareTo(array.get(parent(index))) < 0) {
			swap(index,parent(index));
			index = parent(index);
		}	
	}
	public E remove() {
		if(array.isEmpty() == true){
			return null;
		}
		E temp = array.get(0);
		array.set(0,array.get(array.size()-1));
		array.remove(array.size()-1);
		MinHeapify(0);
		return temp;
	}
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
	public boolean search(E item) {
		for(int i=0;i<array.size();i++)
			if(array.get(i).equals(item))
				return true;
		return false;
				
	}
	public boolean merge(MinHeap other) {
		E temp = (E) other.remove();
		while(temp != null) {
			this.insert(temp);
			temp = (E) other.remove();
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
			return array.get(index++);
		}
	
	}
	public iter Iterator() {
		return new iter(0);
	}
	public void copyOf(MinHeap<E> other) {
		array.clear();
		merge(other);
	}
	public void removeLargest(int index) {
		MinHeap other = new MinHeap<>();
		E temp = (E) this.remove();
		E temp2 = array.get(array.size()-index);
		while(temp != null) {
			if(!temp.equals(temp2))
				other.insert(temp);
			temp = (E) this.remove();
		}
		this.copyOf(other);
		
	}
	

}
