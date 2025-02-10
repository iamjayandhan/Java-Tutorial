//static block in java
//https://youtu.be/_7q4kMfJPDw?si=hwclbVtm1atyboA7

class Mobile{
	String brand;
	int price;
	static String name;

	//static block
	//runs only once for n object creations!

	//The static block executes even before object creation because static blocks run when the class is loaded into memory,
	//not when an instance (object) is created.
	//The static block runs only once when the class is first loaded.
	static{
		name = "Phone";
		System.out.println("In static block, i got executed!");
	}

	//constructor
	public Mobile(){
		brand = "";
		price = 200;
		System.out.println("In constructor...");
	}

	void show(){
		System.out.println(brand+" "+price+" "+name);
	}
}

public class StaticBlock2{
	public static void main(String args[]) throws ClassNotFoundException{

		//everytime we create obj, 2 steps are happening in background!
		//1. load class
		//2. obj is instantiated

		//when class load, static vars and methods are instantiated! (Happens only once!)
		
		// Mobile obj1 = new Mobile();
		// obj1.brand = "Samsung";
		// obj1.price = 500;

		// Mobile obj2 = new Mobile();
		// obj2.brand = "Apple";
		// obj2.price = 1700;

		// System.out.println(obj1.name);
		// System.out.println(obj2.name);

		//Thus
		//Static blocks execute when the class is loaded (only once).
		//Constructors execute every time an object is created.
		//Static variables (name) are shared across all objects.

		//if we dont create obj, then no class will be loaded and no static stuff will happen!
		//to manually load class without creating instance, use this:

		Class.forName("Mobile"); //manually load a class into class loader inside JVM!
		//when doing this, exception handling is must! ClassNotFoundException
	}
}