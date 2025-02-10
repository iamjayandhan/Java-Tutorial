class A{
	public void show(){
		System.out.println("I am inside A");
	}
}

class B extends A{

	@Override
	public void show(){
		System.out.println("I am inside B");
	}
}

class C extends A{

	@Override
	public void show(){
		System.out.println("I am inside C");
	}
}

public class DMD{
	public static void main(String[] args) {

		//Dynamic Method Dispatch (DMD)!

		//Type(ref var) - Implementation(obj)
		//ref of child and obj of parent is not allowed!
		// B refB_objA = new A(); // this is not possible!
		// refB_objA.show();


		//valid
		//ref of super class and obj of subclass.
		A refA_objC = new C(); // this is fine!
		refA_objC.show();	

		//reuse, change only obj not ref! it behaves differently!
		refA_objC = new B();
		refA_objC.show();
	}
}