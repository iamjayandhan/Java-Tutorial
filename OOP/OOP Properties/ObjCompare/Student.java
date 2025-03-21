//To compare two objects!
//we implement Comparable interface(generic interface)
//provide which object to compare! <here>

public class Student implements Comparable<Student>{

	int rollNo;
	float marks;

	public Student(int rollNo, float marks){
		this.rollNo = rollNo;
		this.marks = marks;
	}

	//simple print for toString() method!
	@Override
	public String toString(){
		return "Student{"+
				"rollno="+ rollNo+
				", Marks="+marks+"}";
	}

	//Comparable interface has compareTo method that must be overridden by the class that implements it.

	@Override
	public int compareTo(Student o){
		//'this' refers to the ref var of instance, 
		//'o' refers to the obj ref passed for comparison
		int diff = (int)(this.marks - o.marks);
		System.out.println("Inside compareTo method!");
		// if diff == 0: means both are equal
		// if diff < 1: means o is bigger, else o is smaller! 
		return diff;
	}
}