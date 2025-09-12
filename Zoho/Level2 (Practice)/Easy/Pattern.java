public class Pattern{
    public static void main(String args[]){
        printPattern(5);
    }

    public static void printPattern(int n){
        for(int i=1; i<=n;i++){
            int temp = i;
            for(int j=1; j<=i;j++){
                System.out.print(temp+" ");
                temp += n - j;
            }
            System.out.println();
        }
    }
}