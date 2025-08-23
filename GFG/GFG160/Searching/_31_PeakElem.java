class Solution {
    public int peakElement(int[] arr) {
        if(arr.length == 1){
            return 0;
        }
        for(int i=0;i<arr.length;i++){
            if(i==0){
                if(arr[i]>arr[i+1]){
                    return i;
                }
            }
            else if(i == arr.length-1){
                if(arr[i]>arr[i-1]){
                    return i;
                }
            }
            else{
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                    return i;
                }
            }
        }
        return -1;
    }
}


public class _31_PeakElem {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 7, 8, 3};
        Solution sol = new Solution();
        System.out.println(sol.peakElement(arr));
    }
}