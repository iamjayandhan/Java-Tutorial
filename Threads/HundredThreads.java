
class MyThread extends Thread{

    public MyThread(int id){
        this.setName("Thread -d: "+id);
    }

    @Override
    public void run(){
        System.out.println(this.getName()+" is running!");
        try {
            Thread.sleep(10000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        // finally{
        //    
        // }

        System.out.println(this.getName() + " has completed execution.");
        
    }
}


public class HundredThreads {
    public static void main(String[] args) {
        
        for(int i=0;i<100;i++){
            MyThread t = new MyThread(i);
            t.setDaemon(true);
            t.start();
        }

        try {
            Thread.sleep(10000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            System.out.println("Main Execution completed!");
        }
    }
}
