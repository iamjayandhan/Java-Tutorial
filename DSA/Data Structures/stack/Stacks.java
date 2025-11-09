import java.util.ArrayDeque;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        // stack = LIFO data structure, Last In First Out
        // stores objects into a sort of "vertical tower"
        // push() = add item to the top of the stack
        // pop() = remove item from the top of the stack (EmptyStackException if stack is empty)
        // peek() = return the top item without removing it (EmptyStackException if stack is empty)
        // isEmpty() = check if stack is empty
        // size() = return the number of items in the stack

        Stack<String> stack = new Stack<>();
        System.err.println(stack.empty()); // true

        stack.push("Assassin's Creed");
        stack.push("Far Cry");
        stack.push("The Witcher 3");
        stack.push("Cyberpunk 2077");

        System.err.println(stack.empty()); // false
        System.out.println(stack); // [Assassin's Creed, Far Cry, The Witcher 3, Cyberpunk 2077]

        System.out.println(stack.search("Far Cry")); // 3 (position from the top of the stack, 1-based index)
        System.out.println(stack.search("Minecraft")); // -1 (not found)

        //uses of stack
        // 1. undo/redo features in text editors
        // 2. moving back/forward in browser history
        // 3. backtracking algorithms (maze, file directories)
        // 4. calling functions (call stack)

        System.out.println("Array Deque as Stack");
        //for storage limit use ArrayDeque
        ArrayDeque<Integer> stack1 = new ArrayDeque<>(3);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4); // no error
        System.out.println(stack1); // [4, 3, 2, 1]
    }
}
