class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    // Dutch National Flag Problem
    public void sort012(int[] arr) {
        int lo=0,mid=0,hi=arr.length-1;

        while (mid<=hi){
            if(arr[mid]==0){
                int temp = arr[lo];
                arr[lo] = arr[mid];
                arr[mid] = temp;
                
                lo++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[hi];
                arr[hi] = temp;

                hi--;
            }
        }
    }
}
public class _21_Sort0s1s2s{
    public static void main(String[] args){
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        System.out.println("Before Sorting: ");
        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();
        Solution obj = new Solution();
        obj.sort012(arr);

        System.out.println("After Sorting: ");
        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();
    }
}