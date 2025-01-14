public class Main implements B{
    @Override
    public void fun(){
        System.out.println("yeah fun!");
    }

    @Override
    public void greet(){
        System.out.println("Hello JD!");
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.fun();
        obj.greet();
    }
}
