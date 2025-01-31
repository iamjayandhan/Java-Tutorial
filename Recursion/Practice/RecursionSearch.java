public class RecursionSearch {
	public static void main(String args[]){
		// int arr[] = {5,6,7,8,9,10};
		// System.out.println("Position of element 9 in arr: "+binarySearch(arr,9));

		int arr2[] = {5,6,7,8,9,1,2,3};
		System.out.println("Position of element 2 in arr: "+binaryHalfSorted(arr2,5));
	}

	public static int binaryHalfSorted(int arr[],int target){
		int l = 0;
		int h = arr.length-1;

		return binaryHSHelper(arr,target,l,h);
	}

	public static int binaryHSHelper(int arr[],int target,int l,int h){
		if(l>h){
			return -1;
		}
		int mid = l+(h-l)/2;
		if(arr[mid] == target){
			return mid;
		}
		if(arr[l]<=arr[mid]){
			if(target>=arr[l] && target<=arr[mid]){
				// h = mid-1;
				return binaryHSHelper(arr,target, l,mid-1);
			}
			else{
				// l = mid+1;
				return binaryHSHelper(arr,target,mid+1,h);
			}
		}
		else{ //unsorted order
			if(target >= arr[mid] && target<= arr[h]){
				// h = mid-1;
				return binaryHSHelper(arr,target,mid+1,h);
			}
			else{
				// l = mid+1;
				return binaryHSHelper(arr,target,l,mid-1);
			}
		}
	}

	public static int binarySearch(int arr[],int target){
		int l = 0;
		int h = arr.length-1;

		return binarySearchHelper(arr,target,l,h);
	}

	public static int binarySearchHelper(int arr[],int target,int l,int h){
		if(l>h){
			return -1;
		}
		int mid = l+(h-l)/2;
		if(arr[mid] == target){
			return mid;
		}
		else if (target < arr[mid]){
			// h = mid-1;
			return binarySearchHelper(arr,target,l,mid-1);
		}
		else{
			// l = mid+1;
			return binarySearchHelper(arr,target,mid+1,h);
		}
	}
}