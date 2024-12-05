# Comments in Java

* Comments are **meta-data** in a program.
* While the code is the data, comments provide information about the code, making them **meta-data**.
* **Compilers** ignore comments and they don't affect the execution of the program.

## Types of Comments in Java
1. **Single-line comments**: Denoted by `//`
2. **Multi-line comments**: Denoted by `/* ... */`
3. **Documentation comments**: Denoted by `/** ... */`

### 1. Single-line Comments
* **Syntax**: `// This is a single-line comment`
* These comments are used for short explanations or notes and don't span multiple lines.
* Never compiles, Never included in docs.
* **Example**:
    ```java
    // This is a simple single-line comment
    int x = 10; // Variable initialization
    ```

### 2. Multi-line Comments
* **Syntax**: `/* This is a multi-line comment */`
* These comments span multiple lines and are useful for providing detailed descriptions.
* Never compiles, Never included in docs.
* **Example**:
    ```java
    /*
    This is a multi-line comment.
    It can span multiple lines without the need to use double slashes.
    */
    int y = 20;
    ```

### 3. Documentation Comments
* **Syntax**: `/** This is a documentation comment */`
* Used for generating documentation with tools like Javadoc.
* These comments can be used to explain the purpose of classes, methods, or fields in detail.
* Javadoc comments are typically used to generate HTML documentation for Java classes.
* Never compiles, but included in docs.

* **Example**:
    ```java
    /**
     * This method calculates the sum of two integers.
     * @param a First integer
     * @param b Second integer
     * @return The sum of a and b
     */
    public int sum(int a, int b) {
        return a + b;
    }
    ```

#### **Javadoc Tool**: The javadoc command can generate HTML, CSS, and JavaScript documentation from these comments.

```java
javac File.java
javadoc File.java
```

# Open Source Technology (Java as an Open Source)

- **Free License**: Java can be installed and used without cost.
- **Free Libraries**: Java provides a wide range of libraries for free.
- **Free Documentation**: Official Java documentation is freely available.

## Types of JDK (Java Development Kit)
1. **OpenJDK**:
   - Open-source version of Java SE.
   - Free to use, modify, and distribute.
   - Suitable for development and personal use.
   
2. **Commercial JDK**:
   - Provided by Oracle.
   - Required for production server use.
   - May have licensing fees for enterprise features (e.g., Java Mission Control).

## Why Java is Open Source
- **Free to Use**: OpenJDK is available at no cost and can be modified.
- **Community Support**: Java has a strong, active open-source community.
- **Wide Adoption**: Java is used widely due to its stability and scalability.
