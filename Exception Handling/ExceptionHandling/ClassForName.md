### **What does `Class.forName("classname")` do in Java?**

The method `Class.forName("classname")` is used in Java to **dynamically load a class at runtime**. It returns a `Class` object representing the specified class and loads it into memory if it isn't already loaded.

---

### **Use Cases of `Class.forName()`**
1. **Dynamic Class Loading**
   - It allows loading a class at runtime without explicitly mentioning it in the code.
   - Useful for JDBC drivers, plugins, and frameworks where the class name might be provided as a string.

2. **Executing Static Blocks**
   - If the class contains a static block, it gets executed when the class is loaded.

3. **Reflection API Support**
   - Once a class is loaded, you can use reflection (`getDeclaredMethods()`, `newInstance()`, etc.) to create objects, invoke methods, and inspect fields.

---

### **Example: Loading a JDBC Driver Dynamically**
```java
public class ClassForNameExample {
    public static void main(String[] args) {
        try {
            // Load JDBC Driver dynamically
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found: " + e.getMessage());
        }
    }
}
```
💡 **Explanation:**
- This loads the `com.mysql.cj.jdbc.Driver` class dynamically.
- The static block inside the driver class registers it with `DriverManager`.

---

### **Example: Executing Static Blocks Using `Class.forName()`**
```java
class Test {
    static {
        System.out.println("Static block executed!");
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("Test"); // This triggers the static block
    }
}
```
✅ **Output:**
```
Static block executed!
```
Here, even though we didn’t create an instance of `Test`, the **static block executed** when the class was loaded.

---

### **How `Class.forName()` Differs from `newInstance()`**
| Feature               | `Class.forName()`  | `newInstance()` |
|----------------------|----------------|----------------|
| **Purpose**         | Loads class dynamically | Creates an instance of the class |
| **Triggers Static Blocks?** | ✅ Yes | ❌ No |
| **Returns**         | `Class<?>` object | Instance of the class |
| **Example**         | `Class.forName("Test")` | `Class.forName("Test").newInstance()` |
