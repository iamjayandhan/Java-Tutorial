
import java.util.Arrays;

public class CustArrList2<T> {

    private Object data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustArrList2(){
        this.data = new Object[DEFAULT_SIZE]; 
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        //Object> T (no issues, no need for casting)
        data[size++] = num; 
    } 

    public boolean isFull(){
        return size == data.length;
    }

    public void resize(){
        Object temp[] = new Object[data.length*2];

        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }

        data = temp;
    }

    public T remove(){
        // if(data.length == 0){
        //     System.out.println("List is empty! cannot perform deletion operation!");
        //     return -1;
        // }

        //T < Object
        T removed = (T)data[--size];
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }
 
    public int size(){
        return size;
    }

    public void set(int index, T element){
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
        CustArrList2<String> list = new CustArrList2<>();

        // list.add(3);
        // list.add(5);
        // list.add(7);
        for(int i=0;i<=10;i++){
            list.add("Roll"+i+"s");
        }
        System.out.println(list);
        
    }
}
