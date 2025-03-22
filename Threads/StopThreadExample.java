class MyThread extends Thread {
    private volatile boolean running = true; // Volatile ensures visibility across threads

    public void run() {
        while (running) {
            System.out.println(getName() + " is running...");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " has stopped!");
    }

    public void stopThread() {
        running = false; // Set flag to false, thread will exit loop
    }
}

public class StopThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        try {
            Thread.sleep(5000); // Let thread run for 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.stopThread(); // Stop the thread gracefully
    }
}
