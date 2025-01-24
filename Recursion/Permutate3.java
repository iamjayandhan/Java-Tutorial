import java.util.ArrayList;
import java.util.List;

public class Permutate3 {

    public static List<String> res = new ArrayList<>();
    public static void main(String args[]) {

        String input = "abc";
        permute0("",input);

        System.out.println(res);

        System.out.println();
        System.out.println();
        //arr
        int arr[] = {1, 2, 3};

        // Generate permutations
        List<List<Integer>> ans = new ArrayList<>();
        permute(arr, new ArrayList<>(), ans);

        // Print permutations
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    static void permute0(String p, String input){
        if(input.isEmpty()){
            System.out.print(p+" ");
            res.add(p);
            return;
        }

        Character ch = input.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0, i);
            String l = p.substring(i,p.length());
            permute0(f+ch+l, input.substring(1));
        }
    }

    static void permute(int[] arr, List<Integer> temp, List<List<Integer>> ans) {
        // Base case: if the temporary list size equals the array length, we found a permutation
        if (temp.size() == arr.length) {
            ans.add(new ArrayList<>(temp)); // Add a copy of the temp list to the result
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (temp.contains(arr[i])) {
                continue; // Skip if the number is already in the temporary list
            }

            temp.add(arr[i]); // Choose the current element
            permute(arr, temp, ans); // Recurse to find permutations with the current choice
            temp.remove(temp.size() - 1); // Backtrack to try the next choice
        }
    }
}
