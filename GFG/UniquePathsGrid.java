public class UniquePathsGrid {
    public static void main(String args[]){
        // int grid[][] = {
        //     {0,0,0},
        //     {0,1,0},
        //     {0,0,0}
        // };

        // int grid[][] = {
        //     {0,0,1},
        //     {1,0,0},
        //     {0,0,1}
        // };

        // int grid[][] = {
        //     {0,0,0,1,0},
        //     {1,0,0,0,1},
        //     {1,1,0,0,0}
        // };
        int grid[][] = {
            {1}
        };

        System.out.println("Unique paths in the matrix: "+ uniquePaths(grid));
    }

    public static int uniquePaths(int[][] grid) {
        //initial call with (0,0)
        int res = countUniquePaths(grid,0,0);
        return res;
    }
    
    public static int countUniquePaths(int [][] grid, int i, int j){
        System.out.println(i+" "+j);
        if(i == grid.length-1 && j == grid[0].length-1){
            return 1;
        }
        else if(i> grid.length-1 || j> grid[0].length-1 || grid[i][j] == 1){
            return 0;
        }
        //right + down possbilities
        return countUniquePaths(grid, i, j+1) + countUniquePaths(grid, i+1, j);
    }
}