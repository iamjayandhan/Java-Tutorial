class BubbleSort{

    public void bubbleSort(int[] arr) {
        int n = arr.length;

            for(int i = arr.length-1; i >=0; i--){
                for(int j=0;j<i;j++){
                    if(arr[j]>arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            
            } 
        
        System.out.println("Inside func, Array elements: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

class BubbleMain{
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int arr[] = {2,6,4,8,9,1};
        
        System.out.println("Before Sorting, Array elements: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        bubbleSort.bubbleSort(arr);
        System.out.println();

        System.out.println("After Sorting, Array elements: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}