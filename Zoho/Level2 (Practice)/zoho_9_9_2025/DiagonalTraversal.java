public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 }
        };

        printDiagonalTraversal(mat);
    }

    public static void printDiagonalTraversal(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        for (int sum = 0; sum <= rows + cols - 2; sum++) {
            for (int i = 0; i < rows; i++) {
                int j = sum - i;
                if (j >= 0 && j < cols) {
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
    }
}
