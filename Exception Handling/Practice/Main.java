public class Main {
    public static void main(String args[]){
        int a = 5;
        int b = 0;

        //Unchecked exception, checked only on runtime!
        //we get divide by zero error!
        // int c = a/b;

        //place experimental code inside try block!
        
        int c=-1;
        try{
            // c = div(a, b);
            // throw new Exception("What?? Lets make it!");
            throw new MyException("MyException error occured!");
        }
        //or (ArithmeticException e)
        catch(ArithmeticException e){
            System.out.println("Arithmetic Error found: "+e.getMessage());
            c = 0;
        }
        catch(Exception e){ //this handles any type of exception!
            System.out.println("Error found: "+e.getMessage());
        }
        finally{
            System.out.println("All the code has been executed!");
        }

        System.out.println(c);
    }

    //tell the compiler that this method may throw arithmetic exception if b == 0!
    //convey this info to the calling method!
    public static int div(int a, int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("Please stop the nonsense!\n Never divide a number by Zero!");
        }
        return a/b;
    }
}
