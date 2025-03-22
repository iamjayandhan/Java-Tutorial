### **🚀 Thread Life Cycle in Simple Words**
A thread in Java goes through **5 main states** in its life cycle. Let’s break it down in a simple way.  

---

### **1️⃣ New (Created)**
- **What happens?**  
  A thread is created but **not started yet**.  
- **Example:**  
  ```java
  Thread t = new Thread();
  ```
  The thread `t` is **created** but **not running yet**.

---

### **2️⃣ Runnable (Ready to Run)**
- **What happens?**  
  The thread is **ready** to run but **waiting for CPU**.  
- **Example:**  
  ```java
  t.start();  
  ```
  The thread is **ready** but **might wait** if other threads are using the CPU.

---

### **3️⃣ Running (Executing)**
- **What happens?**  
  The CPU **gives time** to the thread, so it **starts running**.  
- **Example:**  
  If the CPU selects `t`, it starts executing its `run()` method.

---

### **4️⃣ Blocked/Waiting (Paused Temporarily)**
- **What happens?**  
  The thread **pauses** and **waits** for something (e.g., another thread to finish or some resource to be free).  
- **Example:**  
  ```java
  Thread.sleep(1000);  // Sleep for 1 second
  ```
  The thread **waits** and **does nothing** for 1 second.

---

### **5️⃣ Terminated (Dead)**
- **What happens?**  
  The thread **finishes** its task and **stops forever**.  
- **Example:**  
  Once `run()` completes, the thread **dies** and can’t be restarted.

---

### **🎯 Quick Summary**
| State        | What Happens? |
|-------------|--------------|
| **New** | Thread is created but not started |
| **Runnable** | Ready to run, waiting for CPU |
| **Running** | CPU is executing the thread |
| **Blocked/Waiting** | Thread is paused (e.g., waiting for a resource) |
| **Terminated** | Thread is finished and stops |

---

### **🛠 Example with All States**
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Running...");
        try {
            Thread.sleep(2000); // Moves to Waiting state
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished!");
    }
}

public class ThreadLifeCycle {
    public static void main(String[] args) {
        MyThread t = new MyThread(); // New state
        t.start(); // Runnable → Running
    }
}
```

---

### **🔑 Key Takeaways**
✅ **A thread starts in "New" and must be started with `.start()`.**  
✅ **It moves between "Runnable" and "Running" as per CPU scheduling.**  
✅ **It can "Wait" or be "Blocked" when it needs to pause.**  
✅ **Once finished, it "Dies" and cannot be restarted.**  

---