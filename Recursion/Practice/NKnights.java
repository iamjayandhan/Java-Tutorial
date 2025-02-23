public class NKnights{
	public static void main(String args[]){

		int n = 3;
		int knights = 3; //4 knights to be placed!
		boolean board[][] = new boolean[n][n];
		System.out.println("Possible Ways: "+knights(board,0,0,knights));
	}

	public static int knights(boolean board[][],int row,int col, int knights){
		if(knights == 0){
			display(board);
			System.out.println();
			return 1;
		}

		int count = 0;

		//exit if max row has been reached!
		if(row == board.length-1 && col == board.length){
			return 0;
		}

		//go down if col exceeds!
		if(col == board.length){
			return count + knights(board,row+1,0,knights);
		}

		//place knight if safe!
		if(isSafe(board, row, col)){
			board[row][col] = true;
			count = count + knights(board, row, col+1, knights-1);
			board[row][col] = false;
		}

		//if not safe, move ahead!
		count = count + knights(board,row,col+1,knights);

		return count;
	}

	public static boolean isSafe(boolean board[][], int row, int col){
		int tr;
		int tc;

		//left above diagonal
		tr = row-1;
		tc = col -2;
		if(tr>=0 && tc>=0 && board[tr][tc]){
			return false;
		}

		//right above diagonal
		tr = row - 1;
		tc = col + 2;
		if(tr>=0 && tc<board.length && board[tr][tc]){
			return false;
		}

		//above diagonals
		tr = row -2;
		tc = col - 1;
		if(tr>=0 && tc>=0 && board[tr][tc]){
			return false;
		}

		tr = row - 2;
		tc = col + 1;
		if(tr>=0 && tc<board.length && board[tr][tc]){
			return false;
		}
		return true;
	}

	public static void display(boolean board[][]){
		for(boolean row[] : board){
			for(boolean cell : row){
				if(cell) System.out.print("K ");
				else System.out.print("X ");
			}
			System.out.println();
		}
	}

}