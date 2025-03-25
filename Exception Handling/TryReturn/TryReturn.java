public class TryReturn {
    public static void main(String[] args) {
        System.out.println(nothing());
    }

    public static String nothing(){
        String success = "success";
        String failure = "Failure";

        try{
            something();
            return success;
        }
        catch(Exception e){
            return failure;
        }
        finally{
            System.out.println("Inside Finally block!");
        }
    }

    public static void something(){
        System.out.println("Something...");
    }
}
