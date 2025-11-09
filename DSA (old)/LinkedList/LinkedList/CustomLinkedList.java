public class CustomLinkedList{
    
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;

    private int size;

    public CustomLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }        
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head;

        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        if(head == null){
            throw new IllegalStateException("Cannot delete from an empty list");
        }
        if(head == tail){
            int val = head.value;
            head = null;
            tail = null;
            size--;
            return val;
        }
        int val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public int deleteLast(){
        if(head == null){
            throw new IllegalStateException("Cannot delete from an empty list");
        }
        if(head == tail){
            int val = head.value;
            head = null;
            tail = null;
            size--;
            return val;
        }

        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }

        int val = tail.value;

        tail = temp;
        tail.next = null;
        size--;
        return val;
    }

    //returns node at that index!
    public Node get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        Node node = head;
        for(int i=0;i<index;i++){
            node = node.next; 
        }
        return node;
    }

    public int delete(int index){
        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }        
        if(index == 0){
            deleteFirst();
            return 0;
        }
        if(index == size-1){
            deleteLast();
            return 0;
        }

        Node prev = get(index-1);
        Node temp = prev.next;
        
        int val = tail.value;
        prev.next = temp.next;
        size--;
        return val;
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            else{
                node = node.next;
            }
        }
        return null;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

} 