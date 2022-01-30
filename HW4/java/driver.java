import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
public class driver {

	public static void main(String[] args) {
		
		int option;
		Scanner obj = new Scanner(System.in);
		
		System.out.println("1. Test heap\n2. Test BTSheap");
		option = obj.nextInt();
		if(option == 1) {
			testHeap();
		}
		else {
			testBTSHeap();
		}       
        
	}
	public static void testHeap() {
		MyHeap<Integer> minHeap = new MyHeap<Integer>();
		MyHeap<Integer> minHeap2 = new MyHeap<Integer>();

		Iterator<Integer> iter;
		minHeap2.insert(4);
		minHeap2.insert(5); 
		minHeap2.insert(6);
		minHeap2.insert(7);
		minHeap.insert(1);
		minHeap.insert(2); 
		minHeap.insert(3);
		System.out.println("Heap 1:");
		minHeap.print();
		System.out.println("Heap 2:");
		minHeap2.print();
		minHeap2.merge(minHeap);
		System.out.println("Heap 2 after merge:");
		minHeap2.print();
		
		System.out.println("Remove Heap 2 first element :" + minHeap2.remove());
		minHeap2.print();
		
		
		System.out.println("Remove 1. largest element" + minHeap2.removeLargest(1));
		
		iter = minHeap2.Iterator();
		while(iter.hasNext() != false)
			System.out.println(iter.next());

	}
	public static void testBTSHeap() {
		BSTHeapTree<Integer> tree = new BSTHeapTree<Integer>();
		int[] array = new int[3000];
		int i,a,random; 
		Random r=new Random(); 
		
		for(i=0;i<3000;i++) {
			a=r.nextInt(5000)+1;
			tree.add(a);
			array[i] = a;
			
		}
	    sort(array);
	    for(i=0;i<100;i++) {
	    	int temp = tree.find(array[i]); 
	    	if(temp == mode(array,array[i])) {
	    		System.out.println("it is true." + array[i] + " is found in tree."+ temp + " times");
	    	}
	    }
	    for(i=5001;i<5011;i++) {
	    	if(tree.find(i) == -1) {
	    		System.out.println("it is false. " + i + " is not found in tree!");
	    	}
	    }
	    
	    if(tree.find_mode() == largestMode(array))
	    	System.out.println("Tree mode is :" + tree.find_mode());
	    
	    for(i=0;i<100;i++) {
	    	 //tree.print();
	    	random=r.nextInt(2999);
	    	System.out.println( array[random]+  " is removed! " + tree.remove(array[random]) + " " + array[random] + " is left!");
	    	
	    }
		for(i=0;i<10;i++) {
	    	random=r.nextInt(5000)+50000;
	    	if(tree.remove(random) == -1)
	    		System.out.println( random+  " is  not removed! ");			
		}		
	}
	public static void sort(int[] arr) {
		 int n = arr.length;
	     for (int i = 0; i < n-1; i++)
	         for (int j = 0; j < n-i-1; j++)
	             if (arr[j] > arr[j+1]){
	                 int temp = arr[j];
	                 arr[j] = arr[j+1];
	                 arr[j+1] = temp;
	             }	
	}
	public static int mode(int[] arr,int value) {
		int n=arr.length;
		int mode=0;
		for(int i=0;i<n;i++) {
			if(arr[i] == value) {
				mode++;
			}
		}
		return mode;
	}
	public static int largestMode(int[] arr) {
		int n=arr.length;
		int l_mode = 0,returnedValue=0;
		for(int i=0;i<n;i++) {
			int temp = mode(arr,arr[i]);
			if(temp > l_mode) {
				l_mode = temp;
				returnedValue = arr[i];
			}
		}
		return returnedValue;
	}

}







