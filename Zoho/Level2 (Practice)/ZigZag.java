class Solution{
    public void pattern(int arr[][],int n,int m){
        int row = 0;
        int col = 0;
        boolean isUp = true;
        
        while(row < n && col < m){
            if(isUp){
                int r = row,c = col;

            }
            else{
                int r = row,c = col;
            }
        }
    }
}

public class ZigZag {
    public static void main(String args[]){
        Solution obj = new Solution();
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int n = arr.length;
        int m = arr[0].length;
        obj.pattern(arr,n,m);
    }
}
