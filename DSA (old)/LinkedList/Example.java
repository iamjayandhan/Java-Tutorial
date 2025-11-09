class Node{
    public int data;
    public Node next;
    public Node prev;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList{
    public Node head;
    public Node tail;

    LinkedList(){
        this.head = null;
        this.tail = null;
    }

    void add(int value){
        Node newNode = new Node(value);

        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    void addFront(int value){}
    void deleteFront(){}
    void deleteLast(){}
    void deleteMiddle(){}

    void printll(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr=ptr.next;
        }
        System.out.println();
    }
}

class DoublyLinkedList{
    public Node head;
    public Node tail;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    void add(int value){
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
    }

    void printll(){
        Node ptr = this.head;
        while(ptr!=null){
            System.out.print(ptr.data+"<-->");
            ptr=ptr.next;
        }
        System.out.println();
    }

    void deleteLast(){
        Node ptr = this.head;
        while(ptr.next !=this.tail){
            ptr=ptr.next;
        }
        this.tail.prev=null;
        ptr.next = null;
        
    }

    // insert before, end, delete before ,end
}


public class Example{
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.printll();

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.printll();
    }
}