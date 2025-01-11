import java.util.Arrays;

public class OutputExercise {
    public static void main(String[] args) {

        //primitive
        System.out.println(48);

        //Integer Wrapper class
        Integer a = 48;
        System.out.println(a);

        //String
        System.out.println("JD");
        //Array (Object)
        System.out.println(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5}));

        // String name; //declared
        // String name2 = "JD"; //Initialized

        String name = null;
        System.out.println(name);
    }
}
