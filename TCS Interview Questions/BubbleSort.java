class Bubble{
    public void bubbleSort(int arr[]){

        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

public class BubbleSort{
    public static void main(String args[]){
        
        //Obj
        Bubble sort = new Bubble();

        //Input array
        int arr[] = {5, 2, 9, 1, 5, 6};

        System.out.println("Before Sorting: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        sort.bubbleSort(arr);

        System.out.println();
        System.out.println("After Sorting: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }
}