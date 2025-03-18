import java.util.Random;

public class GiftCard implements BankCard {
    private int cardNo;
    private int pin;
    private int balance;
    private boolean isBlocked;
    private static int cardNoProvider = 10000;
    private static Random rand = new Random();

    public GiftCard() {
        this.cardNo = cardNoProvider++;
        this.pin = rand.nextInt(9000) + 1000;
        this.balance = 0;
        this.isBlocked = false;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (!isBlocked && amount > 0) {
            this.balance += amount;
            System.out.println("GiftCard " + cardNo + " recharged with " + amount);
        }
    }

    public boolean withdraw(int amount) {
        if (!isBlocked && amount > 0 && amount <= balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void blockCard() {
        isBlocked = true;
        System.out.println("GiftCard " + cardNo + " is blocked.");
    }
}
