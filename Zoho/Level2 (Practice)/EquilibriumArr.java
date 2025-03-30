import java.util.Arrays;

class Solution{
    public int Equilibrium(int nums[]){
        if(nums.length == 1){
            return 0;
        }

         if (nums.length == 1) {
            return 0;
        }
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                return i;
            }
            
            leftSum += nums[i];
        }
        
        return -1;
        // int numsl= nums.length;
        
        // int pref[] = new int[numsl];
        // pref[0] = nums[0];
        // for(int i=1;i<numsl;i++){
        //     pref[i] = pref[i-1] + nums[i];
        // }

        // int suff[] = new int[numsl];
        // suff[numsl-1] = nums[numsl-1];
        // for(int i=numsl-2;i>=0;i--){
        //     suff[i] = suff[i+1] + nums[i];
        // }

        // for(int i=0;i<numsl;i++){
        //     if(i==0 && suff[1]==0) return 0;
        //     else if(i==numsl-1 && pref[numsl-2]==0) return numsl-1;
        //     else{
        //         if(i!=0 && i!=numsl-1 && pref[i-1]==suff[i+1]) return i;
        //     }
        // }

        // // System.out.println(Arrays.toString(pref));
        // // System.out.println(Arrays.toString(suff));
        // return -1;
    }
}

public class EquilibriumArr {
    public static void main(String args[]){
        Solution obj = new Solution();
        // System.out.print("Enter the input String: ");
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};

        int res = obj.Equilibrium(arr);
        System.out.println(res);
    }
}


