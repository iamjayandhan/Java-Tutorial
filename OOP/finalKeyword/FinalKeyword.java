class Method{
	final public void show(){ // final method cannot be overridden by child!
		System.out.println("I am inside Method");
	}
}

final class Method2 extends Method{ // final class cannot be inherited by any class
	//error : overridden method is final
	// public void show(){
	// 	System.out.println("I am inside Method2");
	// }
}

class Method3 extends Method2{
	//cannot extend/ inherit because method2 is final
	//we cant perform inheritance.

	//error: cannot inherit from final Method2
}

public class FinalKeyword{
	public static void main(String args[]){
		//final - varaible , method , class

		//FINAL VARIBLE
		//whenever we wish not to change a value of var, use final keyword
		final int num = 8;
		// num = 10; // error: cannot assign a value to final variable num
		System.out.println(num);

		//FINAL METHOD
		Method2 method2 = new Method2();
		method2.show();

		//FINAL CLASS
		//check Method3
	}
}