class BinarySearch{
    public int binarySearch(int arr[],int l,int r){
        int res=-1;

        while (l<=r){
            int mid = (l+r)/2;

            //{0,0,0,0,1,1,1};
            if(arr[mid]==1 && arr[mid-1]==0){
                return mid;
            }
            else if(arr[mid]==0){
                l = mid+1;
            }
            else if (arr[mid]==1){
                r = mid-1;
            }
        }
        return res;
    }
}

public class BinSearch{
    public static void main(String[] args) {

        //Obj
        BinarySearch bin = new BinarySearch();

        //Input array
        int arr[] = {0,0,0,1,1,1,1,1,1};

        //Result
        System.out.println(bin.binarySearch(arr,0,arr.length-1));
    }
}