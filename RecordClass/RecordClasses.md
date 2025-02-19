In Java, a **record class** is a special type of class introduced in **Java 14 (as a preview) and finalized in Java 16**. It provides a **concise way to create immutable data-holding classes**.  

### **Key Features of Record Class**:
1. **Immutable Fields**  
   - All fields in a record are `private` and `final` by default.
   - You **cannot** modify them after object creation.

2. **Automatic Methods Generation**  
   When you declare a record, Java automatically generates:
   - **A constructor** (`Alien(int id, String name)`)
   - **Getters** (`id()` and `name()`) instead of traditional `getId()` and `getName()`.
   - **`toString()`** (returns a readable string representation)
   - **`equals()`** (compares based on field values)
   - **`hashCode()`** (ensures correct hashing for collections)

3. **No Need for Boilerplate Code**  
   Unlike regular Java classes, records eliminate the need for writing repetitive code like:
   - Getters (`getId()`, `getName()`)
   - `equals()`, `hashCode()`, `toString()`
   - Explicit constructors

### **Understanding the Given Code**
```java
record Alien(int id, String name) { 
    static int num;  // Allowed, but not tied to instances

    public Alien { 
        if (id == 0) throw new IllegalArgumentException("id cannot be zero");  
    }
}
```
- The `record Alien(int id, String name)` automatically generates:
  - Constructor `Alien(int id, String name)`
  - Getters: `id()` and `name()`
  - `toString()`, `equals()`, and `hashCode()`
- The **compact constructor** inside `Alien` validates the `id` field.
- The `num` variable is **static**, which is allowed but not part of record equality checks.

### **Comparing Objects in `main()`**
```java
Alien a1 = new Alien(1, "JD");
Alien a2 = new Alien(1, "JD");

System.out.println(a1.equals(a2)); // true (values are compared)
System.out.println(a1 == a2); // false (different memory addresses)
System.out.println(a1); // Alien[id=1, name=JD]
System.out.println(a2); // Alien[id=1, name=JD]
```
- **`a1.equals(a2)` returns `true`** because record classes compare values, not references.
- **`a1 == a2` returns `false`** because they are different objects in memory.
- The custom `toString()` implementation prints:  
  `"Alien[id=1, name=JD]"`

### **When to Use Records?**
- When you need **immutable** data models.
- When you want **auto-generated** `toString()`, `equals()`, and `hashCode()`.
- When working with **DTOs (Data Transfer Objects)** or **value-based classes**.

### **Limitations of Records**
- Cannot extend another class (since records are implicitly `final`).
- Cannot modify fields after initialization.
- Cannot define instance variables outside the constructor.

### **Conclusion**
Records simplify Java coding by **reducing boilerplate code** and ensuring **immutability**. They are **best suited for data-holding classes** like DTOs, instead of traditional Java classes with manual `equals()`, `hashCode()`, and `toString()` implementations.