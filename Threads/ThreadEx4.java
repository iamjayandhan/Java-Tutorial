//same as prev file but using Anonymous class and Lambda functions
//Runnable is an functional Interface!
public class ThreadEx4{
	public static void main(String args[]){

		//Runnable Objects

		//Using Anonymous class!
		Runnable objA = new Runnable(){ // instantiate an Interface with anonymous class!
			public void run(){
				for(int i=1;i<=5;i++){
					System.out.println("Hi");
					try {
						Thread.sleep(10); 
					} catch (InterruptedException e) { e.printStackTrace();}
				}
			}
		}; 

		//Using Lambda Function (Works only for Functional Interface!)
		Runnable objB = () ->  // cool syntax for functional interface!
		//since FI only has one method...we can give body directly!
		{ // start of body
			for(int i=1;i<=5;i++){
				System.out.println("Hello");
				try {
					Thread.sleep(10); 
				} catch (InterruptedException e) { e.printStackTrace();}
			}
		}; //end of body!

		//Create Threads manually
		Thread t1 = new Thread(objA); // Thread constructor accepts Runnable Obj! Pass them accordingly!
		Thread t2 = new Thread(objB);

		//Trigger the Threads!
		t1.start();
		t2.start();
	}
}