class Solution{
    public void binSearch(int arr[], int target){
        int l = 0;
        int h = arr.length-1;
        int res = -1;
        res = Search(l,h,arr,target);
        System.out.println(res);
    }

    public int Search(int l,int h,int arr[],int target){
        if(l>h){
            return -1;
        }
        int mid = l+(h-l)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]<target){
            return Search(mid+1,h,arr,target);
        }
        else{
            return Search(l,mid-1,arr,target);
        }
    }
}

public class BinarySearch {
    public static void main(String args[]){
        Solution sol = new Solution();
        int arr[] = {2,4,5,7,8,9};
        int target = 2;

        sol.binSearch(arr,target);
    }
}
