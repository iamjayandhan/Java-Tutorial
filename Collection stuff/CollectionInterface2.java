// import java.util.Collection;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionInterface2{
	public static void main(String args[]){

		//Collection is Interface!
		//List,Queue,Set are also interfaces that extends Collection Interface!

		//List -> ArrayList, LinkedList
		//Queue -> DeQueue
		//Set -> HashSet, LinkedHashSet

		//Use Collection
		// Collection<Integer> nums = new ArrayList<Integer>(); //Data Type is important!

		//Set allows only unique values!
		//Set does not follow sequence!
		//Set does not support index value for accessing elements!

		//HashSet,TreeSet implements Set that extends Collection!
		// Collection<Interger> num = new HashSet<>(); or we can use Set as ref
		Set<Integer> nums = new HashSet<Integer>();
		Set<Integer> nums2 = new TreeSet<Integer>();

		//Random order - Normal Set
		nums.add(6);
		nums.add(2);
		nums.add(2);
		nums.add(5);
		nums.add(1); //all these are objects! not numbers!

		//Ascending order - Tree Set -> Extends AbstractSet(Class) & Implements NavigableSet(Interface) that extends SortedSet!
		nums2.add(6);
		nums2.add(2);
		nums2.add(2);
		nums2.add(5);
		nums2.add(1); 

		// for(int num:nums2){
		// 	System.out.print(num+" ");
		// }

		//Iterator?? (INTERATOR IS THE TOP MOST INTERFACE)
		Iterator<Integer> values = nums.iterator();

		while(values.hasNext()){
			System.out.println(values.next()); // gives one element! 
		}
	}
}