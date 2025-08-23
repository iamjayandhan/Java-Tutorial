class Solution {
    public int singleDigit(int n) {
        
        int temp = n;
        int sum = 0;
        
        while((temp+"").length()!=1){
            while(temp!=0){
                sum+=temp%10;
                temp=temp/10;
            }
            temp = sum;
            sum=0;
        }
        return temp;
    }
}

public class _1_RepAddDigits{
    public static void main(String args[]){
        int n = 9;

        //Obj
        Solution obj = new Solution();
        System.out.println("Sum of "+n+" is: "+obj.singleDigit(n));
    }
}