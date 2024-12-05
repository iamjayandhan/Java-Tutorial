import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCTest{
    static final synchronized public void main(String... abc) throws Exception{

        //Take value from console
        Scanner s = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int id = s.nextInt();

        System.out.print("Enter Name: ");
        String name = s.next();

        s.nextLine();

        System.out.print("Enter Address: ");
        String address = s.nextLine();

        System.out.print("Enter Mobile Number: ");
        long mobile = s.nextLong();

        //JDBC connection!

        //Step0 : Import Packages
        //Step1 : Load the Driver 
        // Class.forName("com.mysql.jdbc.Driver"); // outdated!
        Class.forName("com.mysql.cj.jdbc.Driver"); // Latest!


        //Step2 : Conn Establishment
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kgisl_fourth_batch","root","killer");

        //Step3: Create PreparedStatement
        PreparedStatement ps = con.prepareStatement("insert into student value(?,?,?,?)");

        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setString(3,address);
        ps.setLong(4,mobile);

        //Step4: Execute the query
        int ch = ps.executeUpdate();

        System.out.println(ch+" rows(s) affected");

        //Step5: Release the resources
        ps.close();
        con.close();
    }
}