public class Fibonacci {
    public static void main(String args[]){
        Fibonacci obj = new Fibonacci();

        System.out.println(obj.fibo(50));
    }    

    public int fibo(int n){
        if(n<2){
            return n;
        }else{
            return fibo(n-1) + fibo(n-2);
        }
    }
}
