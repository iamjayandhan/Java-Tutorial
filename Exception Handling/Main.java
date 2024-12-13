public class Main{
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        try{
            // int c = a/b;
            // divide(a, b);
            // Math.divideExact(3,0);

            //Creating exception purposefully!
            String name = "JD";
            if(name.equals("JD")){
                throw new MyException("Just for fun");
            }
        }
        //Custom exception
        catch(MyException e){
            System.out.println(e.getMessage());
        }
        //Handle specific exception
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        //Handles all kind of exceptions!
        catch(Exception e){
            System.out.println("Normal Exception Event");
        }
        finally{
            System.out.println("This will always execute!");
        }
    }

    static int divide(int a, int b) throws ArithmeticException{
        if(b == 0){
            //throw error explicitly
            throw new ArithmeticException("Please do not divide by zero!");
        }
        return a/b;
    }
}