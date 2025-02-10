### **Why Do All Classes Extend the `Object` Class?**  
In Java, **every class implicitly extends `java.lang.Object`** (except `Object` itself). This is because **`Object` is the root class** of the Java class hierarchy, and it provides essential methods that every Java object needs.  

---

### **What’s Inside the `Object` Class?**
The `Object` class provides fundamental methods that are inherited by every class. Here are the most important ones:

| Method | Description |
|--------|------------|
| `toString()` | Returns a string representation of the object. |
| `equals(Object obj)` | Compares if two objects are equal based on content. |
| `hashCode()` | Returns a unique hash code for the object. |
| `getClass()` | Returns the runtime class of the object. |
| `clone()` | Creates a copy of the object (if `Cloneable` is implemented). |
| `finalize()` | Called before garbage collection to clean up resources. |
| `wait(), notify(), notifyAll()` | Used for thread synchronization. |

---

### **Why is `Object` Needed?**
1️⃣ **Uniformity** → Since all classes inherit from `Object`, they get common behaviors, reducing redundancy.  
2️⃣ **Polymorphism** → Any class object can be stored in an `Object` reference, enabling flexibility.  
   ```java
   Object obj = new String("Hello");
   ```
3️⃣ **Collections Framework** → Java collections (like `ArrayList`, `HashMap`) store `Object` references, allowing them to hold any type.  
4️⃣ **Thread Synchronization** → Methods like `wait()`, `notify()`, and `notifyAll()` are used in multi-threading.  

---

### **Example: Overriding `toString()`**
By default:
```java
class A {}
public class Test {
    public static void main(String args[]) {
        A obj = new A();
        System.out.println(obj);  // Output: A@hexCode
    }
}
```
By overriding `toString()`:
```java
class A {
    public String toString() {
        return "This is class A";
    }
}
public class Test {
    public static void main(String args[]) {
        A obj = new A();
        System.out.println(obj);  // Output: This is class A
    }
}
```

---

### **Conclusion**
✔ Java **forces every class to inherit `Object`** for consistency and common functionality.  
✔ The **`Object` class provides essential methods** like `toString()`, `equals()`, `hashCode()`, and `wait()`.  
✔ **Polymorphism, collections, and threading** rely on `Object` methods.  

Let me know if you need more clarification! 🚀