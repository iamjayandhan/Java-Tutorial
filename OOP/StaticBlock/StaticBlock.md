## Detailed Explanation of Static Block Execution in Java

### Code:
```java
public class StaticBlock {

    static int a = 4;
    static int b;

    // Initialized when the class is loaded into memory!
    static {
        System.out.println("I am in static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        // StaticBlock obj = new StaticBlock();
        System.out.println(a + " " + b);
    }
}
```

---

### **Step 1: Compilation Process**

1. **Code Compilation**:
   - You have written the Java code in a file named `StaticBlock.java`.
   - The first step is to compile this Java code using the `javac` command:
     ```bash
     javac StaticBlock.java
     ```
   - The `javac` compiler checks the code for syntax errors and generates a **bytecode file** called `StaticBlock.class` if there are no errors. This file contains the compiled version of your code, which the JVM can understand and execute.
   - **Note**: During compilation, **no execution happens**. The compiler just checks for syntax and generates the class file.

2. **Class Structure**:
   - The `StaticBlock.class` bytecode will include the **static block**, **static variables**, **`main` method**, and other class members.
   - The **static block** is not executed during the compilation phase; it's stored as part of the class and will be executed later when the class is loaded into memory by the JVM.

---

### **Step 2: Class Loading and Execution in JVM**

Now that we have successfully compiled the code, let’s see what happens when you run the program.

1. **Execution of the Program**:
   - To run the program, you use the `java` command:
     ```bash
     java StaticBlock
     ```
   - The JVM performs several internal operations to load, initialize, and execute the code. Let’s break it down step by step.

---

### **Step 3: Class Loading and Initialization**

1. **Class Loading**:
   - The first step that the JVM takes when running the program is **loading the class** `StaticBlock` into memory.
   - **Class loading** involves:
     - **Locating the class file** (`StaticBlock.class`), which was generated during compilation.
     - **Reading the bytecode** and storing it in memory.
   
2. **Static Block Execution**:
   - **Static blocks** are executed only once when the class is loaded into memory. This is part of the class initialization phase.
   - Since your class `StaticBlock` contains a **static block**, it is executed **automatically** when the class is loaded by the JVM, before any method (including `main()`) is called.
   
   Here’s what happens inside the static block:
   - The `System.out.println("I am in static block");` statement prints:
     ```plaintext
     I am in static block
     ```
   - The static variable `b` is initialized with the value of `a * 5`:
     - `a = 4` (as declared in the class).
     - `b = a * 5` → `b = 4 * 5 = 20`.

   **Key Point**: The static block runs only once per class load, and it's used to perform initialization tasks for static variables or perform other setup operations.

---

### **Step 4: Execution of the `main` Method**

1. **Main Method Execution**:
   - After the static block has been executed, the `main` method is executed next.
   - **No object instantiation** occurs in this case (you’ve commented out `StaticBlock obj = new StaticBlock();`), so there’s no need to worry about non-static members.
   
2. **Accessing Static Variables**:
   - Inside the `main` method, you directly access the static variables `a` and `b` (both are static).
   - You use the statement `System.out.println(a + " " + b);`:
     - **Accessing static variables**: Since `a` and `b` are static, they belong to the class itself, not any specific instance. You can access them directly within a static context (like `main`), without needing an object instance.
     - The current values of `a` and `b` are:
       - `a = 4` (as initialized earlier).
       - `b = 20` (set in the static block).

   So, the output of the `main` method is:
   ```plaintext
   4 20
   ```

---

### **Step 5: JVM Internals - Detailed Explanation**

Now let's dive into the inner workings of the JVM during class loading and method execution:

1. **Classloader**:
   - The JVM uses a classloader to load classes into memory. The classloader reads the bytecode from the `StaticBlock.class` file and loads it into memory.
   - The static block is part of the class’s initialization process, so it is executed **once** when the class is first loaded into the JVM.

2. **Class Initialization**:
   - After the class is loaded, the JVM initializes the class. During this phase:
     - The static block is executed.
     - Static variables are initialized (if they have default values, they are initialized first, and then any further initialization happens as defined in the static block).
     - **Static variables are initialized only once** when the class is first loaded. This initialization is done **before** any object instantiation or method call.
   
3. **Main Method**:
   - The `main` method is called by the JVM when you run the program. Since `main` is a static method, it can directly access static variables `a` and `b` without needing any object instance.

4. **Garbage Collection**:
   - The JVM may use garbage collection to clean up memory, but in this case, since we only have static variables and no object creation, the garbage collector will not be involved during the execution.

---

### **Step 6: Execution Summary and Final Output**

To summarize the entire process from compilation to execution:

1. **Compilation**:
   - `javac StaticBlock.java` compiles the code into `StaticBlock.class`.

2. **Class Loading**:
   - The JVM loads `StaticBlock.class` when you run the program (`java StaticBlock`).

3. **Static Block Execution**:
   - The static block executes immediately when the class is loaded, printing `"I am in static block"` and initializing `b = 20`.


4. **Main Method**:
   - The `main` method executes, printing the values of `a` (which is `4`) and `b` (which is `20`).

5. **Output**:
   - The program prints:
     ```plaintext
     I am in static block
     4 20
     ```

---

### **Conclusion**

- **Static block** is executed **only once** when the class is loaded into memory. It’s responsible for initializing static variables or performing other one-time setup tasks.
- Static variables can be accessed directly in the `main` method because they belong to the class itself, not to any specific object instance.
- The class initialization happens before any methods (including `main`) are called, ensuring the static block and static variable initialization are performed first.

### **Static Block2 file Notes**

1. **Static Blocks Execute When the Class is Loaded**  
   - A **static block** runs **only once** when the class is first loaded into memory.  
   - It executes **before any object creation**.  

2. **Static Variables Are Shared Across All Objects**  
   - The `static` variable (`name`) belongs to the **class**, not individual objects.  
   - Changes to a `static` variable reflect across **all instances**.  

3. **Constructors Run Every Time an Object is Created**  
   - While the static block runs **once**, the constructor runs **each time an object is instantiated**.  

4. **Manually Loading a Class Without Object Creation**  
   - Using `Class.forName("Mobile");` forces the class to load and execute static blocks **without creating an object**.  
   - Requires exception handling (`ClassNotFoundException`).  

5. **Execution Order**  
   - **Step 1:** Class loads → **Static block executes** (only once).  
   - **Step 2:** Object is created → **Constructor executes** (for every object).  

### **Key Takeaways**  
✔ **Static blocks initialize static variables** and run **only once** when the class is loaded.  
✔ **Static variables belong to the class**, not objects, and are shared.  
✔ **Constructors run for every new object** but don’t affect static variables.  
✔ **`Class.forName()` loads a class into memory manually**, triggering the static block **without object creation**.  
