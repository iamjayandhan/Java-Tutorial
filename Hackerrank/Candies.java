import java.util.*;

public class Candies{
    public static void main(String args[]){
        int students = 10;
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,4,2,6,1,7,8,9,2,1));

        System.out.println("Total number of candies required: "+ candies(students, arr));
    }

    public static long candies(int students, List<Integer> arr){
        int n = arr.size();
        long candies = 0;

        List<Integer> left_ratings = new ArrayList<>();
        List<Integer> right_ratings = new ArrayList<>();

        for(int i=0;i<n;i++){
            left_ratings.add(0);
            right_ratings.add(0);
        }

        left_ratings.set(0,1);
        right_ratings.set(n-1,1);

        // * Left pass
        for(int i=1;i<n;i++){
            if(arr.get(i-1) < arr.get(i)) left_ratings.set(i, left_ratings.get(i-1) + 1);
            else left_ratings.set(i,1);
        }

        // * Right pass
        for(int i=n-2;i>=0;i--){
            if(arr.get(i) > arr.get(i+1)) right_ratings.set(i, right_ratings.get(i+1) + 1);
        }

        // * calculating total candies
        for(int i=0;i<n;i++){
            candies += Math.max(left_ratings.get(i), right_ratings.get(i));
        }
        return candies;
    }
}