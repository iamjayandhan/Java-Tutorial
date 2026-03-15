# Java 8+ Interview Questions & Answers

**1. Why can a Stream be consumed only once? What would happen if we try to reuse the same stream?**
A Java Stream can be used only once because it works like a pipeline that processes the data step-by-step and then finishes. When we perform a terminal operation like `forEach`, `collect`, or `count`, the stream processes all the elements and then gets closed automatically. Since the stream does not store data like a collection and only processes it once, it cannot be reused. If we try to use the same stream again, Java will throw an `IllegalStateException` saying that the stream has already been operated upon or closed. To process the data again, we must create a new stream.

**2. Why do we need Streams if we can write code without the Stream API?**
While we can write code without the Stream API, Streams make the code shorter, cleaner, and easier to read. Before Streams, we mostly used loops to filter, sort, or process data, which required many lines of code. With Streams, we can do the same work more concisely. It allows us to describe *what* we want to do instead of *how* to do it. Streams also support features like functional programming and easy parallel processing, which can improve performance in some cases.

**3. Can you explain the Stream pipeline structure?**
A Stream pipeline in Java is a sequence of steps used to process data. It mainly has three parts:
- **Source:** Where the data comes from (e.g., a Set, List, or Array).
- **Intermediate Operations:** Operations like `filter`, `map`, or `sorted` that transform the data. These operations prepare the pipeline and do not run immediately (they are lazy).
- **Terminal Operations:** Operations like `forEach`, `collect`, or `count` that trigger the execution of the whole pipeline and produce a final result. Once the terminal operation runs, the stream is completed and cannot be reused.

**4. Why are intermediate operations called "lazy"?**
Intermediate operations like `filter`, `map`, and `sorted` are called lazy because they do not run immediately when they are written. They only prepare the pipeline. The actual processing starts only when a terminal operation like `forEach` or `collect` is called. Until then, Java just remembers the steps but does not process the data.

**5. If a stream pipeline contains multiple filter operations, does it iterate the collection multiple times?**
No, the collection is not iterated multiple times. All intermediate operations are combined into a single pass. For each element, Java applies the first filter method, then the second filter method, and so on, before moving to the next element. The collection is traversed only once, which makes streams very efficient.

**6. You are debugging a stream pipeline and want to check intermediate values without affecting the result. Which concept would you use?**
We could use the `peek()` method. It allows us to look at the elements while they are flowing through the stream pipeline without modifying them. This is useful for debugging because we can print or log the intermediate values without changing the final result.

**7. You are processing a list of 10 million records using streams. After applying multiple filters and a map operation, the performance becomes slow. What factors would you check?**
- Check if the operations inside `filter` or `map` are heavy or slow.
- Check if unnecessary operations are used in the pipeline.
- See if using `parallelStream()` could help improve performance.
- Check if excessive object creation inside the stream is causing issues.

**8. In what scenarios should streams be avoided?**
Streams should be avoided when the logic is very complex. In such cases, a simple loop may be easier to understand and maintain. Streams are best used for simple data processing like filtering, mapping, or collecting.

**9. Can streams modify the original collection?**
No, streams do not modify the original collection. Streams are mainly used to read and process data. They create a new result after operations like `map` or `filter`, while the original collection remains unchanged unless we explicitly modify it ourselves.

**10. What is the difference between map and flatMap conceptually? When would you prefer flatMap?**
- `map` is used to transform each element into exactly one other element (e.g., converting a list of names to uppercase).
- `flatMap` is used when each element contains multiple values (like a list inside a list) and we want to flatten them into a single stream. We prefer `flatMap` when working with nested collections such as a `List<List<T>>`.

**11. Why is forEach considered a terminal operation while peek is an intermediate operation?**
`forEach` is a terminal operation because it triggers the execution of the stream pipeline and finishes the stream, after which the stream cannot be reused. `peek` is an intermediate operation because it just observes the elements in the pipeline, and the stream processing continues to the next operation.

**12. Why is a stream not considered a data structure?**
A stream is not a data structure because it does not store data. Instead, it is just a way to process data from a source (like a list, set, or array). It simply flows the data through operations and produces a result.

**13. What happens if we modify the source collection while the stream is being processed?**
If we modify the source collection while the stream is running, it can cause problems like a `ConcurrentModificationException` or produce unexpected results. Streams expect the source data to remain unchanged during processing.

**14. Can a stream pipeline run without a terminal operation?**
No, a stream pipeline cannot run without a terminal operation. Intermediate operations only build the pipeline but do not process the data. Processing actually starts only when a terminal operation is called.

**15. What is a parallel stream, and how does Java decide how many threads to use?**
A parallel stream processes data using multiple threads simultaneously to improve performance. We can create it using `parallelStream()` or `stream().parallel()`. Java usually decides the number of threads based on the number of CPU cores available in the system.

**16. Why can using a parallel stream sometimes make performance worse?**
Parallel streams can be slower when the task is very small because creating and managing multiple threads adds extra overhead. They can also be slower when there is too much synchronization, shared data, or complex operations, which reduces the benefit of parallel processing.

**17. What kind of operations are not suitable for parallel streams?**
Operations that modify shared variables or depend on a strict order are not suitable for parallel streams. Very small or lightweight tasks are also not good candidates because the overhead of parallelism outweighs the performance gains.

**18. Which thread pool do parallel streams use internally? Can it affect other tasks?**
Parallel streams internally use the `ForkJoinPool.commonPool()`. Since this pool is shared across the entire application, heavy parallel stream tasks can occupy the threads and affect other tasks that also depend on the same pool.

**19. If a stream operation depends on previous results, should we use parallel streams?**
No, we should avoid parallel streams in this case. Parallel streams process elements simultaneously in different threads, so if an operation depends on the results of previous elements, parallel processing can give incorrect or unpredictable results.

**20. When should we prefer sequential streams over parallel streams?**
We should prefer sequential streams when the data size is small, when operations are simple, or when the logic depends on order or shared data. Sequential streams are simpler, safer, and sometimes faster than parallel streams in these cases.

**21. What makes an interface a functional interface? Can it have multiple methods?**
A functional interface is an interface that has *only one* abstract method. It can have multiple `default` methods or `static` methods, but only exactly one abstract method is allowed. This makes it usable with lambda expressions.

**22. Why does Java allow multiple default methods in a functional interface but only one abstract method?**
Java allows multiple default methods because they already have an implementation, so they do not affect the main purpose of the interface. Only one abstract method is allowed because lambda expressions need one clear, unambiguous method to implement.

**23. Can a functional interface extend another interface? What happens if both have abstract methods?**
Yes, a functional interface can extend another interface. However, if inheriting from both interfaces results in more than one abstract method, it will no longer be considered a functional interface and cannot be used with lambda expressions.

**24. What is the purpose of the @FunctionalInterface annotation if it is optional?**
The `@FunctionalInterface` annotation tells the compiler that the interface is intended to have only one abstract method. It helps the compiler catch errors if someone accidentally adds a second abstract method. It mainly acts as a safety mechanism and improves code clarity.

**25. Can a functional interface contain static methods?**
Yes, functional interfaces can contain static methods. The only rule is that it must have exactly one abstract method. Static methods are allowed because they already have implementations.

**26. Give some examples of functional interfaces.**
Some common examples of functional interfaces in Java are:
- `Runnable`
- `Callable`
- `Comparator`
- `java.util.function` interfaces like `Predicate`, `Function`, `Consumer`, and `Supplier`.

**27. Why does Comparator qualify as a functional interface even though it has many methods?**
`Comparator` is a functional interface because it contains exactly one abstract method, which is `compare()`. The other methods (like `reversed()` or `thenComparing()`) are default or static methods, so they already have implementations and do not break the functional interface rule.

**28. What is the difference between Predicate, Function, Consumer, and Supplier conceptually?**
- **Predicate:** Takes an input value and returns a boolean (`true`/`false`). Used for conditions.
- **Function:** Takes an input value and returns an output value after applying transformations.
- **Consumer:** Takes an input value and performs some action (consumes it) but returns nothing.
- **Supplier:** Takes no input but returns (supplies) a value.

**29. How does the compiler determine which method a lambda expression refers to?**
The compiler checks the target functional interface type where the lambda is used. Since the functional interface has only one abstract method, the compiler automatically infers that the lambda expression provides the implementation for that specific method.

**30. Why must variables used inside lambda expressions be final or effectively final?**
Variables used inside a lambda must be `final` or effectively final so that their values do not change while the lambda is using them. This prevents problems related to unpredictable variable state changes and thread safety.

**31. What does "effectively final" mean?**
"Effectively final" means a variable is not explicitly declared with the `final` keyword, but its value is assigned only once and never changed afterward. In such cases, the Java compiler treats it the same as a `final` variable.

**32. What is the difference between a lambda expression and an anonymous class?**
- A **lambda expression** is a short, concise way to implement a functional interface.
- An **anonymous class** is more verbose, can implement multiple methods, can implement non-functional interfaces, and has its own `this` context. Lambdas are mainly used when we want to implement a single abstract method quickly.

**33. Can lambda expressions access instance variables and static variables?**
Yes, lambda expressions can freely access instance variables and static variables of their enclosing class. Unlike local variables, these do not need to be final or effectively final.

**34. Why can't we use lambda expressions without a functional interface?**
Lambda expressions are specifically designed to provide an inline implementation for the single abstract method of a functional interface. Without a functional interface as a target type, the compiler wouldn't know which method the lambda is trying to implement.

**35. What is a method reference and why do we need it?**
A method reference (written using `::`) is a shorter, more readable alternative to a lambda expression for calling an existing method. It essentially points to a method by its name, making the code cleaner instead of writing out a full lambda expression that does nothing but call that method.

**36. Why was Optional introduced in Java? What problems does it solve?**
`Optional` was introduced to handle null values safely and help prevent `NullPointerException`s (NPEs). Instead of a method returning `null`, it can return an `Optional` object, forcing the caller to explicitly check if a value is present or handle its absence.

**37. What is the difference between orElse() and orElseGet() conceptually?**
Both are used to provide a default value when an `Optional` is empty.
- `orElse()` always creates and evaluates its default value, even if the `Optional` is not empty.
- `orElseGet()` takes a `Supplier` and only creates/evaluates the default value if the `Optional` is actually empty. Therefore, it is more efficient, especially for expensive operations.

**38. What's the difference between Optional.of() and Optional.ofNullable()?**
- `Optional.of(value)` is used when you are absolutely sure the value is not null. If you pass null to it, it will immediately throw a `NullPointerException`.
- `Optional.ofNullable(value)` is safer because it accepts `null`. If the value is null, it simply returns an empty `Optional`.

**39. Can you explain the Java 8 Date/Time API?**
The Java 8 Date/Time API (`java.time` package) provides a better, safer, and immutable way to handle dates and times. It replaces legacy classes like `java.util.Date` and `java.util.Calendar`, which were mutable, not thread-safe, and notoriously difficult to work with. Key classes include `LocalDate`, `LocalTime`, and `LocalDateTime`.

**40. Can you explain the var keyword introduced in Java 10?**
`var` was introduced in Java 10 for local variable type inference, making code shorter and cleaner. It allows the compiler to automatically deduce the variable's type based on what is assigned to it (e.g., `var list = new ArrayList<String>();`). The variable is still strongly and statically typed at compile time.

**41. What is a Record and why was it introduced in Java 14?**
A `Record` is a special type of class designed specifically as a transparent carrier for immutable data. It was introduced to eliminate boilerplate code. When you define a record, the Java compiler automatically generates the constructor, getters, `toString()`, `equals()`, and `hashCode()` methods for you.

**42. Can you explain Sealed Classes and when they were introduced?**
Sealed Classes were introduced in Java 17. They allow developers to restrict which other classes or interfaces can extend or implement them. By defining a known group of permitted subclasses, they give better control over inheritance hierarchies and improve application security and domain modeling.

**43. Can you explain the Virtual Threads introduced in Java 21?**
Virtual Threads (Project Loom) were introduced in Java 21 to make highly concurrent applications easier to write and more scalable. Unlike traditional OS-level threads which are heavy and consume substantial memory, virtual threads are lightweight threads managed directly by the JVM. Because of this, an application can effortlessly run millions of concurrent tasks blocking gracefully without exhausting system resources.
