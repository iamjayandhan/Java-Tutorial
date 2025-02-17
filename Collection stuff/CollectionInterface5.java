import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	int age;
	String name;

	public Student(int age, String name){
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString(){
		return "Student [ age = "+age+" ,name = "+name+" ]";
	}
}

public class CollectionInterface5{
	public static void main(String args[]){

		//Comparator
		//Comparator is an interface!

		//Comparator for custom integer sorting!
		Comparator<Integer> com = new Comparator<Integer>(){
			
			@Override
			public int compare(Integer i, Integer j){ //Collections only works with wrapper classes! Not primitives.

				if(i%10 > j%10){
					return 1; //return 1 if numbers need to be swapped!
				}
				else{
					return -1; //no need to swap!
				}
			}
		};

		//Comparator for custom string sorting based on string length
		Comparator<String> com2 = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() > s2.length()){
					return 1;
				}
				else{
					return -1;
				}
			}		
		};

		//Comparator for Student object
		Comparator<Student> com3 = new Comparator<Student>(){

			@Override
			public int compare(Student s1,Student s2){
				if(s1.age > s2.age){
					return 1;
				}
				else{
					return -1;
				}
			}
		};

		List<Integer> nums = new ArrayList<>(); 
		nums.add(41);
		nums.add(33);
		nums.add(76);
		nums.add(98);

		List<String> strs = new ArrayList<>();
		strs.add("Jayandhan");
		strs.add("Rolex");
		strs.add("Dhilli");
		strs.add("Killer");
		strs.add("Wolverine");

		List<Student> students = new ArrayList<>();
		students.add(new Student(22,"Killer"));
		students.add(new Student(14,"JD"));
		students.add(new Student(35,"Rolex"));
		students.add(new Student(66,"Dhilli"));
		students.add(new Student(10,"perry"));

		//comparator is an interface
		//using comparator, we can implement custom sorting techniques!
		Collections.sort(nums, com);
		Collections.sort(strs,com2);
		Collections.sort(students,com3);

		System.out.println(nums);
		System.out.println(strs);

		for(Student s: students){
			System.out.println(s);
		}
	}
}