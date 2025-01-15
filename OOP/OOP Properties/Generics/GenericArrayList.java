public class GenericArrayList<T> {

    //https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html

    //Any user given dtype.
    private Object data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public GenericArrayList(){
        this.data = new Object[DEFAULT_SIZE];
    }

    private void resize(){
        Object temp[] = new Object[data.length * 2];
        
        //copy current items into the new array
        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    
    private boolean isFull(){
        return size == data.length;
    }
    
    public void add(T num){
        if(this.isFull()){
            resize();
        }
        data[size++] = num;
    }

    public T remove(){
        T removed = (T)(data[--size]);
        return removed;
    }

    public T get(int index){
        return (T)(data[index]);
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
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
        GenericArrayList<Integer> list = new GenericArrayList();
        
        for(int i=0;i<15;i++){
            list.add(i+1);
        }
        System.out.println(list.toString());
    }
}
