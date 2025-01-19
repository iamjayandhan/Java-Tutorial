public class QueueMain{
    public static void main(String args[]) throws Exception{
        // CustomQueue queue = new CustomQueue(5);
        DynamicQueue queue = new DynamicQueue(5);

        queue.insert(20);
        queue.insert(25);
        queue.insert(30);
        queue.insert(35);

        queue.insert(40);
        queue.insert(45);

        queue.display();

        System.out.println("Peek:"+queue.peek());

        System.out.println("front: "+queue.front());

        System.out.println("Deleted element: "+queue.remove());
        System.out.println("front: "+queue.front());

        queue.display();
        System.out.println("Peek:"+queue.peek());

    }
}