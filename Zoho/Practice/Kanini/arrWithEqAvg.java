// Divide array into two sub-arrays such that their averages are equal

import java.util.Arrays;

public class arrWithEqAvg{
	public static void main(String args[]){
		int arr[] = {4,2,3,4,2}; 
		int n = arr.length;


		int pref[] = new int[n];
		pref[0] = arr[0];
		for(int i=1;i<n;i++){
			pref[i] = arr[i]+pref[i-1];
		}

		int suff[] = new int[n];
		suff[n-1] = arr[n-1];
		for(int i=n-2;i>=0;i--){
			suff[i] = arr[i]+suff[i+1];
		}

		System.out.println(Arrays.toString(pref));
		System.out.println(Arrays.toString(suff));

		boolean found = false;
		for(int k=0;k<n-1;k++){
			if(pref[k]/(k+1) == suff[k+1]/(n-(k+1))){
				found = true;
				break;
			}
		}

		if(found){
			System.out.println("yes");
		}
		else{
			System.out.println("No");
		}
	}
}