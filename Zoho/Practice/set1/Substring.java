// 3. Save the string “WELCOMETOZOHOCORPORATION” in a two dimensional array and search for substring like “too” in the two dimensional string both from left to right and from top to bottom.

// w	e	L	C	O
// M	E	T	O	Z
// O	H	O	C	O
// R	P	O	R	A
// T	I	O	n	  

// And print the start and ending index as
// Start index : <1,2>
// End index: <3, 2>

public class Substring{
	public static void main(String args[]){
		char grid[][] = {{'w','e','L','C','O'},{'M','E','T','O','O'},{'O','H','O','C','O'},{'R','P','O','R','A'},{'T','I','O','n','0'}};
		String target = "TOO";

		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid.length;j++){

				if(grid[i][j] == target.charAt(0)){
					rowSearch(i, j, grid, target);
					colSearch(i, j, grid, target);
				}

			}
		}
	}

	public static void rowSearch(int i,int j,char grid[][],String target){
		if(grid[i].length-j<target.length()) return; 

		int pi = i;
		int pj = j;

		int p=0;
		while(j<grid[i].length && p < target.length()){
			if (Character.toUpperCase(target.charAt(p)) == Character.toUpperCase(grid[i][j]))
			{
				j++;
				p++;
			}
			else return;
		}
		System.out.println("Start index: <" + pi + "," + pj + ">");
		System.out.println("End index: <" + i + "," + (j-1) + ">");


	} 

	public static void colSearch(int i,int j,char grid[][],String target){
		if(grid.length-i<target.length()) return; 

		int pi = i;
		int pj = j;

		int p=0;
		while(i<grid.length && p<target.length()){
			if (Character.toUpperCase(target.charAt(p)) == Character.toUpperCase(grid[i][j]))
			{
				i++;
				p++;
			}
			else return;
		}
		System.out.println("Start index: <" + pi + "," + pj + ">");
		System.out.println("End index: <" + (i - 1) + "," + j + ">");

	} 
}