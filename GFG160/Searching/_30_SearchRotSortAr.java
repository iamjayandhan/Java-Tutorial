class Solution {
    int search(int[] arr, int key) {
        for (int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}

public class _30_SearchRotSortAr {
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;

        Solution sol = new Solution();
        System.out.println(sol.search(arr,key));
    }
}
