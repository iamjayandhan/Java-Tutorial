package AbstractClass;

public abstract class Parent {

    int age;
    final int VALUE;

    abstract void career();
    abstract void partner();

    public Parent(int age){
        this.age = age;
        this.VALUE = 12345; //final var can be assigned only once!
    }

    static void hello(){
        System.out.println("Hello!");
    }
}
