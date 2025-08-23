class Solution {
    public int findMin(int[] arr) {
        int mid = 0;
        int l=0, h=arr.length-1;
        
        
        while(l<h){

            if(arr[l] == arr[h]){
                return arr[l];
            }

            mid = (l+h)/2;
            if(arr[mid]>arr[h]){
                l = mid+1;
            }
            else{
                h = mid;
            }
        }
        return arr[l];
    }
}

public class _29_SortedRotated{
    public static void main(String args[]){
        Solution sol = new Solution();
        int arr[] = {5, 6, 1, 2, 3, 4};
        System.out.println(sol.findMin(arr));
    }
}

