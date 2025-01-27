public class Patterns{
	public static void main(String[] args) {
		System.out.println("First Pattern(Even length input! 3):");
		pattern6(3);
		System.out.println("Second Pattern(Odd length input! 4):");
		pattern6(4);
	}

	public static void pattern6(int n){

		int newN = (n*2)+1;
		for(int row=0;row<newN;row++){
			for(int col=0;col<newN;col++){
				int left = col;
				int right = newN-col-1;
				int up = row;
				int down = newN - row-1;
				// System.out.print(row+""+col+" L"+left+" R"+right+" U"+up+" D"+down+" - ");
				
				System.out.print(n-(Math.min(Math.min(up,down),Math.min(left,right)))+1);
				System.out.print(" ");
				// System.out.println("row & col:"+row+" & "+col+" => "+left+" "+right+" "+up+" "+down);

			}
			System.out.println();

		}
	}

	public static void pattern5(int n){
		for(int row=1;row<=2*n;row++){

			int spaces = (row<=n)? n-row:row-n;
			for(int space=spaces;space>=0;space--){
				System.out.print("  ");
			}

			int nums = (row<=n)? row: n-(row-n);
			for(int num=nums;num>=1;num--){
				System.out.print(num+" ");
			}

			int nums2 = (row<=n)? row: n-(row-n);
			for(int num = 2;num<=nums2;num++){
				System.out.print(num+" ");
			}
			System.out.println();
		}

	}

	public static void pattern4(int n){
		for(int row=1;row<=n;row++){
			for(int space=n-row;space>0;space--){
				System.out.print("  ");
			}

			for(int ri=row; ri>=1;ri--){
				System.out.print(ri+" ");
			}

			for(int i=2;i<=row;i++){
				System.out.print(i+" ");
			}

			System.out.println();
		}
	}

	public static void pattern3(int n){
		for(int row = 1;row<=2*n;row++){
			int totCol = (row<=n)? row: (2*n)-row;
			int spaces = (row<n)? n-row: row-n;

			for(int space=1;space<=spaces;space++){
				System.out.print(" ");
			}

			for(int col = 1;col<=totCol;col++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void pattern2(int n){
		for(int row = 1;row<=2*n;row++){
			int totCol = (row<=n)? row: (2*n)-row;

			for(int col = 1;col<=totCol;col++){
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	public static void pattern1(int n){
		for(int row = 1;row<=n;row++){
			for(int col = 1; col<=row;col++){
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
}