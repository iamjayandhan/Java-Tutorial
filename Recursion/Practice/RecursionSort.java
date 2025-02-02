import java.util.Arrays;

//hybrid sort(Tim sort) => merge + insertion
//have a try!
public class RecursionSort{
	public static void main(String args[]){
		// int arr[] = {4,3,2,5,7,1,2,1,9,7,6,1};
		int arr[] = {8,3,4,12,5,6};

		System.out.println(Arrays.toString(arr));
		// bubblesort(arr);
		// selectionSort(arr);
		// selectionSort2(arr);
		// mergesortInplaceEntry(arr);
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		// System.out.println(Arrays.toString(arr));
	}

	//quick sort
	public static void quickSort(int arr[], int low,int hi){
		if(low>=hi){
			return;
		}

		int s = low;
		int e = hi;

		//here mid is pivot!
		int mid = s+(e-s)/2;
		int pivot = arr[mid];

		while(s<=e){
			while(arr[s]<pivot){
				s++;
			}

			while(arr[e]>pivot){
				e--;
			}

			if(s<=e){
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
		}
		quickSort(arr, low,e);
		quickSort(arr,s,hi);
	}

	//merge sort inplace!
	public static void mergesortInplaceEntry(int arr[]){
		int s = 0;
		int e = arr.length;

		mergesortInplace(arr,s,e);
	}

	public static void mergesortInplace(int arr[],int s,int e){
		if(e-s == 1){
			return;
		}

		int m = s+(e-s)/2;
		mergesortInplace(arr,s,m);
		mergesortInplace(arr,m,e);

		mergesortInplaceHelper(arr,s,m,e);
	}

	public static void mergesortInplaceHelper(int arr[],int s,int m, int e){
		int mix[] = new int[e-s];

		int i = s;
		int j = m;
		int k = 0;

		//sorting stuff
		while(i<m && j <e){
			if(arr[i]<=arr[j]){
				mix[k] = arr[i];
				i++;
			}
			else{
				mix[k] = arr[j];
				j++;
			}
			k++;
		}

		while(i<m){
			mix[k++] = arr[i];
			i++;
		}

		while(j<e){
			mix[k++] = arr[j];
			j++;
		}
		
		//copy sorted portion into org arr!
		for(int l=0;l<mix.length;l++){
			arr[s+l] = mix[l];
		}
	}


	//merge sort using array copies!
	public static int[] mergesort(int arr[]){
		if(arr.length == 1){
			return arr;
		}
		int mid = arr.length/2;

		//Arrays.copyOfRange(arr,from,to);   
		//[from,to)
		int leftpart[] = mergesort(Arrays.copyOfRange(arr,0,mid)); 
		int rightpart[] = mergesort(Arrays.copyOfRange(arr,mid,arr.length));

		return mergesortMerge(leftpart,rightpart);
	}

	public static int[] mergesortMerge(int left[],int right[]){
		int leftLen = left.length;
		int rightLen = right.length;

		int res[] = new int[leftLen+rightLen];

		int i=0;
		int j=0;
		int k=0;

		//sorting stuff
		while(i<leftLen && j <rightLen){
			if(left[i]<=right[j]){
				res[k] = left[i];
				i++;
			}
			else{
				res[k] = right[j];
				j++;
			}
			k++;
		}

		while(i<leftLen){
			res[k++] = left[i];
			i++;
		}

		while(j<rightLen){
			res[k++] = right[j];
			j++;
		}
		return res;
	}


	//merge sort - MY VERSION
	public static int[] mergeSortSplit(int arr[],int l,int h){
		if(l==h){
			return new int[]{arr[l]};
		}

		//where to split!
		int m = l+(h-l)/2;

		int leftPart[] = mergeSortSplit(arr,l,m);
		int rightPart[] = mergeSortSplit(arr,m+1,h);

		return mergeIt(leftPart,rightPart);
	}

	//mergeSort helper
	public static int[] mergeIt(int left[], int right[]){
		int leftLen = left.length;
		int rightLen = right.length;

		int res[] = new int[leftLen+rightLen];

		int i=0;
		int j=0;
		int k=0;

		//sorting stuff
		while(i<leftLen && j <rightLen){
			if(left[i]<=right[j]){
				res[k] = left[i];
				i++;
			}
			else{
				res[k] = right[j];
				j++;
			}
			k++;
		}

		while(i<leftLen){
			res[k++] = left[i];
			i++;
		}

		while(j<rightLen){
			res[k++] = right[j];
			j++;
		}
		return res;
	}


	//selection sort using pattern rows and cols
	public static void selectionSort2(int arr[]){
		int row = arr.length-1;
		int col = 0;
		selectionSort2Helper(arr,row,col,0);
	}

	public static void selectionSort2Helper(int arr[],int row ,int col,int maxValsofarInd){
		if(row == 0){
			return;
		}
		else if(col<=row){
			if(arr[maxValsofarInd] < arr[col]) maxValsofarInd = col;
			selectionSort2Helper(arr,row,col+1,maxValsofarInd);
		}
		else{
			int temp = arr[row];
			arr[row] = arr[maxValsofarInd];
			arr[maxValsofarInd] = temp;
			selectionSort2Helper(arr,row-1,0,0);
		}
	}

	//normal selection sort
	public static void selectionSort(int arr[]){
		int toReplaceInd = arr.length-1;
		selectionSortHelper(arr, toReplaceInd);
	}

	public static void selectionSortHelper(int arr[], int toReplaceInd){
		if(toReplaceInd == 0){
			return;
		}

		int maxVal = arr[0];
		int maxValInd = 0;
		for(int i=0;i<toReplaceInd;i++){
			if(arr[i]> maxVal){
				maxVal = arr[i];
				maxValInd = i;
			}
		}	

		if(maxVal > arr[toReplaceInd]){
			int temp = arr[maxValInd];
			arr[maxValInd] = arr[toReplaceInd];
			arr[toReplaceInd] = temp;
		}
		selectionSortHelper(arr,toReplaceInd-1);
	}

	//bubble sort using pattern rows and cols
	public static void bubblesort(int arr[]){
		int row = 0;
		int col = 0;

		bubblesortHelper(arr,row,col);
	}

	public static void bubblesortHelper(int arr[], int row, int col){
		if(row >= arr.length){
			return;
		}
		else if (row+col <arr.length-1){
			if(arr[col]>arr[col+1]){
				int temp = arr[col];
				arr[col] = arr[col+1];
				arr[col+1] = temp;
			}
			bubblesortHelper(arr,row, col+1);
		}
		else{
			bubblesortHelper(arr,row+1,0);
		}
	}

}