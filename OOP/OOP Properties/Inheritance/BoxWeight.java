public class BoxWeight extends Box{
    double weight;


    //if we create obj for BoxWeight, then this constructor is executed
    BoxWeight(){
        super(); //this is done internally by java if not explicitly specified!
        this.weight = -1;
    }


    //copy constructor
    BoxWeight(BoxWeight other){ 
        //we get BoxWeight obj and pass it as a parameter to Box(Box obj)??
        //this works! but remember that parent referencing child? SAME CASE here internally(DITTO COPY OF THAT 3rd case!)!
        //Check Notes.md
        super(other);
        other.weight = weight; 
    }


    //what if we pass 4 parameters to child? this below constructor has to handle 4 parameters!
    // weight for itself and remaining h,l,w for parent! how this child constructor pass val to parent constructor?
    BoxWeight(double l,double h, double w, double weight){
        super(l,h,w); // super keyword must be declared on top! with parameters if needed.
        
        //we can also do this
        System.out.println(this.w); //checks here ,then parent
        System.out.println(super.w); //checks parent directly.
        //we can use this when same var is present in both parent and child.
        
        this.weight = weight;
    }
}