import java.util.*;

public class TicketBooker {
    private static final int MAX_SEATS = 60;
    private static final int MAX_WAITING = 10;

    // Each coach type has confirmed and waiting lists
    Map<String, List<Passenger>> confirmed = new HashMap<>();
    Map<String, Queue<Passenger>> waiting = new HashMap<>();
    Map<String, Integer> seatCounter = new HashMap<>();

    public TicketBooker() {
        confirmed.put("AC", new ArrayList<>());
        confirmed.put("Non-AC", new ArrayList<>());
        confirmed.put("Seater", new ArrayList<>());

        waiting.put("AC", new LinkedList<>());
        waiting.put("Non-AC", new LinkedList<>());
        waiting.put("Seater", new LinkedList<>());

        seatCounter.put("AC", 1);
        seatCounter.put("Non-AC", 1);
        seatCounter.put("Seater", 1);
    }

    // BOOKING
    public void bookTicket(String name, int age, String gender, String coachType) {
        if (!confirmed.containsKey(coachType)) {
            System.out.println("Invalid coach type.");
            return;
        }

        List<Passenger> confList = confirmed.get(coachType);
        Queue<Passenger> waitList = waiting.get(coachType);

        if (confList.size() < MAX_SEATS) {
            Passenger p = new Passenger(name, age, gender, coachType, false, seatCounter.get(coachType));
            confList.add(p);
            seatCounter.put(coachType, seatCounter.get(coachType) + 1);
            System.out.println("Booking Successful! " + p);
        } else if (waitList.size() < MAX_WAITING) {
            Passenger p = new Passenger(name, age, gender, coachType, true, waitList.size() + 1);
            waitList.add(p);
            System.out.println("Added to Waiting List: " + p);
        } else {
            System.out.println("No tickets available in " + coachType + " coach.");
        }
    }

    // CANCELLATION
    public void cancelTicket(int passengerId) {
        for (String coach : confirmed.keySet()) {
            List<Passenger> confList = confirmed.get(coach);
            for (Passenger p : confList) {
                if (p.passengerId == passengerId) {
                    confList.remove(p);
                    System.out.println("Cancelled: " + p);

                    // Promote from waiting list if available
                    Queue<Passenger> waitList = waiting.get(coach);
                    if (!waitList.isEmpty()) {
                        Passenger w = waitList.poll();
                        w.isWaiting = false;
                        w.seatNumber = seatCounter.get(coach);
                        confList.add(w);
                        seatCounter.put(coach, seatCounter.get(coach) + 1);
                        System.out.println("Promoted from WL: " + w);

                        // Update WL positions
                        int pos = 1;
                        for (Passenger wp : waitList) {
                            wp.seatNumber = pos++;
                        }
                    }
                    return;
                }
            }
        }
        System.out.println("Passenger ID not found.");
    }

    // AVAILABILITY
    public void printAvailability() {
        for (String coach : confirmed.keySet()) {
            int available = MAX_SEATS - confirmed.get(coach).size();
            int waitingCount = waiting.get(coach).size();
            System.out.println(coach + " Coach -> Available: " + available +
                               " | WL: " + waitingCount + "/" + MAX_WAITING);
        }
    }

    // BOOKED LIST
    public void printBookedTickets() {
        for (String coach : confirmed.keySet()) {
            System.out.println("---- " + coach + " Coach Confirmed ----");
            for (Passenger p : confirmed.get(coach)) {
                System.out.println(p);
            }
            System.out.println("---- " + coach + " Coach WL ----");
            for (Passenger p : waiting.get(coach)) {
                System.out.println(p);
            }
            System.out.println();
        }
    }
}
