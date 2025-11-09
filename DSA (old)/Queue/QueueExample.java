import java.util.LinkedList;
import java.util.Queue;

public class QueueExample{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        //Enqueue: offer()
        queue.offer(1);
        queue.offer(2);

        //Dequeue: poll()
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}