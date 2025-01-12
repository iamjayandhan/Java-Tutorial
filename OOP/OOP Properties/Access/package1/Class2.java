package package1;

public class Class2 {
    public static void main(String[] args) {
        /* 
        * test: same package & not sub class
        */
        
        Class1 c1 = new Class1();
        System.out.println(c1.pubVar); 
        // System.out.println(c1.priVar); //error: priVar has private access in Class1
        System.out.println(c1.proVar); 
        System.out.println(c1.defVar); 
    }
}
