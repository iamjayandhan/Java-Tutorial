public class Student implements Comparable<Student>{

	int rollNo;
	float marks;

	public Student(int rollNo, float marks){
		this.rollNo = rollNo;
		this.marks = marks;
	}

	@Override
	public String toString(){
		return "Student{"+
				"rollno="+ rollNo+
				", Marks="+marks+"}";
	}

	@Override
	public int compareTo(Student o){
		int diff = (int)(this.marks - o.marks);
		System.out.println("Inside compareTo method!");
		// if diff == 0: means both are equal
		// if diff < 1: means o is bigger, else o is smaller! 
		return diff;
	}
}