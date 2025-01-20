class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    // static void rotateArr(int arr[], int d) {
        //method1: Naive Approach (Takes more time!)
        // int c=0;
        // while(c<d){
        //     int temp = arr[0];
        //     for(int i=0;i<arr.length-1;i++){
        //         arr[i] = arr[i+1];
        //     }
        //     arr[arr.length-1] = temp;
        //     c++;
        // }
    // }
    static void rotate(int arr[], int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    //rot (first d elems)
    //rot (rem elems)
    //rot (entire arr)
    //O(n)
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d%n;

        rotate(arr,0,d-1);
        rotate(arr,d,n-1);
        rotate(arr,0,n-1);
    }
}

public class _4_RotateArray{
    public static void main(String args[]){

        int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        System.out.println("Before Rotation: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        Solution.rotateArr(arr,3);
        System.out.println();

        System.out.println("After Rotation: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}