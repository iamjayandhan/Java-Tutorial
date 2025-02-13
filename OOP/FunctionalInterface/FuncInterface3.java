@FunctionalInterface
interface A{

	int add(int i,int j);
}

public class FuncInterface3{
	public static void main(String args[]){

		A objA = new A(){
			public int add(int i,int j){
				System.out.println("Inside add func...");
				return i+j;
			}
		};

		System.out.println(objA.add(3,4));
	}
}