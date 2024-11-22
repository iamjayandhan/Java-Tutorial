public class DataTypes {
    public static void main(String[] args) {
        // Primitive Data Types
        System.out.println("---- Primitive Data Types ----");
        
        // Integer types
        byte byteVar = 127;            // 1 byte: -128 to 127
        short shortVar = 32000;        // 2 bytes: -32,768 to 32,767
        int intVar = 100000;           // 4 bytes: -2^31 to 2^31-1
        long longVar = 10000000000L;   // 8 bytes: -2^63 to 2^63-1
        
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);

        // Floating-point types
        float floatVar = 3.14f;        // 4 bytes: 6-7 decimal digits precision
        double doubleVar = 3.141592653589793; // 8 bytes: 15-16 decimal digits precision
        
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);

        // Character type
        char charVar = 'A';            // 2 bytes: A single 16-bit Unicode character
        System.out.println("char: " + charVar);

        // Boolean type
        boolean boolVar = true;        // 1 bit: true or false
        System.out.println("boolean: " + boolVar);

        // Non-Primitive Data Types
        System.out.println("\n---- Non-Primitive Data Types ----");

        // String type (a sequence of characters)
        String stringVar = "Hello, Java!";
        System.out.println("String: " + stringVar);

        // Array type (collection of elements)
        int[] arrayVar = {1, 2, 3, 4, 5};
        System.out.print("Array: ");
        for (int num : arrayVar) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Object type
        Object objectVar = "I can hold any type!";
        System.out.println("Object: " + objectVar);

        // Wrapper types
        Integer wrapperInt = 42;       // Wrapper for int
        Double wrapperDouble = 3.14159; // Wrapper for double
        System.out.println("Wrapper Integer: " + wrapperInt);
        System.out.println("Wrapper Double: " + wrapperDouble);

        // Null example
        String nullVar = null;
        System.out.println("Null String: " + nullVar);
    }
}
