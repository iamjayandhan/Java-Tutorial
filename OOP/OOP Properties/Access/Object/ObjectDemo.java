package Object;

public class ObjectDemo {
    
    int num;
    public ObjectDemo(int num){
        this.num = num;
    }
    
    //toString provides string representation
    @Override
    public String toString(){
        return super.toString();
    }

    //finalize is called during garbage collection. 
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
    }
        
    //hashcode gives a number representation of a object.
    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(48);
        System.out.println(obj.hashCode());
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getCanonicalName());
        System.out.println(obj.getClass().getName());
    }
}
