@FunctionalInterface
interface A{

	void show(int i);
}

public class FuncInterface2{
	public static void main(String args[]){

		A objA = new A(){
			public void show(int i){
				System.out.println("Inside new show"+i);
			}
		};

		objA.show(5);
	}
}