public class Transaction {
    private static int tIDProvider = 1000;
    private int tID;
    private int amount;
    private BankCard from;
    private BankCard to;

    public Transaction(BankCard from, BankCard to, int amount) {
        this.tID = tIDProvider++;
        this.amount = amount;
        this.from = from;
        this.to = to;
        executeTransaction();
    }

    private void executeTransaction() {
        if (from.withdraw(amount)) {
            to.deposit(amount);
            System.out.println("Transaction Successful: " + amount);
        } else {
            System.out.println("Transaction Failed: Insufficient Funds");
        }
    }
}
