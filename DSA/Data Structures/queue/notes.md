# Java Queue 

### Queue Basics
- **Queue = FIFO (First In, First Out)**  
- **Front = head** (where removal/peek happens)  
- **Rear = tail** (where insertion happens)  
- Java `Queue<E>` is an **interface**  
  - Common implementations: `LinkedList`, `PriorityQueue`, `ArrayDeque`, `ArrayBlockingQueue`.  

## Adding Elements
| Method       | Return Type | Behavior if Full |
|--------------|-------------|------------------|
| `add(E e)`   | `boolean (true if added)`   | **Throws `IllegalStateException`** if capacity full |
| `offer(E e)` | `boolean`   | Returns **`true` if success**, **`false` if full** |

**Tip**: Use `offer()` for safe insert (no exception).  

## Removing Elements
| Method        | Return Type | Behavior if Empty |
|---------------|-------------|-------------------|
| `remove()`    | `E`         | **Throws `NoSuchElementException`** |
| `poll()`      | `E`         | Returns **`null`** |

**Tip**: Use `poll()` to avoid exceptions.  

## Examining Elements (Peek head, no remove)
| Method        | Return Type | Behavior if Empty |
|---------------|-------------|-------------------|
| `element()`   | `E`         | **Throws `NoSuchElementException`** |
| `peek()`      | `E`         | Returns **`null`** |

👉 **Tip**: Use `peek()` for safe head lookup.  

## Utility Methods (from Collection)
- `isEmpty()` → `boolean` → true if empty.  
- `size()` → `int` → number of elements.  
- `contains(Object o)` → `boolean`.  
- `iterator()` → traverse queue.  

## BlockingQueue (multithreading special)
(extends Queue, thread-safe operations)  
- `put(E e)` → waits if full.  
- `take()` → waits if empty.  
- `offer(E e, long time, TimeUnit unit)` → waits up to time.  
- `poll(long time, TimeUnit unit)` → waits up to time.  

## Golden Summary
- **Insert**: `add()` (throws) vs `offer()` (safe).  
- **Remove**: `remove()` (throws) vs `poll()` (safe).  
- **Examine**: `element()` (throws) vs `peek()` (safe).  
- Use **safe versions** (`offer`, `poll`, `peek`) unless you want strict exception handling.  

## Where Queues are used?
- **1.** Keyboard Buffer (letters should appear on the screen in the order they're pressed)
- **2.** Printer Queue (Print jobs should be completed in order)
- **3.** Used in LinkedLists, PriorityQueues, Breadth-first search
- 
# Java Queue vs Stack 

| Feature / Method | **Queue** (FIFO: First In, First Out) | **Stack** (LIFO: Last In, First Out) |
|------------------|---------------------------------------|---------------------------------------|
| **Concept** | Think of a **horizontal line** (first person in line goes first) | Think of a **vertical tower** (last item placed comes out first) |
| **Insert** | `add(E e)` → throws `IllegalStateException` if full<br>`offer(E e)` → returns `true/false` (safe) | `push(E e)` → adds to top (returns the pushed element) |
| **Remove** | `remove()` → removes head, throws `NoSuchElementException` if empty<br>`poll()` → removes head, returns `null` if empty | `pop()` → removes top, throws `EmptyStackException` if empty |
| **Examine (peek without remove)** | `element()` → head, throws `NoSuchElementException` if empty<br>`peek()` → head, returns `null` if empty | `peek()` → top, throws `EmptyStackException` if empty |
| **Check empty** | `isEmpty()` | `empty()` (specific to Stack)<br>`isEmpty()` (inherited from Vector) |
| **Size** | `size()` | `size()` |
| **Search** | Not available directly (need contains/iterator) | `search(Object o)` → returns **1-based position from top**, `-1` if not found |
| **Common Uses** | - Task scheduling<br>- Print queue<br>- Order processing<br>- Producer-consumer (with BlockingQueue) | - Undo/Redo<br>- Browser back/forward<br>- Backtracking (mazes, DFS)<br>- Call stack in function calls |

---

## ⚡ Golden Summary
- **Queue** → FIFO → like a line at a ticket counter.  
  - Safe methods: `offer`, `poll`, `peek`.  
- **Stack** → LIFO → like a pile of plates.  
  - Core methods: `push`, `pop`, `peek`, `search`.  

---
