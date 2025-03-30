import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public void compress(String str){
        // StringBuilder res = new StringBuilder();

        int freq[] = new int[26];
        for(char c : str.toCharArray()){
            freq[c-'a'] +=1;
        }

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(freq[c-'a'] >0 ){
                System.out.print(c+""+freq[c-'a']);
                freq[c-'a'] = 0;
            }
            // StringBuilder temp = new StringBuilder();
            // if(freq[i]!=0){
            //     temp.append((char)('a'+i));
            //     temp.append(freq[i]);
            // }
            // res.append(temp.toString());
            // temp.setLength(0);
        }
        System.out.println();
    }
}

public class OccuranceCompress {
    public static void main(String args[]){
Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the input String: ");
        String input = sc.nextLine();

        obj.compress(input);
        sc.close();
    }
}
