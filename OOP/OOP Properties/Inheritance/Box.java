public class Box{
    double l;
    double h;
    double w;

    Box(){
        this.l = 10;
        this.h = 20;
        this.w = 30;
    }

    //cube
    Box(double side){
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box(double l,double h,double w){
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box(Box old){
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }

    public void information(){
        System.out.println("Running the box");
    }
}