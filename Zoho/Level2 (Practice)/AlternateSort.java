import java.util.Arrays;

class Solution{
    public int[] Alternate(int []arr){
        Arrays.sort(arr);

        int s = 0;
        int e = arr.length-1;

        int res[] = new int[arr.length];
        int index = 0;
        while (s<=e){
            if(s==e){
                res[index] = arr[s];
                break;
            }
            res[index++] = arr[e--];
            res[index++] = arr[s++];
        }
        return res;
    }
}

public class AlternateSort {
    public static void main(String args[])  {
        Solution sol = new Solution();
        int arr[] = {1,2,3,4,5,6,7};

        System.out.println("Before Sorting: "+Arrays.toString(arr));

        int res[] = sol.Alternate(arr);
        System.out.println("After Sorting: "+Arrays.toString(res));
    }
}
