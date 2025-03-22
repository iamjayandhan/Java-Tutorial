A **daemon thread** in Java is a low-priority background thread that runs to support non-daemon threads (user threads). It automatically terminates when all user threads finish execution.

### **Starting a Daemon Thread in Java**
To make a thread a daemon thread, use the `setDaemon(true)` method **before** starting the thread.

---

### **Example: Creating a Daemon Thread**
```java
class DaemonExample extends Thread {
    public void run() {
        // Daemon thread runs indefinitely in background
        while (true) {
            System.out.println("Daemon thread running...");
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Daemon thread interrupted");
            }
        }
    }
}

public class DaemonThreadDemo {
    public static void main(String[] args) {
        DaemonExample dt = new DaemonExample();
        dt.setDaemon(true); // Set thread as Daemon
        dt.start(); // Start the daemon thread

        // Main thread sleeps for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main thread finishing, Daemon thread will exit.");
    }
}
```
---

### **Key Points:**
1. **Call `setDaemon(true)` before `start()`**  
   - If `setDaemon(true)` is called **after** starting the thread, it throws an `IllegalThreadStateException`.

2. **Daemon threads automatically stop**  
   - When all user threads finish execution, JVM **terminates** daemon threads **even if they are running**.

3. **Use case:**  
   - Used for **background tasks**, such as:
     - Garbage Collection (`GC`)
     - Auto-saving documents
     - Log monitoring

---
