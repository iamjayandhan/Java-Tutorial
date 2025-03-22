import java.util.Arrays;
import java.util.Comparator;

public class StudentMain{
	public static void main(String args[]){
		Student JD = new Student(48,99);
		Student Killer = new Student(69,35);
		Student Dhilli = new Student(45,87);
		Student Vikram = new Student(44,98);
		Student Kunal = new Student(12,34);

		//to check sorting!
		Student arr[] = {JD,Killer,Dhilli, Vikram, Kunal};
		//before
		System.out.println(Arrays.toString(arr));

		// Arrays.sort(arr); // this sorting is based on marks obtained! but why? 

		//here compareTo must be overridden right?
		//we did it based on marks!
		//so sorting is also based on the marks of the students.
		//if we remove it, we get error! on what param of obj do i need to compare those?
		//to make sort() to take compareTo to perform sorting, we can pass a comparator for custom sorting of objects
		Arrays.sort(arr); // sorts arr based on marks
		//this sort uses comparator if available!
		System.out.println(Arrays.toString(arr));

		//directly right sort logic just like this!
		//do this directly! no need to implement Comparable!
		Arrays.sort(arr, new Comparator<Student>(){
			@Override
			public int compare(Student o1,Student o2){
				return (int)(o1.marks - o2.marks);
			}
		});
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