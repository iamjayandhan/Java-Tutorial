class Dog{
    String name;
    String breed;
    int age;

    private static int count=0;

    Dog(String n,String breed,int age){
        this.name = n;
        this.breed = breed;
        this.age = age;
        Dog.count++;
    }

    public String getBreed(){
        return this.breed;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    void setAge(){
        this.age = age+1;
    }

    public static int totalDogs(){
        return Dog.count;
    }

    public void bark(){
        System.out.println(this.name+" is barking");
    }
}

//Inheritance
class GuardDog extends Dog{
    private int trainingLevel;

    //since parent has parameterized constructor, we need to call it from child
    GuardDog(String n,String breed,int age,int trainingLevel){

        super(n,breed,age); //calling parent constructor!
        this.trainingLevel = trainingLevel;
    }

    public int getTrainingLevel(){
        return this.trainingLevel;
    }
}

public class ClassExample{
    public static void main(String[] args) {
        Dog tommy = new Dog("tommy","Indie",3);
        System.out.println(Dog.totalDogs());
        Dog spike = new Dog("spike","lab",2);
        System.out.println(Dog.totalDogs());
        Dog sherry = new Dog("sherry","pug",1);
        System.out.println(Dog.totalDogs());

        GuardDog bruno = new GuardDog("burno", "German Shepherd", 5,2);
        System.out.println(bruno.getTrainingLevel());

        //Polymorphism
        //now bruno is normal dog, forgets about training level.
        System.out.println(bruno.getTrainingLevel());
        Dog brunoNew = bruno;
        // System.out.println(brunoNew.getTrainingLevel());
        System.out.println(brunoNew.getBreed());


    }
}