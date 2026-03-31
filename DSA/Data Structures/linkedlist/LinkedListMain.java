
import java.util.LinkedList;

// LinkedList is a Doubly-Linked List
// It implements both List and Deque interfaces
// It can be used as a Stack, Queue, or List

// LinkedList = stores Nodes in 2 parts (data + address)
//              Nodes are in non-consecutive memory locations
//              Elements are linked using pointers
//
//                    Singly Linked List
//
//          Node            Node            Node
//     [data | address] -> [data | address] -> [data | address]
//
//
//                    Doubly Linked List
//
//          Node                           Node
//     [address | data | address] <-> [address | data | address]
//
//
// advantages?
// 1. Dynamic Data Structure (allocates needed memory while running)
// 2. Insertion and Deletion of Nodes is easy. O(1)
// 3. No/Low memory waste
//
// disadvantages?
// 1. Greater memory usage (additional pointer)
// 2. No random access of elements (no index [i])
// 3. Accessing/searching elements is more time consuming. O(n)
//
// uses?
// 1. implement Stacks/Queues
// 2. GPS navigation
// 3. music playlist

public class LinkedListMain{
    public static void main(String[] args) {
        LinkedList<String> linkedlist = new LinkedList<>();

        // linkedlist.push("A");
        // linkedlist.push("B");
        // linkedlist.push("C");
        // linkedlist.push("D");
        // linkedlist.push("E");
        //[E, D, C, B, A]

        // linkedlist.pop();
        // [D, C, B, A]

        // linkedlist as queue
        linkedlist.offer("A");
        linkedlist.offer("B");
        linkedlist.offer("C");
        linkedlist.offer("D");
        linkedlist.offer("E");
        linkedlist.poll(); //remove head

        // insert in middle?
        linkedlist.add(3,"X");
        linkedlist.add(3,"Y");
        linkedlist.add(3,"Z");

        linkedlist.remove("Y");

        //methods of interest
        System.out.println(linkedlist.peekFirst());
        System.out.println(linkedlist.peekLast());

        linkedlist.addFirst("0");
        linkedlist.addLast("L");

        String firstValue = linkedlist.removeFirst();
        String lastValue = linkedlist.removeLast();

        System.out.println(firstValue + " " +lastValue);

        System.err.println(linkedlist);
    }
}