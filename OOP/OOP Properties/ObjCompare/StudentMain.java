import java.util.Arrays;

public class StudentMain{
	public static void main(String args[]){
		Student JD = new Student(48,99);
		Student Killer = new Student(69,35);

		//to check sorting!
		Student arr[] = {JD,Killer};
		//before
		System.out.println(Arrays.toString(arr));

		// Arrays.sort(arr); // this sorting is based on marks obtained! but why? 

		//here compareTo must be overridden right?
		//we did it based on marks!
		//so sorting is also based on the marks of the students.
		//if we remove it, we get error! on what param of obj do i need to compare those?
		//to make sort() to take compareTo to perform sorting, we can pass a comparator for custom sorting of objects
		Arrays.sort();

		System.out.println(Arrays.toString(arr));

		if(JD.compareTo(Killer) < 0){
			System.out.println(JD.compareTo(Killer));
			System.out.println("Killer has more marks!");
		}
		else{
			System.out.println(JD.compareTo(Killer));
			System.out.println("JD has more marks!");
		}
	}
}