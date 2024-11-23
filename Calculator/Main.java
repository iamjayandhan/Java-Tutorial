import java.util.*;

class Calculator{
    //methods - add,sub,mul,div
    int add(int a,int b){
        return a+b;
    }

    int sub(int a,int b){
        return a-b;
    }

    int mul(int a,int b){
        return a*b;
    }

    int div(int a,int b){
        if(b==0){
            System.out.println("Error: Division by zero is not allowed");
            return 0;
        }
        return a/b;
    }
}

public class Main{
    public static void main(String[] args){

        //calc is obj of type Calculator
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int a = sc.nextInt();

        System.out.println("Enter the second number:");
        int b = sc.nextInt();

        System.out.println("Results: ");
        System.out.println("Addition of "+a+" and "+b+" is "+calc.add(a,b));    
        System.out.println("Subtraction of "+a+" and "+b+" is "+calc.sub(a,b));
        System.out.println("Multiplication of "+a+" and "+b+" is "+calc.mul(a,b));
        System.out.println("Division of "+a+" and "+b+" is "+calc.div(a,b));

        sc.close();
    }
}