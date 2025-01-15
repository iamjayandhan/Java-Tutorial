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

