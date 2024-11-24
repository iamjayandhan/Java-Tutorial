package Exercise;
import java.util.ArrayList;


class MergeArr{
    public ArrayList<Integer> mergeArr(int arr1[],int arr2[]){

        ArrayList<Integer> merged = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                merged.add(arr1[i]);
                i++;
            }
            else{
                merged.add(arr2[j]);
                j++;
            }
        }

        while(i<arr1.length){
            merged.add(arr1[i]);
            i++;
        }

        while(j<arr2.length){
            merged.add(arr2[j]);
            j++;
        }

        return merged;

    }
}

public class MergeSortedArr {
    public static void main(String args[]){
        int arr1[] = {1,4,5,7,8};
        int arr2[] = {2,3,6,9,10};

        MergeArr obj = new MergeArr();

        ArrayList<Integer> res = obj.mergeArr(arr1, arr2);

        System.out.println("Merged Sorted array: ");
        for(int num:res){
            System.out.print(num+" ");
        }
    }
}
