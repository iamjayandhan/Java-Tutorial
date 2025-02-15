public class Exceptions{
	public static void main(String args[]){
		//Errors
		//1. Compile time
		//2. Runtime (prevent app from stopping exec by handling exceptions!)
		//3. Logical

		//Types of statement
		//1. Normal EX: int i = 10;
		//2. Critical EX: int j = 25/i; (i cannot be zero!, which can result in error!)

		int i=0;
		int j=0;

		try
		{
			//place all critical statements in try block
			//if error, it will exec catch block, else skips catch block!
			j = 20/i;
		}
		catch(Exception e) // errors are thrown as OBJ!
		{	
			System.out.println("Something went wrong");
		}

		System.out.println("Exec done!");
	}
}