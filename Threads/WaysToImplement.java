//All these 4 methods does not return value or support exception handling!
//check part 2 of this same file for more info!

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Using Thread class!");
        System.out.println("Thread started!");
        System.out.println("Thread Ended!\n");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Using class that implements Runnable Interface + Thread class");
        System.out.println("Thread started!");
        System.out.println("Thread Ended!\n");
    }
}

public class WaysToImplement {
    public static void main(String[] args) {

        //Direct implementation for thread using custom class!
        //using Thread class
        MyThread t = new MyThread();
        t.start();

        //Whenever we use runnable , we need to create seperate instance for Thread.
        //using Runnable Interface(Anonymous class) + Thread class
        Runnable tRun = new Runnable() {
            @Override 
            public void run(){
                System.out.println("Using Runnable Interface(Anonymous class) + Thread class!");
                System.out.println("Thread started!");
                System.out.println("Thread Ended!\n");
            }
        };

        Thread t2 = new Thread(tRun);
        t2.start();

        //Whenever we use runnable , we need to create seperate instance for Thread.
        //using Class that implements Runnable interface + Thread class
        Thread t3 = new Thread(new MyRunnable());
        t3.start();  

        //using lambda expressions to create threads
        //if using lambda expressions(This can be only used for functionalInterface!)
        //Functional Interface -> Interface that contains only one method
        Runnable tRun2 = () -> { //we know that this Runnable has only run() method to override! (So we can use lambda here!)
            System.out.println("Using Lambda Expressions to implement Runnable Interface + Thread class");
            System.out.println("Thread Started!");
            System.out.println("Thread Ended!\n");
        };
        Thread t4 = new Thread(tRun2);
        t4.start();
    }
}
