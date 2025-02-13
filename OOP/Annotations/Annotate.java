class A{
	public void show(){
		System.out.println("In A show");
	}
}

class B extends A{

	//error : method does not override or implement a method from a supertype!
	@Override // we get alert with this sign! if this annotation is not present, then it uses parent's method and done.
	public void shows(){
		System.out.println("In B show");
	}
}

public class Annotate{
	public static void main(String args[]){
		//Annotations are suppliment to the compiler
		//interact with the compiler

		B objB = new B();
		objB.show();

	}
}