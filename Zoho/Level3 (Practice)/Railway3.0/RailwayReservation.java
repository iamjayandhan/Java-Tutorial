import java.util.*;

public class RailwayReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBooker booker = new TicketBooker();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Available Tickets");
            System.out.println("4. Print Booked Tickets");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input! Please enter a number between 1-5.");
                sc.nextLine(); // clear buffer
            }
            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter gender (M/F): ");
                    String gender = sc.nextLine();
                    System.out.print("Enter berth preference (L/M/U or Enter for none): ");
                    String pref = sc.nextLine().trim().toUpperCase();
                    Passenger p = new Passenger(name, age, gender, pref);
                    booker.bookTicketWithPreference(p);
                }
                case 2 -> {
                    System.out.print("Enter Passenger ID to cancel: ");
                    int id = sc.nextInt();
                    booker.cancelTicket(id);
                }
                case 3 -> booker.printAvailable();
                case 4 -> booker.printPassengers();
                case 5 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}