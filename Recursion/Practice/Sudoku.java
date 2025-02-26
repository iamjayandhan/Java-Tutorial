public class Sudoku{
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

		System.out.println("Initial board:");
		display(board);
		System.out.println();

		//answer
		// 8 9 6 3 5 7 1 2 4 
		// 1 2 5 6 8 4 7 3 9 
		// 4 7 3 2 1 9 5 8 6 
		// 5 4 7 9 3 1 2 6 8 
		// 9 1 2 4 6 8 3 5 7 
		// 6 3 8 7 2 5 9 4 1 
		// 3 6 9 1 4 2 8 7 5 
		// 2 8 1 5 7 6 4 9 3 
		// 7 5 4 8 9 3 6 1 2 
		Solver(board,0,0);
	}

	public static void Solver(int board[][],int row,int col){
		if(row == 9){
			System.out.println("Board after solving!");
			display(board);
			System.out.println("\nYou can cross check the image included in this same directory!");

			return;
		}
		if(col == 9){
			Solver(board, row+1, 0);
			return;
		}

		if(board[row][col] == 0){
			for(int num=1;num<10;num++){
				if(isSafe(board,row,col,num)){
					board[row][col] = num;
					Solver(board,row,col+1);
					board[row][col] = 0;
				}
			}
		}
		else{
			Solver(board,row,col+1);
		}
		return;
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