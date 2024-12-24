public class Circle extends Shapes{

    // Same area method is also here!
    // This child method, overrides method of parent class!
    // @override - this annotation is for our reference!

    @Override //this is called annotation
    void area(){
        System.out.println("Area is pie * r * r");
    }

    // @Override
    static void greet(){
        System.out.println("Hey, I am in Circle. Greetings!");
    }

    // @Override //this fails because there is no area2 in parent to override!
    // void area2(){
    //     System.out.println("Area is pie * r * r");
    // }
}

