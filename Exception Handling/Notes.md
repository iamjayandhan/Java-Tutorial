If `main()` has `throws Exception`, it means the exception is not handled inside `main` but passed to the JVM. If an error occurs, the JVM prints the error message and stops the program. Example:  

```java
public class Main {
    public static void main(String args[]) throws Exception {
        int result = 10 / 0; // Causes ArithmeticException
        System.out.println(result);
    }
}
```
**Output (handled by JVM):**  
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

To prevent this, use `try-catch` inside `main()`:  
```java
public class Main {
    public static void main(String args[]) {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: Division by zero!");
        }
    }
}
```
**Output (handled properly):**  
```
Error: Division by zero!
```