public class Exceptions2{
	public static void main(String args[]){

		int i=0;
		int j=0;

		int nums[] = new int[5];

		try
		{
			String str = null;
			System.out.println(str.length());

			j = 20/i;
			System.out.println(nums[0]);
			System.out.println(nums[200]);
		}
		catch(ArithmeticException e) //child
		{	
			System.out.println("Cannot divide by zero");
		}
		catch(ArrayIndexOutOfBoundsException e) //child
		{
			System.out.println("Stay in your limit!");
		}
		catch(Exception e)//parent that handles any exception!
		{
			System.out.println("Something went wrong! "+e);
		}

		System.out.println(j);
		System.out.println("Exec done!");
	}
}