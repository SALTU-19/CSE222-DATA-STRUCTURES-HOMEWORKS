import java.util.Iterator;

public class BSTHeapTree<E> implements SearchTree<E>{
	
	private Node<E> root;
	private int findedIndex;
	private E largestMode;
	private int removedValue;
	public BSTHeapTree() {
		root = null;
	}
	/*
	 * 
	 * isleaf function
	 */
	public boolean isLeaf() {
		return root.left == null && root.right == null;
	}
	private static class Node<E> {
	    private MaxHeap<E> value;
	    private Node<E> left;
	    private Node<E> right;

	    private Node(MaxHeap<E> value) {
	        this.value = value;
	        right = null;
	        left = null;
	    }
	    
	}
	private Node<E> addNode(Node<E> node,E item){
		if(node == null) {
			node = new Node<E>(new MaxHeap<E>(7));
		}
		if(!node.value.insert(item)) {
			if(((Comparable<E>) item).compareTo(node.value.getRootValue()) < 0) {
				node.left = addNode(node.left,item);
			}
			else if(((Comparable<E>) item).compareTo(node.value.getRootValue()) > 0){
				node.right = addNode(node.right,item);
			}
		}

		return node;
	}
	private Node<E> removeNode(Node<E> node,E item){
		if(node == null) {
			removedValue = -1;
			return null;
		}
	
		removedValue = node.value.remove(item);
		if(node.value.size() == 0) {
			return null;
		//	node = null;
		}
		
		if(removedValue == -1) {
			if(((Comparable<E>) item).compareTo(node.value.getRootValue()) < 0) {
				node.left = removeNode(node.left,item);
			}
			else if(((Comparable<E>) item).compareTo(node.value.getRootValue()) > 0){
				node.right = removeNode(node.right,item);
			}			
		}
		else if(removedValue == 0) {
			if(node.left != null) {
				
				E temp = node.left.value.remove();
				if(temp != null)
					node.value.insert(temp);
		
			}
			else if(node.right != null) {
				E temp = node.right.value.removeLargest(node.right.value.size());
				if(temp != null)
					node.value.insert(temp);
				
			}
		}
		return node;
	}
	private Node<E> find(Node<E> node, E item){
		if(node == null) {
			
			return null;
		}
		findedIndex = node.value.search(item);

		if(findedIndex == -1) {
			E temp = node.value.getRootValue();
			if(temp != null) {
				if(((Comparable<E>) item).compareTo(temp) < 0) {
					node.left = find(node.left,item);
				}
				else if(((Comparable<E>) item).compareTo(temp) > 0){
					
					node.right = find(node.right,item);
				}
			}
			else {
				findedIndex = -1;
			}
		}
		else {
			findedIndex = node.value.getNumberOccurences(findedIndex);
		}
		
		return node;
	}
	@Override
	/**
	 * @param item removing item
	 * @return occurenes of item
	 */
	public int remove(E item) {
		root = removeNode(root,item);
		return removedValue;
	}
	
	@Override
	/**
	 * @param item adding item
	 * @return occrurens of item
	 */
	public int add (E item) {
		root = addNode(root,item);
		return 0;
	}
	@Override
	/**
	 * @param item
	 * @return occurens of  item
	 */
	public int find(E item) {
		Node<E> node = find(root,item);
		
		if(node == null)
			return -1;
		return findedIndex;
	}
	/**
	 * 
	 * @return mode of the bstheap
	 */
	public E find_mode () {
		largestMode = root.value.getRootValue();
		stroll(root);
		return largestMode;
	}

	private void stroll(Node<E> node) {
		if(node == null) return;
		Iterator<E> iter = node.value.Iterator();
		while(iter.hasNext() != false) {
			E temp = iter.next();
			if(find(temp) > find(largestMode)) {
				largestMode = temp;
			}
		}
		stroll(node.left);
		stroll(node.right);
		
	}
	private void print(Node<E> localRoot){
        if(localRoot == null)
            return;

        localRoot.value.print();
        System.out.println("---------------");
        print(localRoot.left);
        print(localRoot.right);

    }
	/**
	 * print bstheap
	 */
	public void print() {

		print(root);
	}
}
