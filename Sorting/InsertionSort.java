class Sort{
    public static void sort(int arr[]){
        int i,j;
        for(j=1;j<arr.length;j++){
            int key = arr[j];
            i=j-1;
            while((i>-1) && arr[i]>key){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }
}

public class InsertionSort{
    public static void main(String args[]){
        int[] arr = { 64, 25, 12, 22, 11 };

        System.out.println("Before Sorting: ");
        for (int i : arr) {
            System.out.print(i+" ");
        }

        Sort.sort(arr);
        System.out.println();

        System.out.println("After Sorting: ");
        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();
    }
}