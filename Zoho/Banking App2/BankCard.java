public interface BankCard {
    int getBalance();
    void deposit(int amount);
    boolean withdraw(int amount);
}
