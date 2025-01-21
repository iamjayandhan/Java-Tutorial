class Solution{
    public void pattern(String s){
        int l = 0;
        int r = s.length()-1;
        int m = l+(r-l)/2;

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i==j){
                    System.out.print(s.charAt(l++)+" ");
                }
                if(i==j && i==m){
                    r--;
                }
                else if (i+j == s.length()-1){
                    System.out.print(s.charAt(r--)+" ");
                }
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}

public class Pattern{
    public static void main(String args[]){
        Solution obj = new Solution();
        obj.pattern("zohofinance");
    }
}