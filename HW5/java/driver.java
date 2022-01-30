import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		
		 
		 System.out.println("1.Test iterator(part 1)\n2. Test hashtables");
		int option;
		Scanner obj = new Scanner(System.in);
		option = obj.nextInt();
		if(option == 1) {
			testIterator();
		}
		else {
			testHashTables();
		}  
		 
		 

		 
	   
	    
	    
	}
	public static void testIterator() {
		
		
		System.out.println("HashMap is created!");
		MyMap<String, String> capitalCities = new MyMap<String, String>();
		
		MyIter<String> iter;

		capitalCities.put("Turkey","Ankara");
		capitalCities.put("Italy","Rome");
		capitalCities.put("France","Paris");
		capitalCities.put("Germany","Berlin");
		capitalCities.put("England","London");
		
		for(Object i :capitalCities.keySet())
			System.out.println(i + " , " + capitalCities.get(i));
		
		System.out.println("Iterator is created from Turkey! ");
		iter = capitalCities.iterator("Turkey");

		
		while(iter.hasNext() != false) {
			
			System.out.println(iter.next());
		}
		System.out.println("Iterator is created from Italy! ");
		iter = capitalCities.iterator("Italy");

		
		while(iter.hasNext() != false) {
			
			System.out.println(iter.next());
		}
			
		

	}
	public static void testHashTables() {
		
		 int SMALL=10;
		 int MEDIUM=100;
		 int LARGE=1000; 
		 HashtableOpen<Integer, Integer> numbers = new HashtableOpen<Integer, Integer>(); //  Coalesced hashing technique.
		 HashtableChain<Integer, Integer> numbers2 = new HashtableChain<Integer, Integer>(); //  hash table chain with linked list.
		 MyHashtableChain<Integer, Integer> numbers3 = new MyHashtableChain<Integer, Integer>(); //  hash table chain with tree set.
		 long startTime; 
		 long endTime;
		 long estimatedTime; 

		 
		 
		 
		 
		 
	     System.out.println("---------------TEST WITH SMALL SIZE-------------------");
	    
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table PUT operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers2.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list PUT operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < SMALL; i++) {
			 numbers3.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set PUT operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table GET operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers2.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list GET operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < SMALL; i++) {
			 numbers3.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set GET operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table REMOVE operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers2.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list REMOVE operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < SMALL; i++) {
			 numbers3.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set REMOVE operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers2.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < SMALL; i++) {
			 numbers3.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < SMALL; i++) {
			 numbers2.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < SMALL; i++) {
			 numbers3.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);
		 
	     System.out.println("---------------TEST WITH MEDIUM SIZE-------------------");
		    
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table PUT operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers2.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list PUT operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers3.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set PUT operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table GET operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers2.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list GET operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers3.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set GET operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table REMOVE operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers2.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list REMOVE operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers3.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set REMOVE operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers2.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers3.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers2.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < MEDIUM; i++) {
			 numbers3.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);

	     System.out.println("---------------TEST WITH LARGE SIZE-------------------");
		    
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table PUT operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers2.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list PUT operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < LARGE; i++) {
			 numbers3.put(i, i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set PUT operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table GET operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers2.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list GET operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < LARGE; i++) {
			 numbers3.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set GET operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table REMOVE operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers2.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list REMOVE operation time :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < LARGE; i++) {
			 numbers3.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set REMOVE operation time :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers2.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < LARGE; i++) {
			 numbers3.remove(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set REMOVE operation time with non existing elements:");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Coalesced Hash Table GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);
		 startTime = System.nanoTime(); 
		 for (int i = 0; i < LARGE; i++) {
			 numbers2.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 startTime = System.nanoTime();
		 System.out.println("Hash Table Chain with linked list GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);
		 for (int i = 0; i < LARGE; i++) {
			 numbers3.get(i);
		 }
		 endTime = System.nanoTime();
		 estimatedTime = endTime - startTime;
		 System.out.println("Hash Table Chain with tree set GET operation time  with non existing elements :");
		 System.out.println(estimatedTime);		 


		 
		
		 		
	}

}
