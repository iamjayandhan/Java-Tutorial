public class Numbers{

    // METHOD OVERLOADING
    double sum(double a, int b){
        return a+b;
    }

    int sum(int a, int b,int c){
        return a+b+c;
    }
    public static void main(String[] args) {
        Numbers obj = new Numbers();

        //we can pass int inplace of double!
        //Java will typecast it to double(2 will be converted into double).
        //int -> double
        obj.sum(2,3);

        //double -> int (This is not possible) (Data loss occurs! so not allowed in java)
        // obj.sum(2,3.23343);

        obj.sum(2,4,6);
        System.out.println("Executed!");

    }

}