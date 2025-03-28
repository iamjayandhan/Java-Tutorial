public class RotateArr90 {
    public static void main(String args[]){
        int matrix[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        //logic:
        //Step1: Transpose
        //Step2: Reverse

        //Transpose
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<row;col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        printMatrix(matrix);

        //reverse it!
        reverseMatrix(matrix);

        System.out.println("Rotated matrix: ");
        printMatrix(matrix);
    }

    public static void reverseMatrix(int matrix[][]){

        for(int row[] : matrix){
            int l=0;
            int h=matrix.length-1;

            while(l<h){
                int temp = row[l];
                row[l] = row[h];
                row[h] = temp;

                l++;
                h--;
            }
        }

    }

    public static void printMatrix(int arr[][]){
        for(int row[] : arr){
            for(int elem: row){
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }
}
