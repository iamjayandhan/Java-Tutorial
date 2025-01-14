public class Main implements A,B{
    // @Override
    // public void fun(){
    //     System.out.println("yeah fun!");
    // }

    @Override
    public void greet(){
        System.out.println("Greetings from B!");
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.fun();
        obj.greet();
        A.greetA(); //static call!
    }
}
