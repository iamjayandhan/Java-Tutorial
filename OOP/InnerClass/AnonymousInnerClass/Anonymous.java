class A{
	public void show(){
		System.out.println("In A show");
	}
}

//override with a subclass
class B extends A{
	public void show(){
		System.out.println("In B show");
	}
}

public class Anonymous{
	public static void main(String args[]){

		A objA = new A();
		objA.show();

		//override a method in parent using subclass
		// B objB = new B();
		// objB.show();

		//override a method using anonymous class
		//An anonymous class in Java is useful when you need to override a method
		//of a class without explicitly creating a new subclass. It is beneficial in scenarios where:

		//1. You need a one-time modification of a class’s behavior.
		//2. You don’t want to create a separate named class just for a small change.
		//3. You need to override a method in a quick, inline manner.

		//create A ref, create A obj, but i will give the contents
		A objA2 = new A()
		{ // new implementation here!
			//no use of class keyword and class name! (ANONYMOUS CLASS)
			public void show(){ 
				System.out.println("In Anonymous show");
			}
		};
		objA2.show();

	}
}