### Stack

A stack is a **linear data structure** that follows the **LIFO (Last In, First Out) principle.** This means that the last element added to the stack is the first one to be removed. It is analogous to a stack of plates, where you add and remove plates from the top.

**java.util.Stack:** A built-in class that extends Vector and provides methods like **push(), pop(), peek(), isEmpty()**, etc.
**Custom Implementation:** Using arrays or linked lists.

Stack is internally a **dynamic array** which extends **Vector** class for dynamic nature. Based on the **way it is implemented**, they are called stack and not array!

### Note
* Stack is a class! While Queue is interface. 
* Stacks and Queues are heavyly used in BFS & DFS!
* Used in Trees and graphs
* Convert recursion code into terative code!

### **Table 1: Core Operations of `Stack`**

| **Operation**       | **Description**                                                                 | **Returns (Success)**         | **Returns (Failure)**              |
|----------------------|---------------------------------------------------------------------------------|--------------------------------|-------------------------------------|
| `push(E item)`       | Adds an item to the top of the stack.                                           | The item added (`E`).          | N/A                                 |
| `pop()`              | Removes and returns the item at the top of the stack.                          | The top item (`E`).            | Throws `EmptyStackException` if empty. |
| `peek()`             | Returns the top item without removing it.                                      | The top item (`E`).            | Throws `EmptyStackException` if empty. |
| `empty()`            | Checks if the stack is empty.                                                  | `true` (if empty), `false` (if not). | N/A                                 |
| `search(Object o)`   | Returns the 1-based position of the object in the stack (from top).             | Position (`int`).              | `-1` if not found.                  |

### **Table 2: Inherited Methods from `Vector`**

| **Operation**             | **Description**                                                               | **Returns (Success)**         | **Returns (Failure)**              |
|----------------------------|-------------------------------------------------------------------------------|--------------------------------|-------------------------------------|
| `addElement(E obj)`        | Adds an element to the end of the stack.                                      | N/A                            | N/A                                 |
| `removeElement(Object obj)`| Removes the first occurrence of the specified object.                         | `true` (if removed).           | `false` (if not found).             |
| `remove(int index)`        | Removes the element at the specified index.                                   | The removed element (`E`).     | Throws `ArrayIndexOutOfBoundsException`. |
| `elementAt(int index)`     | Retrieves the element at the specified position.                              | The element (`E`).             | Throws `ArrayIndexOutOfBoundsException`. |
| `size()`                   | Returns the number of elements in the stack.                                  | Size (`int`).                  | N/A                                 |
| `isEmpty()`                | Checks if the stack (or vector) is empty.                                     | `true` (if empty), `false`.    | N/A                                 |
| `clear()`                  | Removes all elements from the stack.                                          | N/A                            | N/A                                 |
| `toArray()`                | Converts the stack elements into an array.                                    | Array of elements (`Object[]`).| N/A                                 |
| `contains(Object obj)`     | Checks if the stack contains the specified object.                            | `true` (if found), `false`.    | N/A                                 |
| `indexOf(Object obj)`      | Returns the index of the first occurrence of the specified object.             | Index (`int`).                 | `-1` if not found.                  |

### **Key Notes**
1. The **core stack operations** strictly follow the **LIFO** principle.  
2. The inherited `Vector` methods allow additional functionality (like arbitrary indexing), which can break the **LIFO** behavior if not used carefully.  
3. For strict stack usage, it is recommended to only use the core `Stack` operations or migrate to **`Deque`** for better consistency.  

