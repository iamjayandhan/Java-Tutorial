//Lets create our own custom exception!
//extend it with Exception class
public class MyException extends Exception{
    public MyException(String message){
        //System.out.println(message);

        //above line prints the string input from that throw statement from try block.
        //then the control searches for corresponding catch block!
        //Since Exception catch block catches 'MyException', there is no body(message)

        //so it displays "Error found: null"
        //here e.getMessage() -> null

        //so we pass message to parent by super(message);
        super(message);

    }
}
