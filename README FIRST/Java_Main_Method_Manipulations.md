# Main Method manipulations and Universal standards

### Class name Recommendations
1. class name should be meaningful.
2. class name should be in pascal case.
3. class name should be noun.
4. If class name is abbreviation, acronym or numeronym than class name should be in upper case.
5. It is not recommended to write **$** on classname

### Rules
1. Class name doesn't have any white space.
2. Class name must starts with non digit character.
3. Class name doesn't have any special character except **$** and **_**.
4. Class name should not be a reserved keyword.
5. Class name can contain digits but after first place.
6. If class is public, then **Class name and file name** must be same.
7. The outer class can not be **private or protected**.
8. If class is not default/public,then  **file name and class name** can be different.


### Byte Codes
* The number of byte code(.class files) is directly dependent on number of classes present inside .java file.
* If a class is nested inside another class, then it produces two byte code:  
  * one is **outerclass.class**
  * another one is **outerclass$innerclass.class**. 
* That's why it is not recommended to add $ to class name

Eg:
```
These are not possible and compiler throws error!
private class ClassName{} (or)
protected class ClassName{}
```


## Note!
- **Traditional C**: Developed by **Dennis Ritchie** in 1972 at Bell Labs for creating the UNIX operating system. It laid the foundation for modern programming languages.
- **K&R C**: Introduced in 1978 by **Brian Kernighan** and **Dennis Ritchie** through their book *"The C Programming Language"*. It established early standards for C programming.
- **ANSI C**: Standardized by the **American National Standards Institute (ANSI)** in 1989. Known as **ANSI C or C89**, it was widely adopted and formed the basis for modern C compilers like Turbo C.
- **C99**: Introduced in 1999 by **ISO/IEC**, this standard added several new features:
  - Inline functions.
  - Variable-length arrays.
  - Data types like `long long int`.
  - New library functions (e.g., `<stdint.h>`).
- **C11**: Introduced in 2011, it focused on improvements in multi-threading, Unicode support, and security.
- **gcc**: The **GNU Compiler Collection** remains one of the most popular compilers for C, supporting multiple standards including C89, C99, C11, and later versions.


# Compilation
* **C Compiler** only translates code, execution is done only by **OS** (.exe file).
* **Java compiler** creates byte code(.class file), **JVM** is responsible to run the byte code.
*  **Perl Compiler** and **PVM** to run perl code.
*  **Process**: source code => compiler => Translated Code
* The Translated code is called **Byte Code** (.class)
* The name of this byte code file is same as Main class name.
* If only main method present in the Main class, then only jvm will execute the class, Otherwise the jvm returns error.
* The class without main method is class **Non-Executable class**.

## Compile and execute with single command
```
javac File.java
java File
```
Usually we take 2 steps to compile and run a java file right?

This file creates a .class (byte code) in local storage and then runs using JVM.
What if there is a way to skip a step of creating and storing .class file?
```
java File.java
```
Now the class file is created in its own memory! not stored anywhere in harddisk or SSD. Single line cmd is enough to make it work🥳🥳🥳

# **Main Method Manipulations**

### **Valid and Executable**
1. `public static void main(String args[])`
2. `public static void main(String[] args)`
3. `public static void main(String [] args)`
4. `public static void main(String[]args)`
5. `public static void main(String []args)`
6. `static public void main(String[] args)` ✅ Compilation and Execution
7. `public static void main(String... args)` ✅ Compilation and Execution  

### **Valid but Non-Executable**
8. `public static void main(String args)` ✅ Compilation ❌ Execution  
9. `public static void main(int[] args)` ✅ Compilation ❌ Execution  
10. `public static Void main(String[] args)` ❌ Compilation ❌ Execution  
11. `public void main(String[] args)` ✅ Compilation ❌ Execution  
12. `private static void main(String[] args)` ✅ Compilation ❌ Execution  
13. `public static void main(String[] args, int x)` ✅ Compilation ❌ Execution  

### **Varargs (Variable Arguments)**
- **Varargs**: Represented with `...` and introduced in JDK 1.5.
- Internally implemented as arrays.  
- Rules:
  1. Vararg must be the last parameter:  
     `public static void main(String..., int a)` ❌ Compilation  
  2. Only one vararg allowed per method:  
     `public static void main(int... a, String... args)` ❌ Compilation  
  3. Combined parameters are allowed, with vararg at the end:  
     `public static void main(int a, String...)` ✅ Compilation  

### **Multi-Dimensional Arrays**
14. `public static void main(String[][][][][][][][][] args)`  
    ✅ Compilation ❌ Execution (Maximum dimension: 255)

### **Modifiers**
15. `public final static void main(String[] args)` ✅  
16. `public final strictfp void main(String[] args)` ✅  
17. `public final strictfp synchronized static void main(String[] args)` ✅  
18. `public static strictfp void main(String[] args)` ✅ Compilation and Execution (with warning)

---

### **Summary**
- **Varargs** simplify variable-length arguments, behaving like arrays.  
- Modifiers like `strictfp`, `final`, and `synchronized` are allowed with the `main` method.  
- Some variations compile but won't execute unless parameters match the standard method signature.



## Final 
* final with class => class cannot have children
* final with method => we cannot override
* final with variable => it become constant, we cannot alter

## Note!
* Operations on Literals are performed by Compiler
```
System.out.println(10+20);
```
* at the time of compilation, 10+20 is changed to 30
```
while(3<2){
    // 10000 lines code
}
```
* The above is not a valid code for compilation
* Because the 3<2 is replaced by false, then the 10000 lines of code will not compiled so unreachable error will be thrown 
---
* Operations on Variables are performed by JVM
* So Compilation works and exec also works.
```
int a=10, b=20;
int sum = a+b;
System.out.println(sum);
```

```
int i = 3;
while(i<2){
    // 10000 lines code
}
```

# For loop

### Syntax
```
for(statement 1; condition; update statement){
    code;
}
```

```
int i = 0;
for(System.out.println("Start") ; i<5; System.out.println("End")){
    i += 1;
}
```
* The above code is valid code for compilation and execution


```
for(int i=0,j=0,k=0; i<j && j<k; i++,j++,k++){
    // code
}
```
* The above code is valid code for compilation and execution

```
for(;;){
    //code
}
```
* The above code is valid code for compilation and execution
* This for loop is called **Infinite For loop**

# **Memory Area in Java (5)**
### 1. **Heap**
   - Stores objects and class instances.
   - Managed by Garbage Collector.
   - Shared across threads; divided into Young Gen, Old Gen, and Metaspace.

### 2. **Stack**
   - Thread-specific; stores local variables and method call details.
   - Follows LIFO order; memory deallocated on method exit.

### 3. **Method Area**
   - Stores class-level data (e.g., static variables, bytecode).
   - Part of Metaspace (Java 8+); shared across threads.

### 4. **PC Register**
   - Thread-specific; tracks the current executing instruction.

### 5. **Native Method Stack**
   - Handles calls to native methods (e.g., C/C++ libraries).

### **Summary**
- Heap: Shared object storage.  
- Stack: Fast, thread-specific, for methods/variables.  
- Garbage Collector reclaims unused heap memory.


## Defining String in java (2)
### By literal
String a = "value";
### By Class
String a  = new String("value");

### Difference
* In heap memory area, the 1/4th is String literal pool and string constant pool
```
String a = "value";
String b = "value";
```
* For the above code only single memory for "value" will be created and a and b will points to same memory
```
String c = new String("value");
String d = new String("value");
```
* For the above code the two individual memory is created
---
**Equals Operation** It checks whether the reference is equal or not

**Equals Method** It checks whether the content is equal or not

```
System.out.println(a==b); // true
System.out.println(b==c); // false
System.out.println(c==d); // false
System.out.println(d==a); // false
```
---
```
System.out.println(a.equals(b)); // true
System.out.println(b.equals(c)); // true
System.out.println(c.equals(d)); // true
System.out.println(d.equals(a)); // true
```

--- 

```
String a = new String("KGISL");
```
* The above statement creates two objects
* One is for "KGISL" inside String() which is a literal
* The JVM creates a **Implicit Variable** of its own in literal memroy
* Then another memory is created for String object


# Representation and Convertion of Number System
## Number System
1. binary - 2
2. octal - 8
3. decimal - 10
4. hexadecimal - 16

## Representation of number system
1. Octal => prefix with 0
2. hexa => prefix with 0x
3. binary => prefix with 0b
4. decimal => no prefix

```
int a = 0123;
System.out.println(a);
```
* java take the octal, converts and provides the decimal value.
