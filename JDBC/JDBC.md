# JDBC
* Connect java with SQL or any DB
* Stands for Java DataBase Connectivity
* It is a set of API used to connect with DB

### 5 steps to connect DB with JAVA
    1. Load the driver (jar - Java Archieve File) compressed col of archieve files
    2. Connection establishment
    3. Create statement
    4. Exec the query
    5. Release the resources

### There are 4 types of Drivers in java:
  1. Type 1 Driver (JDBC - ODBC Bridge driver) 
     - Ms Access - sun.jdbc.odbc.JdbcOdbcDriver
  2. Type 2 Driver (Native Driver)
  3. Type 3 Driver (Middleware Driver)
  4. Type 4 Driver (100% Java Driver)
     - MySQL 5 - com
    - MySQL
    - MYSql    


### Take values from Console
   * Command line
   * Scanner

### System.out.println();
   * System - class in java
   * out - is a pipeline present in system class used to print something in console! similarly in pipleline. Default, pipelines are created in System class...we only use it with System.in
   * println() - print something in stream 


### include vs import?
   * Java is dynamic prog lang!
   * C uses include while python & java doesnt
   * inlcude - includes all code from header file!
   * import - just refers one!

### 4 ways to import class in java
  1. import java.util.LinkedList - only imports single lib
  2. import java.util.* - creates a ref to that lib, doesnt include all code!
  3. import java.util.Scanner s = new java.util.Scanner(System.in) - import using full qualified name
  4. static import never includes a class, but includes static context of a class.

# ORCL
1. Default user_id:pwd = root:root
2. Default user_id of Oracle = scott, pwd = tiger
3. Default Host String = orcl  
4. SQL is 90% DB independent!

# Code
1. create database kgisl_fourth_batch;
2. use kgisl_fourth_batch;
3. create table student