public class CustomStack {
    protected int data[];
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack(){
        // this.data = new int[DEFAULT_SIZE];
        // or call the contructor with this keyword
        //this keyword with 2 use cases - modify member , call constructor!
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public boolean isFull(){
        return ptr == data.length-1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            // System.out.println("Stack is empty!");
            throw new StackException("Cannot pop from an empty stack!");
        }
        // int removed = data[ptr];
        // ptr--;
        // return removed;
        return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            // System.out.println("Stack is empty!");
            throw new StackException("Cannot peek from an empty stack!");
        }
        return data[ptr];
    }

}
