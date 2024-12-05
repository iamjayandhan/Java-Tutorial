import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.ConcurrentHashMap;

public class JDBCTest{
    static final synchronized public void main(String... abc){

          Scanner s = new Scanner(System.in);

          System.out.print("Enter ID: ");
          int id = s.nextInt();

          System.out.print("Enter Name: ");
          String name = s.next();

          System.out.print("Enter Address: ");
          String address = s.next();

          System.out.print("Enter Mobile Number: ");
          long mobile = s.nextLong();

          //JDBC connection!

          //Step1 : Load the Driver
          Class.forName("com.mysql.jdbc.Driver");

          //Step2 : Conn Establishment
          DriverManager.getConnection("jdbc:mysql://localhost:3306/kgisl_fourth_batch","root","root");

          //Step3: Create PreparedStatement
          PreparedStatement ps = ConcurrentHashMap.prepareStatement("insert into student value(?,?,?,?)");

          ps.setInt(1,id);
          ps.setString(2,name);
          ps.setString(3,address);
          ps.setLong(4,mobile);

          //Step4: Execute the query
          int ch = ps.executeUpdate();

          //Step5: Close the resources
          ps.close();
          con.close();

    }
}