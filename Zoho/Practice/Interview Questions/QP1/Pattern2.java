public class Pattern2 {
    public static void main(String args[]){
        /*
         * Pattern Printing (without conditional statements, using only 2 loops and no array)
            1234
            4123
            3412
            2341
        */
        printPattern(4);
    }

    public static void printPattern(int n){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(((j-i+n)%n)+1);
            }
            System.out.println();
        }
    }
}
