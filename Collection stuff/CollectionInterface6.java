//Comparator vs Comparable

import java.util.ArrayList;
import java.util.Collections;
// import java.util.Comparator;
import java.util.List;

//Without comparator and using 'Comparable'!
//We dont use comparator, we implement Comparable and func compareTo() (Mimic comparator here!)
class Student implements Comparable<Student>{
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

	public int compareTo(Student that){
		if(this.age > that.age){
			return 1;
		}
		else{
			return -1;
		}
	}
}

public class CollectionInterface6{
	public static void main(String args[]){

		// Comparator<Student> com3 = new Comparator<Student>(){

		// 	@Override
		// 	public int compare(Student s1,Student s2){
		// 		if(s1.age > s2.age){
		// 			return 1;
		// 		}
		// 		else{
		// 			return -1;
		// 		}
		// 	}
		// };

		// or

		//this is func interface! we can use lambda function
		// Comparator<Student> com3 = (Student s1,Student s2) -> {
		// 		return s1.age>s2.age? 1:-1;
		// };

		//or 

		//single line of code for comparator!
		// Comparator<Student> com3 = (s1, s2) -> return s1.age>s2.age? 1:-1;

		List<Student> students = new ArrayList<>();
		students.add(new Student(22,"Killer"));
		students.add(new Student(14,"JD"));
		students.add(new Student(35,"Rolex"));
		students.add(new Student(66,"Dhilli"));
		students.add(new Student(10,"perry"));

		//comparator is an interface
		//using comparator, we can implement custom sorting techniques!
		// Collections.sort(students,com3);

		//comparable
		//we mimic the functionality of comparator with 'comparable'!
		//since we implement Comparable in Student class, we dont need to pass comparator! (We actually dont need it).
		Collections.sort(students); // without comparator!

		for(Student s: students){
			System.out.println(s);
		}
	}
}