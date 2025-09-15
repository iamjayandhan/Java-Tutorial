/**
 * Main class with menu-driven booking system.
 */
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBooker booker = new TicketBooker();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Available Tickets");
            System.out.println("4. Booked / RAC / WL Passengers");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Please enter a valid integer choice.");
                sc.nextLine(); // clear
                continue;
            }

            switch (choice) {
                case 1 -> {
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) name = "Anonymous";
                    System.out.print("Enter age: ");
                    int age;
                    try {
                        age = sc.nextInt();
                    } catch (InputMismatchException ime) {
                        System.out.println("Invalid age. Booking aborted.");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine(); // consume newline
                    System.out.print("Enter berth preference (L/M/U) or press Enter for no preference: ");
                    String prefInput = sc.nextLine().trim().toUpperCase();
                    String pref = "";
                    if (prefInput.equals("L") || prefInput.equals("M") || prefInput.equals("U")) {
                        pref = prefInput;
                    }

                    Passenger p = new Passenger(name, age, pref);
                    booker.bookTicketWithPreference(p, pref);
                }

                case 2 -> {
                    System.out.print("Enter Passenger ID to cancel: ");
                    int id;
                    try {
                        id = sc.nextInt();
                    } catch (InputMismatchException ime) {
                        System.out.println("Invalid ID.");
                        sc.nextLine();
                        break;
                    }
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
