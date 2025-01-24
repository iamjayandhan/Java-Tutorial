import java.util.Arrays;

public class QuickSort{
    public static void main(String args[]){
        int arr[] = {4,7,2,9,6,1};
        QuickSort.quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick(int arr[],int low,int high){

        if(low>=high){
            return;
        }

        int s = low;
        int e = high;
        int mid = arr[s+(e-s)/2];

        while(arr[s]<mid){
            s++;
        }
        while(arr[e]>mid){
            e--;
        }

        if(s<=e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        quick(arr, low, e);
        quick(arr, s, high);
    }
}