public class CustomQueue{
    protected int data[];
    private static final int DEFAULT_SIZE = 10;
    
    int end = 0;

    public CustomQueue(){
        // this.data = new int[DEFAULT_SIZE];
        // or call the contructor with this keyword
        //this keyword with 2 use cases - modify member , call constructor!
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == data.length-1;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is full!");
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot remove from an empty queue!");
        }
        int removed = data[0];
        
        //shift the elements to left by one place!
        for(int i=1;i<end;i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty!");
        }
        return data[0];
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
        for(int i=0;i<end;i++){
            System.out.print(data[i]+" <- ");
        }
        System.out.print("END\n");
    }
}