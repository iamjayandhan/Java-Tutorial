package package2;
import package1.Class1; //we get class1 from package1

public class Class3 {
    public static void main(String[] args) {
        /* 
        * test: diff package & not sub class
        */

        Class1 c1 = new Class1();
        System.out.println(c1.pubVar); 
        // System.out.println(c1.priVar); //error: priVar has private access in Class1
        // System.out.println(c1.proVar); //error: proVar has protected access in Class1
        // System.out.println(c1.defVar); //error: defVar is not public in Class1; cannot be accessed from outside package
    }
}
