public class CircularQueue{
    protected int data[];
    private static final int DEFAULT_SIZE = 10;
    
    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CircularQueue(){
        // this.data = new int[DEFAULT_SIZE];
        // or call the contructor with this keyword
        //this keyword with 2 use cases - modify member , call constructor!
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is full!");
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot remove from an empty queue!");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty!");
        }
        return data[front];
    }

    public int peek() throws Exception{
        if(isEmpty()){
            // System.out.println("Stack is empty!");
            throw new Exception("Cannot peek from an empty queue!");
        }
        return data[end-1];
        
    }

    public void display() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot peek from an empty queue!");
        }
        int i = front;
        do{
            System.out.print(data[i]+" -> ");
            i++;
            i = i % data.length;
        }while(i!=end);
        System.out.print("(Back to head)\n");
    }
}