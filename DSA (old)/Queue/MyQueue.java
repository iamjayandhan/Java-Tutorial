public class MyQueue{

    private int arr[];
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyQueue(int capacity){
        this.front=0;
        this.rear=-1;
        this.size=0;
        this.capacity=capacity;
        this.arr=new int[capacity];
    }

    public boolean isFull(){
        return size==capacity;
    }   

    public boolean isEmpty(){
        return size==0;
    }   
    
    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full. Cannot enqueue "+value);
            return;
        }
        rear = (rear+1) % capacity;
        arr[rear] = value;
        size++;
        System.out.println("Element added "+value);
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty. Cannot perform deque operation!");
            return;
        }
        int rem_val = arr[front];
        front = (front+1) % capacity;
        size--;
        System.out.println("Dequeued: "+rem_val);
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");
            return -1;
        }
        System.out.println("Peek element is "+arr[front]);
        return arr[front];
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        
        // add 1 - 10 elements
        for(int i=0;i<12;i++){
            queue.enqueue(i+1);
        }
        //check peek element in the queue
        queue.peek();

        // remove first five elements 1 - 5
        for(int i=0;i<15;i++){
            queue.dequeue();
        }

        //check peek element in the queue
        queue.peek();
    }
}