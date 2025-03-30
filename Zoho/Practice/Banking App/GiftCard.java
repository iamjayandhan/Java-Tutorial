import java.util.Random;

public class GiftCard implements BankCard{
    int cardNo;
    int pin;
    int balance;
    boolean status;

    private static int cardNoProvider = 10000;
    
    Random rand = new Random();

    GiftCard(){
        this.cardNo = cardNoProvider++;
        this.pin = rand.nextInt(9000)+1000;
        this.balance = 0;
        this.status = true;
    }

    public int getBalance(){
        return this.balance;
    }
}
