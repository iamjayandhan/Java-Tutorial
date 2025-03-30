import java.util.HashSet;
import java.util.Set;

public class ModSecString {
    public static void main(String args[]){
        // 3. Modify Second String
        // Question:
        // Given two strings str1 and str2, modify the second string based on the following rules:

        // Replace characters in str2 that are not in str1 with #.
        // Keep the characters in str2 as is if they are present in str1.
        // Input:
        // str1 = "abc"
        // str2 = "abcdef"
        // Output:
        // "abc###"

        String s1 = "abc";
        String s2 = "abcdef";

        Set<Character> set = new HashSet<>();
        for(char c : s1.toCharArray()){
            set.add(c);
        }

        StringBuilder res = new StringBuilder();
        for(char c : s2.toCharArray()){
            if(set.contains(c)){
                res.append(c);
            }else{
                res.append('#');
            }
        }

        System.out.println(res.toString());
    }    
}
