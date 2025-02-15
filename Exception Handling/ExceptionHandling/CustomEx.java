class JD extends Exception{
	public JD(String str){
		super(str);
	}
}

public class CustomEx{
	public static void main(String args[]){

		int i=1;
		int j=0;

		try
		{
			j = 20/i;

			if(j == 20){
				throw new JD("custom message here!"); 
			}
		}
		catch(JD e){
			System.out.println("my custom exception! "+ e);
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