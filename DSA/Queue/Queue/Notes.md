### Queue  
A **queue** is a **linear data structure** that follows the **FIFO (First In, First Out)** principle. This means that the first element added to the queue is the first one to be removed. It is analogous to a line of people where the first person in line is served first.

In Java, a queue can be implemented using:
1. **`java.util.Queue`**: An interface that is implemented by classes like `LinkedList` and `ArrayDeque`.
2. **Custom Implementation**: Using arrays or linked lists.

### **Common Operations of a Queue**  
- **Enqueue**: Adds an element to the rear (end) of the queue.  
- **Dequeue**: Removes and returns the element from the front of the queue.  
- **Peek**: Returns the front element without removing it.  
- **isEmpty**: Checks if the queue is empty.  
- **Size**: Returns the number of elements in the queue.

### **Types of Queues**  
1. **Simple Queue**: Follows FIFO strictly.  
2. **Circular Queue**: The last position is connected to the first to form a circle.  
3. **Priority Queue**: Elements are dequeued based on their priority, not just order.  
4. **Deque (Double-Ended Queue)**: Elements can be added or removed from both ends.

### Note
   * Stack is a class! While Queue is interface. 
   * Stacks and Queues are heavyly used in BFS & DFS!
   * Used in Trees and graphs
   * Convert recursion code into terative code!

### Deque (Deck)
* Called as **Doubly ended queue.**
* **Insert and Remove on Both sides.**
```java
    Deque<Integer> deque = new ArrayDeque<>();
```
* null elements are not allowed
* Not thread safe.
* No capacity restrictions
* faster than linkedlist and stack

### **Table 1: Core Operations of `Queue`**

| **Operation**      | **Description**                                                              | **Returns (Success)**         | **Returns (Failure)**                      |
|---------------------|-----------------------------------------------------------------------------|--------------------------------|--------------------------------------------|
| `add(E e)`          | Inserts the specified element into the queue.                              | `true`                        | Throws `IllegalStateException` if capacity-restricted queue is full. |
| `offer(E e)`        | Inserts the specified element into the queue.                              | `true` (if successful).        | `false` if capacity-restricted queue is full. |
| `remove()`          | Retrieves and removes the head of the queue.                               | The head element (`E`).        | Throws `NoSuchElementException` if the queue is empty. |
| `poll()`            | Retrieves and removes the head of the queue.                               | The head element (`E`).        | `null` if the queue is empty.              |
| `element()`         | Retrieves the head of the queue without removing it.                       | The head element (`E`).        | Throws `NoSuchElementException` if the queue is empty. |
| `peek()`            | Retrieves the head of the queue without removing it.                       | The head element (`E`).        | `null` if the queue is empty.              |

### **Table 2: Additional Methods from `Collection` Interface**

| **Operation**             | **Description**                                                               | **Returns (Success)**         | **Returns (Failure)**                      |
|----------------------------|-------------------------------------------------------------------------------|--------------------------------|--------------------------------------------|
| `size()`                   | Returns the number of elements in the queue.                                  | Size (`int`).                  | N/A                                        |
| `isEmpty()`                | Checks if the queue is empty.                                                 | `true` (if empty), `false`.    | N/A                                        |
| `contains(Object obj)`     | Checks if the queue contains the specified element.                           | `true` (if found), `false`.    | N/A                                        |
| `toArray()`                | Converts the elements in the queue into an array.                             | Array of elements (`Object[]`).| N/A                                        |
| `iterator()`               | Returns an iterator over the elements in the queue.                           | `Iterator<E>`.                 | N/A                                        |
| `remove(Object obj)`       | Removes a single instance of the specified object from the queue (if present).| `true` (if removed).           | `false` if not found.                      |
| `clear()`                  | Removes all elements from the queue.                                          | N/A                            | N/A                                        |

### **Key Notes**
1. **Core Queue Operations** strictly follow the **FIFO** (First In, First Out) principle.
2. The **`Collection` methods** provide extended functionality (like size queries, iteration, and conversions), but these do not inherently interfere with the queue's **FIFO** behavior.
3. To ensure queue-specific behavior, avoid using `Collection` operations like `remove(Object obj)` unless necessary.  
4. For **Deque-based queues** (like `ArrayDeque`), additional methods for double-ended behavior are available (`push`, `pop`, etc.).  

