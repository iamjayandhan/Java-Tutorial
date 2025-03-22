//Thread priority and sleep!
//Thread class internally implements Runnable Interface
//Runnable Interface has the method 'run()'

//our class -> extends -> Thread class -> implements -> Runnable Interface!

class A extends Thread{ //this is a thread!
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println("Hi");
			try {
				Thread.sleep(10); //waiting stage! in milli seconds
			} 
			//sleeping thread sometimes waken up by another thread!
			//this causes exception!
			catch (InterruptedException e) { e.printStackTrace();}
		}
	}
}

class B extends Thread{
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println("Hello");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { e.printStackTrace();}
		}
	}
}

public class ThreadEx2{
	public static void main(String args[]){

		A objA = new A(); 
		B objB = new B();

		//check priority of thread
		//priority range(1-10)
		//least to highest
		//5 is default(normal priority)!

		System.out.println(objA.getPriority());
		System.out.println(objB.getPriority());

		//pass a suggestion to scheduler!
		//MIN_PRIORITY,MAX_PRIORITY_PRIORITY,NORM_PRIORITY
		objA.setPriority(Thread.MAX_PRIORITY);
		objB.setPriority(Thread.MAX_PRIORITY);
		
		//start the threads
		objA.start();

		try {
			Thread.sleep(2);
		} catch (InterruptedException e) { e.printStackTrace();}
		
		objB.start();
	}
}