package AbstractClass;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(23);
        son.career();

        Daughter daughter = new Daughter(19);
        daughter.career();

        //static call
        Parent.hello();

        Parent obj1 = new Son(11);
        Parent obj2 = new Daughter(12);
        obj1.career();
        obj2.career();


        //Parent reference → Child object = ✅ Allowed (Polymorphism).
        //Child reference → Parent object = ❌ Not allowed (Type incompatibility).
        // Son obj3 = new Parent(11);
        // Daughter obj4 = new Parent(12);
        // obj3.career();
        // obj4.career();
    }
}
