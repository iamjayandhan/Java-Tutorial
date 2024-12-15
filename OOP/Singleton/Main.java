public class Main{
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        
        //even if we create many instance, same instance that is first created will be returned! only one, no more new instances!
    }
}