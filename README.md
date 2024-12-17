# Hello JD!

|  Java (2 Steps)             | Java (1 Step)             | Java + JDBC                     |
|-----------------------|-----------------------|-------------------------------------------|
| 1. `javac FileName.java`<br>2. `java FileName`  | `java FileName.java`       | `java -cp ".;C:\path\to\file.jar" FileName.java` |
|Creates byte code in local storage|Creates byte code in its own memory|Creates byte code in its own memory|

## Connection strings(Explore more!🥳🥳):
### 1. Mysql (My local DB): 
    * DRIVER = com.mysql.cj.jdbc.Driver
    * STRING = jdbc:mysql://localhost:3306/kgisl_fourth_batch","root","😇"
    * CMD = java -cp ".;libs\mysql-connector-j-9.1.0.jar" File.java

### 2. Postgresql (Supabase Online DB):
    * DRIVER = org.postgresql.Driver
    * STRING = jdbc:postgresql://aws-0-ap-south-1.pooler.supabase.com:6543/postgres?user=postgres.yshxqhzwcekhvudlkaju&password=😇
    * CMD = java -cp ".;libs\postgresql-42.7.4.jar" File.java

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