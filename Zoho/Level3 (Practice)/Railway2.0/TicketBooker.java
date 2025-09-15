/**
 * TicketBooker manages allocations, RAC, WL and cancellations.
 */
import java.util.*;

class TicketBooker {

    // Capacities (you can change these)
    static int TOTAL_LOWER = 1, TOTAL_MIDDLE = 1, TOTAL_UPPER = 1;
    static int TOTAL_RAC = 1, TOTAL_WL = 1;

    // Availability counters
    public static int availableLowerBerths = TOTAL_LOWER;
    public static int availableMiddleBerths = TOTAL_MIDDLE;
    public static int availableUpperBerths = TOTAL_UPPER;
    public static int availableRAC = TOTAL_RAC;
    public static int availableWL = TOTAL_WL;

    // Position lists (seat numbers within each pool start at 1)
    public static List<Integer> lowerPositions = new ArrayList<>();
    public static List<Integer> middlePositions = new ArrayList<>();
    public static List<Integer> upperPositions = new ArrayList<>();
    public static List<Integer> racPositions = new ArrayList<>();
    public static List<Integer> wlPositions = new ArrayList<>();

    // Data stores
    static Map<Integer, Passenger> passengers = new LinkedHashMap<>(); // id -> Passenger
    static Queue<Integer> racList = new LinkedList<>(); // passengerIds in RAC
    static Queue<Integer> wlList = new LinkedList<>();  // passengerIds in WL
    static List<Integer> bookedList = new ArrayList<>(); // confirmed passengerIds

    // Initialize seat positions
    static {
        for (int i = 1; i <= TOTAL_LOWER; i++) lowerPositions.add(i);
        for (int i = 1; i <= TOTAL_MIDDLE; i++) middlePositions.add(i);
        for (int i = 1; i <= TOTAL_UPPER; i++) upperPositions.add(i);
        for (int i = 1; i <= TOTAL_RAC; i++) racPositions.add(i);
        for (int i = 1; i <= TOTAL_WL; i++) wlPositions.add(i);
    }

    /**
     * Book a ticket for passenger 'p' trying to respect 'pref' (L/M/U).
     * If preferred berth unavailable, assigns other confirmed berth if available.
     * Else tries RAC, else WL, else reports full.
     */
    public void bookTicketWithPreference(Passenger p, String pref) {
        // try preferred
        if ("L".equals(pref) && availableLowerBerths > 0) {
            int seat = lowerPositions.get(0);
            allocateConfirmedToPassenger(p, seat, "L");
            return;
        } else if ("M".equals(pref) && availableMiddleBerths > 0) {
            int seat = middlePositions.get(0);
            allocateConfirmedToPassenger(p, seat, "M");
            return;
        } else if ("U".equals(pref) && availableUpperBerths > 0) {
            int seat = upperPositions.get(0);
            allocateConfirmedToPassenger(p, seat, "U");
            return;
        }

        // preference not available or no preference -> try any confirmed berth
        if (availableLowerBerths > 0) {
            int seat = lowerPositions.get(0);
            allocateConfirmedToPassenger(p, seat, "L");
            return;
        } else if (availableMiddleBerths > 0) {
            int seat = middlePositions.get(0);
            allocateConfirmedToPassenger(p, seat, "M");
            return;
        } else if (availableUpperBerths > 0) {
            int seat = upperPositions.get(0);
            allocateConfirmedToPassenger(p, seat, "U");
            return;
        }

        // No confirmed seats -> RAC
        if (availableRAC > 0) {
            int seat = racPositions.get(0);
            allocateRACToPassenger(p, seat);
            return;
        }

        // No RAC -> WL
        if (availableWL > 0) {
            int seat = wlPositions.get(0);
            allocateWLToPassenger(p, seat);
            return;
        }

        // All full
        System.out.println("No tickets available!");
    }

    /* ------------------ Allocation helpers ------------------ */

    // Allocates a confirmed berth to a passenger (L/M/U).
    private void allocateConfirmedToPassenger(Passenger p, int seatNum, String berthType) {
        p.seatNumber = seatNum;
        p.allotted = berthType;
        passengers.put(p.passengerId, p);
        bookedList.add(p.passengerId);

        if ("L".equals(berthType)) {
            lowerPositions.remove(Integer.valueOf(seatNum));
            availableLowerBerths--;
        } else if ("M".equals(berthType)) {
            middlePositions.remove(Integer.valueOf(seatNum));
            availableMiddleBerths--;
        } else if ("U".equals(berthType)) {
            upperPositions.remove(Integer.valueOf(seatNum));
            availableUpperBerths--;
        }

        System.out.println("------------------Booked Successfully: " + p.name + " | Seat: " + seatNum + " (" + berthType + ")");
    }

    // Allocates a RAC slot to a passenger
    private void allocateRACToPassenger(Passenger p, int seatNum) {
        p.seatNumber = seatNum;
        p.allotted = "RAC";
        passengers.put(p.passengerId, p);
        racList.add(p.passengerId);
        racPositions.remove(Integer.valueOf(seatNum));
        availableRAC--;
        System.out.println("------------------Added to RAC: " + p.name + " | RAC Seat: " + seatNum);
    }

    // Allocates a WL slot to a passenger
    private void allocateWLToPassenger(Passenger p, int seatNum) {
        p.seatNumber = seatNum;
        p.allotted = "WL";
        passengers.put(p.passengerId, p);
        wlList.add(p.passengerId);
        wlPositions.remove(Integer.valueOf(seatNum));
        availableWL--;
        System.out.println("------------------Added to Waiting List: " + p.name + " | WL Position: " + seatNum);
    }

    /* ------------------ Cancellation & promotion logic ------------------ */

    public void cancelTicket(int passengerId) {
        if (!passengers.containsKey(passengerId)) {
            System.out.println("Passenger not found!");
            return;
        }

        Passenger p = passengers.get(passengerId);
        String status = p.allotted;

        // Remove the passenger record from the main map (we'll re-add promoted ones)
        passengers.remove(passengerId);

        if ("L".equals(status) || "M".equals(status) || "U".equals(status)) {
            // Confirmed berth cancellation
            bookedList.remove(Integer.valueOf(passengerId));

            // Free the berth
            if ("L".equals(status)) {
                lowerPositions.add(p.seatNumber);
                availableLowerBerths++;
            } else if ("M".equals(status)) {
                middlePositions.add(p.seatNumber);
                availableMiddleBerths++;
            } else {
                upperPositions.add(p.seatNumber);
                availableUpperBerths++;
            }

            // If RAC exists, promote head of RAC to this freed berth
            if (!racList.isEmpty()) {
                int racPassengerId = racList.poll(); // remove head of RAC
                Passenger racPassenger = passengers.get(racPassengerId);

                if (racPassenger != null) {
                    // Free RAC slot (we'll reassign)
                    racPositions.add(racPassenger.seatNumber);
                    availableRAC++;

                    // Allocate freed confirmed berth to RAC passenger
                    allocateConfirmedToPassenger(racPassenger, p.seatNumber, status);

                    System.out.println("RAC passenger " + racPassenger.name + " moved to confirmed seat " + p.seatNumber);

                    // If WL exists, move head of WL into RAC
                    if (!wlList.isEmpty()) {
                        int wlPassengerId = wlList.poll();
                        Passenger wlPassenger = passengers.get(wlPassengerId);

                        if (wlPassenger != null) {
                            // Free WL slot (we'll reassign)
                            wlPositions.add(wlPassenger.seatNumber);
                            availableWL++;

                            // Assign an available RAC seat to the WL passenger
                            if (!racPositions.isEmpty()) {
                                int racSeat = racPositions.get(0);
                                allocateRACToPassenger(wlPassenger, racSeat);
                                System.out.println("WL passenger " + wlPassenger.name + " moved to RAC seat " + racSeat);
                            } else {
                                // This should not normally happen, but handle gracefully
                                System.out.println("No RAC seat available to move WL passenger into RAC.");
                            }
                        }
                    }
                }
            }

            System.out.println("------------------Cancelled Successfully (confirmed berth)");
            return;
        }

        if ("RAC".equals(status)) {
            // Cancel from RAC: remove from racList and free RAC slot
            racList.remove(Integer.valueOf(passengerId));
            racPositions.add(p.seatNumber);
            availableRAC++;

            // If WL exists -> move WL head to RAC
            if (!wlList.isEmpty()) {
                int wlPassengerId = wlList.poll();
                Passenger wlPassenger = passengers.get(wlPassengerId);

                if (wlPassenger != null) {
                    // Free WL slot
                    wlPositions.add(wlPassenger.seatNumber);
                    availableWL++;

                    // Assign freed RAC seat to WL passenger
                    if (!racPositions.isEmpty()) {
                        int racSeat = racPositions.get(0);
                        allocateRACToPassenger(wlPassenger, racSeat);
                        System.out.println("WL passenger " + wlPassenger.name + " moved to RAC seat " + racSeat);
                    } else {
                        System.out.println("No RAC seat available to move WL passenger into RAC.");
                    }
                }
            }

            System.out.println("------------------Cancelled Successfully (RAC)");
            return;
        }

        if ("WL".equals(status)) {
            // Cancel from WL: remove from wlList and free WL position
            wlList.remove(Integer.valueOf(passengerId));
            wlPositions.add(p.seatNumber);
            availableWL++;
            System.out.println("------------------Cancelled Successfully (WL)");
            return;
        }

        // if status unknown
        System.out.println("------------------Cancelled Successfully");
    }

    /* ------------------ Print helpers ------------------ */

    public void printAvailable() {
        System.out.println("Lower Berths: " + availableLowerBerths);
        System.out.println("Middle Berths: " + availableMiddleBerths);
        System.out.println("Upper Berths: " + availableUpperBerths);
        System.out.println("RAC: " + availableRAC);
        System.out.println("Waiting List: " + availableWL);
        System.out.println("------------------");
    }

    public void printPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers booked yet!");
            return;
        }

        // Sort by passengerId for stable output
        List<Passenger> list = new ArrayList<>(passengers.values());
        list.sort(Comparator.comparingInt(a -> a.passengerId));

        for (Passenger p : list) {
            System.out.println("ID: " + p.passengerId + " | Name: " + p.name +
                    " | Age: " + p.age + " | Seat: " + p.seatNumber + " (" + p.allotted + ")");
        }
        System.out.println("------------------");
    }
}