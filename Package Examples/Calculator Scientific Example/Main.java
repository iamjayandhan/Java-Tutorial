import calculator.adder.Adder;
import calculator.subtractor.Subtractor;

public class Main{
    public static void main(String args[]){
        Adder adder = new Adder();
        Subtractor subtractor = new Subtractor();

        System.out.println("Addition: "+adder.add(5,10));
        System.out.println("Subtraction: "+subtractor.subtract(5,10));
    }
}