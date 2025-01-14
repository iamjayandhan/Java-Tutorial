public class Main {
    public static void main(String[] args) {
        // Car car = new Car();

        // car.start();
        // car.stop();
        // car.acc();

        // //variable of interface type
        // Media car1 = new Car();

        // car1.start();
        // car1.stop();
        // car1.acc(); //media ref var- has no acc func defined in it!

        NiceCar car = new NiceCar();

        car.start();
        car.startMusic();
        car.stop();
        car.upgradeEngine();

        car.start();

    }    
}
