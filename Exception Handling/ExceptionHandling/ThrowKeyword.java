public class ThrowKeyword{
	public static void main(String args[]){

		int i=1;
		int j=0;

		try
		{
			j = 20/i;

			if(j == 20){
				//throw new ArithmeticException(); // no custom exception!
				throw new ArithmeticException("custom message here!"); //we create error!
			}
		}
		catch(ArithmeticException e)
		{	
			System.out.println("Cannot divide by zero " + e);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Stay in your limit!");
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong! "+e);
		}

		System.out.println(j);
		System.out.println("Exec done!");
	}
}