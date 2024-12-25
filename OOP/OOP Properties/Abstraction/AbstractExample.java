abstract class Vehicle{
    abstract void start();
}

class Bike extends Vehicle{
    @Override
    void start(){
        System.out.println("Bike is running!");  
    }
}

class Car extends Vehicle{
    @Override
    void start(){
        System.out.println("Car is running!");
    }
}

public class AbstractExample{
    public static void main(String[] args) {
        Vehicle bike = new Bike();
        Vehicle car = new Car();

        bike.start();
        car.start();
    }
}

