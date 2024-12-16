
import javax.xml.transform.OutputKeys;

public class Main{
    public static void main(String[] args) {
        //simple obj
        Box ref = new Box();

        //One parameter
        Box ref2 = new Box(10);

        //Three parameters
        Box box = new Box(2.3,6.4,1.8);

        //copy constructor
        Box box2 = new Box(box);

        // System.out.println(box.l + " " + box.w + " " + box.h);
        // System.out.println(box2.l + " " + box2.w + " " + box2.h);

        //default -1 values
        BoxWeight box3 = new BoxWeight();
        System.out.println(box3.h + " " + box3.weight);

        //set values for both child and parent!
        BoxWeight box4 = new BoxWeight(2,3,4,5);
        System.out.println(box4.l+" "+box4.h+" "+box4.w+" "+box4.weight);



        //Funny play
        //parent referencing child
        //it is actually the type of ref var, and not the the type of object that determines what members can be accessed!
        Box box5 = new BoxWeight(8,6,7,9);

        //my understanding!
        //BoxWeight -> allocated with memory + super() parent also allocated with memory!
        //Box box5 -> ref var that only knows parent class vars!
        //RESULT => memory is allocated for Both, but we can access only parent class vars(because of limitation of ref var)
        System.out.println(box5.l+" "+box5.h+" "+box5.w+" "+box5.weight);
    
    
        //child referencing parent?
        //You are given access to vars that are in ref type i.e BoxWeight
        //so weight is available...ok....then
        //this also means, that the one u r trying to access should be initialized!
        //but the obj itself is parent class, how will u call the constructor of child class?

        //my understanding!
        //BoxWeight ref var knows weight var.   ok.good!
        //Memory is only allocated for Box() parent!
        
        //😂😂😂
        //box6 is pointing to uninitialized obj & there is no pointer ref for initialized obj(Box).
        //RESULT => COMPILATION ERROR😂😂😂
        BoxWeight box6 = new Box();
    }
}