### Abstract Classes

An abstract class is a ==**blueprint for other classes**==. It is a ==**class that cannot be instantiated on its own**== and is designed to be ==**inherited**== **by other classes**. Abstract classes are used to define a **common interface and shared behavior** for all subclasses.

* Contains one or more abstract methods. 
* Method that is declared, but **contains no implementation.**
* **Cannot be used to instantiate objects** and serves only as an interface for other classes to extend. 
* Its role is to provide an appropriate base class from which other classes can **inherit.** 
* Can have both **abstract methods** (method signature,methods without a body) and **concrete methods** (methods with a body).

**Abstract classes are meant to be extended** and have **at least one** abstract method. Abstract methods are declared **without an implementation** (as ==**method declaration ends with a semicolon, not a block**==).

```java
    public abstract class Parent {
        abstract void career(String name);
    }
```

**Pro tip**
  * ==**When a class has abstract method, then the class also should be declared as abstract.**==
  * Abstract classes can have constructors, fields, and methods. They can also have static methods and blocks.


### Why a Class with Abstract Methods Should Be Declared Abstract:
* Incomplete Class: A class with abstract methods is **incomplete** and ==**cannot be instantiated directly,**== as it lacks method implementations.

* Enforcing Implementation:**Declaring the class abstract** ensures that **subclasses must implement** the abstract methods, preventing instantiation of incomplete classes.

* Conceptual Clarity: An abstract class signals that ==**it's intended to be subclassed, not used directly, and requires subclasses to provide specific method implementations.**==

### Thus
  * **Cannot create Object** for Abstract classes.
  * Cannot **create abstract constructors**.
  * Cannot have abstract stuff inside static methods, but abstract class can have static methods.
  * Cannot have final abstract class.(since it restricts inheritance)
  * Cannot inherit multiple class(Multiple inheritance is not allowed for both normal and abstract classes)
  * Can contain normal method.