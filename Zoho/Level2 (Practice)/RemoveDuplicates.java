import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

class Solution{
    public void RemoveDup(int n[]){
        HashSet<Integer> set = new HashSet<>();

        int min = n[0];
        for(int number : n){
            if(number< min){
                min = number;
            }
        }

        for(int i=0;i<n.length;i++){
            if(set.contains(n[i])){
                while(set.contains(min)){
                    min++;
                }
                set.add(min);
                n[i] = min++;
            }
            else{
                set.add(n[i]);
            }
        }
    }
}

public class RemoveDuplicates {
    public static void main(String args[]){
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);

        int arr[] = {2,2,2,2,5,5,108,3,1};
        obj.RemoveDup(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));    
    }
}
