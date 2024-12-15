package packages;

// Importing the classes from greet1 and greet2 packages
import packages.greet1.Morning;
import packages.greet2.Afternoon;
import packages.greet2.Evening;

public class GreetMain{
    public static void main(String args[]){
        // Calling Morning's main method to display the greeting
        Morning.main(args);

        // Calling Afternoon's main method to display the greeting
        Afternoon.main(args);

        Evening.main(args);
    }
}