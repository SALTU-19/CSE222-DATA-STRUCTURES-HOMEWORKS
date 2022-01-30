import java.util.Arrays;

/**
 * implements KWArrayList functions
 */
public class KWArrayList<E> {
	private E[] data;
	private final static int INITIAL_CAPACITY = 10;
	private int size;
	private int capacity;
	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public KWArrayList() {
		capacity = INITIAL_CAPACITY;
		data = (E[]) new Object[capacity];
		size=0;
	}
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}
	
	private void reallocate() {
		capacity*=2;
		data = Arrays.copyOf(data, capacity);
	}
	/**
	 * Appends the specified element to the end of this list.
	 * @param element to be appended to this list
	 * @return if this collection changed as a result of the call
	 */
	public boolean add(E item) {
		if(size >= capacity) {
			reallocate();
		}
		data[size++] = item;
		return true;	
	}
	/**
	 * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * @param index index at which the specified element is to be inserted
	 * @param item element to be inserted
	 */
	public void add(int index,E item) {
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if(size >= capacity) {
			reallocate();
		}
		for(int i=size;i>index;i--) {
			data[i] = data[i-1];
		}
		data[index] = item;
		size++;
	}
	/**
	 * Returns the element at the specified position in this list.
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 */
	public E get(int index) {
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return data[index];
	}
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index index of the element to replace
	 * @param item element to be stored at the specified position
	 * @return the element previously at the specified position
	 */
	public E set(int index,E item) {
		if(index < 0 || index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = get(index);
		data[index] = item;
		return oldValue;
	}
	/**
	 * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
	 * @param index the index of the element to be removed
	 * @return the element that was removed from the list
	 */
	public E remove(int index) {
	
		if(index < 0 || index > size-1) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = get(index);
		for(int i=index;i<size;i++) {
			data[i] = data[i+1];
		}
		size--;
		return oldValue;
	}
	/**
	 * Removes the first occurrence of object obj from the list. 
	 * @param obj - it is object which will be deleted.
	 * @return - true if the list contained object obj; otherwise, returns false
	 */
	public boolean remove(E obj) {
		int i=indexOf(obj);
		if(i == -1) {
			return false;
		}
		remove(i);
		return true;
	}
	public int indexOf(E obj) {
		for(int i=0;i<size;i++) {
			if(obj.equals(get(i))) {
				return i;
			}
		}
		return -1;
	}
	
}
