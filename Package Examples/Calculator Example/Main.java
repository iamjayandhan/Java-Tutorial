import calculator.Calculator;

public class Main{
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.test();
        System.out.println("Addition: "+calc.add(10,5));
        System.out.println("Subraction: "+calc.sub(10,5));
        System.out.println("Multiplication: "+calc.mul(10,5));
        System.out.println("Division: "+calc.div(10,5));
    }
}