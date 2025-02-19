import java.util.Arrays;

public class RecusrionBacktrack{
	public static void main(String args[]){
		int [][]maze = {{1,1,1},{1,1,1},{1,1,1}};
		int matPath[][] = {{0,0,0},{0,0,0},{0,0,0}};

		// System.out.println("Straight path: ");
		// backtrack("",maze,0,0);

		// System.out.println('\n');

		System.out.println("Straight path + Matrix: ");
		backtrackMatrix("",maze,0,0,matPath,1);

		// System.out.println("Cross allowed path: ");
		// backtrackPro("",maze,0,0);
	}


	//backtrack with steps matrix!
	public static void backtrackMatrix(String way, int maze[][], int r,int c,int matPath[][],int matPathCount){
		if(r<0 || c<0 || r>=maze.length || c>= maze[0].length){
			return;
		}
		else if(r == maze.length-1 && c == maze[0].length-1){
			matPath[r][c] = matPathCount;
			System.out.println(way);
			for(int row[]:matPath){
				System.out.println(Arrays.toString(row));	
			}
			System.out.println();	
			return;
		}
		else if(maze[r][c] == -1){
			return;
		}
		else{
			maze[r][c] = -1;
			matPath[r][c] = matPathCount;
		}

		backtrackMatrix(way+"R",maze,r,c+1,matPath,matPathCount+1);
		backtrackMatrix(way+"D",maze,r+1,c,matPath,matPathCount+1);
		backtrackMatrix(way+"L",maze,r,c-1,matPath,matPathCount+1);
		backtrackMatrix(way+"U",maze,r-1,c,matPath,matPathCount+1);

		//cross paths
		backtrackMatrix(way+"-UR-",maze,r-1,c+1,matPath,matPathCount+1);
		backtrackMatrix(way+"-DR-",maze,r+1,c+1,matPath,matPathCount+1);
		backtrackMatrix(way+"-LD-",maze,r+1,c-1,matPath,matPathCount+1);
		backtrackMatrix(way+"-LU-",maze,r-1,c-1,matPath,matPathCount+1);

		maze[r][c] = 1;
		matPathCount--;
		matPath[r][c] = 0;

		return;
	}

	//backtrack to get all paths(cross is allowed)
	//cross ()
	public static void backtrackPro(String way, int maze[][], int r,int c){
		if(r<0 || c<0 || r>=maze.length || c>= maze[0].length){
			return;
		}
		else if(r == maze.length-1 && c == maze[0].length-1){
			System.out.print(way+", ");
			return;
		}
		else if(maze[r][c] == -1){
			return;
		}
		else{
			maze[r][c] = -1;
		}

		//straight paths
		backtrackPro(way+"R",maze,r,c+1);
		backtrackPro(way+"D",maze,r+1,c);
		backtrackPro(way+"L",maze,r,c-1);
		backtrackPro(way+"U",maze,r-1,c);

		//cross paths
		backtrackPro(way+"-UR-",maze,r-1,c+1);
		backtrackPro(way+"-DR-",maze,r+1,c+1);
		backtrackPro(way+"-LD-",maze,r+1,c-1);
		backtrackPro(way+"-LU-",maze,r-1,c-1);

		maze[r][c] = 1;

		return;
	}

	//backtrack to get all paths (RLDU)
	public static void backtrack(String way, int maze[][], int r,int c){
		if(r<0 || c<0 || r>=maze.length || c>= maze[0].length){
			return;
		}
		else if(r == maze.length-1 && c == maze[0].length-1){
			System.out.print(way+", ");
			return;
		}
		else if(maze[r][c] == -1){ //if obstacle, return!
			return;
		}
		else{
			maze[r][c] = -1;
		}

		backtrack(way+"R",maze,r,c+1);
		backtrack(way+"D",maze,r+1,c);
		backtrack(way+"L",maze,r,c-1);
		backtrack(way+"U",maze,r-1,c);
		maze[r][c] = 1;

		return;
	}
}