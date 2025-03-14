
import java.util.Arrays;


public class LongestSubSeq{
    public static void main(String args[]){

        // int nums[] = {1,2,4,3};
        // int nums[] = {10,9,2,5,3,7,101,18};
        int nums[] = {0,1,0,3,2,3};
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        //we know last number has longest subsequence of 1 (Always)
        dp[n-1] = 1;

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                // if(nums[i]<nums[j]) dp[i] = 1 + dp[j];
                // else dp[i] = 1;
                // break;
                if(nums[i]<nums[j]) dp[i] = Math.max(dp[i],1+dp[j]);
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
    }
}