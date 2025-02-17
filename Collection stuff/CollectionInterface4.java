import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionInterface4{
	public static void main(String args[]){

		//after java1.7, Datatype can be declared on only left side!
		//previously it was mandatory to declare on both sides
		//CONCEPT OF GENERICS!
		List<Integer> nums = new ArrayList<>(); 

		nums.add(4);
		nums.add(3);
		nums.add(7);
		nums.add(9);

		// A utility class in java.util that provides static methods (e.g., sorting, searching, synchronization) for working with collections.
		Collections.sort(nums); // does this in-place!

		System.out.println(nums);
	}
}