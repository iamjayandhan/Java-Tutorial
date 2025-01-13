package AbstractClass;

public class Son extends Parent{

    public Son(int age){
        // this.age = age;
        super(age);
    }

    @Override
    void career(){
        System.out.println("I am going to be a Engineer");
    }

    @Override
    void partner(){
        System.out.println("I love Juliet");
    }
}
