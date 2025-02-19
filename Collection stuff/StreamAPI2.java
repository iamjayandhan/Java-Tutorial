import java.util.List;
import java.util.Arrays;

import java.util.stream.Stream;

//Stream!
//Stream makes your work easy by providing with functions!
public class StreamAPI2{
	public static void main(String args[]){

		//new way to add elems to arraylist
		List<Integer> nums = Arrays.asList(4,6,8,3,2,5);

		Stream<Integer> s1 = nums.stream(); // this s1 can be used only once!
		// System.out.println(s1);			

		//apply filter methods for stream! 
		//note that stream returns stream obj!
		// Stream<Integer> s2 = s1.filter(n -> n%2==0); // filter expects boolean!
		// Stream<Integer> s3 = s2.map(n -> n*2); // map is used to perform operation!
		// int res = s3.reduce(0,(c,e)->c+e);

		//in one line!
		int res = nums.stream()
					  .filter(n -> n%2 == 0)
					  .map(n -> n*2)
					  .reduce(0,(c,e)-> c+e);

		System.out.println(res);

		//METHOD3 (using foreach)
		// s3.forEach(i -> System.out.print(i+" ")); //works!

		//Error: stream has already been operated upon or closed
		// s1.forEach(i -> System.out.print(i+" ")); //cannot reuse the same stream!
	}
}