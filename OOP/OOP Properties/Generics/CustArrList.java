
import java.util.ArrayList;
import java.util.Arrays;

public class CustArrList {

    private int data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustArrList(){
        this.data = new int[DEFAULT_SIZE]; 
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num; 
    } 

    public boolean isFull(){
        return size == data.length;
    }

    public void resize(){
        int temp[] = new int[data.length*2];

        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }

        data = temp;
    }

    public int remove(){
        if(data.length == 0){
            System.out.println("List is empty! cannot perform deletion operation!");
            return -1;
        }

        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int element){
        data[index] = element;
    }

    @Override
    public String toString(){
        return "CustArrList{"+
            "data="+Arrays.toString(data)+
            ",size="+size+"}";
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList<>();
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        CustArrList list = new CustArrList();

        // list.add(3);
        // list.add(5);
        // list.add(7);
        for(int i=0;i<=10;i++){
            list.add(i+1);
        }
        System.out.println(list);

    }
}
