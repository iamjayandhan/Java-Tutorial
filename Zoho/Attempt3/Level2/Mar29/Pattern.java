public class Pattern {
    public static void main(String args[]){
        // 4 4 4 4 4 4 4 
        // 4 3 3 3 3 3 4 
        // 4 3 2 2 2 3 4 
        // 4 3 2 1 2 3 4 
        // 4 3 2 2 2 3 4 
        // 4 3 3 3 3 3 4 
        // 4 4 4 4 4 4 4 
        //for n = 4

        int n = 4;
        int size = 2 * n - 1; // 7x7 for n=4
        int matrix[][] = new int[size][size];
        
        for (int layer = 0; layer < n; layer++) {
            int value = n - layer;
            for (int i = layer; i < size - layer; i++) {
                for (int j = layer; j < size - layer; j++) {
                    matrix[i][j] = value;
                }
            }
        }
        
        // Print the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
