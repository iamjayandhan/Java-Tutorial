public interface A {
    default void fun(){
        System.out.println("I am in A");
    }

    static void greetA(){
        System.out.println("Greetings from A!");
    }
}
