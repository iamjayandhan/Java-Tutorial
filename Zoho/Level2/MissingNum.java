public class MissingNum {
    public static void main(String args[]){
        /* 
         * Question:
                Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
                Input: nums = [3, 0, 1]
                Output = 2
                Explanation: The range is [0, 1, 2, 3]. Number 2 is missing.
        */

        int nums[] = {3,0,1};
        int n = nums.length;
        int totSum = n*(n+1)/2;


        for(int i=0;i<nums.length;i++){
            totSum-=nums[i];
        }
        System.out.println(totSum);

    }
}
