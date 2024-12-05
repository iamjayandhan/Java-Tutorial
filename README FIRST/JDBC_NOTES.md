# JDBC (Java Database Connectivity)

- **JDBC** is a set of APIs used to connect Java applications with databases.
- It allows Java applications to interact with databases via SQL queries.
- There are **5 essential steps** to connect to a database using JDBC.

### 5 Steps to Connect with a Database

1. **Load the Driver**: Load the appropriate JDBC driver class.
2. **Establish Connection**: Create a connection to the database.
3. **Create Statement**: Create a statement object to execute SQL queries.
4. **Execute the Query**: Run the query (e.g., SELECT, INSERT).
5. **Release the Resources**: Close the connection and statement to free up resources.

### Archives in Java

- **JAR (Java Archive)**: A compressed collection of `.class` bytecode files.
- **EAR (Enterprise Archive)**: Contains EJB modules and other enterprise resources.
- **WAR (Web Archive)**: Used for packaging web applications.

### Types of JDBC Drivers (4)

1. **Type 1 Driver** (JDBC-ODBC Bridge Driver): Uses ODBC to connect to the database.
2. **Type 2 Driver** (Native Driver): Uses database-specific libraries to communicate.
3. **Type 3 Driver** (Middleware Driver): Uses a middle-tier server to connect to the database.
4. **Type 4 Driver** (100% Java Driver): Directly connects to the database using Java.

### Default Database Credentials
- **MySQL**:
  - Default user ID and password: `root`
- **Oracle**:
  - Default user ID: `scott`
  - Default password: `tiger`
  - Default host string: `orcl`

> **SQL** is **90% database-independent**.

## MySQL Commands
- **Create Database**:
  ```sql
  create database <dbname>;
  ```
- **Use Database**:
  ```sql
  use <dbname>;
  ```
- **Create Table**:
  ```sql
  create table student(
      id int primary key, 
      name varchar(20) not null, 
      address varchar(30), 
      mobile_no bigint
  );
  ```
- **Select Query**:
  ```sql
  select * from student;
  ```

---

### JDBC Connection Example
1. **Load JDBC Driver**:
   - For **Type 1 Driver (MS Access)**:
     ```java
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     ```
   - For **Type 4 Driver (MySQL)**:
     ```java
     Class.forName("com.mysql.jdbc.Driver");
     ```
   - For **MySQL 8**:
     ```java
     Class.forName("com.mysql.oracle.odbc.Driver");
     ```

2. **Establish Connection**:
   ```java
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kgisl", "root", "root");
   ```

3. **Create Prepared Statement**:
   ```java
   PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?)");
   ps.setInt(1, id); // Set value for the first placeholder
   ```

4. **Execute the Query**:
   ```java
   int ch = ps.executeUpdate(); // Executes the insert query
   ```

5. **Release Resources**:
   ```java
   ps.close();
   con.close();
   ```

---

## Ways to Import a Class
1. **Import a specific class**:
   ```java
   import java.util.Scanner;
   ```
2. **Import entire library**:
   ```java
   import java.util.*;
   ```
   - This doesn't import the code itself; it just refers to the library.
3. **Use the fully qualified name**:
   ```java
   java.util.Scanner sc = new java.util.Scanner(System.in);
   ```
4. **Static Import**:
   - Imports static methods from a class without specifying the class name.
   - Example:
     ```java
     import static java.lang.Math.max;
     ```
   - Or, to import all static methods:
     ```java
     import static java.lang.Math.*;
     ```

---

### Difference Between `include` and `import`
- **`include`**:
  - Includes all code from the header files, making the program heavier.
  - Used in C/C++.
  
- **`import`**:
  - Refers to a library or class and allows its usage without including its full code.
  - Used in Java.

---

## Ways to Get Input from the Console
1. **Command Line Arguments**: 
   - Arguments passed at the time of running the program.
2. **Scanner Class**:
   - For reading input from the user.
   ```java
   Scanner sc = new Scanner(System.in);
   ```
3. **BufferedReader**: 
   - For reading input efficiently, especially for large inputs.
4. **Console Class**:
   - Useful for getting input in a command-line interface.
