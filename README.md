# Hello JD!

|  Java (2 Steps)             | Java (1 Step)             | Java + JDBC                     |
|-----------------------|-----------------------|-------------------------------------------|
| 1. `javac FileName.java`<br>2. `java FileName`  | `java FileName.java`       | `java -cp ".;C:\path\to\file.jar" FileName.java` |
|Creates byte code in local storage|Creates byte code in its own memory|Creates byte code in its own memory|

## Rule of thumb😇
* In general, Java does **not allow** running a .java file directly **if it contains multiple classes** (even if only one of them is public). 
* The **Java runtime tries** to compile and execute the file in a single step, **but since the file contains multiple classes**, it ==**cannot directly determine the entry point (the main method) or handle other class dependencies correctly.**==



### **Lets Dive into it!**

1. **Single-Step Execution (`java FileName.java`)**:
   - This works for simple Java scripts (introduced in Java 11+) with a single file containing a `main` method.
   - It does ==**not work**== for more complex files that **define multiple classes or depend on other files.**

2. **Two-Step Execution (`javac` + `java`)**:
   - **First Step (`javac`)**: ==**Compiles**== all classes and creates `.class` files for each.
   - **Second Step (`java`)**: ==**Runs**== the `main` method of the specified class by referencing the `.class` file.

3. ==**Why Two-Step Execution Is Necessary**== 😇:
   - Java needs `.class` files to manage the dependencies and structure of the program, especially when multiple classes are involved.
   - Directly running a `.java` ==**file doesn't allow**== the runtime to handle dependencies or locate auxiliary classes.

### **Enna tha solla vara?**
- Use **`java FileName.java`** for **simple, single-class programs**.
- Use **`javac FileName.java`** followed by **`java ClassName`** for **multi-class programs** or more complex setups.
- Number of class files == number of class present in the file (No matter wheather it is seperate or nested class!)

### Too many import statements?
replace those with this single line!
```java
   import module java.base.*;
```

### Not sure about the methods in class? No worries(javap on rescue)!
The ==**javap**== command **lists the methods and constructors** of the class that you specify.

1. **List methods of `String` class:**
   ```bash
   javap java.lang.String
   ```
2. **List all methods (including private) of `String`:**
   ```bash
   javap -private java.lang.String
   ```

**For your own file?**
1. **Compile your Java file:**
   ```bash
   javac OutputExercise.java
   ```
2. **List methods of your own class (`OutputExercise`):**
   ```bash
   javap OutputExercise
   ```

## Understanding Java Packages: (Compile and Run):
### Why Compile and Run from the Root Directory in Java?
1. **Packages Require Structure:**
   * The package statement (e.g., package package1;) ==**tells Java to treat the file as part of a named package.**==
   * The ==**JVM expects the .class**== file to be inside a folder named after the package (package1).
2. **JVM Starts at the Root Directory:**
   * The root directory is where the JVM begins looking for packages.
   * **If you’re inside package1 and run the program**, the ==**JVM looks for Class1 in the default package (no package), causing an error.**==
3. **Correct Steps:**
   * Compile: Use the **root directory** to ensure the .class file is saved with the correct package path.
   ```java
   javac package1/Class1.java
   ```
   * Run: **Use the root directory to reference the fully qualified class name:**
   ```java
   java package1.Class1
   ```

**Why Not Run Inside the Package Folder?**
==**Inside package1, you cannot reference package1.Class1 because the JVM doesn’t know it’s in a package.**==

## **Java Collection Hierarchy**
1. **Collection (Interface)** => ==**The root interface of the Java Collection Framework, representing a group of objects (List, Set, Queue).**==

2. **Collections (Class)** => ==**A utility class in java.util that provides static methods (e.g., sorting, searching, synchronization) for working with collections.**==

Below is the hierarchical structure of Java's **Collection Framework**:
```java
// Java Collection Framework - Full Interface & Implementation Hierarchy

Iterable<E>  // Root interface
   ├── Collection<E>  
   │      ├── List<E>  // Ordered, allows duplicates
   │      │      ├── ArrayList<E>       // Dynamic array-based
   │      │      ├── LinkedList<E>      // Doubly linked list
   │      │      ├── Vector<E>          // Synchronized ArrayList
   │      │      ├── Stack<E>           // LIFO stack (extends Vector)
   │      │
   │      ├── Set<E>  // No duplicates
   │      │      ├── HashSet<E>         // Unordered, backed by HashMap
   │      │      ├── LinkedHashSet<E>   // Maintains insertion order
   │      │      ├── TreeSet<E>         // Sorted, backed by TreeMap
   │      │
   │      ├── Queue<E>  // FIFO & Priority-based
   │      │      ├── PriorityQueue<E>   // Heap-based priority queue
   │      │      ├── LinkedList<E>      // Can be used as Queue (Deque)
   │      │      ├── ArrayDeque<E>      // Efficient double-ended queue
   │      │
   │      ├── Deque<E>  // Double-ended queue
   │             ├── LinkedList<E>   // Implements Deque
   │             ├── ArrayDeque<E>   // Faster than Stack
   │
   ├── Map<K, V>  // Key-Value pairs (Has special iterators)
   │      ├── HashMap<K, V>        // Unordered key-value store
   │      ├── LinkedHashMap<K, V>  // Maintains insertion order
   │      ├── TreeMap<K, V>        // Sorted key-value store
   │      ├── WeakHashMap<K, V>    // Keys get garbage collected
   │      ├── ConcurrentHashMap<K, V>  // Thread-safe HashMap
   │      ├── Hashtable<K, V>      // Legacy synchronized map
   │
   ├── Specialized Collections  // Thread-safe & blocking collections
   │      ├── CopyOnWriteArrayList<E>  // Thread-safe ArrayList
   │      ├── CopyOnWriteArraySet<E>   // Thread-safe HashSet
   │      ├── LinkedBlockingQueue<E>   // Blocking queue for concurrency
   │      ├── LinkedBlockingDeque<E>   // Blocking deque (both ends)
   │
   ├── Iterators  // Traversal mechanisms for collections
   │      ├── Iterator<E>        // Used in all Collection<E>
   │      ├── ListIterator<E>    // Used only in List<E> (bi-directional)
   │      ├── Spliterator<E>     // Supports parallel iteration (Java Streams)
   │      ├── Enumeration<E>     // Legacy iterator (Vector, Hashtable)
   │
   ├── Additional Interfaces  // Advanced collections
   │      ├── BlockingQueue<E>     // Queue with thread-safety (Producer-Consumer)
   │      ├── NavigableSet<E>      // Extended Set<E> with navigation methods
   │      ├── NavigableMap<K, V>   // Extended Map<K, V> with navigation methods
   │      ├── ConcurrentMap<K, V>  // Thread-safe Map (like ConcurrentHashMap)
```

## Connection strings(Explore more!🥳🥳):
### 1. Mysql (My local DB): 
    * DRIVER = com.mysql.cj.jdbc.Driver
    * STRING = jdbc:mysql://localhost:3306/kgisl_fourth_batch","root","😇"
    * CMD = java -cp ".;libs\mysql-connector-j-9.1.0.jar" File.java

### 2. Postgresql (Supabase Online DB):
    * DRIVER = org.postgresql.Driver
    * STRING = jdbc:postgresql://aws-0-ap-south-1.pooler.supabase.com:6543/postgres?user=postgres.yshxqhzwcekhvudlkaju&password=😇
    * CMD = java -cp ".;libs\postgresql-42.7.4.jar" File.java
    
### 3. Microsoft Mysql server 2022 (My local DB):
    * DRIVER = com.microsoft.sqlserver.jdbc.SQLServerDriver
    * STRING = Server=localhost\SQLEXPRESS;Database=master;Trusted_Connection=True;
    * CMD = java -cp ".;libs\mssql-jdbc-12.2.0.jre11.jar" File.java

---

### SETUP LOCAL FOR ORACLE JAR (College system)
### 1. Set class path for jar if working in local!
```java
    set classpath=;C:\oracle\product\10.2.0\db_1\install\patches\5923165\files\jdbc\lib\ojdbc14.jar  
    echo %classpath%  
```

### 2. Get System username of Oracle!
```java
C:\oracle\product\10.2.0\db_1\network\Admin\tnsnames.ora
```
Search for **tnsnames**, choose second listed with small letters!
Look for orcl block and copy **Host** name. Use for host name!

```java
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@KITEORACLE38191.kgisledu.com:1521/orcl","scott","tiger");
```
Like this!

---

### Different Flavors of Editions of Java!

#### 1. **Java SE (Standard Edition)**  
- **Purpose**: Core Java platform for basic applications.  
- **What It Includes**: Tools for writing and running Java programs (e.g., JDK, JRE).  
- **Uses**: Desktop apps, simple server apps, command-line tools.  

#### 2. **GraalVM**  
- **Purpose**: A powerful runtime supporting Java and other languages (like Python, JavaScript).  
- **What It Offers**:  
  - Better performance through advanced compilation.  
  - Mix Java with other languages easily (polyglot).  
- **Uses**: Multi-language apps, fast performance apps.  

#### 3. **Java EE (Enterprise Edition)** — Now **Jakarta EE**  
- **Purpose**: Java for big business apps.  
- **What It Includes**: APIs for web apps, databases, and messaging.  
- **Uses**: Scalable enterprise apps, web services, and microservices.  

#### 4. **Java ME (Micro Edition)**  
- **Purpose**: Java for small, resource-limited devices.  
- **What It Includes**: Lightweight tools for tiny devices.  
- **Uses**: Mobile phones, IoT devices, embedded systems.  

#### 5. **JavaFX**  
- **Purpose**: Build rich graphical apps for desktops and more.  
- **What It Offers**:  
  - Modern GUI tools (charts, tables, 3D graphics).  
  - Multimedia and animations.  
- **Uses**: Desktop UIs, multimedia apps.  

### Quick Comparison:
| Edition       | Key Focus                        | Example Uses                     |
|---------------|----------------------------------|-----------------------------------|
| **Java SE**   | Core Java platform               | Desktop tools, small apps        |
| **GraalVM**   | High performance, multi-language | Multi-language apps, faster apps |
| **Java EE**   | Enterprise-level apps            | Web services, large systems      |
| **Java ME**   | Small devices                   | Mobile, IoT, embedded systems    |
| **JavaFX**    | Graphical user interfaces        | Desktop UIs, animations          | 

### Current codespaces on cloud
1. https://github.com/codespaces/
2. https://gitpod.io/workspaces/
