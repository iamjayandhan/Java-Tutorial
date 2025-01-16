### Linked List

1. **Definition**: A **Linked List** is a linear data structure where each element (node) contains a **data** part and a **reference (link)** to the next node in the sequence. It allows efficient insertion and deletion of elements.

```java
   class Node{
      int val;
      Node next;
   }
```

2. **Types of Linked Lists**:
   - **Singly Linked List**: Each node has a reference to the next node only.
   - **Doubly Linked List**: Each node has references to both the next and previous nodes.
   - **Circular Linked List**: The last node points back to the first node, forming a circular chain.

3. **Advantages**:
   - **Dynamic Size**: Linked lists can grow or shrink in size dynamically, unlike arrays that have a fixed size.
   - **Efficient Insertions/Deletions**: Inserting or deleting elements (especially at the beginning or middle) is efficient (O(1)) since no shifting of elements is required.

4. **Disadvantages**:
   - **Random Access**: Linked lists do not support random access; you must traverse the list from the start to access an element, making it slower than arrays (O(n) access time).
   - **Extra Memory**: Each node requires extra memory for storing the reference (pointer) to the next node, making it less memory-efficient than arrays.

5. **Common Operations**:
   - **Insertion**: Add a node at the beginning, end, or in the middle.
   - **Deletion**: Remove a node from the beginning, end, or middle.
   - **Traversal**: Iterate through the list to access or print the elements.
   - **Search**: Find an element in the list (requires O(n) time).

6. **Use Cases**:
   - **Implementing Queues and Stacks**: Linked lists are often used to implement queue and stack data structures due to their efficient insertion and deletion.
   - **Dynamic Memory Allocation**: They are useful in scenarios where the size of the dataset is constantly changing.

7. **Comparison with Arrays**:
   - **Arrays**: Fixed size, faster random access (O(1) access time).
   - **Linked Lists**: Dynamic size, slower random access (O(n) access time), but efficient insertions and deletions.

8. **Memory Structure**:
   - **Node Structure**: Each node typically has a `data` field and a `next` (or `previous` for doubly linked lists) pointer.
   - **Head**: The first node in the list, which is accessed to start traversing the list. If the list is empty, the head is null.
