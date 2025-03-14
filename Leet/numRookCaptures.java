//https://leetcode.com/problems/available-captures-for-rook/?envType=problem-list-v2&envId=matrix

public class numRookCaptures {
    public static void main(String args[]){

        String board[][] = {
            {".",".",".",".",".",".",".","."},
            {".",".",".","p",".",".",".","."},
            {".",".",".","R",".",".",".","p"},
            {".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".","."},
            {".",".",".","p",".",".",".","."},
            {".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".","."}
        };

        String board2[][] = {
            {".",".",".",".",".",".","."},
            {".","p","p","p","p","p",".","."},
            {".","p","p","B","p","p",".","."},
            {".","p","B","R","B","p",".","."},
            {".","p","p","B","p","p",".","."},
            {".","p","p","p","p","p",".","."},
            {".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".","."}
        };

        String board3[][] = {
            {".",".",".",".",".",".",".","."},
            {".",".",".","p",".",".",".","."},
            {".",".",".","p",".",".",".","."},
            {"p","p",".","R",".","p","B","."},
            {".",".",".",".",".",".",".","."},
            {".",".",".","B",".",".",".","."},
            {".",".",".","p",".",".",".","."},
            {".",".",".",".",".",".",".","."}
        };

        int coords[] = new int[2];
        coords = findRook(board);

        System.out.println(coords[0]+" "+coords[1]);

        System.out.println("Number of possible pawn kills: "+attack(board3, coords[0], coords[1]));
    }

    public static int attack(String board[][],int x,int y){

        int res = 0;

        //left
        for(int col=y-1;col>=0;col--){
            if(board[x][col].equals("p")) res++;
            else if (board[x][col].equals("B")) break;
        }

        //right
        for(int col=y+1;col<board[0].length;col++){
            if(board[x][col].equals("p")) res++;
            else if (board[x][col].equals("B")) break;
        }

        //up
        for(int row=x-1;row>=0;row--){
            if(board[row][y].equals("p")) res++;
            else if (board[row][y].equals("B")) break;
        }

        //down
        for(int row=x+1;row<board.length;row++){
            if(board[row][y].equals("p")) res++;
            else if (board[row][y].equals("B")) break;
        }

        return res;
    }

    public static int[] findRook(String board[][]){
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y].equals("R")){
                    return new int[]{x,y};
                }
            }
        }

        //if not found
        return new int[]{-1,-1};
    }
}
