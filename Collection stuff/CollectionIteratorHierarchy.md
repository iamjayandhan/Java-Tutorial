# Iterator in Java

## **1. What is an Iterator?**
- **Iterator** is an interface in `java.util` package that allows iterating over a collection (like `List`, `Set`, `Queue`).
- It provides methods to traverse and remove elements **dynamically**.
- Works in a **forward-only** direction.

## **2. Why Use an Iterator?**
- It provides a **universal way** to traverse different collection types.
- Unlike `for-each`, it allows **modifying** elements during iteration.
- It avoids **ConcurrentModificationException** when modifying collections.

---

# Java Collection Framework - Interface Hierarchy & Implementations

## **Java Collection Hierarchy**
Below is the hierarchical structure of Java's **Collection Framework**:

```java
// Java Collection Framework - Full Interface & Implementation Hierarchy

Iterable<E>  // Root interface
   ├── Collection<E>  
   │      ├── List<E>  // Ordered, allows duplicates
   │      │      ├── ArrayList<E>       // Dynamic array-based
   │      │      ├── LinkedList<E>      // Doubly linked list
   │      │      ├── Vector<E>          // Synchronized ArrayList
   │      │      ├── Stack<E>           // LIFO stack (extends Vector)
   │      │
   │      ├── Set<E>  // No duplicates
   │      │      ├── HashSet<E>         // Unordered, backed by HashMap
   │      │      ├── LinkedHashSet<E>   // Maintains insertion order
   │      │      ├── TreeSet<E>         // Sorted, backed by TreeMap
   │      │
   │      ├── Queue<E>  // FIFO & Priority-based
   │      │      ├── PriorityQueue<E>   // Heap-based priority queue
   │      │      ├── LinkedList<E>      // Can be used as Queue (Deque)
   │      │      ├── ArrayDeque<E>      // Efficient double-ended queue
   │      │
   │      ├── Deque<E>  // Double-ended queue
   │             ├── LinkedList<E>   // Implements Deque
   │             ├── ArrayDeque<E>   // Faster than Stack
   │
   ├── Map<K, V>  // Key-Value pairs (Has special iterators)
   │      ├── HashMap<K, V>        // Unordered key-value store
   │      ├── LinkedHashMap<K, V>  // Maintains insertion order
   │      ├── TreeMap<K, V>        // Sorted key-value store
   │      ├── WeakHashMap<K, V>    // Keys get garbage collected
   │      ├── ConcurrentHashMap<K, V>  // Thread-safe HashMap
   │      ├── Hashtable<K, V>      // Legacy synchronized map
   │
   ├── Specialized Collections  // Thread-safe & blocking collections
   │      ├── CopyOnWriteArrayList<E>  // Thread-safe ArrayList
   │      ├── CopyOnWriteArraySet<E>   // Thread-safe HashSet
   │      ├── LinkedBlockingQueue<E>   // Blocking queue for concurrency
   │      ├── LinkedBlockingDeque<E>   // Blocking deque (both ends)
   │
   ├── Iterators  // Traversal mechanisms for collections
   │      ├── Iterator<E>        // Used in all Collection<E>
   │      ├── ListIterator<E>    // Used only in List<E> (bi-directional)
   │      ├── Spliterator<E>     // Supports parallel iteration (Java Streams)
   │      ├── Enumeration<E>     // Legacy iterator (Vector, Hashtable)
   │
   ├── Additional Interfaces  // Advanced collections
   │      ├── BlockingQueue<E>     // Queue with thread-safety (Producer-Consumer)
   │      ├── NavigableSet<E>      // Extended Set<E> with navigation methods
   │      ├── NavigableMap<K, V>   // Extended Map<K, V> with navigation methods
   │      ├── ConcurrentMap<K, V>  // Thread-safe Map (like ConcurrentHashMap)
```