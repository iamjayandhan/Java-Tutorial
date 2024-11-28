class Node{
    int data;
    Node next;
    Node(int value){
        this.data = value;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public void addLast(int value){
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;

            System.out.println("Node added: "+value);
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
            System.out.println("Node added: "+value);
        }
    }

    public void addFront(int value){
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;

            System.out.println("Node added: "+value);
        }else{
            Node ptr = newNode;
            ptr.next = this.head;
            this.head = ptr;
            System.out.println("Node added: "+value);
        }
    }
    
    public void addMiddle(int value, int pos) {
        if (pos <= 0) {
            System.out.println("Position is too minimum. Adding to the front.");
            addFront(value);
            return;
        }
        else if (pos == 1) {
            addFront(value);
            return;
        }
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            System.out.println("Node added: " + value + " at pos 1!");
            return;
        }
        int c = 1;
        Node ptr = this.head;
        while (c < pos - 1 && ptr != null) {
            ptr = ptr.next;
            c++;
        }
    
        if (ptr == null) {
            System.out.println("Position exceeds the length of the list. Adding to the end.");
            addLast(value);
        } else {
            newNode.next = ptr.next;
            ptr.next = newNode;
            System.out.println("Node added: " + value + " at pos " + pos);
        }
    }
    
    public void deleteLast(){
        if(this.head == null && this.tail==null){
            System.out.println("LinkedList is empty! Deletion is not possible.");
        }
        else if(this.head == this.tail){
            System.out.println("Deleted Node: "+this.head.data);
            this.head = null;
            this.tail = null;
        }
        else{
            Node ptr = this.head;
            while(ptr.next.next!=null){
                ptr=ptr.next;
            }
            System.out.println("Deleting Node: "+ptr.next.data);
            this.tail = ptr;
            ptr.next=null;
        }
    }
    
    public void deleteFront(){
        if(this.head == null && this.tail==null){
            System.out.println("LinkedList is empty! Deletion is not possible.");
        }
        else if(this.head == this.tail){
            System.out.println("Deleted Node: "+this.head.data);
            this.head = null;
            this.tail = null;
        }
        else{
            Node ptr = this.head;
            this.head = this.head.next;
            System.out.println("Deleted Node: "+ ptr.data);
            ptr.next = null;
        }
    }
    
    public void deleteMiddle(int pos){
        if(this.head == null && this.tail==null){
            System.out.println("LinkedList is empty! Deletion is not possible.");
        }
        else if(this.head == this.tail){
            System.out.println("Deleted Node: "+this.head.data);
            this.head = null;
            this.tail = null;
        }
        else{
            int c=1;
            Node ptr = this.head;
            Node ptr2;

            while(c<pos-1){
                ptr=ptr.next;
                c++;
            }
            ptr2 = ptr.next;
            System.out.println("Deleted Node: "+ptr2.data);
            ptr.next = ptr.next.next;
            ptr2.next = null;
        }
    }
    
    public void printList(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.println();
    }
}

public class LL{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.printList();

        ll.addFront(40);
        ll.printList();

        ll.addMiddle(50,3);
        ll.printList();

        ll.deleteLast();
        ll.deleteLast();
        ll.printList();

        ll.deleteFront();
        ll.printList();

        ll.addLast(60);
        ll.addLast(70);
        ll.addFront(80);
        ll.printList();

        ll.deleteMiddle(4);
        ll.printList();

        ll.addLast(100);
        ll.addFront(110);
        ll.printList();


        ll.addMiddle(120, 0);
        ll.printList();

        ll.addMiddle(130, 1);
        ll.printList();

        ll.addMiddle(140, 2);
        ll.printList();
        
        ll.addMiddle(150, 10);
        ll.printList();
    }
}