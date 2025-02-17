# Java Collection Framework Notes

## 1. Collection API
- The **Collection API** in Java is a framework that provides architecture for storing and manipulating groups of objects.
- It includes **interfaces**, **classes**, and **methods** that help in handling data efficiently.
- Introduced in **Java 2 (JDK 1.2)**, it replaced older data structures like `Vector` and `Hashtable`.

### **Key Features of Collection API**
- Supports different types of collections like **List, Set, Queue, and Map**.
- Provides **generic support** to ensure type safety.
- Offers built-in **sorting, searching, and thread-safe operations**.
- Improves code **reusability and performance**.

---

## 2. Collection (Interface)
- `Collection<E>` is the **root interface** of the Java **Collection Framework**.
- It extends `Iterable<E>` and is further extended by **List, Set, and Queue**.

### **Hierarchy**
```
Iterable<E>
   └── Collection<E>
          ├── List<E>
          ├── Set<E>
          ├── Queue<E>
```

### **Important Methods in Collection Interface**
| Method | Description |
|---------|------------|
| `add(E e)` | Adds an element to the collection. |
| `remove(Object o)` | Removes an element from the collection. |
| `size()` | Returns the number of elements in the collection. |
| `isEmpty()` | Checks if the collection is empty. |
| `contains(Object o)` | Checks if an element exists in the collection. |
| `iterator()` | Returns an iterator to traverse elements. |
| `toArray()` | Converts the collection into an array. |
| `clear()` | Removes all elements from the collection. |

---

## 3. Collections (Class)
- `Collections` is a **utility class** in `java.util` package that provides static methods for working with collections.
- It contains methods for **sorting, searching, synchronization, and modifying collections**.

### **Commonly Used Methods in Collections Class**
| Method | Description |
|---------|------------|
| `sort(List<T> list)` | Sorts the given list in ascending order. |
| `reverse(List<T> list)` | Reverses the order of elements in a list. |
| `shuffle(List<T> list)` | Randomly shuffles elements in a list. |
| `binarySearch(List<T> list, T key)` | Searches for an element using binary search. |
| `max(Collection<T> coll)` | Returns the maximum element. |
| `min(Collection<T> coll)` | Returns the minimum element. |
| `synchronizedList(List<T> list)` | Returns a thread-safe list. |
| `unmodifiableList(List<T> list)` | Returns an unmodifiable (read-only) list. |

---

## **Key Differences:**
| Feature | Collection (Interface) | Collections (Class) |
|---------|------------------|------------------|
| **Type** | Interface | Utility Class |
| **Belongs to** | `java.util` package | `java.util` package |
| **Purpose** | Defines core methods for working with collections. | Provides static methods to manipulate collections. |
| **Example** | `List<String> list = new ArrayList<>();` | `Collections.sort(list);` |

---

## **Example Code**
```java
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // Collection Interface usage with List
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        System.out.println("Collection: " + numbers);

        // Collections Class usage for sorting
        List<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        
        System.out.println("Sorted List: " + list);
    }
}
```
```
Output:
Collection: [10, 20, 30]
Sorted List: [10, 20, 30]
```

---

## **Summary**
- **Collection API**: The framework that provides collection classes & interfaces.
- **Collection (Interface)**: The root interface for working with collections.
- **Collections (Class)**: A utility class with static methods for collection manipulation.