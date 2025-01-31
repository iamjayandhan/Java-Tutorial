public class Recursion{
	public static void main(String args[]){
		// System.out.println(print(5));
		// _1ton(5);
		// System.out.println("Palindrome check for number 1221: "+palindrome(1221));
		// System.out.println("Palindrome check for 123: " + palindrome(123));
		System.out.println("Number of Zeros in number: "+ countZeros(1042300300));
	}

	//count zeros with helper!
	public static int countZerosHelper(int n, int zeroCount){
		if(n==0){
			return zeroCount;
		}
		if(n%10 == 0){
			return countZerosHelper(n/10,zeroCount+1);
		}
		else{
			return countZerosHelper(n/10,zeroCount);
		}
	}

	public static int countZeros(int n){
		return countZerosHelper(n,0);
	}

	//rev + palindrome check
	public static int palindromeHelper(int n,int pow){
		if(n==0){
			return 0;
		}
		return (int)((n%10)*Math.pow(10,pow)) + palindromeHelper(n/10,pow-1);
	}

	public static boolean palindrome(int n){
		int pow = (int)(Math.log10(n))+1;
		return palindromeHelper(n,pow-1) == n;
	}

	//reverse with helper
	public static int helperRevOfNum2(int n,int pow){
		if(n==0){
			return 0;
		}
		return (int)((n%10)*Math.pow(10,pow)) + helperRevOfNum2(n/10,pow-1);
	}

	public static int revOfNum2(int n){
		int pow = (int)(Math.log10(n))+1;
		return helperRevOfNum2(n,pow-1);
	}

	// static int rev = 0;
	// public static void revOfNum(int n){
	// 	if(n==0){
	// 		return ;
	// 	}
	// 	rev = rev*10+n%10;
	// 	revOfNum(n/10);
	// }

	public static int pdtOfDigits(int n){
		if(n==0){
			return 1;
		}
		return n%10 * pdtOfDigits(n/10);
	}

	public static int sumOfDigits(int n){
		if(n==0){
			return 0;
		}
		return n%10 + sumOfDigits(n/10);
	}

	public static int sum(int n){
		if(n==1){
			return 1;
		}
		return n+sum(n-1);
	}

	public static int fact(int n){
		if(n==1){
			return n;
		}
		return n*fact(n-1);
	}

	public static void _1ton(int n){
		if(n==0){
			return;
		}
		_1ton(n-1);
		System.out.print(n+" ");
	}


	public static void _nto1(int n){
		if(n==0){
			return;
		}
		System.out.print(n+" ");
		_nto1(n-1);
	}

	//sum of n
	public static int print(int n){
		if(n==0){
			return 0;
		}

		return n+print(n-1);
		// System.out.print(n+" ");
	}

	//fibo
	public static int fibo(int n){
		if(n <=1){
			return n;
		}
		return fibo(n-2)+fibo(n-1);
	}
}