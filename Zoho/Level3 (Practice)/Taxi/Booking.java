class Booking {
    private int bookingId; // booking id
    private int customerId; //customer info
    private char from, to; // from and to location of customer
    private int pickupTime, dropTime; // start and end trip timings
    private int amount; // fare computed

    public Booking(int bookingId,int customerId, char from, char to, int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-12d %-6c %-6c %-12d %-10d %-8d",
                bookingId, customerId, from, to, pickupTime, dropTime, amount);
    }
}
