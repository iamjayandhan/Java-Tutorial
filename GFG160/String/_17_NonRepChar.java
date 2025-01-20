
import java.util.ArrayList;

class Solution{
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();


        for(int i=0;i<s.length();i++){
            if(arr.contains(s.charAt(i))){
                count.set(arr.indexOf(s.charAt(i)),count.get(arr.indexOf(s.charAt(i)))+1);
            }
            else{
                arr.add(s.charAt(i));
                count.add(1);
            }
        }

        System.out.println(arr+"\n"+count);

        for(int i=0;i<arr.size();i++){
            if(count.get(i)==1){
                return arr.get(i);
            }
        }
        return '$';
    }
}

public class _17_NonRepChar{
    public static void main(String args[]){
        String s = "racecar";
        char res = Solution.nonRepeatingChar(s);

        if(res=='$'){
            System.out.println("Result: -1");
        }
        else{
            System.out.println("Result: "+res);
        }
    }
}