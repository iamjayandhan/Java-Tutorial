//functional interface
@FunctionalInterface // annotation to help!
interface A{

	//we only have one method here!
	//public abstract by default
	void show();
}

class B implements A{
	public void show(){
		System.out.println("In class show");
	}
}

public class FuncInterface{
	public static void main(String args[]){
		B objB = new B();
		objB.show();

		//or 

		A objA = new A(){
			public void show(){
				System.out.println("Inside new show");
			}
		};

		objA.show();
	}
}