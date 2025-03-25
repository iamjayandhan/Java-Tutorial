public class Volatile {
    private static volatile boolean flag = false;  // ✅ Ensures visibility

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (!flag) {  // ✅ Will exit when flag is changed
            }
            System.out.println("Flag changed! Exiting loop...");
        });

        thread1.start();
        Thread.sleep(2000);
        flag = true;  // ✅ Immediately visible to thread1
    }
}
