public enum Result {

    NO_SEATS_AVAILABLE,
    FAILED,
    SUCCESS;

    private Seat.SeatType seatType = null;

    public void setSeatTypeReserve(){
        this.seatType = Seat.SeatType.RESERVATION;
    }

    public void setSeatTypeWaitingList(){
        this.seatType = Seat.SeatType.WAITING_LIST;
    }

    public Seat.SeatType getSeatType(){
        return this.seatType;
    }


}