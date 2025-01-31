import java.util.ArrayList;

public class RecursionArr{
	public static void main(String args[]){
		int arr[] = {1,2,6,10,6,13};
		// System.out.println("Check if arr is sorted: "+checkSorted2(0,arr));
		System.out.println(indexList2(arr,6,0));
	}

	//return list of indexes without taking list as argument!
	//create list inside body??
	public static ArrayList<Integer> indexList2(int arr[], int target, int ind){
		ArrayList<Integer> list = new ArrayList<>();

		if(ind == arr.length){
			return list;
		}
		else if(arr[ind] == target){
			list.add(ind);
		}
	
		// return list.addAll(indexList2(arr,target,ind+1));   //addAll returns true! so compilation error, so add it seperately and return.
		ArrayList<Integer> returnedValues = indexList2(arr,target,ind+1);
		list.addAll(returnedValues);
		return list;                         
	}


	//return list of indexes!
	public static ArrayList<Integer> indexList(int arr[], int target, int start){
		// int indexes[] = new int[10];
		ArrayList<Integer> indexes = new ArrayList<>();
		return indexListHelper(arr,target,start,indexes);
	} 

	public static ArrayList<Integer> indexListHelper(int arr[], int target, int start,ArrayList<Integer> indexes){
		if(start == arr.length){
			return indexes;
		}
		else if (arr[start] == target){
			// System.out.print(start+" ");
			indexes.add(start);
		}
		return indexListHelper(arr,target,start+1,indexes);
	}

	//find and print multiple indexes
	public static void findIndAll(int arr[], int target, int start){
		if(start == arr.length){
			return;
		}
		else if (arr[start] == target){
			System.out.print(start+" ");
		}
		findIndAll(arr,target,start+1);
	}

	//find last index
	public static int findIndLast(int arr[], int target,int start){
		if(start == -1){
			return -1;
		}
		else if(arr[start]==target){
			return start;
		}
		else{
			return findIndLast(arr,target,start-1);
		}
	}

	//find first index
	public static int findInd(int arr[], int target,int start){
		if(start == arr.length){
			return -1;
		}
		else if(arr[start]==target){
			return start;
		}
		else{
			return findInd(arr,target,start+1);
		}
	}

	//check sorted without helper
	public static boolean checkSorted2(int start, int arr[]){
		if(start == arr.length-1){
			return true;
		}
		return arr[start]<arr[start+1] && checkSorted2(start+1,arr);
	}


	//check sorted with helper1 & helper2
	public static boolean sortedHelper2(int start, int end, int arr[]){
		if(start == end){
			return true;
		}
		return arr[start]<arr[start+1] && sortedHelper2(start+1,end,arr);
	}

	public static boolean sortedHelper(int start,int end,int arr[]){
		if(start == end){
			return true;
		} 
		else if(arr[start]<arr[start+1]){
			return sortedHelper(start+1,end,arr);
		} 
		else{
			return false;
		}
	}

	public static boolean checkSorted(int arr[]){
		int endInd = arr.length-1;
		return sortedHelper2(0,endInd,arr);
	}
}