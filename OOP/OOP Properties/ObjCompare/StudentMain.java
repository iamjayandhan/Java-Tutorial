import java.util.Arrays;

public class StudentMain{
	public static void main(String args[]){
		Student JD = new Student(48,99);
		Student Killer = new Student(69,35);

		//to check sorting!
		Student arr[] = {JD,Killer};
		//before
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr); // this sorting is based on marks obtained! but why? 
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