import java.util.ArrayList;
import java.util.List;

public class Permutate2 {
    public static void main(String args[]){
        int arr[] = {1,2,3};
        List<List<Integer>> ans = subset(arr);

        for(List<Integer> list : ans){
            System.out.print(list);
        }


        System.out.println();
        //duplicates?
        int arr2[] = {1,2,2};
        List<List<Integer>> ans2 = subset2(arr2);

        for(List<Integer> list : ans2){
            System.out.print(list);
        }
    }

    static List<List<Integer>> subset(int arr[]){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }
    static List<List<Integer>> subset2(int arr[]){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                if(!outer.contains(internal)){
                    outer.add(internal);
                }
            }
        }

        return outer;
    }
}
