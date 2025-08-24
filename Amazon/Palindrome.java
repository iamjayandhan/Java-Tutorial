public class Palindrome{
    public static void main(String args[]){
        String s1 = "I am :IronnorI Ma, i";
        String s2 = "Ab?/Ba";

        System.out.println("Is s1 a palindrome? " + isPalindrome(s1));
        System.out.println("Is s2 a palindrome? " + isPalindrome(s2));
    }

    public static String isPalindrome(String s){
        String str = removeSpecialCharacters(s);
        str = str.toLowerCase();

        int start = 0;
        int end = str.length() -1;

        while(start < end){
            if(str.charAt(start)!= str.charAt(end)){
                return "NO";
            }
            start++;
            end--;
        }
        return "YES";
    }

    // using regex!
    // public static String removeSpecialCharacters(String s){
    //     return s.replaceAll("[^a-zA-Z]", "");
    // }
    public static String removeSpecialCharacters(String s){
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

/* Problem Statement:

Jarvis is weak in computing palindromes for Alphanumeric characters.While Ironman is busy fighting Thanos, he needs to activate sonic punch but Jarvis is stuck in computing palindromes.You are given a string S containing alphanumeric characters. Find out whether the string is a palindrome or not. If you are unable to solve it then it may result in the death of Iron Man.

Test Case 1:-

Input:
S = “I am :IronnorI Ma, i”

Output:
YES

Explanation:
Ignore all the symbols and whitespaces S = “IamIronnorIMai”.
Now, Check for palindrome ignoring uppercase and lowercase English letter.

*/