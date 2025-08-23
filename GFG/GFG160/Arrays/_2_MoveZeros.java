class Solution{
    void pushZerosToEnd(int[] arr) {

        //method1
        // int count = 0;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]!=0){
        //         arr[count++] = arr[i];
        //     }
        // }

        // for(int i=count;i<arr.length;i++){
        //     arr[count++] = 0;
        // }

        //gpt
        // int count = 0; // Pointer for the next non-zero element
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] != 0) {
        //         arr[count++] = arr[i]; // Place non-zero element at the next position
        //     }
        // }
        // // Fill remaining positions with zeros
        // while (count < arr.length) {
        //     arr[count++] = 0;
        // }


        int count = 0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                count++;
            }
        }

        System.out.println();
    }
}

public class _2_MoveZeros{
    public static void main(String args[]){

        //Obj
        Solution obj = new Solution();

        //Input
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};


        System.out.println("Before operation: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        obj.pushZerosToEnd(arr);

        System.out.println("After operation: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}