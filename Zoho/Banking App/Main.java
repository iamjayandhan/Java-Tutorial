import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static boolean checkCreds(int cID,String pwd,ArrayList<Customer> clist){
        for(Customer c: clist){
            if(c.custid == cID && encrypt(pwd).equals(c.pwd)){
                return true;
            }
        }
        return false;
    }

    private static String encrypt(String pwd){
        String epwd = "";

        for(char ch : pwd.toCharArray()) {
            epwd += ++ch;
        }
        return epwd;
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("Guru",encrypt("guru123"),new Bank(12345,1000));
        Customer c2 = new Customer("Thaya",encrypt("thaya123"),new Bank(12345,1000));
        Customer c3 = new Customer("Jaya",encrypt("jaya123"),new Bank(12345,1000));

        ArrayList<Customer> customers = new ArrayList<>(Arrays.asList(c1, c2, c3));

        boolean loggedin = false;
        int cID;
        String pwd;

        Scanner sc = new Scanner(System.in);

        while (true) { 
            if(loggedin){
                System.out.println("Users:\n1.) " + c1 + "\n" + c2 + "\n" + c3);
                System.out.println("WELCOME USER!\n1.Create Gift Card\n2.TopUP\n3.Transaction History\n4.Block\n5.Logout");
                int choose = sc.nextInt();

                switch(choose){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    default:
                    System.out.println("Enter a valid option!");
                }
            }
            else{
                System.out.println("Enter Customer ID: ");
                cID = sc.nextInt();

                System.out.println("Enter Password: ");
                pwd = sc.next();
                if(checkCreds(cID,pwd,customers)){
                    loggedin = true;
                }
                else{
                    System.out.println("Wrong creds.");
                }
            }
        }
    }
}
