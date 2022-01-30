
/**
 * implements HybridList functions
 */
public class HybridList<E> {
	
	private KWLinkedList<KWArrayList<E>> list;
	private int size;
	private static final int MAX = 5;

	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public HybridList() {
		list = new KWLinkedList<KWArrayList<E>>();
		list.addFirst(new KWArrayList<E>());
		size=0;	
	}
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}
	/**
	 * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * @param index index at which the specified element is to be inserted
	 * @param item element to be inserted
	 */
	public void add(int index, E item){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
  
        if(size%MAX == 0)
        	list.addLast(new KWArrayList<E>());
        
        for(int i = size-2; i > index; i--){
            KWArrayList<E> temp = list.get(i/MAX);
            if((i+1)%MAX == 0)
                temp = list.get((i+1)/MAX);
            temp.set((i+1)%MAX, temp.get((i+1)%MAX));
        }

        list.get(index/MAX).add(index%MAX, item);
        size++;
    }
	/**
	 * Sets the element at the specified position in this list.
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 */
	public E set(int index,E item) {
		E oldValue = get(index);
		list.get(index/MAX).set(index % MAX, item);
		return oldValue;
	}
	/**
	 * Returns the element at the specified position in this list.
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 */
	public E get(int index) {
		return list.get(index/MAX).get(index % MAX);
	}
	/**
	 * Appends the specified element to the head of this list.
	 * @param element to be appended to this list
	 */
	public void addFirst(E item) {
		add(0, item);
	}
	private boolean contains(E e) {
		for(int i=0;i<size;i++) {
			if(e.equals(get(i))) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Appends the specified element to the end of this list.
	 * @param element to be appended to this list
	 * @return if this collection changed as a result of the call
	 */
	public boolean add(E item) {
		if(contains(item)) {
			return false;
		}
		if(size % MAX == 0) {
			list.addLast(new KWArrayList<E>());	
		}
		list.get(size/MAX).add(size % MAX,item);

		size++;
		return true;
	}
	/**
	 * Returns the element at the first position in this list.
	 * @return the element at the first position in this list
	 */
	public E getFirst() {
		return list.getFirst().get(0);
	}
	/**
	 * Returns the element at the last position in this list.
	 * @return the element at the last position in this list
	 */
	public E getLast() {
		return list.getLast().get(list.getLast().size()-1);
	}
	/**
	 * Removes the first occurrence of object obj from the list. 
	 * @param obj - it is object which will be deleted.
	 * @return - true if the list contained object obj; otherwise, returns false
	 */
	public boolean remove(E obj) {
		int index = IndexOf(obj);
		if(index == -1)
			return false;
		remove(index);
		return true;
	}
	/**
	 * Removes the index occurrence of object obj from the list. 
	 * @param index - it is index which will be deleted.
	 */
	public void remove(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		for(int i=index;i<size-1;i++) {
			KWArrayList<E> temp = list.get(i/MAX);
            if((i)%MAX == -1)
                temp = list.get((i-1)/MAX);
			temp.set(i%MAX, temp.get((i+1)%MAX));
		}
		
		size--;
	
	}
	public int IndexOf(E obj) {
		for(int i=0;i<size;i++) {
			if(list.get(i/MAX).get(i%MAX).equals(obj)) {
				return i;
			}
		}
		return -1;
	}


}
