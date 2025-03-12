import java.util.ArrayList;

public class CustomArrayList {

    //This custom Array List code is hardcoded only for integers!
    //so this code does not intake any generics! '<>'
    //works only for int datatype!

    //only int data!
    private int data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE]; //Initialize with default size!
    }

    private void resize(){
        int temp[] = new int[data.length * 2];
        
        //copy current items into the new array
        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    
    private boolean isFull(){
        return size == data.length;
    }
    
    public void add(int num){
        if(this.isFull()){
            resize();
        }
        data[size++] = num;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CustomArrayList{data=[");
        for(int i=0;i<data.length;i++){ // to valid elems? print only the size of the array
            sb.append(data[i]);
            if(i<data.length-1){
                sb.append(" ,");
            }
        }
        sb.append("], Size="+size+"}");
        return sb.toString();
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList();
        CustomArrayList list = new CustomArrayList();

        //wrong
        // CustomArrayList<String>  list2 = new CustomArrayList<String>();
        // Error: The type CustomArrayList is not generic; it cannot be parameterized with arguments 
        
        for(int i=0;i<15;i++){
            list.add(i+1);
        }
        System.out.println(list.toString());
    }
}
