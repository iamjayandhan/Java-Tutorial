import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws CloneNotSupportedException{
        Human JD = new Human(24,"JD");
        // Human Jayandhan = new Human(JD); // manual clone!

        //Instead of manual copy, java has Clonable interface!
        //copies all from one object to another
        Human Jayandhan = (Human)JD.clone();
        System.out.println(Jayandhan.name);

        System.out.println(Arrays.toString(Jayandhan.arr));
        System.out.println(Arrays.toString(JD.arr));

        //1. Shallow copy
        //array reference inside Human is copied, not duplicated.
        //so change in one instance of obj will affect cloned obj!
        //primitives are copied, while others are copied as references! (Shallow copy)!
        JD.arr[0] = 999;
        System.out.println(Arrays.toString(JD.arr));
        System.out.println(Arrays.toString(Jayandhan.arr));

        //2. Deep copy
        //exactly copy of all stuff from one obj to another
        
    }
}
