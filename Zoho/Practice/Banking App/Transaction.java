public class Transaction {
    int tID;
    int from;
    int to;
    int bankBalance;
    int cardBalance;
    int amt;


    private static int tIDProvider = 0;

    Transaction(BankCard from,BankCard to,int amt){
        this.tID = ++tIDProvider;
        this.from = from.getBalance();
        this.to = to.getBalance();
        this.amt = amt;
    }
}
