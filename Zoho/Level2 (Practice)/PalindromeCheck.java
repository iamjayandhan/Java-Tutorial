import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

class Solution{
    public boolean palindrome(String input){
        
        int freq[] = new int[26];

        for(int i=0;i<input.length();i++){
            freq[input.charAt(i) - 'a'] +=1;
        }

        System.out.println(Arrays.toString(freq));

        boolean oddEncountered = false;
        for(int v : freq){
            if(v % 2 !=0 && !oddEncountered){
                oddEncountered = true;
            }
            else if(v % 2 !=0 && oddEncountered){
                return false;
            }
        }

        return true;
        // Map<Character,Integer> map = new HashMap<>();
        
        // for(char c : input.toCharArray()){
        //     map.put(c,map.getOrDefault(c, 0)+1);
        // }
        // System.out.println(map.toString());
        // System.out.println(map.values()); //values
        
        // boolean oddEncountered = false;
        // for(char c : map.keySet()){
        //     if(map.get(c) % 2 !=0 && !oddEncountered){
        //         oddEncountered = true;
        //     }
        //     else if(map.get(c) % 2 !=0 && oddEncountered){
        //         return false;
        //     }
        // }
        // return true;
    }
}

public class PalindromeCheck {
    public static void main(String args[]){
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the input String: ");
        String input = sc.nextLine();

        if(obj.palindrome(input)){
            System.out.println("Palindrome can be made!");
        }
        else{
            System.out.println("Palindrome cannot be made!");
        }
    }
}
