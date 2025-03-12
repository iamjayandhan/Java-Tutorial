//Inefficient for large input.

public class ClimbingStairs{

	public static void main(String args[]){
		int res = climbStairs(44);
		System.out.println(res);
	}

	public static int climbStairs(int n) {
        int ways = PossibleWays(0,n);
        return ways;
    }

    public static int PossibleWays(int p,int up){
        if(up == 0){
            return 1;
        }
        if(up>=2){
            return PossibleWays(p+1,up-1) + PossibleWays(p+2,up-2);
        }
        else{
            return PossibleWays(p+1,up-1);
        }
    }
}