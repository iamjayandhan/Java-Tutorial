
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CustArrList3<T> {

    private Object data[];
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustArrList3(){
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

    //wildcards
    //perform generics with some restrictions
    //1. unbounded wildcard
    public static void printList(CustArrList3<?> list){
        //this method will print any dtype of CustArrList!
        //only print operation! no elem adding! except null value.
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }

    //2. method with upper bounded wildcard
    public static void printNumbers(CustArrList3<? extends Number> list){
        //this method will print list for all subtypes of Number class (Double, Float,Long,Short,Byte)
        //restricts String, boolean , Character types
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }

    //3. method with lower bounded wildcard
    // The method accepts a list (List<? super Integer>).
    //The ? super Integer means it accepts a list of Integer or its superclasses (Number, Object).
    //This ensures that we can safely add Integer values to the list.

    public static void addNumbers(List<? super Integer> list){
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        // ArrayList list = new ArrayList<>();
        CustArrList3<String> list = new CustArrList3<>();

        // list.add(3);
        // list.add(5);
        // list.add(7);
        for(int i=0;i<=10;i++){
            list.add("Roll"+i+"s");
        }
        System.out.println(list);

        //1. unbounded wildcard example
        CustArrList3<Boolean> boolList = new CustArrList3<>();
        boolList.add(true);
        boolList.add(false);
        boolList.add(false);

        CustArrList3.printList(boolList);

        //2. Upper bound wildcard example
        CustArrList3<Float> floatList = new CustArrList3<>();
        floatList.add(10.2f);
        floatList.add(3.0f);
        floatList.add(2.8f);

        CustArrList3.printNumbers(floatList);
        // CustArrList3.printNumbers(boolList); //fails, only Number type is allowed!

        //3. lower bound wildcard example
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        addNumbers(intList); // ✅ Allowed
        addNumbers(numList); // ✅ Allowed
        addNumbers(objList); // ✅ Allowed

        System.out.println(intList); // [10, 20]
        System.out.println(numList); // [10, 20]
        System.out.println(objList); // [10, 20]
    }
}
