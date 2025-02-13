//1. Interface
interface A{
	void show1();
	void show2();
}

//2. Functional interface
@FunctionalInterface
interface B{
	void singleShow();
}

//3. Marker Interface
interface C{
	//no methods (Marker interface!)
}

public class Types{
	public static void main(String args[]){
		//1. Normal
		//2. Func Interface (or) SAM(Single Abstract Method)
		//3. Marker (A Marker Interface is an interface with no methods or fields. It is used to indicate that a class has a specific property or behavior.)
		// Marker - https://www.geeksforgeeks.org/marker-interface-java/
	}
}