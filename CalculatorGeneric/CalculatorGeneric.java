class Calculator<T extends Number>{
    public Double add(T a,T b){
        return a.doubleValue()+b.doubleValue();
    }

    public Double sub(T a,T b){
        return a.doubleValue()+b.doubleValue();
    }

    public Double mul(T a,T b){
        return a.doubleValue()+b.doubleValue();
    }

    public Double div(T a,T b){
        if(b==0){
            System.out.println("Error: Division by zero is not allowed");
            return 0;
        }
        return a.doubleValue()+b.doubleValue();
    }
        
}

public class CalculatorGeneric{
    Calculator<Integer> calc = new Calculator<Integer>();
}