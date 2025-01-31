public class RecursionPatters{
	public static void main(String args[]){
		int n = 5;
		// pattern1(n);
		// mirrorRight(n);
		mirrorRight2(n);
	}


	//normal right
	public static void mirrorRight2(int n){
		int row = 0;
		int col = 0;

		mirrorRightHelper2(n,row,col);
	}

	public static void mirrorRightHelper2(int size, int row, int col){
		if(row == size){
			return;
		}
		else if (col<=row){
			mirrorRightHelper2(size, row, col+1);
			System.out.print("* ");
		}
		else{
			mirrorRightHelper2(size, row+1,0);
			System.out.println();
		}

	}

	//normal right
	public static void right(int n){
		int row = 0;
		int col = 0;

		rightHelper(n,row,col);
	}

	public static void rightHelper(int size, int row, int col){
		if(row == size){
			System.out.println();
			return;
		}
		else if (col<=row){
			System.out.print("* ");
			rightHelper(size, row, col+1);
		}
		else{
			System.out.println();
			rightHelper(size, row+1,0);
		}

	}


	//mirror right
	public static void mirrorRight(int n){
		int row =0;
		int col = 0;

		mirrorRightHelper(n,row,col);
	}

	public static void mirrorRightHelper(int size,int row, int col){
		if(row == size-1){
			System.out.println("*");
			return;
		}
		if(row + col < size){
			System.out.print("* ");
			mirrorRightHelper(size,row,col+1);
		}
		if(row+col == size){
			System.out.println();
			mirrorRightHelper(size,row+1, 0);
		}
	}
	
	//square pattern
	public static void pattern1(int n){ //passed value n = 5
		int row =  0;
		int col = 0;

		pattern1Helper(n,row,col);
	}

	public static void pattern1Helper(int size,int row,int col){
		if(row>=size || col>=size){
			return;
		}
		else if(col == size-1){
			System.out.println("*");
			pattern1Helper(size , row+1,0);
		}
		else{
			System.out.print("* ");
			pattern1Helper(size,row,col+1);
		}
	}
}