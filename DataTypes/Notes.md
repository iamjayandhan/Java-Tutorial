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

**Pro Tips**

| **Data Type** | **Size (Bits)** | **Size (Bytes)** | **Range Formula**                          | **Minimum Value**       | **Maximum Value**       |
|---------------|-----------------|------------------|---------------------------------------------|-------------------------|-------------------------|
| **byte**      | 8               | 1                | \(-2^{7}\) to \(2^{7} - 1\)                | \(-128\)               | \(127\)                |
| **short**     | 16              | 2                | \(-2^{15}\) to \(2^{15} - 1\)              | \(-32,768\)            | \(32,767\)             |
| **int**       | 32              | 4                | \(-2^{31}\) to \(2^{31} - 1\)              | \(-2,147,483,648\)     | \(2,147,483,647\)      |
| **long**      | 64              | 8                | \(-2^{63}\) to \(2^{63} - 1\)              | \(-9,223,372,036,854,775,808\) | \(9,223,372,036,854,775,807\) |
| **float**     | 32              | 4                | Approx. ±\(1.4 \times 10^{-45}\) to ±\(3.4 \times 10^{38}\)* | \(-3.4 \times 10^{38}\) | \(3.4 \times 10^{38}\) |
| **double**    | 64              | 8                | Approx. ±\(4.9 \times 10^{-324}\) to ±\(1.7 \times 10^{308}\)* | \(-1.7 \times 10^{308}\) | \(1.7 \times 10^{308}\) |
| **boolean**   | 1 (logical)     | (Not precisely defined) | `true` or `false`                       | `false`                | `true`                 |
| **char**      | 16              | 2                | \(0\) to \(2^{16} - 1\) (Unsigned)         | \(0\)                  | \(65,535\)             |

### **Explanation of the Formulas**

1. **Signed Data Types (byte, short, int, long):**
   - The formula for the range of signed data types is:
     \[
     \text{Range} = \left[-2^{\text{(size in bits - 1)}}, 2^{\text{(size in bits - 1)}} - 1\right]
     \]
   - This accounts for both positive and negative numbers, where one bit is reserved for the sign.

2. **Unsigned Data Types (char):**
   - The formula for the range of unsigned data types is:
     \[
     \text{Range} = \left[0, 2^{\text{(size in bits)}} - 1\right]
     \]

3. **Floating-Point Types (float, double):**
   - Floating-point types have approximate ranges due to their IEEE 754 representation. They are stored as:
     - Sign bit
     - Exponent
     - Mantissa (fractional part)
   - Exact precision and range may vary but follow the IEEE 754 standard.

### **Key Notes**
- **byte** is often used for saving memory in large arrays.
- **short** is rarely used as `int` is generally preferred.
- **int** is the default for integer values.
- **long** is used for very large integers.
- **float** and **double** are used for fractional numbers, with **double** being more precise.
- **boolean** only takes `true` or `false`.
- **char** stores a single 16-bit Unicode character.