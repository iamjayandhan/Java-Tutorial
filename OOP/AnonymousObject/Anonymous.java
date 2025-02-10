class A{
	public A(){
		System.out.println("object created");
	}

	public void show(){
		System.out.println("In A show");
	}
}

public class Anonymous{
	public static void main(String[] args) {
		// referenced object
		A obj = new A(); 
		obj.show();	

		// anonymous obj with no reference!
		// we cant use the same obj again! since there is no reference.
		new A(); 
		new A().show(); // this is possible!
	}
}