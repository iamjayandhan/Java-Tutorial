public class MissingNumber {
    public static void main(String args[]){
        int arr[] = {3,1,0};
        int arr2[] = {};
        int arr3[] = {1,2};

        System.out.println(findMissingNumber(arr));
        System.out.println(findMissingNumber(arr2));
        System.out.println(findMissingNumber(arr3));
    }

    public static int findMissingNumber(int arr[]){
        int length = arr.length;
        if(length == 0){
            return 0;
        }

        int total = length * (length+1)/2;
        for(int num: arr){
            total -= num;
        }

        return total;
    }
}
