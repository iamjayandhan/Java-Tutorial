import java.util.ArrayList;

public class Customer {
    private String name;
    private int custId;
    private String password;
    private ArrayList<GiftCard> giftCards;
    private Bank bankAccount;
    private static int customerIdProvider = 1000;

    public Customer(String name, String password, Bank bank) {
        this.name = name;
        this.password = hashPassword(password);
        this.bankAccount = bank;
        this.custId = customerIdProvider++;
        this.giftCards = new ArrayList<>();
    }

    public boolean verifyPassword(String inputPwd) {
        return this.password.equals(hashPassword(inputPwd));
    }

    public GiftCard createGiftCard() {
        GiftCard gc = new GiftCard();
        giftCards.add(gc);
        return gc;
    }

    public Bank getBankAccount() {
        return bankAccount;
    }

    private String hashPassword(String pwd) {
        return Integer.toHexString(pwd.hashCode()); // Simple Hashing (Better than character shifting)
    }

    @Override
    public String toString() {
        return "Customer: " + name + " | ID: " + custId;
    }
}
