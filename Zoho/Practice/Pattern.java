public class Pattern {
    public static void main(String[] args) {
        int n = 3;

        for(int i=1;i<=n;i++){

            for(int space = 1;space<=n-i;space++){  
                System.out.print("  ");
            }

            // Print decreasing numbers
            for (int num = i; num >= 1; num--) {
                System.out.print(num + " ");
            }
            
            // Print increasing numbers
            for (int num = 2; num <= i; num++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
