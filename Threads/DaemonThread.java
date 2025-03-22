class MyDaemon extends Thread{

    //assign thread a name!
    public MyDaemon(String name) {
        super(name);  // Set thread name
    }

    public void run(){
        while(true){
            System.out.println("Daemon Thread is running!");
            try {
                Thread.sleep(1000); //1sec
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DaemonThread {
    public static void main(String args[]){
        MyDaemon th = new MyDaemon("Wolverine"); //pass name of thread!

        th.setName("Wolverine"); // or directly like this! Set thread name!

        //we tell that thread is daemon,
        //daemon will stop once the main thread completes execution!
        //so no infinite loop

        //if this line is removed,then it is user thread,
        //JVM will run this thread infinitely since while(true) is there!
        //even main completes exec, user thread will run indefinitely.args

        //but incase of daemon, after 3 seconds , main will complete its execution and 
        //also stopping the execution of daemon thread! wow!

        //✅ JVM will exit if only daemon threads are running.
        //🚫 JVM will NOT exit if any user thread is still running.
        //If all user threads finish, JVM stops automatically.
        th.setDaemon(true);
        th.start();

        System.out.println("Main thread is running!");

        try {
            Thread.sleep(3000); //1sec
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " finishing, Daemon thread will exit.");
        System.out.println("Main thread finishing, Daemon thread will exit.");
    }
}
