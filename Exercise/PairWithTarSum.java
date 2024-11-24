package Exercise;
import java.util.ArrayList;

class TargetPair{
    public ArrayList<int[]> targetPair(int arr[],int target){
        // int res[] = new int[];
        ArrayList<int[]> pairs = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    int temp[] = new int[2];
                    temp[0] = arr[i];
                    temp[1] = arr[j];
                    pairs.add(temp);
                }
            }
        }
        return pairs;
    } 
}

public class PairWithTarSum {
    public static void main(String args[]){
        TargetPair tp = new TargetPair();
        int arr[] = {1,2,3,4,5};
        int target = 7;
        ArrayList<int[]> res = tp.targetPair(arr,target);
        
        for(int pair[]:res){
            System.out.println(pair[0]+" "+pair[1]);
        }
    }
}
