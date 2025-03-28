
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class EvenOdd {
    //3. Given an array, sort all even numbers in ascending order and all odd numbers in descending order while keeping their original positions intact
    public static void main(String args[]){
        // int arr[] = {3,4,5,1,2};
        int arr[] = {-8,7,3,-2,1,7};
        int pos[] = new int[arr.length];

        //fill even number positions with -1 as marker
        for(int i=0;i<arr.length;i++){
            if(arr[i] % 2 == 0){
                pos[i] = -1;
            }
        }

        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        for(int elem : arr){
            if(elem % 2 == 0) evens.add(elem);
            else odds.add(elem);
        }

        Collections.sort(evens); //TimSort is a hybrid of Merge Sort and Insertion Sort.
        Collections.sort(odds,Collections.reverseOrder()); 

        System.out.println(evens+"\n"+odds);

        int eptr = 0;
        int optr = 0;
        for(int i=0;i<pos.length;i++){
            if(pos[i] == -1) pos[i] = evens.get(eptr++);
            else pos[i] = odds.get(optr++);
        }

        System.out.println(Arrays.toString(pos));

    }
}
