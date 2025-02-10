### **Summary of Dynamic Method Dispatch (DMD) in Java**  

1. **Dynamic Method Dispatch (DMD)** allows method calls to be resolved at **runtime** based on the **actual object type**, not the reference type.  
2. **Reference type** (`A`) determines **what is accessible** at **compile-time**.  
3. **Object type** (`B` or `C`) determines **which overridden method is executed** at **runtime**.  
4. **Java uses method overriding** to achieve **runtime polymorphism** (parent reference, child object).  
5. **Method calls are dynamically bound at runtime**, so changing the object makes it behave differently.  
6. If a child class **does not override** the method, the **parent method is called instead**.  

🔹 **Key Rule:** If a method is overridden in the child class, the **child's method gets executed** instead of the parent's, even when referenced by a parent type. 🚀