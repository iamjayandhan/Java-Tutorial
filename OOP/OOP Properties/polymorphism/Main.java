public class Main {
    public static void main(String args[]){
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        shape.area();
        circle.area();
        square.area();
        triangle.area();

        Shapes square2 = new Square();
        square2.area(); // uses area() from Square class!

    }
}
