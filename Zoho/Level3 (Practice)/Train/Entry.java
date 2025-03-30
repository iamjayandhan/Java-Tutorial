import java.util.ArrayList;
import java.util.List;

public class Entry {


    public enum EntryType {
        BOOK,
        CANCEL,
        NO_SEATS_AVAILABLE,
        UPDATE;

    }
    List<String> seatingList;

    private char from;
    private char to;
    private int pnrNo;
    private List<Ticket> ticketList;


    public Entry() {
        seatingList = new ArrayList<>();
        ticketList = new ArrayList<> ();
    }

    public Entry(char from, char to, int pnrNo) {
        this();
        this.from = from;
        this.to = to;
        this.pnrNo = pnrNo;
    }

    public List<Ticket> getTicketList() {
        return this.ticketList;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public int getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(int pnrNo) {
        this.pnrNo = pnrNo;
    }

    public void addSeatToList(String s) {
        seatingList.add(s);
    }

    public List<String> getSeatingList() {
        return this.seatingList;
    }

    public void addTicket(Ticket ticket){
        ticketList.add(ticket);
    }

    public int getTicketListCount() {
        return seatingList.size();
    }


}
