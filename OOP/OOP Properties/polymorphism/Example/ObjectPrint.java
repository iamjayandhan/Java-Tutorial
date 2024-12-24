//this is done by default by all the classes in java
public class ObjectPrint extends Object{

    int num;

    public ObjectPrint(int num){
        this.num = num;
    }

    public String toString(){
        return "ObjectPrint{"+"num="+num+"}";
    }

    public static void main(String args[]){
        ObjectPrint obj = new ObjectPrint(5);

        //All classes by default inherits Object class!
        // When we try to print obj, it called toString method inside that Object class.
        // it prints ObjectPrint@418e7838

        //we can use @override annotation to override this method!
        //we can define our own toString!
        System.out.println(obj);
    }
}
