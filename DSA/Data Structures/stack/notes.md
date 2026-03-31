# Java Stack

### Stack Basics
- **Stack = LIFO (Last In, First Out)**  
- **Top = where push/pop happens**  
- Java `Stack<E>` is a class in `java.util` (extends `Vector`).  

## Stack has 5 special methods for data manipulation!

### Adding Elements
| Method       | Return Type | Behavior if Full |
|--------------|-------------|------------------|
| `push(E e)`  | `E`         | Adds item to **top** of stack. No special failure case (unbounded unless memory full). |

### Removing Elements
| Method      | Return Type | Behavior if Empty |
|-------------|-------------|-------------------|
| `pop()`     | `E`         | Removes and returns top element. **Throws `EmptyStackException`** if empty. |

### Examining Elements (Peek top, no remove)
| Method      | Return Type | Behavior if Empty |
|-------------|-------------|-------------------|
| `peek()`    | `E`         | Returns top element without removing. **Throws `EmptyStackException`** if empty. |

### Utility Methods
- `empty()` → `boolean` → true if stack is empty.  
- `isEmpty()` (inherited from `Vector`) → `boolean`.  
- `size()` → `int` → number of items in stack.  
- `search(Object o)` → `int`  
  - Returns **1-based position from the top**.  
  - Returns **-1** if not found.  

### empty() vs isEmpty()

| Feature             | `isEmpty()`                                               | `empty()`                    |
| ------------------- | --------------------------------------------------------- | ---------------------------- |
| **Availability**    | Available in `String`, `Collection`, `Map`, `Queue`, etc. | Only in `Stack` class        |
| **Return type**     | `boolean`                                                 | `boolean`                    |
| **Checks**          | If the object has no elements or characters               | If the stack has no elements |
| **Syntax**          | `object.isEmpty()`                                        | `stack.empty()`              |
| **Preferred usage** | Modern and consistent across collections                  | Legacy (specific to Stack)   |

### Common Uses of Stack
1. **Undo/Redo** in text editors.  
2. **Back/Forward navigation** in web browsers.  
3. **Backtracking algorithms** (mazes, recursive directory traversal).  
4. **Function calls (Call Stack)** in programming languages.  

### Golden Summary
- **Push** → add to top.  
- **Pop** → remove from top (throws if empty).  
- **Peek** → look at top (throws if empty).  
- **Search** → 1-based position from top, `-1` if not found.  
- Think of Stack as a **vertical tower**: last placed = first removed.  
