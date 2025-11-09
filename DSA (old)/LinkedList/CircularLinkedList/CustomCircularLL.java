public class CustomCircularLL {
    
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;

    private int size;

    public CustomCircularLL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }

    public void insert(int val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete from an empty list");
        }
        int val = head.value;
        if (head == tail) { 
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete from an empty list");
        }
        int val = tail.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        }
        size--;
        return val;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        size--;
        return temp.value;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node find(int value) {
        Node node = head;
        if (node == null) {
            return null;
        }

        do {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        } while (node != head);

        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }
}
