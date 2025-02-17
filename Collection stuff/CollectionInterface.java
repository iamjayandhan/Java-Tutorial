import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class CollectionInterface{
	public static void main(String args[]){

		//Collection is Interface!
		//List,Queue,Set are also interfaces that extends Collection Interface!

		//List -> ArrayList, LinkedList
		//Queue -> DeQueue
		//Set -> HashSet, LinkedHashSet

		//Use Collection
		// Collection<Integer> nums = new ArrayList<Integer>(); //Data Type is important!

		//Use List, because it has get(to get value at index!)
		//List is an collection API that supports index value!
		List<Integer> nums = new ArrayList<Integer>();

		nums.add(6);
		nums.add(2);
		nums.add(5);
		nums.add(1); //all these are objects! not numbers!

		System.out.println(nums.get(1));

		for(int num:nums){
			System.out.print(num+" ");
		}
	}
}