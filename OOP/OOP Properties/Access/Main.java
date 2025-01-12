import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        A obj = new A(10,"Jd");
        System.out.println(obj.arr);
        System.out.println(obj.name);

        //num is private!
        // System.out.println(obj.num);
        System.out.println(obj.getNum());
        obj.setNum(20);
        System.out.println(obj.getNum());

        //need to do few things
        // 1. Access the data members
        // 2. Modify the data members

        ArrayList<Integer> arr = new ArrayList<Integer>(10);
        
    }
}
