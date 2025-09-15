import java.util.*;

class TaxiService {
    private List<Taxi> taxis; // list of taxis
    private int bookingCounter; // counter

    // constructor - pass number of taxis to create!
    public TaxiService(int numTaxis) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= numTaxis; i++) {
            taxis.add(new Taxi(i));
        }
        bookingCounter = 1;
    }

    // calculate the distance between two points!
    // 15km between 2 points!
    private int distance(char a, char b) {
        return Math.abs(a - b) * 15;
    }

    // convert km into fare
    private int calculateFare(int km) {
        if (km <= 5)
            return 100;
        return 100 + (km - 5) * 10;
    }

    // find available taxi or reject request!
    // which taxi is free at that spot and at that time?? we pass pickup & pickup
    // time!
    private Taxi findTaxi(char pickup, int pickupTime) {
        // initially no taxi is selected
        Taxi selected = null;
        // min distance is max initially, will be updated after exec...
        int minDistance = Integer.MAX_VALUE;

        // check if the taxi is free first, then we can check for distance!
        for (Taxi taxi : taxis) {
            if (taxi.getFreeTime() <= pickupTime) {
                // taxi is free!
                // how far it is?
                int dist = distance(taxi.getCurrentPoint(), pickup);
                if (dist < minDistance) {
                    minDistance = dist;
                    selected = taxi;
                }
                // we have another free driver at same distance!
                // now we check for total earnings!
                else if (dist == minDistance) {
                    // choose taxi with lesser earnings if tie
                    if (taxi.getTotalEarnings() < selected.getTotalEarnings()) {
                        selected = taxi;
                    }
                }
            }
        }
        return selected;
    }

    // we got customer , from , to and when to pick up!
    public void bookTaxi(int customerId, char from, char to, int pickupTime) {
        //first we find taxi
        Taxi taxi = findTaxi(from, pickupTime);

        //no taxi available!
        if (taxi == null) {
            System.out.println("No taxi can be allotted.\n");
            return;
        }

        //calc distance & fare
        int km = distance(from, to);
        int amount = calculateFare(km);

        int travelTime = km/15; // 1hr
        int dropTime = pickupTime + travelTime;

        Booking booking = new Booking(bookingCounter++, customerId, from, to, pickupTime, dropTime, amount);
        taxi.addBooking(booking, dropTime,to, amount);

        System.out.println("Taxi can be allotted.");
        System.out.printf("Booking Confirmed → Taxi-%d allotted to Customer-%d (%c → %c, Pickup: %d, Drop: %d, Fare: Rs.%d)%n%n",
                taxi.getId(), customerId, from, to, pickupTime, dropTime, amount);


    }

     public void displayDetails() {
        for (Taxi t : taxis) {
            t.printDetails();
        }
    }
}
