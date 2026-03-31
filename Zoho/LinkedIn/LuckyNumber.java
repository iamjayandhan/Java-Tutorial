
import java.util.Arrays;
import java.util.HashMap;

public class LuckyNumber {

    //Rank	Method	            Approach	        Time	    Space	Why
    //#1	findLuckyNumber2	HashMap optimized	O(n)	    O(k)	Best balance, very clean
    //#2	findLuckyNumber4	Frequency array	    O(n)	    O(max)	Fast but risky memory
    //#3	findLuckyNumber	    Original HashMap	O(n)	    O(k)	Slightly less optimal
    //#4	findLuckyNumber3	Sorting	            O(n log n)	O(1)	Slowest but simple
    public static void main(String args[]){

        //return largest lucky number
        //-1 if not found.
        //number == count(number) means lucky number!
        int arr[] = {1,2,2,3};
        int arr2[] = {5,5,5,5};
        
        System.out.println("lucky: "+findLuckyNumber4(arr));
        System.out.println("lucky: "+findLuckyNumber4(arr2));
    }
    
    //O(n)
    public static int findLuckyNumber(int arr[]){
        int res = -1;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }

        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i]) == arr[i]) {
                if(arr[i] > res) res = arr[i];
            }
        }
        return res;
    }

    // optimized! O(n)
    public static int findLuckyNumber2(int arr[]){
        int res = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int key: map.keySet()){
            if(map.get(key) == key){
                res = Math.max(res, key);
            }
        }

        return res;
    }

    //using sorting O(nlogn)
    public static int findLuckyNumber3(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = -1;

        for (int i = 0; i < n; ) {
            int num = arr[i];
            int count = 0;

            while (i < n && arr[i] == num) {
                count++;
                i++;
            }

            if (num == count) {
                res = num;   // always larger because array is sorted
            }
        }

        return res;
    }

    //using frequency array
    public static int findLuckyNumber4(int[] arr) {
        int res = -1;

        //find the largest number to create a freq array
        int maxValue = 0;
        for(int n: arr){
            maxValue = Math.max(maxValue, n);
        }

        int freq[] = new int[maxValue+1];

        for(int n: arr){
            freq[n]++;
        }

        for(int i=1;i<freq.length;i++){
            if(freq[i] == i) res = i;
        }

        return res;
    }
}
