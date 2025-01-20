class Solution {
    public void reverseArray(int arr[]) {
        int i=0;
        int j=arr.length-1;
        
        while(i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}

public class _3_ReverseArray{
    public static void main(String args[]){
        Solution obj = new Solution();

        //Input
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};


        System.out.println("Before operation: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        obj.reverseArray(arr);

        System.out.println("After operation: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}