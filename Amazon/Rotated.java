public class Rotated{
    public static void main(String[] args) {
        String s1 = "mightandmagic";
        String s2 = "andmagicmigth";   
        System.out.println(areRotations(s1, s2)); // Output: 3 
    }

    public static int areRotations(String s1, String s2){
        // If the strings are of different lengths, they cannot be rotations of each other
        if(s1.length()!=s2.length()) return 0;

        String doubled = s1 + s1;
        return doubled.indexOf(s2) == -1? 0: 1; // If s2 is found in the concatenated string, it's a rotation of s1
    }
}

/* 
Problem Statement: Check if strings are rotations of each other or not
Given two strings s1 and s2. The task is to check if s2 is a rotated version of the string s1. The characters in the strings are in lowercase.

Test Case 1:

Input:
mightandmagic
andmagicmigth

Output:
0

Explanation:
Here with any amount of rotation s2 can’t be obtained by s1.

Your Task:
The task is to complete the function areRotations() which checks if the two strings are rotations of each other. The function returns true if string 1 can be obtained by rotating string 2, else it returns false.

Expected Time Complexity: O(N).
Expected Space Complexity: O(N).
Note: N = |s1|.
Constraints:

1 <= |s1|, |s2| <= 107 
*/