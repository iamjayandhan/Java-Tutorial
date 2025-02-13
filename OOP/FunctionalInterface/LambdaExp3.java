@FunctionalInterface
interface A{

	int add(int a,int b);
}

public class LambdaExp3{
	public static void main(String args[]){

		A objA = (int a,int b) -> // either i or int i (Both works!)
			{
				System.out.println("Inside add func");
				return a+b;
			};
		System.out.println(objA.add(2,3));

		//or 

		// A objA2 = (a,b) -> return a+b; // fails, if only one exp, default it is returned after evaluation!
		A objA2 = (a,b) -> a+b;
		System.out.println(objA2.add(4,5));
		
	}
}