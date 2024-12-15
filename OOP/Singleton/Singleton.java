public class Singleton {
    private Singleton(){

    }

    private static Singleton instance;

    public static Singleton getInstance(){
        //check wheather only 1 obj is created or not
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
