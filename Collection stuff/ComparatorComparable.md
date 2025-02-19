### **Comparator vs. Comparable in Java**  

| Feature         | **Comparable** (`java.lang.Comparable`) | **Comparator** (`java.util.Comparator`) |
|---------------|----------------------------------|----------------------------------|
| **Definition** | Used to define a natural ordering of objects. | Used to define custom ordering of objects. |
| **Package** | `java.lang` | `java.util` |
| **Method** | `int compareTo(T obj)` | `int compare(T obj1, T obj2)` |
| **Sorting Logic** | Defined inside the class itself. | Defined externally in a separate class. |
| **Modifiable Sorting Order?** | No, it provides a single sorting logic. | Yes, multiple sorting logics can be created. |
| **Example Use Case** | Sorting objects based on a single field (e.g., sorting students by roll number). | Sorting objects based on multiple fields (e.g., sorting students by name, age, etc.). |

### **Example: Comparable (Single Sorting Criteria)**
```java
class Student implements Comparable<Student> {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(this.rollNo, s.rollNo); // Sorting by roll number
    }
}
```

### **Example: Comparator (Multiple Sorting Criteria)**
```java
import java.util.*;

class Student {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}

// Custom comparator for sorting by name
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}
```

### **When to Use What?**
- **Use Comparable** when natural ordering should be defined within the class itself.  
- **Use Comparator** when multiple sorting strategies are needed or when sorting logic should be separate from the class definition.