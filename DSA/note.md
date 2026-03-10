What is a data structure?
A named location that can be used to store and organize data.
eg. Array
A collection of element stored at contiguous memory locations.

What is an Algorithm? 
A collection of steps to solve a problem.

---------------------------------------------------------
💡 THE GOLDEN RULE OF DSA
Data Structures are HOW we store data.
Algorithms are HOW we solve problems using that data.
They work together. You cannot have an efficient algorithm 
without an appropriate data structure.
---------------------------------------------------------

# Time and Space Complexity (Big O Notation)

Big O Notation measures how well an algorithm scales as the amount of data (n) increases.

*   **O(1) - Constant Time:** Excellent. The operation takes the same amount of time regardless of data size.
    *   *Example:* Accessing an array element by index (`arr[5]`).
*   **O(log n) - Logarithmic Time:** Very Good. The dataset is halved with each step.
    *   *Example:* Binary Search.
*   **O(n) - Linear Time:** Fair. The time grows directly proportional to the data size.
    *   *Example:* Looping through an array once.
*   **O(n log n) - Linearithmic Time:** Bad. Typical for good sorting algorithms.
    *   *Example:* Merge Sort, Quick Sort.
*   **O(n²) - Quadratic Time:** Terrible. Time grows exponentially with the data size. Nested loops!
    *   *Example:* Bubble Sort, Insertion Sort, a loop inside a loop.
*   **O(2^n) - Exponential Time:** Horrible.
    *   *Example:* Recursive Fibonacci.
*   **O(n!) - Factorial Time:** Disastrous.
    *   *Example:* Generating all permutations of a string.

# ☕ Hidden Notes for Java Developers

### 1. Primitive vs Reference Types (Memory Reality)
*   **Primitives** (`int`, `double`, `boolean`) are lightweight and stored directly where they are needed (usually the stack).
*   **Reference Types** (Objects, arrays, `String`, `Integer`) store a *pointer* (reference) to the actual data located on the heap.
*   **Why it matters in DSA:** An `int[]` is a contiguous block of actual numbers. An `Integer[]` or `ArrayList<Integer>` is a contiguous block of *pointers* pointing to objects scattered around the heap. This causes "cache misses" and is significantly slower for massive datasets.

### 2. The Truth About Strings
*   In Java, `String` is **immutable** (cannot be changed).
*   Operation: `str += "a"` creates a completely *new* string in memory and copies the old one over. This is **O(n)** time every single time you do it!
*   **DSA Secret:** If you are building or modifying strings in a loop, ALWAYS use `StringBuilder`. Its `append()` method is **O(1)**.

### 3. Collection Sizing Overhead
*   Collections (like `ArrayList`, `HashMap`) have dynamic sizing.
*   When an `ArrayList` hits its capacity, it creates a new array that is 1.5x larger and copies everything over (O(n) operation).
*   **DSA Secret:** If you know you are going to put 10,000 items into a list, instantiate it with that capacity: `new ArrayList<>(10000)`. This prevents expensive resize operations.

### 4. `HashMap` and `HashSet` Magic
*   Under the hood, `HashMap` uses an array. It takes your key's `hashCode()`, does some math, and uses that as the array index.
*   **Lookups are O(1)** (average case). 
*   **DSA Secret:** If you need to repeatedly check "does this item exist?" (like checking for duplicates or seen nodes in a graph), do NOT use `ArrayList.contains()` which is O(n). Put them in a `HashSet` and use `set.contains()` which is O(1).

### 5. Recursion and the Call Stack
*   Every recursive call in Java adds a new "frame" to the call stack holding local variables.
*   Too many recursive calls = `StackOverflowError`.
*   **DSA Secret:** Java does *not* optimize "tail recursion" like some other languages (e.g., Scala). If your algorithm recurses deeply (e.g., 10,000+ times), you must convert it to an iterative approach using a loop and your own `Stack` object.

### 6. Passing by Value
*   Java ALWAYS passes arguments by value.
*   However, for objects, the "value" being passed is the *reference* (the remote control to the object).
*   **DSA Secret:** If you pass an array or a `List` into a helper function and modify it (e.g., `arr[0] = 5;`), those changes *will* be reflected in the original caller's data. If you reassign the reference itself (e.g., `arr = new int[5];`), the original caller sees nothing.
