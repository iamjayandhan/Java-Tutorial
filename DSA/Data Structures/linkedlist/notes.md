# Java LinkedList

### LinkedList Basics
- **Implementation**: It is a **Doubly-Linked List**.
- **Versatility**: Implements both **`List`** and **`Deque`** interfaces. This means it can be used as a standard list, a **Stack** (LIFO), or a **Queue** (FIFO).
- **Structure**: It stores elements in **Nodes**. Each node holds the data and two pointers: one to the `next` node and one to the `previous` node.
- **Head = first node**, **Tail = last node**.

## Adding/Inserting Elements
| Method | Description |
|---|---|
| `add(E e)` | Appends the element to the end of the list. |
| `add(int index, E element)` | Inserts the element at the specified index. |
| `addFirst(E e)` | Inserts at the beginning. |
| `addLast(E e)` | Appends to the end (same as `add`). |
| `push(E e)` | Inserts at the front (**Stack** method). |
| `offer(E e)` | Adds to the end (**Queue** method, safe insert). |

## Removing Elements
| Method | Behavior / Description |
|---|---|
| `remove()` | Removes and returns the first element (**Throws exception** if empty). |
| `remove(int index)` | Removes the element at the specified index. |
| `remove(Object o)` | Removes the first occurrence of the specified element. |
| `removeFirst()` / `removeLast()` | Removes first/last element (**Throws exception** if empty). |
| `poll()` / `pollFirst()` | Removes and returns the first element (**Returns `null`** if empty). |
| `pollLast()` | Removes and returns the last element (**Returns `null`** if empty). |
| `pop()` | Removes and returns the first element (**Stack** method, throws exception if empty). |

## Examining Elements (Peek / Get)
| Method | Behavior / Description |
|---|---|
| `get(int index)` | Returns the element at the specified index (Requires traversal, slower). |
| `getFirst()` / `getLast()` | Returns first/last element (**Throws exception** if empty). |
| `peek()` / `peekFirst()` | Returns the first element (**Returns `null`** if empty). |
| `peekLast()` | Returns the last element (**Returns `null`** if empty). |
| `element()` | Returns the first element (**Throws exception** if empty). |

## Utility Methods
- `isEmpty()` → `boolean` (true if the list has no elements)
- `size()` → `int` (number of elements)
- `contains(Object o)` → `boolean`
- `indexOf(Object o)` → returns the index of the first occurrence (or `-1` if not found)
- `clear()` → Removes all elements from the list.

## ⚔️ LinkedList vs ArrayList
| Feature | **LinkedList** | **ArrayList** |
|---|---|---|
| **Underlying Structure** | Doubly-Linked List | Resizable Array |
| **Access/Get (`get(i)`)** | **O(n) Slower.** Has to traverse from head/tail to the index. | **O(1) Faster.** Instant random access via index. |
| **Insert/Delete (Middle)** | **O(1)** *after* finding the node. No shifting required. | **O(n) Slower.** Elements must be shifted. |
| **Insert/Delete (Ends)** | **O(1)** Fast. Head and tail are tracked. | **O(1)** at end, but **O(n)** at start (shifting). |
| **Memory Overhead** | **Higher.** Each node stores data + 2 pointers (`prev`, `next`). | **Lower.** Just an array of references. |

## ⚡ Golden Summary
- Use **LinkedList** if your application requires heavy **insertions and deletions** at the front and back of the list (e.g., implementing a Queue, Deque, or Stack).
- Avoid **LinkedList** if you need fast, random access to elements (e.g., `list.get(5000)`). Use `ArrayList` instead.
- **As a Stack**: Use `push()` to add and `pop()` to remove.
- **As a Queue**: Use `offer()` to add and `poll()` to remove.
- **Middle Operations**: `add(index, value)` and `remove(index)` still take *O(n)* time because you have to traverse the list to find the location first!
