class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        //method1 Time exceeded.
        // for(int i=0;i<s1.length()-1;i++){
        //     char c = s1.charAt(0);
        //     String s = s1.substring(1);
        //     s1 = s.concat(c+"");
        //     if(s1.equals(s2)){
        //         return true;
        //     }
        // }
        // return false;
        String doubled = s1+s2;
        return doubled.contains(s2);
    }
}

public class _20_StringRotOfEachOther{
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab"; //true 2rot
        // String s1 = "aab", s2 = "aba"; //true 1rot
        // String s1="abcd", s2 = "acbd"; //false
        System.out.println("Is Rotated? "+Solution.areRotations(s1, s2));
    }
}