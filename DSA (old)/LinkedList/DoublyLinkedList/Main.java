
public class Main {
    public static void main(String[] args) {
        CustomDoublyLL dll = new CustomDoublyLL();

        dll.insertFirst(2);
        dll.insertFirst(5);
        dll.insertFirst(1);
        dll.insertFirst(8);

        dll.display();
        dll.displayReverse();

        dll.insertLast(10);
        dll.display();

        dll.insert(17,2);

        dll.display();
        dll.displayReverse();

        System.out.println("Removed element: "+dll.deleteFirst());
        dll.display();
        System.out.println("Removed element: "+dll.deleteLast());
        dll.display();
        System.out.println("Removed element: "+dll.delete(2));
        dll.display();

        System.out.println(dll.find(17));
        System.out.println(dll.find(99));

    }

}
