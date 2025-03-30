import java.util.*;

interface Vehicle {
    String getVehicleType();
    int getRatePerHour();
}

class Bike implements Vehicle {
    @Override
    public String getVehicleType() {
        return "Bike";
    }

    @Override
    public int getRatePerHour() {
        return 10;
    }
}

class Car implements Vehicle {
    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public int getRatePerHour() {
        return 20;
    }
}

class Truck implements Vehicle {
    @Override
    public String getVehicleType() {
        return "Truck";
    }

    @Override
    public int getRatePerHour() {
        return 50;
    }
}

class ParkingLevel {
    private int levelNumber;
    private boolean[] slots;
    private int bikeSlots, carSlots, truckSlots;
    private Map<Integer, ParkingInfo> occupiedSlots;
    private Map<String, Integer> vehicleRegistrationMap; // Vehicle number to slot map

    public ParkingLevel(int levelNumber, int totalSlots) {
        this.levelNumber = levelNumber;
        this.slots = new boolean[totalSlots]; // False indicates available
        this.bikeSlots = totalSlots * 50 / 100;
        this.carSlots = totalSlots * 30 / 100;
        this.truckSlots = totalSlots * 20 / 100;
        this.occupiedSlots = new HashMap<>();
        this.vehicleRegistrationMap = new HashMap<>();
    }

    public int parkVehicle(Vehicle vehicle, String regNumber, String ownerName, int inTime) {
        int startSlot = 0;
        int endSlot = 0;

        switch (vehicle.getVehicleType()) {
            case "Bike":
                endSlot = bikeSlots;
                break;
            case "Car":
                startSlot = bikeSlots;
                endSlot = startSlot + carSlots;
                break;
            case "Truck":
                startSlot = bikeSlots + carSlots;
                endSlot = startSlot + truckSlots;
                break;
        }

        for (int i = startSlot; i < endSlot; i++) {
            if (!slots[i]) {
                slots[i] = true;
                occupiedSlots.put(i, new ParkingInfo(vehicle, regNumber, ownerName, inTime));
                vehicleRegistrationMap.put(regNumber, i);
                return i + 1; // Return slot number (1-based index)
            }
        }
        return -1; // No slot available
    }

    public int unparkVehicle(String regNumber, int outTime) {
        if (vehicleRegistrationMap.containsKey(regNumber)) {
            int index = vehicleRegistrationMap.get(regNumber);
            ParkingInfo info = occupiedSlots.get(index);
            slots[index] = false;
            occupiedSlots.remove(index);
            vehicleRegistrationMap.remove(regNumber);
            return (outTime - info.getInTime()) * info.getVehicle().getRatePerHour();
        }
        return -1; // Invalid registration number
    }

    public void displayAvailableSlots() {
        System.out.println("Available slots in Level " + levelNumber + ":");
        for (int i = 0; i < slots.length; i++) {
            if (!slots[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}

class ParkingLot {
    private List<ParkingLevel> levels;

    public ParkingLot(int numberOfLevels, int slotsPerLevel) {
        levels = new ArrayList<>();
        for (int i = 0; i < numberOfLevels; i++) {
            levels.add(new ParkingLevel(i + 1, slotsPerLevel));
        }
    }

    public void park(String vehicleType, String regNumber, String ownerName, int inTime) {
        Vehicle vehicle;
        switch (vehicleType) {
            case "Bike":
                vehicle = new Bike();
                break;
            case "Car":
                vehicle = new Car();
                break;
            case "Truck":
                vehicle = new Truck();
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        for (ParkingLevel level : levels) {
            int slotNumber = level.parkVehicle(vehicle, regNumber, ownerName, inTime);
            if (slotNumber != -1) {
                System.out.println(vehicleType + " parked at Level " + (levels.indexOf(level) + 1) + ", Slot " + slotNumber);
                return;
            }
        }
        System.out.println("Parking Full for " + vehicleType + ".");
    }

    public void unpark(String regNumber, int outTime) {
        for (ParkingLevel level : levels) {
            int fee = level.unparkVehicle(regNumber, outTime);
            if (fee != -1) {
                System.out.println("Vehicle with Registration Number " + regNumber + " unparked. Parking Fee: ₹" + fee);
                return;
            }
        }
        System.out.println("Vehicle with Registration Number " + regNumber + " not found.");
    }

    public void displayAvailableSlots() {
        for (ParkingLevel level : levels) {
            level.displayAvailableSlots();
        }
    }
}

class ParkingInfo {
    private Vehicle vehicle;
    private String regNumber;
    private String ownerName;
    private int inTime;

    public ParkingInfo(Vehicle vehicle, String regNumber, String ownerName, int inTime) {
        this.vehicle = vehicle;
        this.regNumber = regNumber;
        this.ownerName = ownerName;
        this.inTime = inTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getInTime() {
        return inTime;
    }
}

public class ParkingManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot(5, 20);

        while (true) {
            System.out.println("\n1. Park Vehicle\n2. Unpark Vehicle\n3. List Available Slots\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Type (Bike/Car/Truck): ");
                    String type = scanner.next();
                    System.out.print("Enter Registration Number: ");
                    String regNumber = scanner.next();
                    System.out.print("Enter Owner Name: ");
                    String ownerName = scanner.next();
                    System.out.print("Enter In Time (hour): ");
                    int inTime = scanner.nextInt();
                    parkingLot.park(type, regNumber, ownerName, inTime);
                    break;
                case 2:
                    System.out.print("Enter Vehicle Registration Number: ");
                    String vehicleRegNumber = scanner.next();
                    System.out.print("Enter Out Time (hour): ");
                    int outTime = scanner.nextInt();
                    parkingLot.unpark(vehicleRegNumber, outTime);
                    break;
                case 3:
                    parkingLot.displayAvailableSlots();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
