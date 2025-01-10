### Strings

* A string is a ==**sequence of characters**==. 
* Strings are one of the most commonly used data types in Java and are represented by the ==**String class in the java.lang package.**==
* A string in Java is ==**immutable**==, meaning once it is created, its content cannot be changed.
![string](../images/image1.png)

### **Note**
Consider the below code!
```java
    String a = "JD";
    String b = "JD";
```
Both a,b are stored in stack and the String Objects are stored in heap!
does above code ==**makes a,b point to same obj or diff identical objects??**==

### Concepts
### 1. **String Pool**
  * A seperate memory or structure inside heap.
  * **Speciality** : similar string objs are not created! ==**UNIQUE OBJ ONLY**==
  * So from the above ex inside note, both a,b points to same single instance of OBJ "JD" inside string pool.
  * ==**Makes code optimal.**==
  * Srings are immutable due to some security reasons.
  
    ```java
    String a = "JD";
    System.out.println(a);
    a = "iamjayandhan";
    System.out.println(a);
    ```

    This results:
    ```console
    JD
    iamjayandhan
    ```
  * Here reference variable is **made to point newly created obj** "**iamjayandhan**". Now the object "**JD**" has **no ref var** pointing! This obj **"JD" now will be garbage collected.**
  * ==**IF WE MODIFY, WE ACTUALLY CREATE NEW STRING OBJ EVERYTIME!**==

### Why we cant modify string objects?
ex : consider 5 persons a,b,c,d,e has same name "JD"

**a,b,c,d,e -> "JD"**

if one person changes his same, all others name will also gets changed!
so for this reason, java security concerns over strings and behaves like this.

now one person "a" changes his name to "jimmy", now:
**a -> "jimmy"**
**b,c,d,e -> "JD"**

**Thus SECURE😇**

### How to create duplicate objects that has same value?
```java
  String c = new String("JD");
  String d = new String("JD");
```
This way, obj are created outside the string pool.
Thus duplicates are allowed! They will be inside heap, outside pool.


### String Comparisons
1. **== method (Comparator):**
   * Checks if ref vars are pointing to same obj.
2. **.equals():**
   * checks only the values, not ref.
  

### Memery mgmt and garbage collection
src: [Java Memory Management and Garbage Collection in Depth](https://www.youtube.com/watch?v=vz6vSZRuS2M)
