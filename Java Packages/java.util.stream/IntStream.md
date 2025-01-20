## **Java `IntStream` Notes**

### **1. Overview**
`IntStream` is a part of **Java 8 Stream API**, specifically designed for **primitive `int` values**. It allows for **functional programming** operations on sequences of integers in a more efficient and concise way.

- **Package**: `java.util.stream`
- **Primitive type**: `int` (as opposed to `Stream<Integer>`)

### **2. Common Methods of `IntStream`**

| **Method**                        | **Description**                                               |
|-----------------------------------|---------------------------------------------------------------|
| **`range(start, end)`**           | Generates a stream of integers from `start` (inclusive) to `end` (exclusive). |
| **`rangeClosed(start, end)`**     | Generates a stream of integers from `start` (inclusive) to `end` (inclusive).   |
| **`toArray()`**                   | Converts the stream to an `int[]` array.                      |
| **`forEach(action)`**             | Performs the given action for each element in the stream.     |
| **`map(mapper)`**                 | Transforms each element using the provided function.         |
| **`sum()`**                       | Computes and returns the sum of elements in the stream.       |
| **`average()`**                   | Computes and returns the average of elements in the stream.   |
| **`filter(predicate)`**           | Filters elements based on the provided condition.            |
| **`collect(collector)`**          | Collects the elements into a collection (e.g., list).         |

### **3. Method Details**

#### **`IntStream.range(start, end)`**
- **Description**: Generates a stream of integers starting from `start` (inclusive) up to `end` (exclusive).
- **Example**:
  ```java
  IntStream.range(1, 5);  // Generates: 1, 2, 3, 4
  ```

#### **`IntStream.rangeClosed(start, end)`**
- **Description**: Generates a stream of integers starting from `start` (inclusive) to `end` (inclusive).
- **Example**:
  ```java
  IntStream.rangeClosed(1, 5);  // Generates: 1, 2, 3, 4, 5
  ```

#### **`toArray()`**
- **Description**: Converts the `IntStream` into an `int[]` array.
- **Example**:
  ```java
  int[] arr = IntStream.range(1, 5).toArray();  // arr = [1, 2, 3, 4]
  ```

#### **`forEach(action)`**
- **Description**: Applies the given action (lambda) to each element of the stream.
- **Example**:
  ```java
  IntStream.range(1, 5).forEach(System.out::println);
  ```

#### **`map(mapper)`**
- **Description**: Transforms each element using the provided function.
- **Example**:
  ```java
  int[] squared = IntStream.range(1, 5)
                           .map(x -> x * x)  // Map to squares
                           .toArray();       // squared = [1, 4, 9, 16]
  ```

#### **`sum()`**
- **Description**: Returns the sum of all the elements in the stream.
- **Example**:
  ```java
  int sum = IntStream.range(1, 5).sum();  // sum = 10 (1+2+3+4)
  ```

#### **`average()`**
- **Description**: Returns the average of the elements in the stream as `OptionalDouble`.
- **Example**:
  ```java
  OptionalDouble avg = IntStream.range(1, 5).average();  // avg = 2.5
  ```

### **4. Functional Programming with `IntStream`**

`IntStream` allows you to perform **functional programming** operations such as **mapping**, **filtering**, and **reducing**.

- **Example**:
  ```java
  int result = IntStream.range(1, 5)
                        .filter(x -> x % 2 == 0)  // Only even numbers
                        .map(x -> x * x)          // Square them
                        .sum();                   // Sum = 20
  System.out.println(result);  // Output: 20
  ```

### **5. Efficiency**
- `IntStream` works directly with the **primitive `int` type**, so there is **no autoboxing** (conversion to `Integer`).
- This reduces **memory overhead** and leads to **better performance** compared to `Stream<Integer>`.

### **6. Example Code**

```java
import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {
        int start = 1;  // Starting number
        int end = 5;    // Ending number (exclusive)

        // Generate range from start to end-1, transform them and collect to an array
        int[] arr = IntStream.range(start, end)
                             .map(x -> x * 2)       // Double each number
                             .toArray();            // Convert to array

        // Print the result
        for (int num : arr) {
            System.out.print(num + " ");  // Output: 2 4 6 8
        }
    }
}
```

### **7. Summary Table for `IntStream` Methods**

| **Method**                        | **Description**                                               |
|-----------------------------------|---------------------------------------------------------------|
| `IntStream.range(start, end)`     | Creates a stream of integers from `start` to `end - 1`.       |
| `IntStream.rangeClosed(start, end)`| Creates a stream of integers from `start` to `end`.           |
| `toArray()`                       | Converts the stream to an `int[]` array.                      |
| `forEach(action)`                 | Performs the given action for each element in the stream.     |
| `map(mapper)`                     | Transforms each element using the provided function.         |
| `sum()`                           | Returns the sum of elements in the stream.                   |
| `average()`                       | Returns the average of elements in the stream.               |
| `filter(predicate)`               | Filters elements based on the provided condition.            |
| `collect(collector)`              | Collects the elements into a collection (e.g., list).         |

### **8. Final Notes**

- **`IntStream`** is ideal when you need to work with sequences of **primitive `int` values** and want to perform operations in a **functional programming style**.
- It is **more efficient** than using `Stream<Integer>` due to its direct handling of primitive values, avoiding the overhead of **boxing**.
- Provides a wide range of methods for transforming, filtering, and aggregating values.

### **Useful Resources**
- **Java 8 Documentation**: [Stream API](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
