// A) Alternate sorting: Given an array of integers, rearrange the array in such a way that the first element is first maximum and second element is first minimum.

//     Eg.) Input  : {1, 2, 3, 4, 5, 6, 7}
//          Output : {7, 1, 6, 2, 5, 3, 4} 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlternativeSort{
    public static void main(String args[]){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,5,6,3,2,1,7));
        ArrayList<Integer> res = new ArrayList<>();

        //sort the array
        Collections.sort(A);
        System.out.println("A="+A);
            
        int i=0,j=A.size()-1;
        while(i<j){
            res.add(A.get(j--));
            res.add(A.get(i++));
        }
        if(i==j) res.add(A.get(i));

        System.out.println(res);
        
    }
}