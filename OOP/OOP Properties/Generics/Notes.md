### Generics

Generics is a **powerful feature introduced in Java 5** that allows developers to create **classes, interfaces, and methods** that operate on ==**parameterized types.**==

This enables **type safety and eliminates** the need for **explicit casting** while ==**allowing the code to handle different data types seamlessly.**==

### Example (Without Generics)
The CustomArrayList implementation only works with **integers**, making it **inflexible for other data types**.

```java
    ArrayList<Integer> arr = new ArrayList<>();
    //This implementation only supports int, making it unsuitable for other types such as String, Double, etc.
```

* Generics ensure **type safety** by allowing you to specify the data type a collection can hold, **preventing unintended usage of different types**.
* 

**Check** => CustomArrayList.java

### Example (With Generics)
**Check** => GenericArrayList.java
==**Visit here**== -> [link](https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html)
  * Cannot **Instantiate Generic Types with Primitive Types**
  * Cannot **Create Instances** of Type Parameters
  * Cannot Declare **Static Fields** Whose Types are Type Parameters
  * Cannot **Use Casts or instanceof** With Parameterized Types
  * Cannot **Create Arrays of Parameterized** Types
  * Cannot **Create, Catch, or Throw Objects** of Parameterized Types
  * Cannot **Overload a Method Where the Formal Parameter Types** of Each Overload Erase to the Same Raw Type.

### Add restrictions for a generic class!
```java

import java.util.Arrays;

public class CustArrList2<T> {

    private Object data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustArrList2(){
        this.data = new Object[DEFAULT_SIZE]; 
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        //Object> T (no issues, no need for casting)
        data[size++] = num; 
    } 

    public boolean isFull(){
        return size == data.length;
    }

    public void resize(){
        Object temp[] = new Object[data.length*2];

        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }

        data = temp;
    }

    public T remove(){
        // if(data.length == 0){
        //     System.out.println("List is empty! cannot perform deletion operation!");
        //     return -1;
        // }

        //T < Object
        T removed = (T)data[--size];
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }
 
    public int size(){
        return size;
    }

    public void set(int index, T element){
        data[index] = element;
    }

    @Override
    public String toString(){
        return "CustArrList{"+
            "data="+Arrays.toString(data)+
            ",size="+size+"}";
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList<>();
        CustArrList2<String> list = new CustArrList2<>();

        // list.add(3);
        // list.add(5);
        // list.add(7);
        for(int i=0;i<=10;i++){
            list.add("Roll"+i+"s");
        }
        System.out.println(list);

    }
}

```

To restrict your generic class CustArrList2<T> to only accept number-related types **(like Integer, Double, Float, Long, etc.), you can use bounded type parameters with T extends Number.**

```java
public class CustArrList2<T extends Number>
```

### Why Use T extends Number?
✅ Allows Integer, Double, Float, Long, Short, Byte.
❌ Prevents non-number types like String, Boolean, or Character.

## **🔹 What is `?` in Generics in Simple words?**
Think of `?` as saying **"I don’t know exactly what type this will be."**  

When you use `?`, Java allows different types to fit, but with some rules.

---

### **1️⃣ `?` (Unbounded Wildcard)**
💡 **Use when you don’t care about the type, just want to read data.**  

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```
**✅ Works with:**
```java
printList(List.of(1, 2, 3));       // List of Integers
printList(List.of("A", "B", "C")); // List of Strings
```
🛑 **You CANNOT add new elements**, because Java doesn’t know the exact type.

---

### **2️⃣ `? extends T` (Upper Bound)**
💡 **Use when you only want types that are a subtype of `T` (like Number, Integer, Double, etc.).**  

```java
public void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}
```
**✅ Works with:**
```java
printNumbers(List.of(1, 2, 3));         // List of Integers
printNumbers(List.of(1.1, 2.2, 3.3));   // List of Doubles
```
🛑 **You CANNOT add elements** (except `null`), because Java isn’t sure of the exact type.

---

### **3️⃣ `? super T` (Lower Bound)**
💡 **Use when you want to store `T` or its superclasses (like `Integer` into `Number` or `Object`).**  

```java
public void addNumbers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```
**✅ Works with:**
```java
List<Number> numList = new ArrayList<>();
addNumbers(numList);  // Allowed

List<Object> objList = new ArrayList<>();
addNumbers(objList);  // Allowed
```
🛑 **You CANNOT read elements as `Integer`**, because the list might store `Object`.

---

### **🔹 Simple Analogy**
Think of it like a **container**:

| Wildcard | What it Means | Can Read? | Can Add? |
|----------|--------------|----------|---------|
| `?` | Any type | ✅ Yes (`Object`) | ❌ No |
| `? extends T` | `T` or its subtypes | ✅ Yes (`T`) | ❌ No |
| `? super T` | `T` or its supertypes | ✅ Yes (`Object`) | ✅ Yes (`T`) |

---

### **🔹 When to Use What?**
1. **Use `?`** → If you don’t care about the type, just want to read data.  
2. **Use `? extends T`** → If you only need to read values (like `Number` or `Integer`).  
3. **Use `? super T`** → If you want to add values (like adding `Integer` to a `List<Number>`).  

### **Why is the Type `List<? super Integer>`?**

#### **1. Understanding the Parameter Type**
```java
public static void addNumbers(List<? super Integer> list) {
    list.add(10); // ✅ Allowed
    list.add(20); // ✅ Allowed
}
```
- The method accepts **a list** (`List<? super Integer>`).
- The `? super Integer` means it accepts a list of **Integer or its superclasses** (`Number`, `Object`).
- This ensures that **we can safely add `Integer` values** to the list.

---

### **2. Why Use `List` Instead of Other Collection Types?**
In Java, `List` is part of the **Collection Framework** (`List`, `Set`, `Map`, etc.), but:

✅ **Lists are ordered and allow duplicate elements.**  
✅ **Lists provide indexed access (`get(index)`, `add(index, element)`).**  
✅ **`List<? super Integer>` ensures type safety (only `Integer` values can be added).**  

**Example:**
```java
import java.util.*;

class WildcardExample {
    public static void addNumbers(List<? super Integer> list) {
        list.add(10);  // ✅ Allowed
        list.add(20);  // ✅ Allowed
        // list.add(3.14); // ❌ NOT ALLOWED (Only Integer is safe)
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        addNumbers(intList); // ✅ Allowed
        addNumbers(numList); // ✅ Allowed
        addNumbers(objList); // ✅ Allowed

        System.out.println(intList); // [10, 20]
        System.out.println(numList); // [10, 20]
        System.out.println(objList); // [10, 20]
    }
}
```
---

### **3. Why Not Use `Collection<? super Integer>`?**
While `Collection` is a more general interface that includes `List`, `Set`, and `Queue`, using `List` ensures:
- **Index-based access** (e.g., `list.get(0)`, `list.add(1, 30)`).
- **Ordered elements** (preserves insertion order).
- **Duplicate elements allowed**.

📌 **If you used `Collection<? super Integer>`, you would lose access to methods like `get(index)`**.

---

### **4. Summary**
| Type | Can Add `Integer`? | Can Access by Index? | Allows Duplicates? |
|------|-------------------|---------------------|-------------------|
| `List<? super Integer>` | ✅ Yes | ✅ Yes (`get(index)`) | ✅ Yes |
| `Collection<? super Integer>` | ✅ Yes | ❌ No (`get(index)` unavailable) | ✅ Yes |
| `Set<? super Integer>` | ✅ Yes | ❌ No (`get(index)` unavailable) | ❌ No (No duplicates) |

💡 **Use `List<? super Integer>` when you want to store and access elements with indexing.**

### Thus,
T → Generic type (flexible, user-defined type).
? (Wildcard) → Unknown type (flexible but restricted).
? extends T → Read from subtype (T or its child classes).
? super T → Write to supertype (T or its parent classes).