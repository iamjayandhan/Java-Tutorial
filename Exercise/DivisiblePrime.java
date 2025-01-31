public class DivisiblePrime{

	public static boolean isPrime(int n){
		for(int i=2;i<n/2;i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]){
		int minR = 50;
		int maxR = 72;
		int n = 2;

		int res = 0;
		for(int num=minR;num<=maxR;num++){
			if(isPrime(num)){
				int tempN = num;
				int tempS = 0;

				while(tempN!=0){
					int ld = tempN%10;
					tempS+=ld;
					tempN/=10;
				}
				if(tempS%n == 0){
					res++;
				}
			}
		}

		System.out.println("Divisble primes: "+res);

	}
}