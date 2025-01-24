class Solution {
    public void reverseStr(String s1, String s2) {
        // Find the first occurrence of s2 in s1
        int index = s1.indexOf(s2);
        
        if (index == -1) {
            System.out.println(s1); // If s2 is not found, print the original string
            return;
        }

        // Separate the part before and including the first occurrence of s2
        String partBefore = s1.substring(0, index + s2.length()); // Include s2 in partBefore
        String partAfter = s1.substring(index + s2.length());    // Everything after s2

        // Split the partAfter string into words
        String[] words = partAfter.split("\\s+");

        // Reverse the order of the words in partAfter
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(" ").append(words[i]);
        }

        // Print the result by combining partBefore and the reversed partAfter
        System.out.println(partBefore + res.toString());
    }
}

public class ReverseWords {
    public static void main(String args[]) {
        String string1 = "This is a test String only";
        String string2 = "st"; // Substring to find in string1

        Solution sol = new Solution();
        sol.reverseStr(string1, string2); // Call the method to reverse words after first occurrence of "st"
    }
}
