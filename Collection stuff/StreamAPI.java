import java.util.List;
// import java.util.ArrayList;
import java.util.Arrays;

//Different ways to print valeus of arraylist
public class StreamAPI{
	public static void main(String args[]){

		//new way to add elems to arraylist
		List<Integer> nums = Arrays.asList(4,6,8,3,2,5);

		//how to print all the values?

		//METHOD1
		// for(int i=0;i<nums.size();i++){
		// 	System.out.print(nums.get(i)+" ");
		// }
		// System.out.println();

		//METHOD2
		// for(int i: nums){
		// 	System.out.print(i+" ");
		// }
		// System.out.println();

		//METHOD3 (using foreach)
		nums.forEach(i -> System.out.print(i+" "));
	}
}