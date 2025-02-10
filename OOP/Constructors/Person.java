class Person {
    String name;
    int age;

    public Person() {
        name = "Unknown";
        age = 0;
        System.out.println("Non-Parameterized Constructor called!");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized Constructor called!");
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.display(); // Output: Name: Unknown, Age: 0

        Person p2 = new Person("John", 25);
        p2.display(); // Output: Name: John, Age: 25
    }
}
