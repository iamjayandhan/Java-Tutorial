//Best efficient sudoku solver!
//avoids unnecessary calls!
public class SudokuPro{
	public static void main(String args[]){
		int board[][] = {
			{0,9,6,0,0,0,0,2,4},
			{1,0,5,6,8,0,0,0,0},
			{4,7,0,2,1,0,0,8,6},
			{0,0,7,0,0,0,0,6,8},
			{9,0,0,4,0,8,0,5,0},
			{0,3,8,7,0,0,0,0,1},
			{0,6,0,1,0,0,8,7,0},
			{2,0,1,0,7,0,0,9,0},
			{0,0,4,8,9,0,0,0,0},
		};

		//check if it is solvable or not!
		if(Solver(board)){
			display(board);
		}
		else{
			System.out.println("The Sudoku is not solvable!");
		}
	}

	public static boolean Solver(int board[][]){
		int n = board.length;
		int row = -1; 
		int col = -1;

		//no empty cell (0) present? means it is solved!
		//else do iterate and try to solve it!
		boolean emptyLeft = true;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(board[i][j] == 0){
					//take a note on the row and col!
					row = i;
					col = j;
					emptyLeft = false;
					break;
				}
			}
			//if you found an empty element then break
			if(emptyLeft == false){
				break;
			}
		}

		//no empty cell is found? then the board is solved! 
		//check if it is true and return!
		if(emptyLeft == true){
			return true;
		}

		//if emptyLeft is false, then empty cell is found.
		//so we need to try all the possibilities!
		//we also perform backtracking!
		for(int num=1;num<=9;num++){
			if(isSafe(board, row, col, num)){
				board[row][col] = num;
				if(Solver(board)){
					return true;
				}
				else{
					//backtrack
					board[row][col] = 0;
				}
			}
		}
		//if all the possibilities cause conflict...then the board is not solvable!
		return false;
	}

	public static boolean isSafe(int board[][], int row, int col,int num){
		//check entire row
		for(int i=0;i<board.length;i++){
			if(board[row][i] == num){
				return false;
			}
		}

		//check entire col
		for(int i=0;i<board.length;i++){
			if(board[i][col] == num){
				return false;
			}
		}

		//check entire 3X3
		int sqrt = (int)(Math.sqrt(board.length));
		int r = row - row % sqrt;
		int c = col - col % sqrt;

		for(int i=r;i<r+sqrt;i++){
			for(int j=c;j<c+sqrt;j++){
				if(board[i][j] == num){
					return false;
				}
			}
		}
		//all test passed!
		return true;
	}

	public static void display(int board[][]){
		for(int row[] : board){
			for(int cell : row){
				System.out.print(cell+" ");
			}
			System.out.println();
		}
	}
}