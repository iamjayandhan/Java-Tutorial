class DynamicArray {

    int size;
    int capacity = 10;
    Object array[];

    public DynamicArray(){
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity){
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object data){
        if (size > capacity) {
            grow();
        }
        array[size]= data;
        size++;
    }   

    public void insert(int index, Object data){

    }

    public void delete(Object data){

    }

    public int search(){
        return -1;
    }

    private void grow(){

    }

    private void shrink(){

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        String string = "";

        for(int i=0;i<size;i++){
            string+= array[i] + ", ";
        }
        
        return null;
    }
}

public class DynamicArrayMain{
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        // System.out.println(dynamicArray.capacity);

        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C"); 

        System.out.println(dynamicArray);
    }
}