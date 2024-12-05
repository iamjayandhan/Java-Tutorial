class Solution {
    public int getSecondLargest(int[] arr) {
        int max=arr[0];
        int secMax=-1;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max && arr[i]>secMax){
                secMax= max;
                max=arr[i];
            }
            else if(arr[i]<max && arr[i]>secMax){
                secMax= arr[i];
            }
        }
        return secMax;
    }
}

public class SecondLargest{
    public static void main(String args[]){
        Solution sol = new Solution();
        int arr[] = {12,35, 1, 10, 34, 1};
        System.out.println(sol.getSecondLargest(arr));
    }
}