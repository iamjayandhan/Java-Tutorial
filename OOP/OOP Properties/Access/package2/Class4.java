package package2;
import package1.Class1;

public class Class4 extends Class1 {
    public static void main(String[] args) {
        /* 
        * test: diff package & sub class
        */

        // we r here to study proVar
        // proVar can be accessed in different package! but only in subclass.
        // parent class wont work as below.
        // Class1 c1 = new Class1();
        // if that works, then there is no diff between public and protected!

        //proVars can only be accessed in diff package via inheritance(ONLY SUBCLASS OBJ AND NOT EVEN PARENT CLASS OBJ)

        Class4 c4 = new Class4();

        //Inheritance + child obj => proVar works!
        System.out.println(c4.pubVar); 
        // System.out.println(c1.priVar); //error: priVar has private access in Class1
        System.out.println(c4.proVar); //WORKS!
        // System.out.println(c1.defVar); //error: defVar is not public in Class1; cannot be accessed from outside package
    }
}
