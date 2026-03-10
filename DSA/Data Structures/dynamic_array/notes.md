# Java Arrays: Static vs Dynamic (ArrayList)

### What is an Array?
An **Array** is a data structure used to store a collection of elements of the same data type in a single variable. It occupies a contiguous block of memory.

## ⚔️ Array (Static) vs ArrayList (Dynamic Array)

| Feature | **Array (`String[] arr`)** | **ArrayList (`ArrayList<String> list`)** |
|---|---|---|
| **Size** | **Fixed**. Size is declared at creation and cannot be changed. | **Dynamic**. Automatically grows and shrinks as elements are added/removed. |
| **Data Types** | Can store **primitives** (`int`, `double`) AND **Objects** (`String`). | Can ONLY store **Objects**. For primitives, use wrapper classes (`Integer`, `Double`). |
| **Performance** | **Faster**. Direct memory access without method overhead. | **Slower**. Slight overhead from method calls and resizing operations. |
| **Memory** | **Lower overhead**. Just contiguous data in memory. | **Higher overhead**. Stores an internal array, tracks size, and has method references. |
| **Syntax** | Special syntax (e.g., `arr[i] = val;`, `arr.length`). | Uses methods (e.g., `list.set(i, val);`, `list.size()`). |
| **Multidimensional** | Native support (`int[][] matrix`). | Clunky (Requires nested lists `ArrayList<ArrayList<Integer>>`). |

---

## Operations Comparison

| Action | **Static Array** | **Dynamic ArrayList** |
|---|---|---|
| **Declaration** | `String[] arr = new String[5];`<br>`String[] arr = {"A", "B"};` | `ArrayList<String> list = new ArrayList<>();` |
| **Add Element** | `arr[index] = "A";` *(Must track index manually)* | `list.add("A");` *(Appends to end)* |
| **Insert in Middle** | Not natively supported. You must shift all subsequent elements manually. | `list.add(1, "A");` *(Automatically shifts elements right)* |
| **Get Element** | `String val = arr[2];` | `String val = list.get(2);` |
| **Update Element**| `arr[2] = "NewVal";` | `list.set(2, "NewVal");` |
| **Remove Element**| Not natively supported. You must shift elements left manually or set to `null`. | `list.remove(2);`<br>`list.remove("A");` |
| **Size/Length** | `int len = arr.length;` *(Property)* | `int size = list.size();` *(Method)* |
| **Clear All** | Iteratively set all to `null` or create a new array. | `list.clear();` |

---

## How does ArrayList work under the hood? (The "Dynamic" part)
Since arrays in Java are fundamentally fixed in size, how does an `ArrayList` grow?

1. **Internal Array**: When you create an `ArrayList`, it creates a standard static array behind the scenes (default capacity is 10).
2. **Filling up**: As you `add()` elements, it fills this internal array.
3. **Resizing (The Magic)**: When the internal array gets full, the `ArrayList`:
   - Creates a **new** static array that is typically **1.5x or 2x** the size of the old array.
   - **Copies** all elements from the old array to the new array.
   - Replaces the old array reference with the new one.
   - Discards the old array (handled by Garbage Collector).

*This resizing operation is expensive `O(n)`, but because it happens infrequently, adding to an `ArrayList` is said to have an **amortized time complexity of O(1)**.*

---

## ⚡ Golden Summary
- Use **Standard Arrays (`[]`)** when:
  - You know exactly how many items you will need ahead of time.
  - You are working heavily with primitives to save memory/performance.
  - You are building multidimensional grids/matrices.
- Use **ArrayLists** when:
  - You aren't sure how many items you'll need.
  - You need to frequently add or remove elements.
  - You want access to utility methods like `contains()`, `remove()`, or easy sorting.
