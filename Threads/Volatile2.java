public class Volatile2 {
    public static volatile boolean flag = false;
    public static void main(String args[]){

        Runnable MyRunnable = () -> {
            System.err.println("Inside Thread!");

            while(!flag){
                System.out.println("Infinite loop!");
            }
            System.out.println("Flag is found to be false, so terminating. Inside thread");
        };
        
        Thread t1 = new Thread(MyRunnable);
        t1.start();
        
        try {
            Thread.sleep(1000); // Ensure thread starts before flag is updated
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("Flag set to false by main!");
    }    
}
