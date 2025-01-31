import java.util.Arrays;

public class RecursionSort{
	public static void main(String args[]){
		int arr[] = {4,3,2,1};

		System.out.println(Arrays.toString(arr));
		// bubblesort(arr);
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int arr[]){
		int row = 0;
		int col = 0;

		selectionSortHelper(arr, row, col);
	}

	public static void selectionSortHelper(int arr[], int row, int col){
		if(row >= arr.length){
			return;
		}

	}

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