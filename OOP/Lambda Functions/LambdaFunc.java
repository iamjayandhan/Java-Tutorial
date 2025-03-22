import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunc {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i+1);
        }

        //for each technique to print elements!
        //Cannot be reused elsewhere in the program.
        //❌ If the logic inside {} is complex, readability may decrease.
        list.forEach((elem) -> {
            System.out.println("Element is: "+elem);
        });

        //Consumer Functional Interface (WE USE THIS TO REUSE LAMBDA FUNCTIONS IN FUTURE!)
        //assign lambda func to Consumer var for reuse in future!
        Consumer<Integer> con = (elem) -> {
            System.out.println("Element is: "+elem);
        };

        //foreach accepts Consumer object!
        //we can reuse logic inside foreach n number of times!
        list.forEach(con);

        //we implement Operation interface for custom lambda function!
        //just like Consumer interface for simple lambda func!

        // Reusable – Instead of writing separate methods for addition, subtraction, etc., we use one function (operate()).
        //✅ Flexible – We can add more operations easily (like division, modulo, etc.).
        //✅ Clean Code – Reduces unnecessary method definitions and makes the code shorter and easier to read.

        Operation sum = (a,b) -> a + b;
        Operation prod = (a,b) -> a * b;
        Operation sub = (a,b) -> a - b;

        LambdaFunc calc = new LambdaFunc();
        //provide input and operation to be done!
        calc.operate(1, 3, sum);
        calc.operate(1, 3, prod);
        calc.operate(1, 3, sub);
    }

    //pass input and operation to be done(logic is written inside lambda function!)
    private int operate(int a, int b, Operation op){
        return op.operation(a, b);
    }

    int sum(int a,int b){
        return a + b;   
    }
}

//WHAT IF THERE EXISTS CUSTOM CONSUMER INTERFACE FOR BETTER USE? 
//FOR EXAMPLE, WE CAN WRITE SUM LOGIC USING 2 VARIABLES IN LAMBDA FUNCTION?

//just implement this interface and override this method with any logic using lambda function!
//just like we did for Consumer interface!
//Default, Consumer takes one argument in lambda func, but we create custom one that takes two arguments in lambda function for operations(sum,diff,prod etc!)

//this tag tells that this interface contains only one abstract method!
//It is similar to Java’s built-in Consumer<T>
//It's a custom interface with a method that takes two numbers and returns a result.
@FunctionalInterface
interface Operation{
    int operation(int a, int b);
}