class Obj{
    public void objFunc(){
        System.out.println("obj function.");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Object is destroyed.");
    } 

}

public class DestroyObj{
    public static void main(String args[]){

        Obj obj;

        System.out.println();

        for(int i=0;i<1000000000;i++){
            obj = new Obj();
        }
    }
}