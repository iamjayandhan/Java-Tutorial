class A{
	public A(){

		//If the parent class also calls super(), it will try to call its own parent class constructor.
		//Ultimately, the chain leads to Object class, since every class in Java extends Object by default.

		super(); // every constructor has this line by default!
		System.out.println("I am inside A");
	}

	public A(int n){
		this();
		System.out.println("I am inside parameterized constructor A!");
	}
}

class B extends A{
	public B(){
		//implicit call
		super(5); // first this will be called to allocate mem for parent class
		System.out.println("I am inside B");
	}

	public B(int n){
		// super(5); //goes to parent class constructor
		this(); // will exec constructor of same class!
		System.out.println("I am inside parameterized constructor B!");
	}
}

class C{

}

public class ThisSuper{
	public static void main(String args[]){
		B obj = new B(5);
	}	
}
