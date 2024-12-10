class Sort{
    public static void sort(int arr[]){
        
        int i,j;
        for(i=0;i<arr.length-1;i++){
            int min_idx = i;
            for(j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min_idx]){
                    min_idx=j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}

public class SelectionSort{
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