class Passenger {
    static int counter = 1;
    int passengerId;
    
    String name;
    int age;
    String gender;
    String preference;
    String allotted = "";
    String seatNumber = "";

    Passenger(String name, int age, String gender, String pref) {
        this.passengerId = counter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.preference = pref;
    }
}