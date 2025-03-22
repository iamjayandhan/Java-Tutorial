interface test{
    public void hello();
}

public class Basic{
    enum Week implements test{
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday; //predefined objects
        //They are created when the enum Week is first referenced
        //Unlike regular classes, enums create all their instances at class loading time.
        //Even though you only reference Week.Monday in main(), 
        //Java initializes all constants immediately.

        //these are enum constants
        //they are static ,public and final by default
        //since final, we can't crate child enums!
        // type is week

        //this is not public or protected, only private or default
        //enum can also have constructor!
        Week(){
            System.out.println("Constructor called for "+this);
        }

        //internally
        // public static final Week Monday = new Week();

        //Enum can also implement interface!
        //enum can also behave like class and can implement interface!
        public void hello(){
            System.out.println("Hello!");
        }
    }

    public static void main(String args[]){
        Week week;

        // when the program starts and Week is loaded, 
        //it creates all instances, 
        //calling the constructor for each value (Monday to Sunday).
        week = Week.Monday;

        System.out.println(week);
        week.hello(); // just implement interface in enum declaration line!

        for(Week day : Week.values()){
            System.out.println(day);
        }

        System.out.println(week.ordinal()); //positional value

    }
}
