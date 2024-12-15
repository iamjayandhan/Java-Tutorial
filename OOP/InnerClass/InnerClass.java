// class Test{
//     String name;

//     public Test(String name){
//         this.name = name;
//     }
// }

//This same above code inside this below class cause error, since that Test is dependent on Outer class.
//so we use static!

public class InnerClass {

    static class Test{
        String name;
    
        public Test(String name){
            this.name = name;
        }

        //overrides def toString method!
        @Override
        public String toString(){
            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Jayandhan");
        Test b = new Test("JD");

        System.out.println(a);

        System.out.println(a.name);
        System.out.println(b.name);
    }
}   
