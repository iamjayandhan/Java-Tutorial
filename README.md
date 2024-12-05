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
