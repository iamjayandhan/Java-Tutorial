import java.util.Scanner;

public class MainApp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TaxiService service = new TaxiService(4);

        while (true) {
            System.out.println("========== Call Taxi Booking ==========");
            System.out.println("1 -> Book Taxi");
            System.out.println("2 -> Display Taxi Details");
            System.out.println("3 -> Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Customer ID: ");
                int customerId = sc.nextInt();
                System.out.print("Pickup Point (A-F): ");
                char from = sc.next().toUpperCase().charAt(0);
                System.out.print("Drop Point (A-F): ");
                char to = sc.next().toUpperCase().charAt(0);
                System.out.print("Pickup Time: ");
                int pickupTime = sc.nextInt();

                if (from < 'A' || from > 'F' || to < 'A' || to > 'F') {
                    System.out.println("❌ Invalid pickup/drop point. Must be between A and F.\n");
                    continue;
                }

                if (pickupTime < 0) {
                    System.out.println("❌ Pickup time cannot be negative.\n");
                    continue;
                }

                service.bookTaxi(customerId, from, to, pickupTime);

            } else if (choice == 2) {
                service.displayDetails();
            } else if (choice == 3) {
                System.out.println("Exiting... Thank you for using Call Taxi Booking!");
                break;
            } else {
                System.out.println("Invalid choice, try again.\n");
            }
        }
        sc.close();
    }
}
