//by default, enum extends Enum class!
// java.lang.enum
// values()				- Returns an array of all enum constants.
// valueOf(String name)	- Returns the enum constant with the specified name.
// ordinal()			- Returns the position (index) of the enum constant (zero-based).
// name()				- Returns the exact name of the enum constant as a String.
// compareTo(E o)		- Compares the order of two enum constants.
// toString()			- Returns the name of the enum constant.
// getDeclaringClass()	- Returns the class object of the enum type.

enum Status {
    Running, Failed, Pending, Success;
}

public class EnumClass {
    public static void main(String args[]) {
        Status s = Status.Success;

        System.out.println("Class of s: " + s.getClass()); // Output: class Status
        System.out.println("Superclass of s: " + s.getClass().getSuperclass()); // Output: class java.lang.Enum

        System.out.println("\n--- Enum Methods ---");
        System.out.println("Enum Name: " + s.name()); // Success
        System.out.println("Enum Ordinal: " + s.ordinal()); // 3
        System.out.println("Enum toString: " + s.toString()); // Success
        System.out.println("Enum Declaring Class: " + s.getDeclaringClass()); // class Status

        // Compare Enums
        System.out.println("\n--- Comparing Enums ---");
        System.out.println("Success vs Pending: " + s.compareTo(Status.Pending)); // 1 (Success comes after Pending)
        System.out.println("Running vs Failed: " + Status.Running.compareTo(Status.Failed)); // -1

        // Get all values from Enum
        System.out.println("\n--- Listing All Enum Constants ---");
        for (Status st : Status.values()) {
            System.out.println(st + " -> Ordinal: " + st.ordinal());
        }

        // Convert String to Enum
        System.out.println("\n--- Convert String to Enum ---");
        Status statusFromString = Status.valueOf("Failed");
        System.out.println("Converted: " + statusFromString); // Failed

        // Enum with switch-case
        System.out.println("\n--- Switch-Case on Enum ---");
        switch (s) {
            case Running:
                System.out.println("All Good");
                break;
            case Failed:
                System.out.println("Try Again");
                break;
            case Pending:
                System.out.println("Please Wait");
                break;
            case Success:
                System.out.println("Success!");
                break;
            default:
                System.out.println("Default block executed!");
                break;
        }
    }
}
