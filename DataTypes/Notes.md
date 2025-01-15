### **Primitive Types vs Wrapper Classes**

| **Primitive**  | **Wrapper Class** | **Key Differences**                                | **Use Case**                        |
|----------------|-------------------|----------------------------------------------------|-------------------------------------|
| **`byte`**      | **`Byte`**         | - `byte` is a primitive, `Byte` is an object.      | Use `byte` for small numbers.       |
| **`short`**     | **`Short`**        | - `short` stores values from -32,768 to 32,767.    | Use `short` for memory-efficient 16-bit numbers. |
| **`int`**       | **`Integer`**      | - `int` is a 32-bit primitive. `Integer` is an object. | Use `int` for regular integer operations. |
| **`long`**      | **`Long`**         | - `long` stores 64-bit values. `Long` is an object. | Use `long` for large integers.      |
| **`float`**     | **`Float`**        | - `float` is a 32-bit floating-point.              | Use `float` for floating-point numbers with less precision. |
| **`double`**    | **`Double`**       | - `double` is a 64-bit floating-point.             | Use `double` for precise floating-point numbers. |
| **`char`**      | **`Character`**    | - `char` stores single 16-bit characters.          | Use `char` for storing characters.  |
| **`boolean`**   | **`Boolean`**      | - `boolean` stores `true/false`, while `Boolean` can be `null`. | Use `boolean` for flags, `Boolean` for nullable states. |

---

### **Key Differences Between Primitives & Wrappers**:

1. **Nullability**:
   - **Primitives**: Cannot be `null`. They hold default values (`0`, `false`, `'\u0000'` for `char`).
   - **Wrappers**: Can be `null`, representing an absence of a value.
   
2. **Memory Usage**:
   - **Primitives**: Use less memory as they store values directly.
   - **Wrappers**: Objects, so they use more memory due to metadata and object structure.
   
3. **Performance**:
   - **Primitives**: Faster due to direct value representation.
   - **Wrappers**: Slower because of object overhead (e.g., boxing and unboxing).

4. **Use in Collections**:
   - **Primitives**: Cannot be used directly in collections like `ArrayList`.
   - **Wrappers**: Can be used in collections (e.g., `ArrayList<Integer>`).

5. **Autoboxing & Unboxing**:
   - **Autoboxing**: Java automatically converts primitive types to their corresponding wrapper class when needed (e.g., `int` to `Integer`).
   - **Unboxing**: Java automatically converts wrapper objects to their primitive types when required (e.g., `Integer` to `int`).

### **Example**:
```java
int num = 5;          // Primitive
Integer wrappedNum = 5;  // Wrapper (autoboxed from int)

int unwrappedNum = wrappedNum;  // Unboxing (from Integer to int)
```

### **When to Use Which**:
- **Primitives**: Use when you need efficiency and simple operations (e.g., flags, counters).
- **Wrappers**: Use when you need to store `null` values or work with collections (e.g., `ArrayList<Integer>`).


### **`boolean` vs `Boolean` in Java**

1. **`boolean` (Primitive Type)**:
   - Holds only `true` or `false`.
   - Cannot be `null`.
   - Default value: `false` (for instance variables).
   - Memory-efficient (1 bit, but stored as a byte).

2. **`Boolean` (Wrapper Class)**:
   - Holds `true`, `false`, or `null`.
   - Can be used when a value can be absent or undefined.
   - Default value: `null` (if uninitialized).
   - Memory overhead due to being an object.

3. **Key Differences**:
   - **Nullability**: `boolean` can't be `null`, `Boolean` can be.
   - **Performance**: `boolean` is more efficient (primitive type).
   - **Usage**: Use `boolean` for simple true/false, use `Boolean` for nullable values.

### **Use Cases**:
- **`boolean`**: When you need only `true`/`false` values (e.g., flags, conditions).
- **`Boolean`**: When a value may be `null` (e.g., in databases, API responses).
