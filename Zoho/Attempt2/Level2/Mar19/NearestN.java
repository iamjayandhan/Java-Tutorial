import java.util.Arrays;

public class NearestN {
    public static void main(String args[]){
        // Nearest Neighbour of all the elements
        // Given an array, for each element, find the nearest greater element that appears after it in the array. If no such element exists, return -1.
        // int arr[] = {4,5,2,10,8};
        int arr[] = {5,5,5};

        int sorted[] = arr.clone(); // Object provides this method! to create a copy!
        Arrays.sort(sorted);

        int res[] = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int ind = binarySearch(sorted,arr[i]);
            res[i] = ind;
        }

        System.out.println(Arrays.toString(res));
    }

    public static int binarySearch(int arr[],int key){
        
        int l = 0;
        int h = arr.length-1;
        int ans = -1;

        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]>key){
                ans = arr[mid];
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        return ans;
    }
}
