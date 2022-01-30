



/**
 * implements Container functions
 */
public class container<E>  {
	/**
	 * that is array of ArrayList
	 */
	private E[] array;
	/**
	 * that is size of HashSet
	 */
	private int size = 0;
	/**
	 * that is constructor of HashSet
	 */
	public container() {
		this.size = 0;
	}
	/**
	 * Returns an iterator over the collection
	 */
	public E at(int index) throws ArrayIndexOutOfBoundsException
	{
	    if(index < 0 || index >= size())
	        throw new ArrayIndexOutOfBoundsException("Invalid index!");

	    return array[index];
	}

	@SuppressWarnings("unchecked")
	
	/**
	 * Ensures that this collection contains the specified element
	 */
	public boolean add(E e) {
	
		if(array == null) {
			array = (E[]) new  Object[size+1];
			size++;
			array[size-1] = e;
			return true;
		}
		if(this.contains(e)) {
			return false;
		}
		E[] temp = (E[]) new Object[size+1];
		for(int i=0;i<size;i++) {
			temp[i] = array[i];
		}
		temp[size] = e;
		array = temp;
		size++;
		return true;
	}
	@SuppressWarnings("unchecked")
	public boolean add(E e,int ignorme) {
		
		if(array == null) {
			array = (E[]) new  Object[size+1];
			size++;
			array[size-1] = e;
			return true;
		}
		E[] temp = (E[]) new Object[size+1];
		for(int i=0;i<size;i++) {
			temp[i] = array[i];
		}
		temp[size] = e;
		array = temp;
		size++;
		return true;
	}

	


	
	/**
	 *Removes all of the elements from this collection
	 */
	public void clear() throws Exception{
		if(this.isEmpty() == true) {
			throw new Exception("This list does not have an element!");
		}
		else {
			for(int i=0;i<size;i++) {
				array[i] = null;
			}
			size = 0;
		}
	}

	
	/**
	 * Returns true if this collection contains the specified element 
	 */
	public boolean contains(E e) {
		for(Object i:array) {
			if(e.equals(i)) {
				return true;
			}
		}
		return false;
	}



	
	/**
	 * Returns true if this collection contains no elements.
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")

	/**
	 *Removes a single instance of the specified element from this collection, if it is present 
	 */
	public boolean remove(E e)  {
		if(size == 1) {
			array[0] = null;
			array = null;
			size--;
			return true;
		}
		int counter=0;
		boolean flag = false;
		E[] temp = (E[]) new  Object[size-1];
		for(int i=0;i<size;i++) {
			if(counter+1 == size) {
				break;
			}
			if(!array[i].equals(e)) {
				temp[counter] = array[i];
				counter++;
			}
			else {
				flag = true;
			}
		}
		if(flag == true) {
			this.array = temp;
			size = counter;
		}

		return flag;
	}

	/**
	 *Returns the number of elements in this collection
	 */
	public int size() {
		
		return size;
	}
}

