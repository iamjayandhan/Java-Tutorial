import java.util.*;

public class LargestNumber{
    public static void main(String args[]){
        int nums[] = {3,30,34,5,9};

        System.out.println("Maximum number is: " + largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;

        String s[] = new String[n];
        for(int i=0;i<n;i++){
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str: s){
            sb.append(str);
        }

        String result = sb.toString();
        return result.charAt(0) == 0? "0": result;
    }
}