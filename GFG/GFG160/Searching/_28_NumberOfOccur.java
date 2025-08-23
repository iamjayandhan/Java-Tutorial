import java.util.Arrays;

class Solution {
    int countFreq(int[] arr, int target) {
        int c = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target){
                c++;
            }
        }
        return c;
    }
}

public class _28_NumberOfOccur {
    public static void main(String[] args){
        int arr[] = {1,1,2,2,2,2,3};
        System.out.println("Array:"+Arrays.toString(arr));
        Solution obj = new Solution();
        System.out.println(obj.countFreq(arr,2));
        System.out.println();
    }
}
