// Memoization is a technique used to optimize recursive functions by storing previously computed results and reusing them instead of recalculating.
// https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairsMemo{
	public static void main(String args[]){
		
		int n = 4;
		//no memoization
		System.out.println(withoutMemo(n));

		//with memoization
		//we use array to store previously computed results!
		int memo[] = new int[n+1];
		System.out.println(withMemo(n,memo));
	}

	//without memoization
	public static int withoutMemo(int n){
		if(n == 0) return 1;
		else if(n < 0) return 0;

		return withoutMemo(n-1)+withoutMemo(n-2);
	}

	//with memoization
	public static int withMemo(int n,int []memo){
		if(n == 0) return 1;
		else if (n < 0) return 0;

		//check if already computed!
		if(memo[n]>0) return memo[n];

		//compute value of not previously computed!
		memo[n] = withMemo(n-1, memo)+withMemo(n-2, memo);

		return memo[n];
	}
}