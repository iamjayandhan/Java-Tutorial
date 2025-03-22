###  Excption Handling

In Java there exists a class that handles all errors and exceptions -> Throwable class

Here,
1. Main class => **Object class**
2. **Throwable class** => Inherited from Object class
3. Has **Exceptions and Errors**
   
### Types of Exceptions
1. **Checked** => Exceptions are checked during compile time!
2. **Unchecked** => Checked only in runtime.

### Terminologies
1. **try** => Experimental code is dropped here in this block.
2. **catch** => handle any kind of exceptions
3. **finally** => This block is always gets executed.

### throw vs throws
1. **throw** => throw an exception.
2. **throws** => declare exceptions(tells java that the method may/may not throw an exception!)

### **Checked vs. Unchecked Exceptions in Java**



#### **Checked Exceptions**
- Checked exceptions are exceptions that are **checked at compile time**.
- The compiler enforces handling these exceptions using `try-catch` or by declaring them with `throws` in the method signature.
- They usually represent **recoverable conditions** in the program (e.g., file not found, network issues).
- Examples:
  - `IOException`
  - `SQLException`
  - `FileNotFoundException`
  
**Example of Checked Exception:**
```java
import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
```
Here, `FileNotFoundException` is checked at compile-time, forcing the developer to handle it.

---

#### **Unchecked Exceptions**
- Unchecked exceptions are **not checked at compile time**.
- These exceptions occur due to **logical errors** and usually indicate **programming mistakes**.
- They extend `RuntimeException` and do **not require mandatory handling**.
- Examples:
  - `NullPointerException`
  - `ArithmeticException`
  - `ArrayIndexOutOfBoundsException`

**Example of Unchecked Exception:**
```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int a = 5 / 0; // ArithmeticException
    }
}
```
Here, dividing by zero causes an `ArithmeticException`, but the compiler does not enforce handling.

---

### **Ducking Exceptions using `throws`**
- **Exception ducking** means **passing the responsibility** of handling an exception to the calling method by using `throws` in the method signature.
- This allows methods to **delegate exception handling** instead of dealing with it directly.

#### **Example:**
```java
import java.io.*;

public class ExceptionDuckingExample {
    public static void readFile() throws IOException { // Ducking exception
        FileReader file = new FileReader("file.txt");
    }

    public static void main(String[] args) {
        try {
            readFile(); // Exception handling happens here
        } catch (IOException e) {
            System.out.println("Handled IOException in main method.");
        }
    }
}
```
- The method `readFile()` **ducks** the `IOException` by declaring `throws IOException`, so the responsibility of handling it is passed to `main()`, where it is caught.

This technique is useful when:
- You want to **let the caller decide** how to handle the exception.
- You're working with **library code**, where exception handling might be left to the user.