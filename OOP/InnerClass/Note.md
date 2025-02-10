### **Knowledge from InnerClass2.java**
**`A.B objB`** might seem confusing at first because `B` is a **non-static inner class**.

---

### **🚀 Why Do We Use `A.B` Even Though `B` is Non-Static?**
In Java, **nested classes (both static and non-static) are members of their enclosing class**. This means **Java treats inner classes as part of the outer class's namespace**.

Even though `B` is **non-static**, it still **belongs to `A`**, so Java requires us to specify the full path as **`A.B`**.

**💡 General Rule:**
- **Static Inner Class:** `OuterClass.InnerClass obj = new OuterClass.InnerClass();`
- **Non-Static Inner Class:** `OuterClass.InnerClass obj = outerObject.new InnerClass();`

---

### **🔍 Key Concept: What Does `A.B objB` Mean?**
- **`A.B`** tells Java that `B` is a class inside `A`.
- This is **NOT** about whether `B` is static or not.
- Even though `B` is **non-static**, it is still **defined within `A`**, so Java requires the **outer class name (`A`) as a prefix**.

---

### **🚀 Why Can’t We Just Write `B objB = new B();`?**
❌ **Incorrect Syntax:**
```java
B objB = new B(); // ❌ Compilation Error
```
🚫 **Why?**
- `B` is **not a top-level class**; it is **inside `A`**.
- Java cannot recognize `B` directly **outside of `A`**.

---

### **✔ Correct Syntax for Non-Static Inner Class**
```java
A obj = new A(); // Create instance of A first
A.B objB = obj.new B(); // Use obj to create B
objB.config(); // Works ✅
```
✔ **Why Does This Work?**
- **`A.B`** tells Java we are referring to class `B` inside `A`.
- **`obj.new B()`** creates an instance of `B` using an `A` object.

---

### **🛠 Example to Demonstrate Why We Need `A.B`**
```java
class A {
    class B {
        public void display() {
            System.out.println("Inside B");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        A obj = new A();
        // B objB = new B(); // ❌ Error: Cannot resolve class B
        A.B objB = obj.new B(); // ✅ Correct way
        objB.display(); // Output: Inside B
    }
}
```
---

### **🔥 Summary**
| Inner Class Type | Syntax for Reference (`ref objB`) | Syntax for Object Creation |
|-----------------|---------------------------------|-----------------------------|
| **Non-Static Inner Class** (`B`) | `A.B objB` | `A obj = new A(); A.B objB = obj.new B();` |
| **Static Inner Class** (`C`) | `A.C objC` | `A.C objC = new A.C();` |

So, **even though `B` is non-static, Java still needs `A.B` because `B` is a member of `A`'s namespace**. 🚀