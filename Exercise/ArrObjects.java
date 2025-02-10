class Student{
	String name;
	String rollNo;
	int marks;
}

public class ArrObjects{
	public static void main(String args[]){
		Student s1 = new Student();
		s1.name = "JD";
		s1.rollNo = "21CSA48";
		s1.marks = 98;

		Student s2 = new Student();
		s2.name = "Killer";
		s2.rollNo = "5713Q";
		s2.marks = 99;

		Student s3 = new Student();
		s3.name = "Rolex";
		s3.rollNo = "12345";
		s3.marks = 100;

		Student stuArr[] = new Student[3];
		stuArr[0] = s1;
		stuArr[1] = s2;
		stuArr[2] = s3;

		//list
		// for(Student obj : stuArr){
		// 	System.out.println(obj.name);
		// }

		for(int i=0;i<stuArr.length;i++){
			System.out.println(stuArr[i].name+" - "+stuArr[i].marks);
		}

		//for each
		for(Student obj: stuArr){
			System.out.println(obj.name+" - "+obj.marks);
		}

	}
}