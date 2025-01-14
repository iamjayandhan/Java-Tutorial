### Interfaces

An interface in Java is a **blueprint of a class** that **contains abstract methods and constants.** It is used to achieve ==**abstraction and multiple inheritance in Java.**==

* Cannot create objects
* Can have static stuffs(Does not depends on objects).
* **Variables** are **static** and **final** in interfaces.
* **Methods** in Interfaces Are **public by Default**
* Similar to abstract class but multiple inheritance is possible.
* Abstract class can provide implementation of interface but vice versa is not possible.
* Interface can extend another interface.
* Not suitable for performance critical code!

### Extending Interfaces
Interface <- Interface => extends
Interface <- Class => implements
Abstract <- Class => extends

### Annotations
Annotations are **metadata (data about data)** that provide additional information to the **compiler, JVM, or tools** during runtime or compile-time.

They do not change the behavior of the code directly but can **influence** **how the code** is processed.

### Examples of Common Annotations:

1. **@Override**: Indicates that a ==**method overrides a method in a superclass**== or interface.
2. **@Deprecated**: Marks a method or class as ==**outdated**==.
3. **@FunctionalInterface**: Ensures that an interface is a functional interface ==**(an interface with exactly one abstract method).**==
4. **@SuppressWarnings**: Suppresses specific ==**warnings during compilation.**==

**Note**
* Annotations are public interfaces!
* Static methods cannot be inherited or overridden. So if we need static method in Interface, then it must have body declared!
* Thus, ==**static interface methods must have body!**==
* Static methods can be called via interface name inside Main!

==**Pro Tip**==
When **overriding** a method, you can **only change the body** (behavior). The ==**access modifier must remain the same or become more permissive to ensure**== that the method can still be accessed as expected by the parent class or interface.

```java
    interface Shape {
        //Methods in Interfaces Are public by Default
        void draw(); // Implicitly public, not default!
    }

    class Circle implements Shape {
        @Override
        public void draw() { // Must be public
            System.out.println("Drawing a circle");
        }
        // void draw() { //Error: attempting to assign weaker access privileges
        //     System.out.println("Drawing a circle");
        // }
    }

    public class Main {
        public static void main(String[] args) {
            Shape shape = new Circle();
            shape.draw(); // Works fine
        }
    }

//inc in scope should be applied for overridden method!
//if less is given, then error as we seen before!
```

**Note**
* for nested interfaces, **top level interface must be declared as public or default(no modifier).**
* rest can have **private or protected** if needed.