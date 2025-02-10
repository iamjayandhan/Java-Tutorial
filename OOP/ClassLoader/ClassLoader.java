import java.lang.ClassLoader;

class A{
	public A(){

		//If the parent class also calls super(), it will try to call its own parent class constructor.
		//Ultimately, the chain leads to Object class, since every class in Java extends Object by default.

		super(); // every constructor has this line by default!
		System.out.println("I am inside A");
	}

	public A(int n){
		super();
		System.out.println("I am inside parameterized constructor A!");
	}
}

class B extends A{
	public B(){
		//implicit call
		super(); // first this will be called to allocate mem for parent class
		System.out.println("I am inside B");
	}

	public B(int n){
		super(5);
		System.out.println("I am inside parameterized constructor B!");
	}
}

class C{

}

public class ThisSuper{
	public static void main(String args[]){
		B obj = new B(5);

		// Get ClassLoader for A and B (only once)
	    ClassLoader classLoaderA = A.class.getClassLoader();
	    ClassLoader classLoaderB = B.class.getClassLoader();

	    //empty class, C which is not loaded!
	    ClassLoader classLoaderC = C.class.getClassLoader();

	    // Print ClassLoader details
	    System.out.println("\n--- ClassLoader Details ---");
	    System.out.println("ClassLoader of A: " + classLoaderA);
	    System.out.println("ClassLoader of B: " + classLoaderB);

	    System.out.println("ClassLoader of C: " + classLoaderC);
	}	
}
