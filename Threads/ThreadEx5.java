// Thread Safe
// only one thread can work on a thing at a time!
// Avoid instability and race conditions in code!

class Counter{
	int count=0;
	//synchronized - makes it to be called by one thread at a time!
	public synchronized void increment(){ // 'synchronized' makes only one thread access this method at a time!
		// This avoids race condition and makes desired output!
		count++; // read, increment, store in memory!
		//count  = count + 1; (get + update)!
	}
}

public class ThreadEx5{
	public static void main(String args[]){

		Counter c = new Counter();

		//Runnable Objects
		//Using Anonymous class!
		Runnable objA = new Runnable(){ // instantiate an Interface with anonymous class!
			public void run(){
				for(int i=1;i<=1000;i++){
					c.increment();
				}
			}
		}; 

		//Using Lambda Function (Works only for Functional Interface!)
		Runnable objB = () -> 
		{
			for(int i=1;i<=1000;i++){
				c.increment();
			}
		};

		//Create Threads manually
		Thread t1 = new Thread(objA); //NEW STATE
		Thread t2 = new Thread(objB); //NEW STATE

		//Trigger the Threads!
		t1.start(); //RUNNING(got cpu) & RUNNABLE(waiting for scheduler to get cpu)
		t2.start(); //RUNNING(got cpu) & RUNNABLE(waiting for scheduler to get cpu)

		//NOTE
		//Using sleep() or wait() on threads makes it to go WAITING STATE!
		//notify() -> waiting to runnable
		//stop() -> running/runnable to terminate

		//make a wait till both threads complete the task!
		//makes main thread to wait for t1,t2 threads!
		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e){
			System.out.println(e);
		}

		//all jobs are done, finally check value of count!
		System.out.println(c.count);
	}
}