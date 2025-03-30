
import java.util.ArrayList;

public class Bank implements BankCard {
    int accountNo;
    int balance;
    ArrayList<Transaction> tsList;

    Bank(int accountNo,int balance){
        this.accountNo = accountNo;
        this.balance = balance;
        this.tsList = new ArrayList<Transaction>();
    }

    public int getBalance(){
        return this.balance;
    }
}
