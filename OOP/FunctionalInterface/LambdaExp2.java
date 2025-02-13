@FunctionalInterface
interface A{

	void show(int i);
}

public class LambdaExp2{
	public static void main(String args[]){

		//anonymous and lambda class file will not be created!
		//but makes main class file heavy!

		A objA = (int i) -> // either i or int i (Both works!)
			{
				System.out.println("Inside new show"+i);
			};
		objA.show(5);

		//or 

		A objA2 = i -> System.out.println("Inside new show"+i);
		objA2.show(10);
		
	}
}