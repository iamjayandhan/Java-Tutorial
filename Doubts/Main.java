public class Main {
    public static void main(String[] args) {
        Parent obj = new Child2();
        System.out.println(++obj.num);
        System.out.println(obj.num);
    }
}
