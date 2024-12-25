class BankAccount{
    private double balance;

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        if(amount>0){
            this.balance += amount;
        }
        else{
            System.out.println("Invalid deposit!");
        }
    }

    public void withdraw(double amount){
        if(amount >0 && amount<=balance){
            this.balance -= amount;
        }
        else{
            System.out.println("Invalid withdraw!");
        }
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        System.out.println("Initial: Bank Balance => "+ acc.getBalance());
        
        //deposit
        acc.deposit(1000);
        System.out.println("After deposit: Bank Balance => "+ acc.getBalance());
        
        //withdraw
        acc.withdraw(500);
        System.out.println("After withdraw: Bank Balance => "+ acc.getBalance());
    }
}
