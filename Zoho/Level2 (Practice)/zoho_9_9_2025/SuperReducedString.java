import java.util.*;

public class SuperReducedString {
    public static void main(String args[]){
        //https://www.hackerrank.com/challenges/reduced-string/problem

        System.out.println("aaabccddd -> "+reducedString("aaabccddd"));
        System.out.println("aa -> "+reducedString("aa"));
        System.out.println("baab -> "+reducedString("baab"));
    }

    public static String reducedString(String s){
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            int len = sb.length();
            if(len>0 && sb.charAt(len-1) == c){
                sb.deleteCharAt(len-1);
            }else{
                sb.append(c);
            }
        }
        return sb.length() == 0? "Empty String": sb.toString();
    }
}
