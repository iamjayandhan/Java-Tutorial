public class Pattern {
    public static void main(String args[]){
        //       1
        //     2 1 2
        //   3 2 1 2 3
        
        int n = 5;
        printPattern(n);
    }    

    public static void printPattern(int n){

        int loopCount = 1;
        int spaces;
        int rev;

        while(loopCount<=n){
            spaces = n - loopCount;
            for(int space = 0; space<spaces; space++) System.out.print(" ");

            rev = n - spaces;
            for(int revNum=rev; revNum>=1; revNum--) System.out.print(revNum);

            for(int orgNum = 2; orgNum<=loopCount ; orgNum++) System.out.print(orgNum);

            System.out.println();
            loopCount++;
        }
       
    }
}
