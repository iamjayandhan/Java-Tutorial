public class LargestNumberInSortedArray {
    public static void main(String args[]){
        //  Find the Nearest Number in a Sorted Array (Binary Search)
        int tc1[] = {2, 5, 9, 12}; 
        int t1 = 10;

        int tc2[] = {1, 4, 6, 8, 10, 13, 17, 21}; 
        int t2 = 15;

        int tc3[] = {5, 10, 15, 20}; 
        int t3 = 3;

        findNearest(tc1,t1);
        findNearest(tc2,t2);
        findNearest(tc3,t3);
    }

    public static void findNearest(int nums[], int target){
        int s = 0;
        int e = nums.length-1;

        while(s<=e){
            int m = (s+e)/2;
            if(nums[m] == target) {
                System.out.println("Nearest number is: " + nums[m]);
                return;
            }
            else if(nums[m] < target) s = m+1;
            else e = m - 1;
        }

        if(s >= nums.length) System.out.println("Nearest Number is: "+nums[nums.length-1]);
        else if(e < 0) System.out.println("Nearest Number is: "+ nums[0]);
        else{
            int diff1 = Math.abs(target - nums[e]);
            int diff2 = Math.abs(target - nums[s]);

            if(diff1 <= diff2){
                System.out.println("Nearest number is: "+ nums[e]);
            }
            else{
                System.out.println("Nearest number is: "+ nums[s]);
            }
        }
    }
}
