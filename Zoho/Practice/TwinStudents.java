public class TwinStudents {

    // Function to normalize the name (convert to sorted form)
    public static String normalizeName(String str) {
        char[] charArray = str.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

    // Function to find and print unique pairs of twins
    public static void findTwins(String[] names) {
        // Iterate through each name
        for (int i = 0; i < names.length; i++) {
            // Skip if the name has already been paired
            if (names[i] == null) continue;
            
            String name1 = names[i];
            String normalized1 = normalizeName(name1);

            // Compare the current name with every other name in the array
            for (int j = i + 1; j < names.length; j++) {
                // Skip if the name has already been paired
                if (names[j] == null) continue;

                String name2 = names[j];
                String normalized2 = normalizeName(name2);

                // If the names are anagrams (same normalized form)
                if (normalized1.equals(normalized2)) {
                    // Print the first pair found and stop further searching
                    System.out.println(name1 + ", " + name2);
                    names[j] = null;  // Mark this name as processed by setting it to null
                    return;  // Exit the function after printing the first pair
                }
            }
        }
    }

    public static void main(String[] args) {
        // Input list of names
        String[] names = {"MAYA", "BENJAMIN", "AAYM", "SOPHIA", "LUCAS", "AHPIOS", "KIARA", "PHSOAI"};

        // Find and print only the first valid pair of twins
        findTwins(names);
    }
}
