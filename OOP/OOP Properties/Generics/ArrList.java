import java.util.ArrayList;

public class ArrList {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.get(1));
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        list.add(10);
        System.out.println(list);

        // list.remove(30); // to remove value directly, dont pass int, pass obj!
        list.remove(Integer.valueOf(30)); //now it takes 30 as a obj! (remove actual value present in the arraylist)
        System.out.println(list);

        list.set(0,100);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());




    }

}
