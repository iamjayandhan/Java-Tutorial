import java.util.ArrayList;

public class RecursionMaze{
	public static void main(String args[]){
		int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
		// maze("",mat,0,0);
		// System.out.println(maze2("",mat,0,0));
		// ArrayList<String> res = mazeList("",mat,0,0);
		// System.out.println(res);

		//Diagonal
		// mazeDiagonal("",mat,0,0);
		// ArrayList<String> res = mazeDiagonalList("",mat,0,0);
		// System.out.println(res);
		System.out.println(maze2("",mat,0,0));		
	}


	//Diagonal move? ArrayList!
	public static ArrayList<String> mazeDiagonalList(String way,int mat[][],int row,int col){
		if(row>mat.length || col>mat[0].length){
			return new ArrayList<>();
		}
		if(row == mat.length-1 && col == mat[0].length){
			ArrayList<String> path = new ArrayList<>();
			path.add(way);
			return path;
		}

		ArrayList<String> res = new ArrayList<>();
		res.addAll(mazeDiagonalList(way+"H", mat, row, col+1));
		res.addAll(mazeDiagonalList(way+"V", mat, row+1, col));
		res.addAll(mazeDiagonalList(way+"D", mat, row+1, col+1));

		return res;
	}

	//Diagonal move? print ways!
	public static void mazeDiagonal(String way,int arr[][],int row, int col){
		if(row>arr.length || col>arr[0].length){
			return;
		}
		if(row == arr.length-1 && col == arr[0].length-1){
			System.out.println(way);
			return;
		}

		mazeDiagonal(way+"H",arr,row,col+1);
		mazeDiagonal(way+"V",arr,row+1,col);
		mazeDiagonal(way+"D",arr,row+1,col+1);
		return;
	}

	//return path as arraylist!
	public static ArrayList<String> mazeList(String way,int arr[][],int row, int col){
		if(row>arr.length || col>arr[0].length){
			return new ArrayList<>();
		}
		if(row == arr.length-1 && col == arr[0].length-1){
			ArrayList<String> res = new ArrayList<>();
			res.add(way);
			return res;
		}

		ArrayList<String> res = new ArrayList<>();
		res.addAll(mazeList(way+"R",arr,row,col+1));
		res.addAll(mazeList(way+"D",arr,row+1,col));
		return res;
	}

	//count ways!
	public static int maze2(String way,int arr[][],int row, int col){
		if(row>arr.length || col>arr[0].length){
			return 0;
		}
		if(row == arr.length-1 && col == arr[0].length-1){
			// System.out.println(way);
			return 1;
		}

		return maze2(way+"R",arr,row,col+1) + maze2(way+"D",arr,row+1,col);
	
	}

	//print ways
	public static void maze(String way,int arr[][],int row, int col){
		if(row>arr.length || col>arr[0].length){
			return;
		}
		if(row == arr.length-1 && col == arr[0].length-1){
			System.out.println(way);
			return;
		}

		maze(way+"R",arr,row,col+1);
		maze(way+"D",arr,row+1,col);
		return;
	}
}