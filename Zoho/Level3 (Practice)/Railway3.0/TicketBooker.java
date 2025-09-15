import java.util.*;

class TicketBooker {

    // Capacities
    static int TOTAL_LOWER = 1, TOTAL_MIDDLE = 1, TOTAL_UPPER = 1; // 21
    static int TOTAL_RAC = 1, TOTAL_WL = 1; //18 10

    // Availability counters
    public static int availableLowerBerths = TOTAL_LOWER;
    public static int availableMiddleBerths = TOTAL_MIDDLE;
    public static int availableUpperBerths = TOTAL_UPPER;
    public static int availableRAC = TOTAL_RAC;
    public static int availableWL = TOTAL_WL;

    // Position lists (Available seats)
    public static List<String> lowerPositions = new ArrayList<>();
    public static List<String> middlePositions = new ArrayList<>();
    public static List<String> upperPositions = new ArrayList<>();
    public static List<String> racPositions = new ArrayList<>();
    public static List<String> wlPositions = new ArrayList<>();

    // Data stores (Master Records)
    static Map<Integer, Passenger> passengers = new LinkedHashMap<>(); //store all booked passenger with their id.
    static List<Integer> bookedList = new ArrayList<>();
    static Queue<Integer> racList = new LinkedList<>();
    static Queue<Integer> wlList = new LinkedList<>();

    // Initialize seat positions
    static {
        for (int i = 1; i <= TOTAL_LOWER; i++) lowerPositions.add("L" + i);
        for (int i = 1; i <= TOTAL_MIDDLE; i++) middlePositions.add("M" + i);
        for (int i = 1; i <= TOTAL_UPPER; i++) upperPositions.add("U" + i);
        for (int i = 1; i <= TOTAL_RAC; i++) racPositions.add("SL" + i); // Side-Lower for RAC
        for (int i = 1; i <= TOTAL_WL; i++) wlPositions.add("WL" + i);
    }

    /**
     * Book a ticket for passenger 'p' with preference and rules
     */
    public void bookTicketWithPreference(Passenger p) {
        // Rule: No seat allocation for children below 5
        if (p.age < 5) {
            //create entry
            //first create map entry either valid or for a child.
            passengers.put(p.passengerId, p);
            System.out.println("Passenger " + p.name + " is below 5 years old. No seat allotted.");
            return;
        }

        // Rule: Senior citizen (>60) or female with child -> allocate Lower if available
        if ((p.age > 60 || p.gender.equalsIgnoreCase("F")) && availableLowerBerths > 0) {
            allocateConfirmedToPassenger(p, lowerPositions.get(0), "L");
            return;
        }

        // Rule: Try preferred berth
        if ("L".equals(p.preference) && availableLowerBerths > 0) {
            allocateConfirmedToPassenger(p, lowerPositions.get(0), "L");
            return;
        } else if ("M".equals(p.preference) && availableMiddleBerths > 0) {
            allocateConfirmedToPassenger(p, middlePositions.get(0), "M");
            return;
        } else if ("U".equals(p.preference) && availableUpperBerths > 0) {
            allocateConfirmedToPassenger(p, upperPositions.get(0), "U");
            return;
        }

        // No preference or not available -> any berth
        if (availableLowerBerths > 0) {
            allocateConfirmedToPassenger(p, lowerPositions.get(0), "L");
            return;
        } else if (availableMiddleBerths > 0) {
            allocateConfirmedToPassenger(p, middlePositions.get(0), "M");
            return;
        } else if (availableUpperBerths > 0) {
            allocateConfirmedToPassenger(p, upperPositions.get(0), "U");
            return;
        }

        // Else allocate RAC (side-lower only)
        if (availableRAC > 0) {
            allocateRACToPassenger(p, racPositions.get(0));
            return;
        }

        // Else allocate WL
        if (availableWL > 0) {
            allocateWLToPassenger(p, wlPositions.get(0));
            return;
        }

        // All full
        System.out.println("No tickets available!");
    }

    /* ------------------ Allocation helpers ------------------ */

    private void allocateConfirmedToPassenger(Passenger p, String seatNum, String berthType) {
        p.seatNumber = seatNum;
        p.allotted = berthType;

        //first create map entry
        passengers.put(p.passengerId, p);
        //create pointer in book list
        bookedList.add(p.passengerId);

        if ("L".equals(berthType)) {
            lowerPositions.remove(seatNum);
            availableLowerBerths--;
        } else if ("M".equals(berthType)) {
            middlePositions.remove(seatNum);
            availableMiddleBerths--;
        } else if ("U".equals(berthType)) {
            upperPositions.remove(seatNum);
            availableUpperBerths--;
        }

        System.out.println("Booked: " + p.name + " | Seat: " + seatNum + " (" + berthType + ")");
    }

    private void allocateRACToPassenger(Passenger p, String seatNum) {
        p.seatNumber = seatNum;
        p.allotted = "RAC";

        //create map entry
        passengers.put(p.passengerId, p);
        //instead of booklist , we use queuee
        racList.add(p.passengerId);

        //remove seat & availability
        racPositions.remove(seatNum);
        availableRAC--;
        System.out.println("RAC: " + p.name + " | Seat: " + seatNum);
    }

    private void allocateWLToPassenger(Passenger p, String seatNum) {
        p.seatNumber = seatNum;
        p.allotted = "WL";

        //create map and queue entry
        passengers.put(p.passengerId, p);
        wlList.add(p.passengerId);

        //remove pos from queue pos list and availability.
        wlPositions.remove(seatNum);
        availableWL--;
        System.out.println("Waiting List: " + p.name + " | Position: " + seatNum);
    }

    /* ------------------ Cancellation & promotion ------------------ */

    public void cancelTicket(int passengerId) {
        if (!passengers.containsKey(passengerId)) {
            System.out.println("Passenger not found!");
            return;
        }

        Passenger p = passengers.get(passengerId);
        String status = p.allotted; //get the berth info allocated
        passengers.remove(passengerId); //remove from map

        if ("L".equals(status)) {
            lowerPositions.add(p.seatNumber); //inc position count first 
            availableLowerBerths++; //increase availability
        } else if ("M".equals(status)) {
            middlePositions.add(p.seatNumber);
            availableMiddleBerths++;
        } else if ("U".equals(status)) {
            upperPositions.add(p.seatNumber);
            availableUpperBerths++;
        } else if ("RAC".equals(status)) {
            racList.remove(passengerId);
            racPositions.add(p.seatNumber);
            availableRAC++;
        } else if ("WL".equals(status)) {
            wlList.remove(passengerId);
            wlPositions.add(p.seatNumber);
            availableWL++;
        }

        bookedList.remove(Integer.valueOf(passengerId));

        // Promotion logic
        if ("L".equals(status) || "M".equals(status) || "U".equals(status)) {
            //if L,M,U cancels, then RAc person gets that place!
            if (!racList.isEmpty()) {
                //queue! we get the 
                int racPassengerId = racList.poll(); //get the first person from the poll.(id)
                Passenger racPassenger = passengers.get(racPassengerId); //search inside map for full info.

                //restore RAC seat info and count.
                racPositions.add(racPassenger.seatNumber);
                availableRAC++;
                //re allocate the seat to this rac person.
                allocateConfirmedToPassenger(racPassenger, p.seatNumber, status);

                if (!wlList.isEmpty()) {
                    int wlPassengerId = wlList.poll(); // take the person from wl and move him to rac
                    Passenger wlPassenger = passengers.get(wlPassengerId); // get info from map

                    //restore wl seat details and availability
                    wlPositions.add(wlPassenger.seatNumber);
                    availableWL++;

                    //
                    if (!racPositions.isEmpty()) {
                        allocateRACToPassenger(wlPassenger, racPositions.get(0));
                    }
                }
            }
        }
        System.out.println("Cancelled: Passenger ID " + passengerId);
    }

    /* ------------------ Print helpers ------------------ */

    public void printAvailable() {
        System.out.println("Available Tickets:");
        System.out.println("Lower Berths: " + availableLowerBerths);
        System.out.println("Middle Berths: " + availableMiddleBerths);
        System.out.println("Upper Berths: " + availableUpperBerths);
        System.out.println("RAC: " + availableRAC);
        System.out.println("Waiting List: " + availableWL);
        System.out.println("Total Available: " +
                (availableLowerBerths + availableMiddleBerths + availableUpperBerths + availableRAC + availableWL));
        System.out.println("------------------");
    }

    public void printPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers booked yet!");
            return;
        }
        System.out.println("Booked Passengers:");
        for (Passenger p : passengers.values()) {
            System.out.println("ID: " + p.passengerId + " | Name: " + p.name +
                    " | Age: " + p.age + " | Gender: " + p.gender +
                    " | Seat: " + (p.seatNumber.isEmpty() ? "No seat (child)" : p.seatNumber) +
                    " (" + p.allotted + ")");
        }
        System.out.println("Total Booked: " + passengers.size());
        System.out.println("------------------");
    }
}