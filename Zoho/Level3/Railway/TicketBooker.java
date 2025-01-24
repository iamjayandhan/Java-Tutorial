import java.util.*;

public class TicketBooker
{
    //63 berths(upper ,lower , middle)  + ( 18 RAC passengers) 
    //10 waiting list tickets ->21 L, 21 M, 21U , 18RAC, 10WL
    static int availableLowerBerths = 1;//normally 21
    static int availableMiddleBerths = 1;//normally 21
    static int availableUpperBerths = 1;//normally 21
    static int availableRacTickets = 1;//normally 18
    static int availableWaitingList = 1;//normally 10

    static Queue<Integer> waitingList = new LinkedList<>();//queue of WL passengers
    static Queue<Integer> racList =  new LinkedList<>();//queu of RAC passengers
    static List<Integer> bookedTicketList =  new ArrayList<>();//list of bookedticket passengers

    static List<Integer> lowerBerthsPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...21
    static List<Integer> middleBerthsPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...21
    static List<Integer> upperBerthsPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...21
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...18
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));//normally 1,2,...10

    static Map<Integer, Passenger> passengers = new HashMap<>();//map of passenger ids to passengers

    //book ticket
    public void bookTicket(Passenger p, int berthInfo,String allotedBerth)
    {
        //assign the seat number and type of berth(L,U,M)
        p.number = berthInfo;
        p.alloted = allotedBerth;
        // add passenger to the map
        passengers.put(p.passengerId,p);
        //add passenger id to the list of booked tickets
        bookedTicketList.add(p.passengerId);        
        System.out.println("--------------------------Booked Successfully");
    }

    //adding to RAC
    public void addToRAC(Passenger p,int racInfo,String allotedRAC)
    {
        //assign seat number and type(RAC)
        p.number = racInfo;
        p.alloted = allotedRAC;
        // add passenger to the map
        passengers.put(p.passengerId,p);
        //add passenger id to the queue of RAC tickets
        racList.add(p.passengerId);
        //decrease available RAC tickets by 1    
        availableRacTickets--;
        //remove the position that was alloted to the passenger
        racPositions.remove(0);

        System.out.println("--------------------------added to RAC Successfully");
    }

    //adding to WL
    public void addToWaitingList(Passenger p,int waitingListInfo,String allotedWL)
    {
        //assign seat number and type(WL)
        p.number = waitingListInfo; 
        p.alloted = allotedWL;
        // add passenger to the map
        passengers.put(p.passengerId,p);
        //add passenger id to the queue of WL tickets
        waitingList.add(p.passengerId);
        //decrease available WL tickets by 1    
        availableWaitingList--;
        //remove the position that was alloted to the passenger
        waitingListPositions.remove(0);

        System.out.println("-------------------------- added to Waiting List Successfully");
    }

    //cancel ticket
    // public void cancelTicket(int passengerId)
    // {
    //     //remove the passenger from the map
    //     Passenger p = passengers.get(passengerId);
    //     passengers.remove(Integer.valueOf(passengerId));
    //     //remove the booked ticket from the list
    //     bookedTicketList.remove(Integer.valueOf(passengerId));

    //     //take the booked position which is now free
    //     int positionBooked = p.number;

    //     System.out.println("---------------cancelled Successfully");

    //     //add the free position to the correspoding type of list (either L,M,U)
    //     if(p.alloted.equals("L")) 
    //     { 
    //       availableLowerBerths++;
    //       lowerBerthsPositions.add(positionBooked);
    //     }
    //     else if(p.alloted.equals("M"))
    //     { 
    //       availableMiddleBerths++;
    //       middleBerthsPositions.add(positionBooked);
    //     }
    //     else if(p.alloted.equals("U"))
    //     { 
    //       availableUpperBerths++;
    //       upperBerthsPositions.add(positionBooked);
    //     }

    //     //check if any RAC is there
    //     if(racList.size() > 0)
    //     {
    //         //take passenger from RAC and increase the free space in RAC list and increase available RAC tickets
    //         Passenger passengerFromRAC = passengers.get(racList.poll());
    //         int positionRac = passengerFromRAC.number;
    //         racPositions.add(positionRac);
    //         racList.remove(Integer.valueOf(passengerFromRAC.passengerId));
    //         availableRacTickets++;

    //         //check if any WL is there
    //         if(waitingList.size()>0)
    //         {
    //             //take the passenger from WL and add them to RAC , increase the free space in waiting list and 
    //             //increase available WL and decrease available RAC by 1
    //             Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
    //             int positionWL = passengerFromWaitingList.number;
    //             waitingListPositions.add(positionWL);
    //             waitingList.remove(Integer.valueOf(passengerFromWaitingList.passengerId));

    //             passengerFromWaitingList.number = racPositions.get(0);
    //             passengerFromWaitingList.alloted = "RAC";
    //             racPositions.remove(0);
    //             racList.add(passengerFromWaitingList.passengerId);
                
    //             availableWaitingList++;
    //             availableRacTickets--;
    //         }
    //         // now we have a passenger from RAc to whom we can book a ticket, 
    //         //so book the cancelled ticket to the RAC passenger
    //         Main.bookTicket(passengerFromRAC);
        // }

        
    // Cancel ticket
    public void cancelTicket(int passengerId) {
        // Retrieve the passenger
        Passenger p = passengers.get(passengerId);
        passengers.remove(Integer.valueOf(passengerId));

    
        String cancelled = ""; // To track where the cancellation occurred
    
        // Check if the passenger is in the booked tickets
        if (bookedTicketList.contains(passengerId)) {
            // Remove the passenger from the booked tickets
            bookedTicketList.remove(Integer.valueOf(passengerId));
    
            // Take the booked position which is now free
            int positionBooked = p.number;
            cancelled = "berth";  // Cancelled from booked tickets
    
            System.out.println("---------------Cancelled Successfully");
    
            // Free up the seat based on the type (L, M, U)
            if (p.alloted.equals("L")) {
                availableLowerBerths++;
                lowerBerthsPositions.add(positionBooked);
            } else if (p.alloted.equals("M")) {
                availableMiddleBerths++;
                middleBerthsPositions.add(positionBooked);
            } else if (p.alloted.equals("U")) {
                availableUpperBerths++;
                upperBerthsPositions.add(positionBooked);
            }
        } 
        // Check if the passenger is in the RAC list
        else if (racList.contains(passengerId)) {
            // If the passenger is in RAC, just remove them from the RAC list
            racList.remove(Integer.valueOf(passengerId));
            availableRacTickets++;
    
            // Add the freed RAC position back to the available list
            int positionRac = p.number;
            racPositions.add(positionRac);
    
            cancelled = "rac";  // Cancelled from RAC
    
            System.out.println("---------------RAC Ticket Cancelled Successfully");
    
            // No need to modify `bookedTicketList` as the passenger hasn't been promoted yet
        } 
        // Check if the passenger is in the Waiting List
        else if (waitingList.contains(passengerId)) {
            // If the passenger is in the Waiting List, just remove them
            waitingList.remove(Integer.valueOf(passengerId));
            availableWaitingList++;
    
            // Add the freed waiting list position back to the available list
            int positionWL = p.number;
            waitingListPositions.add(positionWL);
    
            cancelled = "wl";  // Cancelled from WL
    
            System.out.println("---------------Waiting List Ticket Cancelled Successfully");
    
            // No need to update `bookedTicketList` or `racList` as the passenger is still on the list
        }
    
        // Handle promotion logic (RAC -> booked and WL -> RAC)
        promoteIfNeeded(cancelled);
    }
    

    
    public void promoteIfNeeded() {
        // First, check if a booked ticket was canceled (since we only promote RAC to booked when a booked ticket is canceled)
        if (bookedTicketList.size() > 0) {
            // Check if there are any RAC passengers waiting to be promoted to booked tickets
            if (racList.size() > 0) {
                Passenger passengerFromRAC = passengers.get(racList.poll());
                int positionRac = passengerFromRAC.number;
    
                // Free up RAC positions and assign a berth
                racPositions.add(positionRac);
                availableRacTickets++;
    
                // Promote the RAC passenger to booked ticket
                passengerFromRAC.alloted = "";  // Mark as booked
                bookedTicketList.add(passengerFromRAC.passengerId); // Add to booked list
    
                // Decrease RAC tickets and assign them a booked seat
                availableRacTickets--;
                bookTicket(passengerFromRAC, passengerFromRAC.number, passengerFromRAC.alloted);
            }
    
            // Now, check if there are any waiting list (WL) passengers to promote to RAC
            if (waitingList.size() > 0) {
                Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
                int positionWL = passengerFromWaitingList.number;
    
                // Add to available waiting list positions and assign them a RAC seat
                waitingListPositions.add(positionWL);
                availableWaitingList++;
    
                // Assign RAC to the WL passenger
                passengerFromWaitingList.number = racPositions.get(0); // Assign the first RAC position
                passengerFromWaitingList.alloted = "RAC";
                racPositions.remove(0); // Remove the RAC position from the list
    
                // Add the WL passenger to the RAC queue
                racList.add(passengerFromWaitingList.passengerId);
    
                // Decrease RAC tickets and promote the passenger to booked if needed
                availableRacTickets--;
            }
        }
    }
    

}

    //print all available seats
    public void printAvailable()
    {
        System.out.println("Available Lower Berths "  + availableLowerBerths);
        System.out.println("Available Middle Berths "  + availableMiddleBerths);
        System.out.println("Available Upper Berths "  + availableUpperBerths);
        System.out.println("Availabel RACs " + availableRacTickets);
        System.out.println("Available Waiting List " + availableWaitingList);
        System.out.println("--------------------------");
    }

    //print all occupied passengers from all types including WL
    public void printPassengers()
    {
        if(passengers.size() == 0)
        {
            System.out.println("No details of passengers");
            return;
        }
        for(Passenger p : passengers.values())
        {
            System.out.println("PASSENGER ID " + p.passengerId );
            System.out.println(" Name " + p.name );
            System.out.println(" Age " + p.age );
            System.out.println(" Status " + p.number + p.alloted);
            System.out.println("--------------------------");
        }
    }
}