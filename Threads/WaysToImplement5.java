import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WaysToImplement5 {
    public static void main(String[] args) {
        //4. Using completable future!
        //An enhanced version of Future.
        //Allows non-blocking execution and chaining of multiple tasks.
        //Supports exception handling and manual completion.

        //supplyAsync() -> start task (like executor.submit() or executor.execute())
        CompletableFuture<String> comfuture = CompletableFuture.supplyAsync(()->{ // supplyAsync -> start an async task
            System.err.println("Executing task in: "+ Thread.currentThread().getName());
            return "Hello, CompletableFuture!"; 
        });

        //a small delay!
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       comfuture.thenAccept(result2 -> System.out.println("Result: "+result2));

       //thenApply() for chained execution!
       CompletableFuture<String > comfuture2 = CompletableFuture.supplyAsync(() -> "My ")
                                                .thenApply(var -> var+"Name is ")
                                                .thenApply(var2 -> var2 + "Jayandhan.");
        try {
            Thread.sleep(1000);
            System.out.println(comfuture2.get()); 
            System.err.println();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //thenCombine() -> merge two results!
        CompletableFuture<String > p1 = CompletableFuture.supplyAsync(() -> "part1 ");
        CompletableFuture<String > p2 = CompletableFuture.supplyAsync(() -> "part2 ");

        CompletableFuture<String > combined = p1.thenCombine(p2, (a,b) -> a+" + "+b);
        try {
            Thread.sleep(1000);
            System.out.println(combined.get()); 
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //exceptionally() -> Handles exceptions and provides a default fallback.
        CompletableFuture<String> excepCF = CompletableFuture.supplyAsync(() -> {
            int a = 10/0;
            return "done";
        }).exceptionally(ex -> {
            System.err.println("Exception: "+ex);
            return "error resolved!";
        });

        try {
            Thread.sleep(1000);
            System.out.println(excepCF.get()); 
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        //allOf() -> waits for all the tasks to finish
        List<CompletableFuture<String>> futures = Arrays.asList(
            CompletableFuture.supplyAsync(() -> "Task - 1"),
            CompletableFuture.supplyAsync(() -> "Task - 2"),
            CompletableFuture.supplyAsync(() -> "Task - 3")
        );

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
            futures.toArray(new CompletableFuture[0])
        );
        
        try {
            allFutures.get(); //blocks until all tasks complete
        } catch (Exception e) {
            e.printStackTrace();
        }

        futures.forEach(f -> {
            try {
                System.err.println(f.get());
            } catch (Exception e) {
                System.out.println("Error handled!");
            }
        });

        System.err.println("\n");

        //anyOf() -> returns result of first completing task.
        CompletableFuture<String> comp1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Comp1 done with the task";
        });

        CompletableFuture<String> comp2 = CompletableFuture.supplyAsync(() -> {
            return "Comp2 done with the task";
        });

        CompletableFuture<Object> firstCompletedCF = CompletableFuture.anyOf(comp1,comp2);

        try {
            System.err.println(firstCompletedCF.get());
        } catch (Exception e) {
            System.out.println("Done with error!");
        }

    }    
}
