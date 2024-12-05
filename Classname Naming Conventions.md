# Class naming conventions

## Universal standards

### Recommendation to follow
1. class name should be meaninful
2. class name should be in pascal case
3. class name should be noun
4. If class name is abbreviation, acronym or numeronym than class name should be in upper case
5. It is not recommended to write **$** on classname
### Rules
1. Class name does not contain the white space.
2. Class name must starts with non digit character
3. Class name doesn't have any special character except $ and _.
4. Class name should not be keyword.
5. Class name can contain digits except on first character.
6. If class is public, then **Class name and file name** must be same.
7. The outer class can not be **private or public**.
8. Incase of default class the **file name and class name** can be different.


### Byte Codes
* The number of byte code is directly dependent on number of classes
* If a class is nested inside another class, then it produces two byte code but ont class name is **outerclass.class** and other one is **outerclass$innerclass.class** 
* That's why it is not recommended to add $ to class name

Eg:
```
private class ClassName{

}
or

protected class ClassName{

}
```

# C History
* Traditional C => developed by Dennis Ritchie
* K&R C
* ANSI C => Turbo C
* C99
*     => gcc

# Compilation
source code => compiler => Translated Code

* OS is responsible to execute Translated code. => this is for c and c++
* for perl, pvm is responsible for executing perl code.
* for java => JVM is responsible to execute the program
* The Translated code is called **Byte Code** (.class)
* The name of this byte code file is same as Main class name.
* If only main method present in the Main class, then only jvm will execute the class.
* Otherwise the jvm returns error.
* The class without main method is class **Non-Executable class**.

## Compile and execute with single command
```
java File.java
```
* The byte code will be created on its own memory

## Different ways to declare array
1. String[] arr;
2. String arr[];
3. String [] arr;
4. String []arr;
5. String[]arr;

## Main method Manipulations:
1. public static void main(String args[])
2. public static void main(String babu[])
3. public static void main(String[] babu)
4. public static void main(String [] babu)
5. public static void main(String[]babu)
6. public static void main(String []babu)
7. public static void main(String args) => Compilation ✅ but execution ❌
8. public static void main(int[] args) => Compilation ✅ but execution ❌
9. public static void Main(String[] args) => Compilation ✅ but execution ❌
10. public static Void main(String[] args) => Compilation ❌ but execution ❌
11. public void main(String[] args) => Compilation ✅ but execution ❌
12. static public void main(String[] args) => Compilation ✅ and execution ✅
13. private static void main(String[] args) => Compilation ✅ but execution ❌
14. public static void main(String[] args, int x) => Compilation ✅ but execution ❌ => main only takes single argument with type string.
15. public static void main(String... args) => Compilation ✅ and execution ✅

* Those are **varargs** they are used to create a method that receive any number of arguments.
* varargs => Variable Arguments
* Denoted by only 3 dots
* Introduced in jdk 1.5
* It is internally implemented in the concept of arrays.
* That's why removing String array and passing String varargs is acceptable.

14. public static void main(String..., int a) => Compilation ❌
* vararg parameter must be the last parameter of the method 

15. public static void main(int a, String...)
* We can use normal parameter with vararg parameter but vararg must be in last place.

16. public static void main(int... a, String... args) => Compilation ❌
* We can use only one vararg parameter with one method

17. public static void main(String[][][][][][][][][] args) => => Compilation ✅ but execution ❌
* For multi-dimensional array we only have make dimension of 255
18. public static strictfp void main(String[] args) => => Compilation ✅ but execution ✅ but with only 1 warning

19. public final static void main(String[] args)

20. public final strictfp void main(String[] args)

21. public final strictfp synchronized static void main(String[] args)


## Final 
* final with class => class cannot have children
* final with method => we cannot override
* final with variable => it become constant

---
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


---


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


# Memory Area in Java (5)
1. Heap
2. Stack
3. Method
4. PC register

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
# Equals Operation
* It checks whether the reference is equal or not

# Equals Method
* It checks whether the content is equal or not

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

```
int a = 0123;
System.out.println(a);
```
* java take the octal, convers and provides the decimal value
