class Person{

}

public class MemoryManagement {
    public static void main(String args[]) {
        int primitiveVariable1 = 10;
        Person personObj = new Person();
        String stringLiteral = "24";
        MemoryManagement memObj = new MemoryManagement(); 
        memObj.memoryManagementTest(personObj);
    }
    private void memoryManagementTest (Person personObj){ 
        Person personObj2 = personObj;
        String stringLiteral2 = "24";
        String stringLiteral3 = new String("24");
        System.gc();
    }
}