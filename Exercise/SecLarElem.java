package Exercise;
import java.util.Scanner;

class SecondLargest{
    public int findElem(int arr[]){
        int max=arr[0];
        int secMax=arr[0];

        for (int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secMax=max;
                max = arr[i];
            }
        }
        return secMax;
    }
}

public class SecLarElem {
    public static void main(String args[]){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array elements: ");

        n = sc.nextInt();

        System.out.println("Enter those array elements:");
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }


        SecondLargest sl = new SecondLargest();

        int res = sl.findElem(arr);
        
        System.out.println("Array elements are: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        System.out.println("Second largest element is: "+res);
    }
}
