import java.util.ArrayList;

public class RecursionMazeObstacles{
	public static void main(String args[]){
		//given a boolean matrix
		//1 -> good to go
		//0 -> river that blocks the way

		//moto is to move from 0,0 to 2,2
		int maze[][] = {{1,1,1},{1,0,1},{1,1,1}};
		// mazeObstacle("",maze,0,0);
		// mazeObstacle2("",maze,0,0);

		ArrayList<String> res = mazeObstacleList("",maze,0,0);
		System.out.println(res);
	}

	//return as arraylist
	public static ArrayList<String> mazeObstacleList(String way,int maze[][], int r,int c){
		if((r>=maze.length || c>=maze[0].length) || maze[r][c] == 0){
			return new ArrayList<>();
		}
		else if (r == maze.length-1 && c == maze[0].length-1){
			// System.out.println(way);
			ArrayList<String> res = new ArrayList<>();
			res.add(way);
			return res;
		}

		ArrayList<String> res = new ArrayList<>();
		res.addAll(mazeObstacleList(way+"R",maze,r,c+1));
		res.addAll(mazeObstacleList(way+"D",maze,r+1,c));
		res.addAll(mazeObstacleList(way+"C",maze,r+1,c+1));

		return res;
	}

	//cross allowed
	public static void mazeObstacle2(String way,int maze[][], int r,int c){
		if((r>=maze.length || c>=maze[0].length) || maze[r][c] == 0){
			return;
		}
		else if (r == maze.length-1 && c == maze[0].length-1){
			System.out.println(way);
			return;
		}

		mazeObstacle2(way+"R",maze,r,c+1);
		mazeObstacle2(way+"D",maze,r+1,c);
		mazeObstacle2(way+"C",maze,r+1,c+1);

		return;
	}

	//with obstacle
	public static void mazeObstacle(String way,int maze[][], int r,int c){
		if((r>=maze.length || c>=maze[0].length) || maze[r][c] == 0){
			return;
		}
		else if (r == maze.length-1 && c == maze[0].length-1){
			System.out.println(way);
			return;
		}

		mazeObstacle(way+"R",maze,r,c+1);
		mazeObstacle(way+"D",maze,r+1,c);

		return;
	}


}