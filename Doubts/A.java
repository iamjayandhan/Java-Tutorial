public class A {
    private int num = 10;
    public void show(){};

    public class Inner{
        // A obj = new A();
        public void show(){
            System.out.println(this.num);
        }
    }

    public static void main(String[] args) {
        A obj = new A();
        A newObj = new B();
        newObj.show();



        // obj.Inner innerobj = new obj.Inner();
        A.Inner innerObj = obj.new Inner();
        

        // System.out.println(innerObj.num);

    }
}

class B extends A{
    public void show() {
        System.out.println(this.num);
    }
}
