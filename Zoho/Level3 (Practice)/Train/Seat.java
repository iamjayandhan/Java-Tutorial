import java.util.ArrayList;
import java.util.List;

public class Seat {

    enum SeatType {

        RESERVATION,
        WAITING_LIST;


    }

    private List<Ticket> ticketList = new ArrayList<>();

    private String seatName;

    Seat(String seatName) {
        this.seatName = seatName;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public String getSeatName() {
        return this.seatName;
    }

    public void book(Ticket ticket) {
        ticketList.add(ticket);
    }

    public boolean canSit(char nf , char nt) {

        for (Ticket curTicket : ticketList) {

            char cf = curTicket.getFrom();
            char ct = curTicket.getTo();

            boolean isOverLap = isOverLap(cf , ct , nf , nt);

            if (isOverLap) {
                return false;
            }

        }

        return true;

    }

    private boolean isOverLap(char cf , char ct , char nf , char nt) {

        if (nt <= cf) {
            // interval is on the left
            return false;
        } else if (ct <= nf) {
            // interval is on the right
            return false;
        }
        return true;

    }

    public boolean isOccupied(char station) {

        for (Ticket ticket : ticketList) {

            boolean isOverLap = isOverLap(station , ticket);

            if (isOverLap) {
                return true;
            }

        }

        return false;

    }

    private boolean isOverLap(char station , Ticket ticket) {
        return (ticket.getFrom() <= station && station <= ticket.getTo());
    }

    public boolean isTherePnr(int pnrNumber) {

        for (Ticket curTicket : ticketList) {
            if (curTicket.getPnrNumber() == pnrNumber) {
                return true;
            }
        }

        return false;
    }

    public Ticket cancel(int pnrNumber) {

        for (int i = 0; i < ticketList.size(); i++) {

            Ticket curTicket = ticketList.get(i);

            if (curTicket.getPnrNumber() == pnrNumber) {
                return ticketList.remove(i);
            }

        }

        return null;

    }

    public boolean canSit(Ticket curTicket) {
        return canSit(curTicket.getFrom() , curTicket.getTo());
    }

}