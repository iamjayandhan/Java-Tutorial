import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBooker tb = new TicketBooker();

        while (true) {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Check Availability");
            System.out.println("4. Print Booked Tickets");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Coach Type (AC / Non-AC / Seater): ");
                    String coachType = sc.nextLine();

                    tb.bookTicket(name, age, gender, coachType);
                    break;

                case 2:
                    System.out.print("Enter Passenger ID to cancel: ");
                    int id = sc.nextInt();
                    tb.cancelTicket(id);
                    break;

                case 3:
                    tb.printAvailability();
                    break;

                case 4:
                    tb.printBookedTickets();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
