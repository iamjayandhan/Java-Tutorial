abstract class Car{

	//abstract method!
	//if a method is abstract, then the class must be declared as abstract!
	public abstract void drive();

	// public abstract void fly(); // if not written body in another inherited class, then throws error!

	public void music(){
		System.out.println("Music started");
	}
}

class WagonR extends Car{ 
	public void drive(){
		System.out.println("Started Engine!");
	}
}


public class AbstractUsage{
	public static void main(String args[]){
		WagonR carObj = new WagonR();
		carObj.music();
		carObj.drive();

		//NOTE
		//if a class is declared abstract, then it is not a mandatory thing that the class
		//should have any abstract stuff! it can have both normal & abstract methods or no abstract method!

		//the class that implements all abstract methods is called concrete class, we can create obj for it!

		//we cannot create obj for abstract class! since there is no body(definition)
		// Car obj = new Car(); //fails
	}
}