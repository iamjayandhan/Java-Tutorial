//Lambda func only works with functional interface!


@FunctionalInterface // annotation to help!
interface A{

	//we only have one method here!
	//public abstract by default
	void show();
}

// class B implements A{
// 	public void show(){
// 		System.out.println("In class show");
// 	}
// }

public class LambdaExp{
	public static void main(String args[]){
		// B objB = new B();
		// objB.show();

		//or 

		//anonymous class
		// A objA = new A(){  // a class that implements interface anonymously!
		// 	public void show(){
		// 		System.out.println("Inside new show");
		// 	}
		// };

		// objA.show();

		//convert anonymous class into lambda exp
		A objA = () -> 
			{ // since this works only in func Interface..compiler knows only one func is there, we can give body directly!
				System.out.println("In A show");
			};
		objA.show();
	}
}