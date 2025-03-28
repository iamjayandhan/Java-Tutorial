import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WaysToImplement4 {
    public static void main(String[] args) {
        //4. Using future!
        //We can use executor for creating pool of threads
        //we can use callable to return a string (a resultant or something)
        //we obtain the callable return string in future refvar.
        //future's refVar.get() -> used to get the resultant string

        //CAllable for future!
        //❌ The diamond operator (<>) is not allowed for anonymous inner classes.
        //so specifying generic type on both side is mandatory!
        Callable<String> myCallable = new Callable<String>(){
            @Override
            public String call() throws Exception{
                System.out.println("Task execution completed!");
                    return "success";
            } 
        }; // also must end with ; for anonymous class

        Callable<String> myCallable2 = () -> {
                System.out.println("Task execution completed!");
                return "success";
        };   

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> future = executor.submit(myCallable);

        if(!future.isDone()){
            System.err.println("Future isDone(): "+ future.isDone()); //returns boolean true/false
            System.out.println("Future state(): "+future.state()); //RUNNING
            System.out.println("Task is still running!");
        }

        String result = "failure"; //for testing
        System.err.println("Future isDone(): "+future.isDone()); //returns boolean true/false
        System.out.println("Future state: "+future.state()); //SUCCESS


        try {
            result = future.get(); //get() method can throw checked exceptions
        } catch (InterruptedException | ExecutionException e) {
            //InterruptedException - if get() is interrupted
            //ExecutionException - if the task fails with an exception
            System.err.println("Error occured!");
        }
        System.out.println("Result: "+ result);
        executor.shutdown();
    }
}
