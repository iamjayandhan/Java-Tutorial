import java.util.ArrayList;

public class Bank implements BankCard {
    private int accountNo;
    private int balance;
    private ArrayList<Transaction> tsList;

    public Bank(int accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.tsList = new ArrayList<>();
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount + ". New Balance: " + balance);
            return true;
        }
        return false;
    }
}
