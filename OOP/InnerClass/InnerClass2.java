class A{
	int age;

	public void show(){
		System.out.println("In show, class A");
	}

	class B{
		public void config(){
			System.out.println("In config, class B");
		}
	}

	static class C{
		public void config(){
			System.out.println("In config, static class C");
		}
	}
}

public class InnerClass2{
	public static void main(String args[]){
		A obj = new A();
		obj.show();

		// obj.B objB = new obj.B(); // not works
		// A.B objB = new A.B(); // not a proper syntax for creating obj
		// A.B objB = A.new B(); // not proper syntax

		A.B objB = obj.new B(); // non static , so use obj
		objB.config();

		A.C objC = new A.C(); // static class! use class name
		objC.config();
	}
}