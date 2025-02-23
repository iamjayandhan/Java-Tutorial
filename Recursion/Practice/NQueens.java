public class NQueens{
	public static void main(String args[]){

		//make true if a queen is placed!
		int n = 5;
		boolean board[][] = new boolean[n][n]; // all are false by default!
		
        System.out.println("Possible Ways: "+queens(board,0));
	}

	public static int queens(boolean board[][],int row){

		//First check if we are at valid row range!
		if(row  == board.length){
			//we came down after placing last queen on last row!
			//that means we found a possible solution!
			//print board and increase count by 1
			displayBoard(board);
			System.out.println();
			return 1;
		}

		int count = 0;
		int col;
		//place queen and check for conflicts
		for(col = 0; col<board.length;col++){
			//place the queen if it is safe!
			if(isSafe(board,row,col)){
				board[row][col] = true;
				count = count + queens(board,row+1);
				board[row][col] = false;
			}
		}
		return count;
	}

	//check for conflicts
	public static boolean isSafe(boolean board[][],int row, int col){ //Takes: O(N) time
		//return true if safe!
		//if conflict found, then return false!
		int tr = row;
		int tc = col;

		--tr;
		--tc;
		//up left
		while(tr>=0 && tc>=0){
			if(board[tr][tc]){
				return false;
			}
			--tr;
			--tc;
		}
		//reset
		tr = row;
		tc = col;

		--tr;

		//above
		while(tr>=0 && tc>=0){
			if(board[tr][tc]){
				return false;
			}
			--tr;
		}
		//reset
		tr = row;
		tc = col;

		--tr;
		++tc;

		//up right
		while(tr>=0 && (tc>=0 && tc<board.length)){
			if(board[tr][tc]){
				return false;
			}
			--tr;
			++tc;
		}
		return true;
	}

	//to display the board!
	public static void displayBoard(boolean board[][]){
		for(boolean row[] : board){
			for(boolean cell : row){
				if(cell) System.out.print("Q ");
				else System.out.print("X ");
			}
			System.out.println();
		}
	}
}