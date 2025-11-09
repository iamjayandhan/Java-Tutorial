public class MyStack {
    private int[] stack;
    private int top;
    private int capacity;

    public MyStack(int size){
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int value){
        if(top == capacity){
            System.out.println("Stack is full. Cannot insert value "+value);
            return;
        }
        top++;
        stack[top] = value;
        System.out.println("Added value: "+value);
    }

    public void pop(){
        if(top==-1){
            System.out.println("Stack is empty. Cannot perform pop operation!");
            return;
        }
        int pop_val = stack[top];
        top--;
        System.out.println("Popped value: "+pop_val);    
    }

    public int peek(){
        if(top==-1){
            System.out.println("Stack is empty!");
            return -1;
        }
        System.out.println("Peek element: "+stack[top]);
        return 1;
    }

    public static void main(String args[]){
        MyStack stack = new MyStack(10);

        stack.push(10); 
        stack.push(20); 
        stack.push(30); 

        stack.peek();   
        stack.pop();    
        stack.peek();   

        stack.pop();    
        stack.pop();    
        stack.pop();    
    }
}
