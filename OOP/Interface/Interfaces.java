// Interfaces in Java Don't Have Memory Allocated Like Objects

interface A{
	//public abstract - by default
	void show();

	//all variables in interface is final and static by default!
	// int a; // a static var must be declared a value for sure!
	int a = 10; // works! static and final by default!

	//to get this value, use interface name.var name
	//since these variables are static!
}

abstract class B{
	public abstract void show2();
}

//implement an interface?
class C implements A{
	public void show(){
		System.out.println("Implementing an interface A through seperate class C");
	}
}

//implement an abstract class?
//if this class does not implement all abstract func, then it becomes abstract class!
class D extends B{
	public void show2(){
		System.out.println("Implementing an abstract class B through seperate class D");
	}
}

public class Interfaces{
	public static void main(String args[]){

		//power and elegance of anonymous classes!

		A objA; //create ref for interface! works!
		objA = new A(){ // obj creation works only with inline class!
			public void show(){
				System.out.println("Interface A implementation for show using anonymous inline class!");
			}
		};
		objA.show();

		B objB; //create ref for abstract class! works!
		objB = new B(){ //obj creation works only with inline class!
			public void show2(){
				System.out.println("Abstract class B implementation for show2 using anonymous inline class!");
			}
		};
		objB.show2();

		C objC = new C();
		objC.show();

		D objD = new D();
		objD.show2();

		System.out.println(A.a); //interfaceName.varName
		// A.a = 11; //error: cannot assign a value to static final variable a
	}
}