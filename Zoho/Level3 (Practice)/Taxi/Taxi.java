import java.util.*;

class Taxi {
    private int id;
    private char currentPoint;
    private int freeTime;
    private int totalEarnings;
    private List<Booking> bookings;

    public Taxi(int id) {
        this.id = id;
        this.currentPoint = 'A';
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public char getCurrentPoint() {
        return currentPoint;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void addBooking(Booking b, int dropTime, char dropPoint, int amount) {
        bookings.add(b);
        this.currentPoint = dropPoint;
        this.freeTime = dropTime;
        this.totalEarnings += amount;
    }

    public void printDetails() {
        System.out.println("Taxi-" + id + "    Total Earnings: Rs. " + totalEarnings);

        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.\n");
            return;
        }

        System.out.printf("%-10s %-12s %-6s %-6s %-12s %-10s %-8s%n",
                "BookingID", "CustomerID", "From", "To", "Pickup", "Drop", "Amount");
        System.out.println("-------------------------------------------------------------------");

        for (Booking b : bookings) {
            System.out.println(b);
        }
        System.out.println();
    }

}
