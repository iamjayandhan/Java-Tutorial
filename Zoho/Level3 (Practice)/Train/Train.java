import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Train {

    private final List<Seat> waitingListSeats = new ArrayList<>();
    private final List<Seat> reservationSeats = new ArrayList<>();

    public final int TOTAL_STATIONS = 5;
    public final int WAITING_LIST_SEAT_COUNT = 2;
    public final int RESERVATION_SEAT_COUNT = 8;

    Train() {

        IntStream.range(0 , RESERVATION_SEAT_COUNT).boxed().forEach(it -> reservationSeats.add(new Seat((it + 1) + "")));
        IntStream.range(0 , WAITING_LIST_SEAT_COUNT).boxed().forEach(it -> waitingListSeats.add(new Seat("WL" + (it + 1))));

    }

    public Result checkAvailability(char from , char to , int passengers) {

        boolean isValidStop = isValidStop(from) && isValidStop(to);
        boolean isValidJourney = isValidJourney(from , to);

        if (!isValidJourney || !isValidStop) {
            return Result.FAILED;
        }

        boolean res = checkReservationAvailability(from , to , passengers);

        if (res) {
            Result result = Result.SUCCESS;
            result.setSeatTypeReserve();
            return result;
        }

        res = checkWaitingListAvailability(from , to , passengers);

        if (res) {
            Result result = Result.SUCCESS;
            result.setSeatTypeWaitingList();
            return result;
        }

        return Result.NO_SEATS_AVAILABLE;

    }

    private boolean checkReservationAvailability(char from , char to , int passengers) {

        for (Seat curSeat : reservationSeats) {

            if (curSeat.canSit(from , to)) {
                passengers--;
            }

            if (passengers == 0) {
                break;
            }

        }

        return passengers == 0;

    }

    private boolean checkWaitingListAvailability(char from , char to , int passengers) {

        for (Seat curSeat : waitingListSeats) {

            if (curSeat.canSit(from , to)) {
                passengers--;
            }

            if (passengers == 0) {
                break;
            }

        }

        return passengers == 0;

    }

    public Entry bookReservationSeat(Ticket ticket , int passengers) {

        Entry bookingEntry = new Entry(ticket.getFrom() , ticket.getTo() , ticket.getPnrNumber());

        for (Seat curSeat : reservationSeats) {

            char nf = ticket.getFrom();
            char nt = ticket.getTo();

            if (curSeat.canSit(nf , nt)) {
                curSeat.book(ticket);
                String seatName = curSeat.getSeatName();
                bookingEntry.addSeatToList(seatName);
                passengers--;
            }

            if (passengers == 0) {
                break;
            }

        }

        return bookingEntry;

    }

    public Entry bookWaitingListSeat(Ticket ticket , int passengers) {

        Entry bookingEntry = new Entry(ticket.getFrom() , ticket.getTo() , ticket.getPnrNumber());

        for (Seat curSeat : waitingListSeats) {

            char nf = ticket.getFrom();
            char nt = ticket.getTo();

            if (curSeat.canSit(nf , nt)) {
                curSeat.book(ticket);
                String seatName = curSeat.getSeatName();
                bookingEntry.addSeatToList(seatName);
                passengers--;
            }

            if (passengers == 0) {
                break;
            }

        }

        return bookingEntry;

    }

    private boolean isValidStop(char station) {
        return station >= 'A' && station <= 'E';
    }

    private boolean isValidJourney(char from , char to) {
        return from < to;
    }

    public boolean isOccupied_Reservation(int seatNumber , char station) {
        Seat curSeat = reservationSeats.get(seatNumber);
        return curSeat.isOccupied(station);
    }

    public boolean isOccupied_WaitingList(int seatNumber , char station) {
        Seat curSeat = waitingListSeats.get(seatNumber);
        return curSeat.isOccupied(station);
    }

    private boolean isValidPassenger(int passengers) {
        return passengers >= 1 && passengers <= Math.max(WAITING_LIST_SEAT_COUNT , RESERVATION_SEAT_COUNT);
    }

    public Result checkPnr(int pnrNumber , int passengers) {

        boolean isValidPassengers = isValidPassenger(passengers);

        if (!isValidPassengers) {
            return Result.FAILED;
        }

        boolean res = checkReservationPnr(pnrNumber , passengers);

        if (res) {
            Result result = Result.SUCCESS;
            result.setSeatTypeReserve();
            return result;
        }

        res = checkWaitingListPnr(pnrNumber , passengers);

        if (res) {
            Result result = Result.SUCCESS;
            result.setSeatTypeWaitingList();
            return result;
        }

        return Result.FAILED;

    }

    private boolean checkReservationPnr(int pnrNumber , int passengers) {

        for (Seat curSeat : reservationSeats) {

            if (curSeat.isTherePnr(pnrNumber)) {
                passengers--;
            }

            if (passengers == 0) {
                return true;
            }

        }

        return false;

    }

    private boolean checkWaitingListPnr(int pnrNumber , int passengers) {

        for (Seat curSeat : waitingListSeats) {

            if (curSeat.isTherePnr(pnrNumber)) {
                passengers--;
            }

            if (passengers == 0) {
                return true;
            }

        }

        return false;


    }

    public Entry cancelReservationTicket(int pnrNumber , int passengers) {

        Entry cancallationEntry = new Entry();

        for (Seat curSeat : reservationSeats) {

            if (curSeat.isTherePnr(pnrNumber)) {

                Ticket cancelledTicket = curSeat.cancel(pnrNumber);

                cancallationEntry.setFrom(cancelledTicket.getFrom());
                cancallationEntry.setTo(cancelledTicket.getTo());
                cancallationEntry.setPnrNo(cancelledTicket.getPnrNumber());

                cancallationEntry.addSeatToList(curSeat.getSeatName());
                passengers--;

            }

            if (passengers == 0) {
                return cancallationEntry;
            }

        }

        return cancallationEntry;

    }

    public Entry cancelWaitingListTicket(int pnrNumber , int passengers) {

        Entry cancallationEntry = new Entry();

        for (Seat curSeat : waitingListSeats) {

            if (curSeat.isTherePnr(pnrNumber)) {

                Ticket cancelledTicket = curSeat.cancel(pnrNumber);

                cancallationEntry.setFrom(cancelledTicket.getFrom());
                cancallationEntry.setTo(cancallationEntry.getTo());
                cancallationEntry.setPnrNo(cancallationEntry.getPnrNo());

                cancallationEntry.addSeatToList(curSeat.getSeatName());
                passengers--;

            }

            if (passengers == 0) {
                return cancallationEntry;
            }

        }

        return cancallationEntry;

    }

    public Entry updateWaitingList(List<String> cancelledSeats , char from , char to) {

        Entry updationEntry = new Entry();

        // updateTicketList;
        // updateCancelledSeats

        int i = 0;

        int currentReservationSeatNo = Integer.parseInt(cancelledSeats.get(i))-1;

        for (Seat curWLSeat : waitingListSeats) {

            Seat reservationSeat = reservationSeats.get(currentReservationSeatNo);

            Ticket updatedTicket = updateWLSeatToReserve(curWLSeat , updationEntry , reservationSeat);

            if (updatedTicket != null) {
                updationEntry.addTicket(updatedTicket);
                i++;
                if(i==cancelledSeats.size()){
                    break;
                }
                currentReservationSeatNo = Integer.parseInt(cancelledSeats.get(i))-1;
            }


        }

        return updationEntry;


    }

    private Ticket updateWLSeatToReserve(Seat curWLSeat , Entry updationEntry , Seat reservationSeat){

        List<Ticket> cWL_ticketList = curWLSeat.getTicketList();

        for(Ticket curTicket : cWL_ticketList){

            boolean canSit = reservationSeat.canSit(curTicket);

            if(canSit){
                updationEntry.addSeatToList(reservationSeat.getSeatName());
                Ticket cancelledTicket = cancelWaitingListTicketAt(curWLSeat.getSeatName() , curTicket.getPnrNumber());
                reservationSeat.book(cancelledTicket);
                return curTicket;
            }

        }

        return null;

    }

    private Ticket cancelWaitingListTicketAt(String seatName , int pnrNumber) {
        int seatPos = Integer.parseInt(seatName.substring(2))-1;
        Seat toBeRemovedSeat = waitingListSeats.get(seatPos);
        Ticket cancelledTicket = toBeRemovedSeat.cancel(pnrNumber);
        return cancelledTicket;
    }


}