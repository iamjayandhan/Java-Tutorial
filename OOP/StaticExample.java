public class StaticExample{
    public static void main(String args[]){
        // greeting(); fails!
        //cannot make a static reference to the non-static method greeting() from the type StaticExample
        // a static method can access only static data.

        StaticExample obj = new StaticExample();
        obj.greeting();
    }

    //this is not dependent on objects
    static void fun(){ //replicates main behaviour!
        // greeting(); //fails! from which instance?

        StaticExample obj = new StaticExample();
        //ok now i know the instance!
        obj.greeting(); //works!
    }

    //something that is not static, belongs to an object
    void fun2(){
        fun(); // static func, works!
        greeting(); //works! both fun2 & greeting are non static belonging to an obj instance!
        // greeting - since we have same instance, we can communicate without obj creation right?
        // fun2 - yes! we both non-static!
    }

    //something that is not static, belongs to an object
    void greeting(){
        fun(); //this works! independent right?
        System.out.println("Hello user");
    }
}