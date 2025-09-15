public class Passenger {
    private static int idCounter = 1;
    int passengerId;

    String name;
    int age;
    String gender;
    
    String coachType; // AC / Non-AC / Seater
    int seatNumber;   // Assigned seat number
    boolean isWaiting;

    public Passenger(String name, int age, String gender, String coachType, boolean isWaiting, int seatNumber) {
        this.passengerId = idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.coachType = coachType;
        this.isWaiting = isWaiting;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        if (isWaiting) {
            return "ID: " + passengerId + " | " + name + " | Age: " + age + " | Gender: " + gender +
                   " | " + coachType + " | WL Position: " + seatNumber;
        } else {
            return "ID: " + passengerId + " | " + name + " | Age: " + age + " | Gender: " + gender +
                   " | " + coachType + " | Seat: " + seatNumber;
        }
    }
}
