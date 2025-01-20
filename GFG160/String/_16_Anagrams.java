
import java.util.HashMap;

import Arrays.Solution;

class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(map1.containsKey(s1.charAt(i))){
                map1.put(s1.charAt(i),map1.get(s1.charAt(i))+1);
            }
            else{
                map1.put(s1.charAt(i),1);
            }
        }

        for(int i=0;i<s2.length();i++){
            if(map2.containsKey(s2.charAt(i))){
                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
            }
            else{
                map2.put(s2.charAt(i),1);
            }
        }
        return map1.equals(map2);
    }
}

public class _16_Anagrams{
    public static void main(String args[]){
        String s1 = "geeks";
        String s2 = "kseeg";

        System.out.println("Given two strings are: "+'\n'+"s1: "+s1+'\n'+"s2: "+s2);
        System.out.println("Anagram result: "+Solution.areAnagrams(s1,s2));
    }
}