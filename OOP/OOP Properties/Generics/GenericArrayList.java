// import java.lang.SuppressWarnings;
import java.util.List;

// public class GenericArrayList<T> { 
public class GenericArrayList<T extends Number> { // this generics only works with Numbers, String is not allowed

    //Here T should either be a Number or subclass of a Number
    //https://www.geeksforgeeks.org/java-lang-number-class-java/

    //We created a kind of restriction that this generics only allowes Numbers
    //acceptable Wrapper versions of classes are byte , double , float , int , long , and short.

    //https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html

    //NOTE
    //1. Static for typed parameters are not allowed! static T..
    //2. Cannot use instanceof
    //3. Overloading for generic type is not allowed!

    //Custom array list - Using Generics
    //Any user given dtype.
    private Object data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public void getList(List<? extends Number> list){
        //do something
    }

    public GenericArrayList(){
        // this.data = new T[DEFAULT_SIZE]; 
        // Java Feature - 'type erasure'
        // Not possible because Java does not allow direct instantiation of generic arrays. 
        //we know object creation is done during runtime!
        //after compilation, bytecode will not contain the dtype! but generic
        //so during runtime, compiler does not identify 'T' during runtime! so object creation is not possible!
        //so direct instantiation of generics is not possible!

        //so as alternative, we can use Object class! (The one that is inherited by all classes in java!)
        //whenever obj instantiation, use "Object" else for func parameters , use "T"
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

    // i may use annatations to suppress a warning of:
    // Warning => Type Safety: Unchecked cast from Object to T
    // @SuppressWarnings("Unchecked")
    public T remove(){
        T removed = (T)(data[--size]); //here data is "Object" but removed ref is "T", so we need to type cast!
        return removed;                //"T" is smaller type, while Object is big type! so we need type casting!
    }

    public T get(int index){
        return (T)(data[index]); //casting is needed!
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value; // here small dtype "T" is assigned to big dtype "Object" , so casting is not required!
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

        //We pass the datatype of inputs through '<>' 
        //This is called Generics
        // GenericArrayList<Integer> list = new GenericArrayList<Integer>();
        GenericArrayList<String> list = new GenericArrayList<String>();
        
        for(int i=0;i<15;i++){
            list.add("Hello"+i);
        }

        System.out.println(list.toString());
    }
}
