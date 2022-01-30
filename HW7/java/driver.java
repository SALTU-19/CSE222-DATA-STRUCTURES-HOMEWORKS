import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class driver {

	public static void main(String[] args) {
		
		System.out.println("-----PART 1-----");
		part1();
		System.out.println("-----PART 2-----");
		part2();
		System.out.println("-----PART 3-----");
		part3();


	}
	public static void part1() {
		
		
		System.out.println("-----Define navigableset with avl tree-----");
		
		NavigableSetwithAVLTree<Integer> tree = new NavigableSetwithAVLTree<Integer>();
		NavigableSet tree2;
		Iterator<Integer> iter;
		
		System.out.println("-----Insert operation avl tree-----");
		System.out.println("----- 1 2 3 4 5 added-----");
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		
		System.out.println("-----Define iterator avl tree-----");
		iter = tree.Iterator();
		
		System.out.println("-----Testing Iterator-----");
		while(iter.hasNext() != false) {
			System.out.println(iter.next());
		}
		System.out.println("-----Testing HeadSet operation until 4-----");
		tree2 = tree.headSet(4, false);
		

		System.out.println();
		iter = tree2.Iterator();
		System.out.println("-----Printing HeadSet Tree-----");
		while(iter.hasNext() != false) {
			System.out.println(iter.next());
		}		
		

		System.out.println("-----Define navigableset with skiplist-----");
		
		NavigableSetwithSkipList<Integer> list = new NavigableSetwithSkipList<>();
		Iterator<Integer> iter2;  
		
		System.out.println("-----Insert operation skip list-----");
		System.out.println("----- 1 2 3 4 5 added-----");	
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		
		System.out.println("-----Delete operation skip list - delete 4 ");
		System.out.println(list.delete(4));
		
		System.out.println("-----Delete operation skip list - delete 100 ");
		System.out.println(list.delete(100));
		
		
		System.out.println("-----Define descending iterator skip list-----");
		iter2 = list.descendingIterator();
		System.out.println("-----Testing Iterator-----");		
		while(iter2.hasNext() != false) {
			System.out.println(iter2.next());
		}		
	}
	
	public static void part2() {
		
		
		System.out.println("-----Define AVL Tree-----");
		AVLTree<Integer> avl = new AVLTree<>();
		
		
		System.out.println("-----Insert elements AVL Tree-----");
		avl.add(1);
		avl.add(2);
		avl.add(3);
		avl.add(4);
		avl.add(5);
		
		System.out.println("-----Define BST Tree-----");
		BinarySearchTree<Integer> search = new BinarySearchTree<>();
		System.out.println("-----Insert elements BST Tree-----");
		search.add(1);
		search.add(2);
		search.add(3);
		search.add(4);
		search.add(5);
		
		System.out.println("Is avl tree is avl tree ? ");
		System.out.println(is_AVL(avl));
		System.out.println("Is BST tree is avl tree ? ");
		System.out.println(is_AVL(search));
	}
	
	public static boolean is_AVL(BinaryTree tree) {
		if(tree == null) {
			return true;
		}
		int value = maxDepth(tree.getLeftSubtree()) - maxDepth(tree.getRightSubtree());
		if((Math.abs(value) <= 1)  && is_AVL(tree.getRightSubtree())) {
			return true;
		}
		return false;
	}
    public static int maxDepth(BinaryTree tree)
    {
        if (tree == null)
            return 0;
        else
        {

            int lDepth = maxDepth(tree.getLeftSubtree());
            int rDepth = maxDepth(tree.getRightSubtree());
  

            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
	public static void part3() {

		long startTime; 
		long endTime;
		long estimatedTime;
		double average_bst = 0;
		double average_redBlack = 0;
		double average_twoSecond = 0;
		double average_skiplist = 0;
		double average_btree = 0;
		
		
	    System.out.println("---------------TEST WITH  SIZE (10000)-------------------");
		for(int i=0;i<10;i++) {
			BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
			RedBlackTree<Integer> redBlack = new RedBlackTree<>();
			TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>();
			SkipList<Integer> skipList = new SkipList<>();
			BTree<Integer> bTree = new BTree<>(5);
			List<Integer> range = IntStream.range(0, 10000).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);

			for(int j=0;j<10000;j++) {
				searchTree.add(range.get(j));
				redBlack.add(range.get(j));
				twoThreeTree.add(range.get(j));
				skipList.add(range.get(j));
				bTree.add(range.get(j));
			}
			range = IntStream.range(10000,10100).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				searchTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_bst += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				redBlack.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_redBlack += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				twoThreeTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_twoSecond += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				skipList.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_skiplist += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				bTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_btree += estimatedTime;
			
		}
		System.out.println("BST add operation with 10000 items time: " + average_bst/10);
		System.out.println("Red-Black Tree add operation with 10000 items time: " + average_redBlack/10);
		System.out.println("Two-Theree Tree add operation with 10000 items time: " + average_twoSecond/10);
		System.out.println("Skip-List add operation with 10000 items time: " + average_skiplist/10);
		System.out.println("B-tree add operation with 10000 items time: " + average_btree/10);
		average_bst = 0;
		average_redBlack = 0;
		average_twoSecond = 0;
		average_skiplist = 0;
		average_btree = 0;
	    System.out.println("---------------TEST WITH  SIZE (20000)-------------------");
		for(int i=0;i<10;i++) {
			BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
			RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>();
			TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>();
			SkipList<Integer> skipList = new SkipList<>();
			BTree<Integer> bTree = new BTree<>(5);
			List<Integer> range = IntStream.range(0, 20000).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);

			for(int j=0;j<20000;j++) {
				searchTree.add(range.get(j));
				redBlackTree.add(range.get(j));
				twoThreeTree.add(range.get(j));
				skipList.add(range.get(j));
				bTree.add(range.get(j));
			}
			range = IntStream.range(20000,20100).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				searchTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_bst += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				redBlackTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_redBlack += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				twoThreeTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_twoSecond += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				skipList.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_skiplist += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				bTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_btree += estimatedTime;
		}
		System.out.println("BST add operation with 20000 items time: " + average_bst/10);
		System.out.println("Red-Black Tree add operation with 20000 items time: " + average_redBlack/10);
		System.out.println("Two-Theree Tree add operation with 20000 items time: " + average_twoSecond/10);
		System.out.println("Skip-List add operation with 20000 items time: " + average_skiplist/10);
		System.out.println("B-tree add operation with 20000 items time: " + average_btree/10);
		average_bst = 0;
		average_redBlack = 0;
		average_twoSecond = 0;
		average_skiplist = 0;
		average_btree = 0;
	    System.out.println("---------------TEST WITH  SIZE (40000)-------------------");
		for(int i=0;i<10;i++) {
			BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
			RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
			TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>();
			SkipList<Integer> skipList = new SkipList<>();
			BTree<Integer> bTree = new BTree<>(5);
			List<Integer> range = IntStream.range(0, 40000).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);

			for(int j=0;j<40000;j++) {
				searchTree.add(range.get(j));
				redBlackTree.add(range.get(j));
				twoThreeTree.add(range.get(j));
				skipList.add(range.get(j));
				bTree.add(range.get(j));
			}
			range = IntStream.range(40000,40100).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				searchTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_bst += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				redBlackTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_redBlack += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				twoThreeTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_twoSecond += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				skipList.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_skiplist += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				bTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_btree += estimatedTime;
		}
		System.out.println("BST add operation with 40000 items time: " + average_bst/10);
		System.out.println("Red-Black Tree add operation with 40000 items time: " + average_redBlack/10);
		System.out.println("Two-Theree Tree add operation with 40000 items time: " + average_twoSecond/10);
		System.out.println("Skip-List add operation with 40000 items time: " + average_skiplist/10);
		System.out.println("B-tree add operation with 40000 items time: " + average_btree/10);
		average_bst = 0;
		average_redBlack = 0;
		average_twoSecond = 0;
		average_skiplist = 0;
		average_btree = 0;
	    System.out.println("---------------TEST WITH SIZE (80000)-------------------");
		for(int i=0;i<10;i++) {
			BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
			RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
			TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>();
			SkipList<Integer> skipList = new SkipList<>();
			BTree<Integer> bTree = new BTree<>(5);
			List<Integer> range = IntStream.range(0, 80000).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);

			for(int j=0;j<80000;j++) {
				searchTree.add(range.get(j));
				redBlackTree.add(range.get(j));
				twoThreeTree.add(range.get(j));
				skipList.add(range.get(j));
				bTree.add(range.get(j));
			}
			range = IntStream.range(80000,80100).boxed()
			        .collect(Collectors.toCollection(ArrayList::new));
			Collections.shuffle(range);
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				searchTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_bst += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				redBlackTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_redBlack += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				twoThreeTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_twoSecond += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				skipList.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_skiplist += estimatedTime;
			startTime = System.nanoTime(); 
			for(int k=0;k<100;k++) {
				bTree.add(range.get(k));
			}
			endTime = System.nanoTime();
			estimatedTime = endTime - startTime;
			average_btree += estimatedTime;
		}
		System.out.println("BST add operation with 80000 items time: " + average_bst/10);
		System.out.println("Red-Black Tree add operation with 80000 items time: " + average_redBlack/10);
		System.out.println("Two-Theree Tree add operation with 80000 items time: " + average_twoSecond/10);
		System.out.println("Skip-List add operation with 80000 items time: " + average_skiplist/10);
		System.out.println("B-tree add operation with 80000 items time: " + average_btree/10);
		average_bst = 0;
		average_redBlack = 0;
		average_twoSecond = 0;
		average_skiplist = 0;
		average_btree = 0;
	}

}
