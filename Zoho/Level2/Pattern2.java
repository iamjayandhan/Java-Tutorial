import java.util.Scanner;

class Solution {
    public void pattern(int n){
        int odd = 1;
        int val = 1;

        for(int i=0;i<n;i++){
            int sp = n-i-1;
            
            for(int j=0;j<sp;j++){
                System.out.print(" ");
            }

            int v= i+1;
            for(int k=0;k<odd;k++){
                System.out.print(v);
                if(k<odd/2){
                    v++;
                }
                else{
                    v--;
                }

                //try2
                // if(k>=m){
                //     System.out.print(v++);
                // }
                // else{
                //     System.out.print(v--);
                // }

                //try1
                // if(k!=m && m!=0){
                //     System.out.print(i+1);
                // }
                // else{
                //     System.out.print(odd);
                // }
            }
            odd+=2;
            System.out.println();
        }
    }   
}

public class Pattern2 {
    public static void main(String args[]){
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);

        int input = 5;

        obj.pattern(input);
    }
}