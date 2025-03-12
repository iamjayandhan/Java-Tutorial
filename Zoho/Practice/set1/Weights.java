// 2. Given a set of numbers like <10, 36, 54,89,12> we want to find sum of weights based on the following conditions
//     1. 5 if a perfect square
//     2. 4 if multiple of 4 and divisible by 6
//     3. 3 if even number
// And sort the numbers based on the weight and print it as follows
// <10,its_weight>,<36,its weight><89,its weight>
// Should display the numbers based on increasing order.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class Weights{
    public static void main(String args[]) {
        int weights[] = {10, 36, 54, 89, 12};

        // Step 1: Store numbers and their weights as a list of NumberWeight objects
        List<NumberWeight> numList = new ArrayList<>();

        for (int num : weights) {
            int weight = calculateWeight(num);
            numList.add(new NumberWeight(num, weight));
        }

        // Step 2: Sort the list based on weight, then by number (ascending)
        Collections.sort(numList, new Comparator<NumberWeight>() {
            @Override
            public int compare(NumberWeight a, NumberWeight b) {
                return Integer.compare(a.num,b.num);
            }
        });

        // Step 3: Print sorted numbers with their weights
        for (NumberWeight p : numList) {
            System.out.print("<" + p.num + "," + p.weight + "> ");
        }
    }

    // Custom class to store number-weight pairs
    static class NumberWeight  {
        int num;
        int weight;

        NumberWeight (int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static int calculateWeight(int num) {
        if (perfectSquare(num)) return 5;
        if (div46(num)) return 4;
        if (even(num)) return 3;
        return 0;
    }

    public static boolean perfectSquare(int num){
        int sqr = squareRoot(num);
        return (sqr*sqr) == num;

    }

    public static boolean div46(int num){
        return num%4==0 && (num%2==0 && num%3==0);
    }

    public static boolean even(int num){
        return num%2 == 0;
    }

    public static int squareRoot(int num){

        int start = 1;
        int end = num;

        int ans = 0;

        while(start<=end){
            int mid = start + (end - start)/2;

            if(mid*mid == num) return mid;
            else if (mid*mid < num){
                start++;
                ans = mid;
            }
            else end--;
        }
        return ans;
    } 
}
