import java.util.List;
import java.util.Arrays;

import java.util.function.Consumer;
import java.util.stream.Stream;

//to filter inside forEach loop, we used Consumer!
public class ForEach{
	public static void main(String args[]){

		List<Integer> nums = Arrays.asList(4,6,8,3,2,5);

		//Consumer is a functional interface!
		//method to implement - accept

		//We use Consumer for "Modifying Objects"
		Consumer<Integer> con = new Consumer<Integer>(){
			 public void accept(Integer n){
			 	System.out.println(n);
			 }
		}; 

		Consumer<Integer> con2 = (n) -> System.out.println(n);

		// NORMAL WAY (using directly)
		// nums.forEach(i -> System.out.print(i+" "));

		//ANOTHER WAY (Using Consumer obj)
		//forEach accepts Consumer object!
		nums.forEach(con2); //forEach gives you one value at a time!
		//Value given by forEach is then goes to thais 
	}
}