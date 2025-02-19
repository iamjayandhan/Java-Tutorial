### **Sealed Classes in Java (Introduced in Java 15 - Finalized in Java 17)**

#### **Definition:**  
A **sealed class** is a class that restricts which other classes can extend it. Unlike regular inheritance, where any class can extend another class, a **sealed class explicitly specifies a limited set of permitted subclasses**.

---

### **Why Sealed Classes?**
- **Control Inheritance:** Prevents unwanted subclassing, improving maintainability and security.
- **Better Modeling:** Helps enforce domain constraints by ensuring only a specific set of subclasses exist.
- **Enhances Pattern Matching:** Works well with **`switch` expressions** and **pattern matching**, making code more robust.

---

### **How to Declare a Sealed Class?**
A **sealed class** uses the `sealed` keyword and specifies permitted subclasses using `permits`.

```java
sealed class Vehicle permits Car, Bike {
    // common properties for all vehicles
}

final class Car extends Vehicle { 
    // Car-specific implementation
}

non-sealed class Bike extends Vehicle { 
    // Bike allows further inheritance
}
```

---

### **Key Points:**
1. **Sealed Classes Use the `sealed` Keyword.**  
   - Example: `sealed class Vehicle permits Car, Bike {}`

2. **Must Specify Permitted Subclasses Using `permits`.**  
   - Example: `permits Car, Bike` ensures only these classes can extend `Vehicle`.

3. **Subclasses Must Declare Their Nature:**  
   Each permitted subclass **must be one of the following**:
   - `final` → Cannot be extended further.  
   - `sealed` → Further restricts extension to specific subclasses.  
   - `non-sealed` → Allows unrestricted extension (acts like a normal class).

4. **Requires `sealed`, `permits`, and Proper Access Modifiers.**  
   - The permitted subclasses **must be in the same package** or **module**.

---

### **Example with Sealed, Final, and Non-Sealed Classes**

```java
sealed class Animal permits Dog, Cat { } // Only Dog and Cat can extend Animal

final class Dog extends Animal { } // No further extension allowed

non-sealed class Cat extends Animal { } // Cat can be extended freely

class PersianCat extends Cat { } // Allowed because Cat is non-sealed
```

---

### **Advantages of Sealed Classes**
✅ **More Secure** – Prevents unwanted inheritance.  
✅ **Better Code Maintainability** – Controls hierarchy explicitly.  
✅ **Improves Pattern Matching** – Works well with `switch` expressions in Java 17+.

---

### **When to Use?**
Use **sealed classes** when:
- You want to **restrict** subclassing to specific classes.
- You are designing a **controlled hierarchy** (like `sealed` enums in other languages).
- You need **better pattern matching** support in `switch`.

---

### **Sealed Interfaces**
Sealed classes also work with **interfaces**:

```java
sealed interface Shape permits Circle, Rectangle { }

final class Circle implements Shape { }

non-sealed class Rectangle implements Shape { }
```

---

### **Conclusion**
**Sealed classes** in Java allow **controlled inheritance**, improving security and maintainability while enhancing **pattern matching** in `switch` expressions.