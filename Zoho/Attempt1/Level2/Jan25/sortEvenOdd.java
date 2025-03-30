// http://leetcode.com/problems/sort-even-and-odd-indices-independently/description/

import java.util.ArrayList;
import java.util.Collections;

public class sortEvenOdd{
	public static void main(String args[]){
		//even indices -> Ascending order
		//odd indices -> Descending order

		int nums[] = {4,1,2,3};
		ArrayList<Integer> res = OrderIt(nums);

		for(int n: res){
			System.out.print(n+" ");
		}
	}

	public static ArrayList<Integer> OrderIt(int nums[]){
		ArrayList<Integer> even = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();

		ArrayList<Integer> res = new ArrayList<>();

		for(int i=0;i<nums.length;i++){
			if(i%2==0){
				even.add(nums[i]);
			}
			else{
				odd.add(nums[i]);
			}
		}

		System.out.println(even+" "+odd);

		Collections.sort(even);
		Collections.sort(odd,Collections.reverseOrder());
		
		System.out.println(even+" "+odd);

		int i=0,j=0;
		while(i<even.size() && j<odd.size()){
			res.add(even.get(i));
			res.add(odd.get(j));
			i++;
			j++;
		}

		while(i<even.size()){
			res.add(nums[i++]);
		}

		while(j<odd.size()){
			res.add(nums[j++]);
		}

		return res;
	}
}