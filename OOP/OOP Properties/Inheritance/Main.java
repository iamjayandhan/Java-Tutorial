public class Main{
    public static void main(String[] args) {
        Box box = new Box(2.3,6.4,1.8);

        //copy constructor
        Box box2 = new Box(box);

        System.out.println(box.l + " " + box.w + " " + box.h);
        System.out.println(box2.l + " " + box2.w + " " + box2.h);

        BoxWeight box3 = new BoxWeight();
        System.out.println();
    }
}