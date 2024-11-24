package Exercise;

class Reverse{
    int[] rev(int arr[]){
        int rev_arr[] = new int[arr.length];

        for (int i=arr.length-1;i>=0;i--){
            rev_arr[arr.length-1-i] = arr[i];
        }

        return rev_arr;
    }
}


public class ReverseArr {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};

        System.out.println("Initial Array: ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Reverse rev = new Reverse();
        int[] rev_arr = rev.rev(arr);
        System.out.println("Reversed Array length: "+rev_arr.length);

        System.out.println("Initial Array: ");
        for (int i=0;i<rev_arr.length;i++){
            System.out.print(rev_arr[i] + " ");
        }

    }
}
