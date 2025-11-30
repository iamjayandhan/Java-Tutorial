public class LongPressedVersion {
    public static void main(String[] args) {
        
        //TC001
        String name = "alex";
        String typed = "aaallexx";
        //Output: true

        //TC002
        String name2 = "sai";
        String typed2 = "ssaaaii";
        //Output: true
        
        //TC003
        String name3 = "kavi";
        String typed3 = "kaaviu";
        //Output: false

        System.err.println("TC001: "+ findIt(name,typed));
        System.err.println("TC001: "+ findIt(name2,typed2));
        System.err.println("TC001: "+ findIt(name3,typed3));
    }

    public static boolean findIt(String name, String typed) {
        boolean res = false;

        

        return res;
    }
}
