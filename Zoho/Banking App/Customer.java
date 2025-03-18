import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    String name;
    int custid;
    String pwd;
    ArrayList<GiftCard> gCards;
    Bank bank;


    static int customerId = 0;

    Customer(String name,String pwd,Bank bank){
        this.name = name;
        this.pwd = pwd;
        this.bank = bank;
        custid = ++customerId; 
        gCards = new ArrayList<GiftCard>();
    }

    public String toString() {
        return this.name + " " + this.custid+ " " + this.pwd;
    }
}
