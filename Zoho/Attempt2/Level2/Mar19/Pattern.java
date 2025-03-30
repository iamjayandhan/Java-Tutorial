import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Pattern {
    public static void main(String[] args) {
        String tc1 = "ZOHO";
        String tc2 = "1234567";

        List<String> tcs = new ArrayList<>(Arrays.asList(tc1,tc2));

        for(String tc : tcs){

            //check if has even length, if yes convert it!
            if(tc.length() % 2 ==0){
                tc = EvenToOddLengthMaker(tc);
                System.out.println(tc+"\n");
            }
            printPattern(tc);
            System.out.println("\n");
        }

    }

    public static void printPattern(String tc){

        int n = tc.length();
        int mid = n / 2; // Middle index

        int T = 0;
        int L = 0;
        int d1 = 0;
        int d2 = 0;

        for(int i=0;i<tc.length();i++){
            for(int j=0;j<tc.length();j++){
                if(i==j && i == n/2){
                    System.out.print(tc.charAt(mid)+" ");
                    d1++;
                    d2++;
                    T++;
                    L++;
                }
                else if(i==j){
                    System.out.print(tc.charAt(d1)+" ");
                    d1++;
                }
                else if (i+j == n-1) {
                    System.out.print(tc.charAt(d2)+" ");
                    d2++;
                }
                else if(i == mid){
                    System.out.print(tc.charAt(L)+" ");
                    L++;
                }
                else if(j == mid){
                    System.out.print(tc.charAt(T)+" ");
                    T++;
                }
                else{
                    System.out.print("  ");
                }

                //only star!
                // //Left to Right (row fixed)
                // boolean middleRow = (i == mid);

                // //Top to Bottom (col fixed)
                // boolean middleCol = (j == mid);

                // //Main Diagonal (Top left to Bottom right)
                // boolean mainDiagonal = (i == j);

                // //Secondary Diagonal (Top right to Bottom left)
                // boolean secDiagonal = (i + j == n - 1);

                // if(middleRow || middleCol || mainDiagonal || secDiagonal) System.out.print(tc.charAt(j)+" ");
                // else System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static String EvenToOddLengthMaker(String tc){
        
        int mid = tc.length()/2;
        String firstHalf = tc.substring(0,mid);
        String secondHalf = tc.substring(mid);

        return firstHalf+"*"+secondHalf;
    }
}
