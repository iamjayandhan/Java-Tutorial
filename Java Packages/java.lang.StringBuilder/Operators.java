import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a'+'b'); //195
        System.out.println("a"+"b"); //ab

        System.out.println('a');
        System.out.println('a'+3);
        System.out.println((char)('a'+3));

        System.out.println("a"+3);
        //integer will be converted into Integer that will call toString()
        //this is as same as: "a"+"1"

        //Obj always uses toString()
        System.out.println("JD"+ new ArrayList<>()); //JD[]
        System.out.println("JD"+new Integer(48)); //JD48

        //+ can be used with any dtype, but anyone of them must be a string!
        // System.out.println(new Integer(48)+new int[]{1,2,3}); //obj + obj fails
        System.out.println(new Integer(48)+""+new int[]{1,2,3}); //obj +""+ obj pass. Result will be a string.
    }
}
