public class Main {
    public static void main(String[] args) {
        CustomCircularLL ll = new CustomCircularLL();

        ll.insertFirst(2);
        ll.insertFirst(5);
        ll.insertFirst(1);
        ll.insertFirst(8);

        ll.insertLast(10);
        ll.insert(17, 2);

        ll.display();
        System.out.println("Removed element: " + ll.deleteFirst());
        ll.display();
        System.out.println("Removed element: " + ll.deleteLast());
        ll.display();
        System.out.println("Removed element: " + ll.delete(2));
        ll.display();

        System.out.println("Find 17: " + ll.find(17));
        System.out.println("Find 99: " + ll.find(99));
    }
}
