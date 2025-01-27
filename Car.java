class Car{
    String brand = "Toyota";
    String color = "white";

    void drive(){
        System.out.println("The car is driving.");
    }

}

class NormalCar extends Car{
    static int maxSpeed = 130;
}

class RaceCar extends Car{
    static int maxSpeed = 200;

}

public class Main{
    public static void main(String[] args) {
        NormalCar normalCar = new NormalCar();
        NormalCar.maxSpeed = 140;
        NormalCar normalCar2 = new NormalCar();

        System.out.println(NormalCar.maxSpeed);
        System.out.println(NormalCar.maxSpeed);

        RaceCar raceCar = new RaceCar();
        System.out.println(RaceCar.maxSpeed);
    }
}