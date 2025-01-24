import java.util.Arrays;

public class MergeInPlace{

    public static void mergeSort(int arr[], int s, int e){
        if(e-s == 1){
            return;
        }
        int m = (s+e)/2;
        mergeSort(arr,s,m);
        mergeSort(arr,m,e);

        merge(arr, s , m ,e);
    }

    public static int[] merge(int arr[], int s,int m, int e){
        int i = s;
        int j = m;
        int k = 0;

        int mix[] = new int[e-s];

        while(i<m && j<e){
            if(arr[i]<arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<m){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j<e){
            mix[k] = arr[j];
            j++;
            k++;
        }
        
        //move mix elem into that curr arr elems!
        for(i=0;i<mix.length;i++){
            arr[s+i] = mix[i];
        }
        return arr;
    }
    public static void main(String args[]){
        int arr[] = {3,1,2,9,6};
        MergeInPlace.mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}