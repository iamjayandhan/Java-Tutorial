class Passenger {
    static int idCounter = 1;

    String name;
    int age;
    String berthPreference; // requested preference: L, M, U or ""
    int passengerId;
    String allotted; // L, M, U, RAC, WL or ""
    int seatNumber;  // number within that pool

    public Passenger(String name, int age, String berthPreference) {
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference == null ? "" : berthPreference;
        this.passengerId = idCounter++;
        this.allotted = "";
        this.seatNumber = -1;
    }
}