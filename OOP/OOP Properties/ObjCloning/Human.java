import java.lang.Cloneable;

public class Human implements Cloneable{
    //this class now, implements clonable interface
    int age;
    String name;
    int arr[];

    public Human(int age,String name){
        this.age = age;
        this.name = name;
        this.arr = new int[]{1,2,3,4,5};
    }

    //Manually clone one object to another
    public Human(Human other){
        this.age = other.age;
        this.name = other.name;
    }

    public Object clone() throws CloneNotSupportedException{
        // return super.clone();
        
        //this is shallow copy
        //super.clone() creates a shallow copy of the object.
        //Primitive fields (age, name) are copied.
        //Reference fields (arr) are not duplicated; only their reference is copied
        Human twin = (Human)super.clone();

        //Converting Shallow Copy to Deep Copy
        //A new array (twin.arr) is created for the cloned object.
        //Each element from the original array is copied one by one.
        //Now, twin.arr and this.arr are completely separate arrays.
        twin.arr = new int[twin.arr.length];
        for(int i=0;i<twin.arr.length;i++){
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}
