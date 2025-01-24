class Solution{
    public void floodFill(int[][] screen, int x, int y, int newColor){
        int M = screen.length;
        int N = screen[0].length;
        int orgColor = screen[x][y];

        if(orgColor == newColor){
            return;
        }

        floodFillUtil(screen, x, y, orgColor,newColor,M,N);
    }

    public void floodFillUtil(int[][] screen, int x, int y, int orgColor, int newColor,int M,int N){
        if (x < 0 || x >= M || y < 0 || y >= N || screen[x][y] != orgColor) {
            return;
        }

        screen[x][y] = newColor;
        // Recursively call for north, south, east, and west pixels.
        floodFillUtil(screen, x + 1, y, orgColor, newColor, M, N); // Down
        floodFillUtil(screen, x - 1, y, orgColor, newColor, M, N); // Up
        floodFillUtil(screen, x, y + 1, orgColor, newColor, M, N); // Right
        floodFillUtil(screen, x, y - 1, orgColor, newColor, M, N); // Left
    }
}

public class MsPaint {
    public static void main(String[] args) {
        int[][] screen = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int x = 4, y = 4, newColor = 3;

        Solution obj = new Solution();
        obj.floodFill(screen, x, y, newColor);

        // Print the updated screen.
        System.out.println("Updated Screen:");
        for (int[] row : screen) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}