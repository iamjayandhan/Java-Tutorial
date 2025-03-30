public class Ticket {

    private char from;
    private char to;
    private int pnrNumber;

    public int getPnrNumber() {
        return pnrNumber;
    }

    public char getTo() {
        return to;
    }

    public char getFrom() {
        return from;
    }

    public Ticket(char from, char to, int pnrNumber) {
        this.from = from;
        this.to = to;
        this.pnrNumber = pnrNumber;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public void setPnrNumber(int pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

}
