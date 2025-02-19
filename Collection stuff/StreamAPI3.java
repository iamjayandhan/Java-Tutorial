import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

//stream().filter() -> takes Predicate(So we hardcode them here!)
//stream().map() -> takes Function(So we hardcode them here!)
public class StreamAPI3{
	public static void main(String args[]){

		List<Integer> nums = Arrays.asList(5,3,6,9,2,4);

		//We use this for filter!
		//This is functional interface(We can also code it as lambda functions!)
		Predicate<Integer> p = new Predicate<Integer>(){

			//filter function logic implementation!
			//here we just have implemented a method!
			public boolean test(Integer n){
				// if(n%2 == 0)
				// 	return true;
				// else
				// 	return false;

				//SAME AS ".filter(n -> n%2==0)"
				return n%2 == 0;
			}
		};

		//We use this for map!
		//This is functional interface(We can also code it as lambda functions!)
		Function<Integer,Integer> fun = new Function<Integer,Integer>(){
			public Integer apply(Integer n){

				//SAME AS ".map(n -> n*2)"
				return n*2;
			}
		}; 


		//sum stream
		int sum = nums.stream()
			// .filter(n -> n%2==0)
			.filter(p) // filter() accepts predicate object! so we hardcode them and pass here! 
			// .map(n -> n*2)
			.map(fun) // map() accepts Function object! so we hard code them and pass here!
			.reduce(0,(c,e)->c+e); // here 0 -> initial value.

		System.out.println(sum);

		//sorted stream
		Stream<Integer> sortedStream = nums.parallelStream() // parallelStream also works, uses multiple threads to perform task
						//please avoid using parallelStream along with sorted() , since this takes all elements!
													.filter(p)
													.map(fun)
													.sorted();

        sortedStream.forEach(n -> System.out.print(n+" "));

        //To make multiple threads to work with filter, use parallelStream()

		//CONCLUSION (Custom implementations!)
        //1. forEach filter? Consumer Interface
        //2. Stream filter? Predicate Interface
        //3. Stream map? Function Interface
	}
}