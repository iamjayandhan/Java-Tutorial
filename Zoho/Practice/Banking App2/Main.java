import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Guru", "guru123", new Bank(12345, 1000)));
        customers.add(new Customer("Thaya", "thaya123", new Bank(12346, 2000)));
        customers.add(new Customer("Jaya", "jaya123", new Bank(12347, 1500)));

        Scanner sc = new Scanner(System.in);
        Customer loggedInCustomer = null;

        while (true) {
            if (loggedInCustomer != null) {
                System.out.println("Welcome, " + loggedInCustomer + "!");
                System.out.println("1. View Balance\n2. Create Gift Card\n3. Top Up Gift Card\n4. Transfer Funds\n5. Logout");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Bank Balance: " + loggedInCustomer.getBankAccount().getBalance());
                        break;
                    case 2:
                        GiftCard newCard = loggedInCustomer.createGiftCard();
                        System.out.println("Gift Card Created: " + newCard.getBalance());
                        break;
                    case 3:
                        System.out.println("Enter Amount to Top Up:");
                        int amt = sc.nextInt();
                        loggedInCustomer.getBankAccount().withdraw(amt);
                        loggedInCustomer.createGiftCard().deposit(amt);
                        break;
                    case 4:
                        System.out.println("Enter amount to transfer:");
                        int transferAmt = sc.nextInt();
                        new Transaction(loggedInCustomer.getBankAccount(), loggedInCustomer.createGiftCard(), transferAmt);
                        break;
                    case 5:
                        loggedInCustomer = null;
                        break;
                }
            } else {
                System.out.println("Enter Customer ID: ");
                int cID = sc.nextInt();
                System.out.println("Enter Password: ");
                String pwd = sc.next();

                for (Customer c : customers) {
                    if (c.verifyPassword(pwd)) {
                        loggedInCustomer = c;
                        break;
                    }
                }

                if (loggedInCustomer == null) {
                    System.out.println("Invalid Credentials. Try Again.");
                }
            }
        }
    }
}
