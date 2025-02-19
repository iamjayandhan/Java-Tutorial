### **Stream API in Java**  

The **Stream API** in Java is a part of the **Java Collections Framework** (introduced in **Java 8**) that allows functional-style operations on collections, making data processing **faster, more readable, and parallelizable**.  

It is **not** directly part of **OOP (Object-Oriented Programming)** but falls under **Functional Programming** principles in Java.  

---

### **Key Features of Stream API**
1. **Functional Programming** – Uses lambda expressions and method references.  
2. **Declarative Approach** – Focuses on "what to do" rather than "how to do it."  
3. **Lazy Evaluation** – Operations are performed only when needed.  
4. **Parallel Processing** – Supports parallel execution for improved performance.  
5. **Chainable Operations** – Allows method chaining to process collections efficiently.  

---

### **How Stream API Works**
A **Stream** processes a sequence of elements in three stages:  

1. **Creation** → Generate a Stream from a Collection or an array.  
2. **Processing (Intermediate Operations)** → Transform data (e.g., `filter()`, `map()`, `sorted()`).  
3. **Terminal Operations** → Produce a result (e.g., `collect()`, `forEach()`, `count()`).  

---

### **Example Usage**
```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Convert to uppercase and filter names starting with 'A'
        List<String> result = names.stream()
                .map(String::toUpperCase)   // Intermediate Operation
                .filter(name -> name.startsWith("A")) // Intermediate
                .collect(Collectors.toList()); // Terminal Operation

        System.out.println(result); // Output: [ALICE]
    }
}
```

---

### **Common Stream Operations**
| Type | Method | Purpose |
|------|--------|---------|
| **Creation** | `stream()`, `of()`, `generate()` | Create a stream |
| **Intermediate** | `map()`, `filter()`, `sorted()`, `distinct()` | Transform data |
| **Terminal** | `collect()`, `forEach()`, `count()`, `reduce()` | Produce a result |
| **Parallel** | `parallelStream()` | Process in parallel |
