import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueues {
    public static void main(String[] args) {

        // priority queue = FIFO data structure, but elements are ordered by priority
        // higher priority elements are dequeued before lower priority elements
        // if elements have the same priority, they are dequeued in the order they were added

        Queue<Double> queue = new PriorityQueue<>(); //numbers will be arranged in ascending order! similarly for alphabets!
        Queue<Double> queue2 = new PriorityQueue<>(Collections.reverseOrder()); //reverse order!
        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        queue2.offer(3.0);
        queue2.offer(2.5);
        queue2.offer(4.0);
        queue2.offer(1.5);
        queue2.offer(2.0);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.err.println();
        while(!queue2.isEmpty()){
            System.out.println(queue2.poll());
        }
    }
}
