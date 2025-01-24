import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutate {
    public static void main(String args[]){
        //only print output
        String str = "abc";
        permutate("", str);

        //return output as array
        ArrayList<String> res = permutateArr("",str);
        System.out.println(res.toString());

        //int array
        // int arr[] = {1,2,3};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<ArrayList<Integer>> res2 = new ArrayList<>();
        permutateIntArr(res2,new ArrayList<>(),arr);
        System.out.println(res2);

    }   

    public static void permutate(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }

        char ch = up.charAt(0);
        permutate(p+ch, up.substring(1));
        permutate(p, up.substring(1));
    }

    public static ArrayList<String> permutateArr(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(!p.isEmpty()){
                list.add(p);
            }
            // System.out.print(p+" ");
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = permutateArr(p+ch, up.substring(1));
        ArrayList<String> right = permutateArr(p, up.substring(1));

        left.addAll(right);
        return left;
    }


    public static void permutateIntArr(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp,ArrayList<Integer> arr){
        if(arr.isEmpty()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.size(); i++) {

            int num = arr.get(i); 
            temp.add(num);

            ArrayList<Integer> remaining = new ArrayList<>(arr);
            remaining.remove(i);

            permutateIntArr(res, temp, remaining);
            temp.remove(temp.size() - 1);
    }
}

}