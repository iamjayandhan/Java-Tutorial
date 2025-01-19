public class CircularQueueMain{
    public static void main(String args[]) throws Exception{
        // CircularQueue queue = new CircularQueue(5);
        DynamicQueue queue = new DynamicQueue(5);

        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);
        queue.insert(111);
        
        queue.display();
        
        System.out.println("Deleted element: "+queue.remove());
        queue.insert(133);
        
        queue.display();

        System.out.println("Deleted element: "+queue.remove());
        queue.insert(99);

        queue.display();



        // System.out.println("Peek:"+queue.peek());
        // System.out.println("front: "+queue.front());

        // System.out.println("front: "+queue.front());

    }
}