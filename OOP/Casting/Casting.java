class A{
	public void show1(){
		System.out.println("In show A");	
	}

	public void common(){
		System.out.println("Common method in A");			
	}
}

class B extends A{
	public void show2(){
		System.out.println("In show B");	
	}

	@Override	
	public void common(){
		System.out.println("Common method in B");			
	}
}

public class Casting{
	public static void main(String args[]){
		//TYPE CASTING
		double d = 4.5;
		int i = (int)d; // Explicit casting
		System.out.println(i);	

		//CASTING IN OOP

		//1. TWO DIFFERENT METHODS

		//in both 1 & 2, object is child! (we compare two diff methods!)
		//1. upcasting
		//child is obj, ref is parent!
		A objA = (A) new B(); //make it parent ref
		objA.show1(); // works
		// objA.show2(); // A knows only show1, not show2! so error!

		//2. downcasting
		//here obj is child itself, we make ref from parent to child!
		//so we can access show2 in child!
		B objB = (B) objA;
		objB.show1(); // works
		objB.show2(); // works
		//here child ref and obj can access all!
		//but parent ref can access only parent stuff! not child!
		//if overridden, then parent ref can access child's overridden func

		//2. TWO SAME METHODS(OVERRIDDEN)

		//in both 1 & 2, object is child! (for overridden methods!)
		//1. upcasting
		//child is obj, ref is parent!
		A objAA = (A) new B(); //make it parent ref
		objAA.common(); // uses common method from child, parent ref knows that child has overridden method!

		//2. downcasting
		//here obj is child itself, we make ref from parent to child!
		//so we can access show2 in child!
		B objBB = (B) objAA;
		objBB.common(); // uses common method from child, child ref knows that child has overridden method!
		//if overridden, then parent ref can access child's overridden func

		//NOTE
		//we can never use a child ref to parent obj
		//always fails
		//either diff or overridden func!
		B objBA = new A();
		objBA.show1();
		objBA.show2();
		objBA.common();
	}
}