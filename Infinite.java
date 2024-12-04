public class Infinite{
    public static void main(String args[]){
        //Unreachable statement
        // while(3<2){
        //     System.out.println("Hello");
        // }

        //compiler fails

        //compiler pass, exec pass
        //works! prints nothing!
                  
        int i=3;
        while(i<2){
            System.out.println("Hello");
        }
    }
}