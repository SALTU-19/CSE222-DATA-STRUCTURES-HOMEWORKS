import java.io.Serializable;
import java.util.Scanner;
/**
 * 
 * @author alien
 *
 * @param <E>
 */
public class BinaryTree<E> implements Serializable {

	protected Node<E> root;
	
	
	protected class Node<E> {
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}
		public String toString() {
			return data.toString();
		}
	}
	/**
	 * 
	 */
	public BinaryTree() {
		root = null;
	}
	protected BinaryTree(Node<E> root) {
		this.root = root;
	}
	/**
	 * 
	 * @param data
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(E data,BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		this.root = new Node<E>(data);
		if(leftTree != null) 
			root.left = leftTree.root;
		else
			root.left = null;
		if(rightTree != null)
			root.right = rightTree.root;
		else
			root.right = null;
		
	}
	/** Return the left subtree. 
	 @return The left subtree or null if either the root or
	 the left subtree is null 
	*/
	public BinaryTree<E> getLeftTree(){
		if(root != null && root.left != null)
			return new BinaryTree<E>(root.left);
		return null;
	}
	/** Return the right subtree. 
	 @return The right subtree or null if either the root or
	 the left subtree is null 
	*/
	public BinaryTree<E> getRightTree(){
		if(root != null && root.right != null)
			return new BinaryTree<E>(root.right);
		return null;
		
	}
	/**
	 * 
	 * @return data
	 */
	public E getData() {
		return root.data;
	}
	/** Determine whether this tree is a leaf.
	 @return true if the root has no children
	*/
	public boolean isLeaf() {
		return root.left == null && root.right == null;
	}
	/**
	 * tosting method
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
	private void preOrderTraverse(Node<E> node, int depth,StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append(" "); // indentation
		}
		if (node == null) {
			sb.append("null\n");
		} 
		else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	/** Method to read a binary tree.
	 pre: The input consists of a preorder traversal
	 of the binary tree. The line "null" indicates a null tree. 
	 @param scan the Scanner attached to the input file.
	 @return The binary tree
	*/
	public static BinaryTree<String> readBinaryTree(Scanner scan) {
		String data = scan.next();
		if (data.equals("null")) {
			return null;
		} 
		else {
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree,rightTree);
		}
	}
}