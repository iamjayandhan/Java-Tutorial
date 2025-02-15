//Directly use Runnable Interface
//We avoid using Thread class, we manually create Threads here!
//Now a class can Inherit another class and implement an Runnable Interface for Thread behaviour!

class A implements Runnable{ 
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println("Hi");
			try {
				Thread.sleep(10); 
			} catch (InterruptedException e) { e.printStackTrace();}
		}
	}
}

class B implements Runnable{
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println("Hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { e.printStackTrace();}
		}
	}
}

public class ThreadEx3{
	public static void main(String args[]){

		//Runnable Objects
		Runnable objA = new A(); 
		Runnable objB = new B();

		//Create Threads manually
		Thread t1 = new Thread(objA); // Thread constructor accepts Runnable Obj! Pass them accordingly!
		Thread t2 = new Thread(objB);

		//Trigger the Threads!
		t1.start();
		t2.start();
	}
}