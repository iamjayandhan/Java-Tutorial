### **What is `java.util.function.Consumer<T>`?** 🤯  

🔹 `Consumer<T>` is a **functional interface** in Java's **`java.util.function`** package.  
🔹 It **takes an input** but **does not return anything** (it "consumes" the input).  
🔹 It is typically used in **lambda expressions** and **method references** for performing actions like logging, printing, or modifying an object.

---

## **🛠 Functional Interface Definition**
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t); // Abstract method (must be implemented)
}
```
✔️ Since `Consumer<T>` is a **functional interface**, it can be used with **lambda expressions** and **method references**.

---

## **✅ Simple Example**
```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // Using Consumer with a Lambda Expression
        Consumer<String> printConsumer = s -> System.out.println("Hello, " + s);

        // Calling accept() method
        printConsumer.accept("Jayandhan"); // Output: Hello, Jayandhan
    }
}
```

---

## **🛠 `Consumer<T>` with `forEach()`**
One common use case of `Consumer<T>` is with **`forEach()`** in Java Streams.

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerForEachExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Consumer to print each element
        Consumer<Integer> printNumber = n -> System.out.println("Number: " + n);

        // Using Consumer in forEach
        numbers.forEach(printNumber);
    }
}
```
✅ **Output:**
```
Number: 1
Number: 2
Number: 3
Number: 4
Number: 5
```

---

## **🔥 Chaining Consumers (`andThen()`)**
`Consumer` supports **method chaining** using `andThen()`.  

```java
import java.util.function.Consumer;

public class ConsumerChainingExample {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("Upper: " + s.toUpperCase());
        Consumer<String> c2 = s -> System.out.println("Lower: " + s.toLowerCase());

        // Chaining Consumers using andThen()
        Consumer<String> combined = c1.andThen(c2);

        combined.accept("Jayandhan");
    }
}
```
✅ **Output:**
```
Upper: JAYANDHAN
Lower: jayandhan
```

---

## **⚡ When to Use `Consumer<T>`?**
| Use Case | Example |
|----------|---------|
| **Printing values** | `list.forEach(System.out::println);` |
| **Logging messages** | `Consumer<String> log = msg -> System.out.println("LOG: " + msg);` |
| **Modifying objects** | `Consumer<Employee> giveBonus = emp -> emp.salary += 5000;` |
| **Chaining actions** | `consumer1.andThen(consumer2).accept(value);` |

---

## **🚀 Summary**
✔ **`Consumer<T>`** is a functional interface that **takes an input but returns nothing**.  
✔ Commonly used with **`forEach()`**, logging, and **method chaining**.  
✔ Supports **chaining with `andThen()`** for sequential execution.  