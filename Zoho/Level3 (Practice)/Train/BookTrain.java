import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class BookTrain {

    private Train curTrain;
    private int pnrNumber = 0;
    private final List<Summary> summaryList = new ArrayList<>();

    BookTrain() {
        curTrain = new Train();
    }

    public void book(char from , char to , int passengers) {

        Result res = curTrain.checkAvailability(from , to , passengers);

        if (res == Result.NO_SEATS_AVAILABLE) {
            Summary newSummary = new Summary(Entry.EntryType.NO_SEATS_AVAILABLE);
            summaryList.add(newSummary);
            System.out.println(newSummary);
            return;
        }

        if (res == Result.FAILED) {
            System.out.println("Enter the valid Input");
            return;
        }

        if (res == Result.SUCCESS) {

            Seat.SeatType seatType = res.getSeatType();

            Ticket ticket = new Ticket(from , to , ++pnrNumber);

            if (seatType == Seat.SeatType.RESERVATION) {

                Entry bookingEntry = curTrain.bookReservationSeat(ticket , passengers);
                Summary newSummary = new Summary(from , to , ticket.getPnrNumber() , Entry.EntryType.BOOK , bookingEntry.getSeatingList());
                summaryList.add(newSummary);
                System.out.println(newSummary);

            } else {

                Entry bookingEntry = curTrain.bookWaitingListSeat(ticket , passengers);
                Summary newSummary = new Summary(from , to , ticket.getPnrNumber() , Entry.EntryType.BOOK , bookingEntry.getSeatingList());
                summaryList.add(newSummary);
                System.out.println(newSummary);

            }

        }

    }

    public void cancel(int pnrNumber , int passengers) {

        if (pnrNumber > this.pnrNumber) {
            System.out.println("Enter the valid inputs");
            return;
        }

        Result result = curTrain.checkPnr(pnrNumber , passengers);

        if (result == Result.FAILED) {
            System.out.println("Enter the valid inputs");
            return;
        }

        if (result == Result.SUCCESS) {

            Seat.SeatType seatType = result.getSeatType();

            if (seatType == Seat.SeatType.RESERVATION) {

                Entry cancelEntry = curTrain.cancelReservationTicket(pnrNumber , passengers);

                char from = cancelEntry.getFrom();
                char to = cancelEntry.getTo();
                int pnrNo = cancelEntry.getPnrNo();
                List<String> cancelledSeats = cancelEntry.getSeatingList();

                Summary cancallationSummary = new Summary(from , to , pnrNo , Entry.EntryType.CANCEL , cancelledSeats);
                summaryList.add(cancallationSummary);


                Entry updationEntry = curTrain.updateWaitingList(cancelledSeats , from , to);
                List<Ticket> upatedTicketList = updationEntry.getTicketList();
                List<String> _cancelledSeats = cancelEntry.getSeatingList();

                for (int i = 0; i < upatedTicketList.size(); i++) {

                    Ticket updateTicket = upatedTicketList.get(i);
                    char _from = updateTicket.getFrom();
                    char _to = updateTicket.getTo();
                    int _pnrNo = updateTicket.getPnrNumber();

                    summaryList.add(new Summary(_from , _to , _pnrNo , Entry.EntryType.UPDATE , new ArrayList<>(Arrays.asList(_cancelledSeats.get(i)))));

                }


            } else if (seatType == Seat.SeatType.WAITING_LIST) {

                Entry cancelEntry = curTrain.cancelWaitingListTicket(pnrNumber , passengers);

                char from = cancelEntry.getFrom();
                char to = cancelEntry.getTo();
                int pnrNo = cancelEntry.getPnrNo();
                List<String> cancelledSeats = cancelEntry.getSeatingList();

                Summary cancallationSummary = new Summary(from , to , pnrNo , Entry.EntryType.CANCEL , cancelledSeats);
                summaryList.add(cancallationSummary);

            }

        }


    }

    public void print() {
        printSummary();
        printChart();
    }

    private void printSummary() {
        System.out.println();
        for (Summary summary : summaryList) {
            System.out.println(summary);
        }
    }

    private void printChart() {

        System.out.println();
        char[][] reservationChart = new char[curTrain.RESERVATION_SEAT_COUNT][curTrain.TOTAL_STATIONS];
        char[][] waitingListChart = new char[curTrain.WAITING_LIST_SEAT_COUNT][curTrain.TOTAL_STATIONS];

        Arrays.stream(reservationChart).forEach(it -> Arrays.fill(it , ' '));
        Arrays.stream(waitingListChart).forEach(it -> Arrays.fill(it , ' '));


        for (int i = 0; i < reservationChart.length; i++) {
            for (int j = 0; j < reservationChart[i].length; j++) {

                if (curTrain.isOccupied_Reservation(i , (char) (j + 'A'))) {
                    reservationChart[i][j] = '*';
                }

            }
        }

        for (int i = 0; i < waitingListChart.length; i++) {
            for (int j = 0; j < waitingListChart[i].length; j++) {

                if (curTrain.isOccupied_WaitingList(i , (char) (j + 'A'))) {
                    waitingListChart[i][j] = '*';
                }

            }
        }


        for (int i = 0; i < curTrain.TOTAL_STATIONS; i++) {
            System.out.print("   " + (char) (i + 'A'));
        }
        System.out.println();
        for (int i = 0; i < reservationChart.length; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < reservationChart[i].length; j++) {

                System.out.print(reservationChart[i][j] + "   ");

            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < curTrain.TOTAL_STATIONS; i++) {
            System.out.print("   " + (char) (i + 'A'));
        }

        System.out.println();

        for (int i = 0; i < waitingListChart.length; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < waitingListChart[i].length; j++) {

                System.out.print(waitingListChart[i][j] + "   ");

            }
            System.out.println();
        }
        System.out.println();
    }

}