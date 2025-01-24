import java.util.Scanner;


class Solution{
    public void pattern(String s){
        if(s.length() % 2 ==0){
            System.out.println("Please provide odd length string input");
            return;
        }
        int l = 0;
        int r = s.length() - 1; 
        int mid = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j && i == mid) {
                    System.out.print(s.charAt(l++) + " ");
                    r--;
                } else if (i == j) {
                    System.out.print(s.charAt(l++) + " ");
                } else if (i + j == s.length() - 1) { 
                    System.out.print(s.charAt(r--) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        //slightly has space in middle!
        // int l = 0;
        // int r = s.length()-1;
        // int m = l+(r-l)/2;

        // for(int i=0;i<s.length();i++){
        //     for(int j=0;j<s.length();j++){
        //         if(i==j){
        //             System.out.print(s.charAt(l++)+" ");
        //         }
        //         if(i==j && i==m){
        //             r--;
        //         }
        //         else if (i+j == s.length()-1){
        //             System.out.print(s.charAt(r--)+" ");
        //         }
        //         else System.out.print("  ");
        //     }
        //     System.out.println();
        // }
    }
}

public class Pattern{
    public static void main(String args[]){
        Solution obj = new Solution();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an odd length string: ");
        String input = sc.nextLine();

        // obj.pattern(args[0]);
        obj.pattern(input);
        sc.close();
    }
}