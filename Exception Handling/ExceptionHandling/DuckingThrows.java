class JD extends Exception{
	public JD(String str){
		super(str);
	}
}

class SampleClass{
	static{
		System.out.println("I am inside a static block of SampleClass");
	}
}

public class DuckingThrows{
	//Main is called by JVM
	//Main asks JVM to handle that exception, but JVM simply terminates instead! SO DONT CARRY EXCEPTION ABOVE MAIN! HANDLE INSIDE MAIN ITSELF!
	// public static void main(String args[]) throws ArithmeticException{ //never do this!
	public static void main(String args[]){

		//handle exception!
		try{
			Class.forName("SampleClassUNKNOWN"); // dynamically loads the class in class loader, also exec any static stuffs in it!
			// suspiciousCode();
			// throw new JD("What the hell");
		}
		catch(ClassNotFoundException e){
			System.out.println("Class is missing! "+e);
			e.printStackTrace(); //printStackTrace() in Java prints the detailed stack trace of an exception to help debug errors by showing where the exception occurred and the method call sequence leading to it. 
		}
		catch (ArithmeticException e){
			System.out.println("Error occured: "+e);
		}
	}

	public static void suspiciousCode() throws ArithmeticException{ // this func is not responsible for handling exception! 
		//the calling func should handle "ArithmeticException"!
		System.out.println(2/0);
	}
}


//output
// java.lang.ClassNotFoundException: SampleClassUNKNOWN       //The exception type (ClassNotFoundException) and the missing class name (SampleClassUNKNOWN).
// 	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)     //1. 
// 	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)    //2.
// 	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:528) 				 //3. these 3 lines indicate that Java's ClassLoader tried to find and load the class but failed.
// 	at java.base/java.lang.Class.forName0(Native Method)    //1. 
// 	at java.base/java.lang.Class.forName(Class.java:462)	//2. 
// 	at java.base/java.lang.Class.forName(Class.java:453)`	//3. These lines show that the failure occurred inside Class.forName().
// 	at DuckingThrows.main(DuckingThrows.java:21)    //The exception occurred in your main method at line 21 of DuckingThrows.java

// Thus, The Java ClassLoader couldn't find it in the classpath.