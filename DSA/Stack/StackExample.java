import java.util.Stack;

public class StackExample {

    private Stack<Integer> stack = new Stack<>();

    public void add(int value){
        stack.push(value);
        System.out.println("Added value: " + value);
    }
    public void remove(){
        if(!stack.isEmpty()){
            int value = stack.pop();
            System.out.println("Removed value: "+value);
        }
        else{
            System.out.println("Stack is empty");
        }
    }
    public void peek(){
        if(!stack.isEmpty()){
            int value = stack.peek();
            System.out.println("Top value: "+value);
        }
        else{
            System.out.println("Stack is empty");
        }
    }
    public void printStack(){
        System.out.println("Stack: ");
        for(int i = 0; i<stack.size(); i++){
            System.out.println(stack.get(i));
        }
    }

    public int search(int value){
        if(!stack.isEmpty()){
            return stack.search(value);
        }
        else{
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public static void main(String[] args) {
        StackExample stackExample = new StackExample();
        stackExample.add(10);
        stackExample.add(20);
        stackExample.peek();
        stackExample.printStack();
        stackExample.remove();
        stackExample.printStack();
        stackExample.add(20);
        stackExample.printStack();

        
        int position = stackExample.search(20);
        if(position<0){
            System.out.println("Element not found in the stack");
        }else{
            System.out.println("Position of 20 from the top: " + position);
        }
    }        
}
