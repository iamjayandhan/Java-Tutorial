
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class WaysToImplement3 {
    public static void main(String[] args) {
        //3. Using ScheduledExecutorService (Scheduled Tasks)
        //Allows executing tasks after a delay or at fixed intervals.
        //Useful for running cron jobs and monitoring!

        // Runnable run = new Runnable() {
        //     @Override
        //     public void run(){
        //         System.out.println("Scheduled Task Executed at: " + System.currentTimeMillis());
        //     }
        // };

        Runnable run = () -> {
            // System.out.println("Scheduled Task Executed at: " + System.currentTimeMillis());
            System.out.println("Current Time: " + new Date());
        };

        ScheduledExecutorService executer = Executors.newScheduledThreadPool(3);
        executer.scheduleAtFixedRate(run, 1, 1  , TimeUnit.SECONDS);

        //4. Using ForkJoinPool (Parallel Processing)
        //Suitable for divide-and-conquer tasks, used in parallel computing.
        //Used for parallel processing (e.g., image processing, big data computations).
    }
}
