class A extends Thread{ //this is a thread, not ordinary class!
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println("Hi");
		}
	}
}

class B extends Thread{
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println("Hello");
		}
	}
}

public class ThreadsEx{
	public static void main(String args[]){
		A objA = new A();
		B objB = new B();

		// objA.show();
		// objB.show();

		//MAKE IT WORK PARALLELy
		//start is a method in thread class!

		//To initialize a thread, use 'start()'
		//Every class that extends Thread, must have 'run' method
		objA.start(); // start method checks for 'run' in that class and exec it!
		objB.start(); // start actually triggers thread to run 'run' method!

		//Internally we have a concept 'Scheduler'
		//"if you want to exec something, come to me first!"
		//if all threads cant exec at same time, then it will go for time scheduler!
		//based on allocated time for a thread, it will exec code!

		//EXTRA CODE! (to find tot number of threads the code uses and tot cores present in CPU)!
		// System.out.println(Thread.activeCount());
		// int cores = Runtime.getRuntime().availableProcessors();
        // System.out.println("Available Cores/Threads: " + cores);
	}
}