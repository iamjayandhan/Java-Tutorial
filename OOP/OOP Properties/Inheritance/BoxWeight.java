public class BoxWeight extends Box{
    double weight;


    //if we create obj for BoxWeight, then this constructor is executed
    BoxWeight(){
        super(); //this is done internally by java if not explicitly specified!
        this.weight = -1;
    }

    //what if we pass 4 parameters to child? this below constructor has to handle 4 parameters!
    // weight for itself and remaining h,l,w for parent! how this child constructor pass val to parent constructor?
    BoxWeight(double l,double h, double w, double weight){
        super(l,h,w); // super keyword must be declared on top! with parameters if needed.
        this.weight = weight;
    }
}