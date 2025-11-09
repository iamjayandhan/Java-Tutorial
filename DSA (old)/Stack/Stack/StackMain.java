public class StackMain {
    public static void main(String args[]) throws StackException{
        CustomStack stack = new CustomStack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);

        stack.push(100); //stack is full!
        System.out.println(stack.peek());

        DynamicStack dstack = new DynamicStack(5);

        dstack.push(34);
        dstack.push(45);
        dstack.push(2);
        dstack.push(9);
        dstack.push(18);

        dstack.push(100); //works!
        System.out.println(dstack.peek());
    }
}
