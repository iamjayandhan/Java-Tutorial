import java.util.Map;
import java.util.HashMap;

public class CollectionInterface3{
	public static void main(String args[]){
		//Map does not extends Collection Interface!
		//Key-Value pairs
		//We can have any String or number in the place of index and map that to any value!

		Map<String,Integer> students = new HashMap<>();
		//HashTable vs HashMap?
		//HashMap - No synchronization
		//HashTable - Synchronization! (Thread safe version of HashMap)!

		//put() - try to add, if exists then replace value!
		students.put("JD", 99); 
		students.put("Rolex", 67); 
		students.put("Dhilli", 54); 
		students.put("Killer", 98); 
		students.put("Master", 88);
		students.put("JD", 0); //deuplicate keys will replaces values!

		//sequence is not followed!
		System.out.println(students); 
		System.out.println(students.get("JD")); 

		//get all the keys!
		System.out.println(students.keySet());

		//iterate to display forloop
		for(String name: students.keySet()){
			System.out.print(name+" ");
		} 

		//get all the values
		System.out.println("\n"+students.values());

		//iterate to display forloop
		for(int values: students.values()){
			System.out.print(values+" ");
		} 

		//both
		System.out.println("\n");
		for(String key: students.keySet()){
			System.out.println(key+":"+students.get(key));
		}

	}
}