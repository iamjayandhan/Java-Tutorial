import java.util.List;

public class Summary {

    private Entry.EntryType entryType;
    private List<String> seatingList;
    private char from;
    private char to;
    private int pnrNo;

    Summary(Entry.EntryType entryType){
        this.entryType = entryType;
    }

    public Summary(char from, char to, int pnrNo , Entry.EntryType entryType, List<String> seatingList) {
        this.entryType = entryType;
        this.seatingList = seatingList;
        this.from = from;
        this.to = to;
        this.pnrNo = pnrNo;
    }

    public void setSeatingList(List<String> seatingList) {
        this.seatingList = seatingList;
    }



    @Override
    public String toString() {
        return printData();
    }

    public String printData() {

        Entry.EntryType type = this.entryType;

        String s = "";

        if (type == Entry.EntryType.NO_SEATS_AVAILABLE) {
            s = "No Seats Available";
        } else if (type == Entry.EntryType.BOOK) {
            s = "PNR Number : " + this.pnrNo + " " + this.from + " to " + this.to + " Confirmed Seats: " + this.seatingList;
        } else if (type == Entry.EntryType.CANCEL) {
            s = "PNR Number : " + this.pnrNo + " " + this.from + " to " + this.to + " Cancelled Seats: " + this.seatingList;
        }else if(type == Entry.EntryType.UPDATE){
            s = "PNR Number : " + this.pnrNo + " " + this.from + " to " + this.to + " Updated Seats: " + this.seatingList;
        }

        return s;

    }

}
