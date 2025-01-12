package package1;

public class Class1 {
    /* 
     * test: same class
    */
    
    public int pubVar = 10;
    private int priVar = 15;
    protected int proVar = 20;
    int defVar = 25;

    public static void main(String[] args) {
        Class1 obj = new Class1();
        System.out.println(obj.pubVar+"\n"+obj.priVar+"\n"+obj.proVar+"\n"+obj.defVar);
    }
}
