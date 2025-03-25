//Other methods:
//1. Callable + Future (Supports return value & Exception Handling)
//2. ExecutorService (does not!, same as that basic 4 ways)
//3. ScheduledExecutorService (does not!, same as that basic 4 ways)
//4. ForkJoinPool (Supports return value & Exception Handling)

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


//1.Callable
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception{
        System.out.println("Using class that implements callable Interface!");
        System.out.println("Thread Execution Started!");
        Thread.sleep(1000);
        return "Thread Execution complete!"; //we can return a string!
    }
}

//2. ExecutorService (that uses Thread pool)
class Task implements Runnable{

    //value can be assigned only once!
    private final int taskId;

    public Task(int id){    
        this.taskId = id;
    }

    @Override
    public void run(){
        System.out.println("Using ExecutorService for managing multiple threads!");
        System.err.println("Task-id:"+ taskId+" is running on the thread: "+Thread.currentThread().getName());

        try {
            Thread.sleep(5000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class WaysToImplement2 {
    public static void main(String args[]){
        //1. Callable -> uses ExecutorService + Future
        // Unlike Runnable, Callable allows returning a result and throwing checked exceptions.
        //Uses ExecutorService and Future to retrieve the result.

        //Advantage: Can return a result and handle exceptions.
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        Thread t = new Thread(futureTask);
        t.start();

        try {
            System.out.println("Result from callable: "+ futureTask.get()); //Blocks the main thread until call() completes.
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("\n");

        //2. ExecutorService -> uses Executors + FixedThreadPool
        //If you need multiple threads, manually managing them can be inefficient.
        //ExecutorService allows managing thread pools efficiently.
        
        //Advantage: Optimized for handling multiple tasks with a thread pool.
        ExecutorService executor = Executors.newFixedThreadPool(3); //creates a thread pool of 3 threads!

        //submits 13 tasks (Task instances).
        //Since only 3 threads exist, they execute tasks in a round-robin manner.
        for(int i=1;i<=13;i++){
            executor.execute(new Task(i));
        }

        //Gracefully shut down the ExecutorService.
        // executor.shutdown(); //Waits for running tasks to complete, no new tasks allowed.
        System.out.println("Shutting down executor...");
        executor.shutdown();//stops accepting new tasks but allows already submitted tasks to finish execution. (works)
        // executor.shutdownNow(); //This attempts to interrupt running tasks and stops execution immediately. (error: java.lang.InterruptedException)
        
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) { // waits up to 5 seconds for tasks to finish.
                System.out.println("Forcing shutdown...");
                executor.shutdownNow(); //force shutdown!
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }
}
