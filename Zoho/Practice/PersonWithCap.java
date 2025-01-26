import java.util.Scanner;

public class PersonWithCap {
    
    // Function to insert a new height into the sorted list
    public static void insertSorted(int[] room, int n, int height) {
        int i = n - 1;
        // Shift elements to the right to make space for the new height
        while (i >= 0 && room[i] > height) {
            room[i + 1] = room[i];
            i--;
        }
        // Insert the new height at the correct position
        room[i + 1] = height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create an array with a maximum size of 100 (assuming 100 max people)
        int[] room = new int[100];
        int n = 0;  // This will track how many people are in the room

        while (true) {
            System.out.print("Enter a new height (or -1 to stop): ");
            int height = sc.nextInt();
            
            if (height == -1) {
                break;  // Stop if input is -1
            }

            // Insert the height in the correct position in the sorted list
            insertSorted(room, n, height);
            n++;  // Increase the number of people in the room

            // The middle person has the cap
            int middlePerson = room[n / 2];
            System.out.println("The person with the cap is: " + middlePerson);
        }

        sc.close();
    }
}
