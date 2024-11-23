class Dog{
    String name;

    Dog(String name){
        this.name = name;
    }
}

public class PointerExample{

    public static void changeName(Dog d){
        d.name = "Max";
    }

    public static void changeNumber(int a){
        a = 20;
    }

    public static int doubleIt(int a){
        return a * 2;
    }

    public static void main(String[] args){
        Dog dog = new Dog("Buddy");
        System.out.println(dog.name);

        //passing ref
        changeName(dog);
        System.out.println(dog.name);

        //passing value
        int a=5;
        a=doubleIt(a);
        System.out.println(a);
        changeNumber(a);
        System.out.println(a);
        //in java, passing obj means , passing reference
    }
}