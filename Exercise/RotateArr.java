package Exercise;

class Rotate{
    public int[] rot(int arr[],int k){

        int c=0;
        
        for (int i=0;i<arr.length;i++){
            int lastElem = arr[arr.length-1];
            for (int j=arr.length-1;j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[0]=lastElem;
            c++;
            if (c==k){
                break;
            }
        }
        return arr;
    }
}

public class RotateArr {
    // rotate arr elems k positions to right
    public static void main(String args[]){
        Rotate r = new Rotate();
        int arr[] = {1, 2, 3, 4, 5};
        int k=3;

        System.out.println("Initial array elements: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        int rotatedArr[] = r.rot(arr,k);

        String res = String.format("Rotated array elements by %d times: ",k);
        System.out.println(res);

        for(int i=0;i<rotatedArr.length;i++){
            System.out.print(rotatedArr[i] + " ");
        }
    }
}
