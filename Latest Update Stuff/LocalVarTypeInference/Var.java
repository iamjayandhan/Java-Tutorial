import java.util.Arrays;

//var keyword is introduced in Java10 !
class Demo{
	public void show(){
		System.out.println("Inside show method!");
	}
}

public class Var{

	//error: 'var' is not allowed here
	// var variable = 10;

	public static void main(String args[]){
		//statically typed programming language!
		var i = 8; //type is assigned at compile time!
		int j = 8;
		// var obj = Arrays.asList(1,2,3);

		int c;

		//We must need a initializer for var variables, so that compiler knows which datatype to infer!
		// var d; //error: cannot infer type for local variable d
		//compiler checks to assign a datatype for this d, since it is unknown, it cant allocate memory and proceed further!
		//so it throws error at runtime as well as run time!

		//var is not reserved keyword, can be used as variable name!
		String var = "Jayandhan";
		System.out.println(var);

		//Declare array using var?
		var arr = new int[10]; // works! not needed to use '[]'.
		System.out.println(Arrays.toString(arr));

		//create obj with var reference?
		var obj = new Demo(); // works!
		obj.show();
	}
}