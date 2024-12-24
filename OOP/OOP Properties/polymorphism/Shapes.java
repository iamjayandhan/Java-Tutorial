public class Shapes{

    // Parent has area method with void return type!
    // Late binding!
    void area(){
        System.out.println("I am in Shapes");
    }

    static void greet(){
        System.out.println("Hey, I am in Shapes. Greetings!");
    }

    //Early binding!
    //declared as final (prevent overriding and inheritance)
    // final void area(){
    //     System.out.println("I am in Shapes");
    // }
}