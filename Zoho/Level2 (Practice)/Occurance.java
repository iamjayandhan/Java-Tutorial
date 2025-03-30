import java.util.Scanner;

class Solution{
    public void occurance(String input,int k){
        int n = input.length();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<input.length();i++){
            StringBuilder temp = new StringBuilder();
            int freq = 0;

            while(i<n && Character.isLetter(input.charAt(i))){
                temp.append(input.charAt(i));
                i++;
            }

            while(i<n && Character.isDigit(input.charAt(i))){
                freq = (freq*10) + (input.charAt(i) - '0'); 
                i++;
            }

            i--;
            String tempstr = temp.toString();
            for(int j=0;j<freq;j++){
                res.append(tempstr);
            }

            temp.setLength(0);
            freq = 0;
        }

        System.out.println(res.toString());
        String result = res.toString();
        System.out.println(result.charAt(k-1));
        // List<String> list = new ArrayList<>();

        // StringBuilder temp = new StringBuilder();
        // for(int i=0;i<input.length()-1;i++){
        //     if((input.charAt(i) <= 58 && input.charAt(i+1) >=58)){
        //         temp.append(input.charAt(i));
        //         list.add(temp.toString());
        //         System.out.println(temp.toString());
        //         temp.setLength(0);
        //     }
        //     else if(i == input.length()-2){
        //         temp.append(input.charAt(i));
        //         temp.append(input.charAt(i+1));

        //         list.add(temp.toString());
        //         System.out.println(temp.toString());
        //     }
        //     else{
        //         temp.append(input.charAt(i));
        //     }
        // }

        // System.out.println(list.toString());
    }
} 

public class Occurance {
    public static void main(String args[]){
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);

        // System.out.print("Enter the input String: ");
        String input = "ab2cd2";

        obj.occurance(input,5);
    }
}
