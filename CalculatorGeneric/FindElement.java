//more specific func - only for int and returns int!
class Find{
    public static int findElement(int arr[],int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i] ==k){
                return i;
            }
        
        }
        return -1;
    }
}

//generic func - can be used for any type and returns the same type.
class FindGeneric<T>{
    public int findElement(T arr[],T k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(k)){
                return i;
            }
        
        }
        return -1;
    }
}

class FindElement{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k=3;
        System.out.println(FindGeneric.findElement(arr,k));
    }
}