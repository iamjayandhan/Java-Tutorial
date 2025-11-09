import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues {
    public static void main(String[] args) {
        // queue = FIFO data structure, First In First Out
        // stores objects into a sort of "horizontal line"

        // add elem:
        // add(E e) → throws exception if it fails (e.g., full capacity queue).
        // offer(E e) → returns true/false instead of throwing.

        // remove elem:
        // remove() → removes and returns head, throws exception if empty.
        // poll() → removes and returns head, returns null if empty.

        // peek() = return the front item without removing it
        // isEmpty() = check if queue is empty
        // size() = return the number of items in the queue

        Queue<String> queue = new java.util.LinkedList<>();
        System.out.println(queue.isEmpty()); // true

        queue.offer("Assassin's Creed");
        queue.offer("Far Cry");
        queue.offer("The Witcher 3");
        queue.offer("Cyberpunk 2077");

        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.size());
        System.out.println(queue); // [Assassin's Creed, Far Cry, The Witcher 3, Cyberpunk 2077]

        System.out.println(queue.peek()); // Assassin's Creed

        queue.poll(); // removes Assassin's Creed
        System.out.println(queue); // [Far Cry, The Witcher 3, Cyberpunk 2077]

        queue.poll(); // removes Far Cry
        System.out.println(queue); // [The Witcher 3, Cyberpunk 2077]

        System.err.println(queue.contains("Cyberpunk 2077")); // true
        System.err.println(queue.contains("Minecraft")); // false

        System.err.println("Array Blocking Queue as Queue");
        // for storage limit use ArrayBlockingQueue
        ArrayBlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(3);
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        boolean r = queue1.offer(4); // returns false
        System.out.println(r); // false
    }
}
