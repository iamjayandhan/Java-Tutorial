public class BooleanMatrix{
    public static void main(String args[]){
        int mat[][] = {
            {1,0},
            {0,0}
        };

        int mat2[][] = {
            {1,0,0},
            {1,0,0},
            {1,0,0},
            {0,0,0}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat2);

        int resolvedMatrix[][] = resolveMatrix(mat2);
        System.out.println("Resolved Matrix:");
        printMatrix(resolvedMatrix);
    }

    public static int[][] resolveMatrix(int mat[][]){
        boolean rowFlag[] = new boolean[mat.length];
        boolean colFlag[] = new boolean[mat[0].length];

        for(int row=0;row<mat.length;row++){
            for(int col=0;col<mat[0].length;col++){
                if(mat[row][col] == 1){
                    rowFlag[row] = true;
                    colFlag[col] = true;
                }
            }
        }

        for(int row=0;row<mat.length;row++){
            for(int col=0;col<mat[0].length;col++){
                if(rowFlag[row] || colFlag[col]){
                    mat[row][col] = 1;
                }
            }
        }

        return mat;
    }

    public static void printMatrix(int mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length; j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }

}


// Given a boolean matrix mat[], where each cell contains either 0 or 1, modify it such that if a matrix cell matrix[i][j] is 1 then all the cells in its ith row and jth column will become 1.

// Examples:

// Input: mat[][] = [[1, 0], [0, 0]]
// Output: [[1, 1], [1, 0]] 
// Explanation: Only cell that has 1 is at (0,0) so all cells in row 0 are modified to 1 and all cells in column 0 are modified to 1.
// Input: mat[][] = [[1, 0, 0], [1, 0, 0], [1, 0, 0], [0, 0, 0]]
// Output: [[1, 1, 1], [1, 1, 1], [1, 1, 1], [1, 0, 0]]
// Explanation: The position of cells that have 1 in the original matrix are (0, 0), (1, 0) and (2, 0). Therefore, all cells in row 0, 1, 2 are and column 0 are modified to 1. 
// Input: mat[][] = [[0, 0], [0, 0]]
// Output: [[0, 0], [0, 0]] 
// Explanation: There is no cell that contains 1, so mat[] will remain the same.
// Constraints:
// 1 ≤ mat.size(), mat[0].size() ≤ 103
// 0 ≤ mat[i][j] ≤ 1