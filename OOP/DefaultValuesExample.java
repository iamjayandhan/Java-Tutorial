public class DefaultValuesExample {

    // Primitive types with default values
    byte byteVal;
    short shortVal;
    int intVal;
    long longVal;
    float floatVal;
    double doubleVal;
    char charVal;
    boolean booleanVal;

    // Wrapper types with default values
    Byte byteWrapper;
    Short shortWrapper;
    Integer intWrapper;
    Long longWrapper;
    Float floatWrapper;
    Double doubleWrapper;
    Character charWrapper;
    Boolean booleanWrapper;

    public static void main(String[] args) {
        DefaultValuesExample obj = new DefaultValuesExample();

        // Printing primitive types
        System.out.println("Primitive Types:");
        System.out.println("byte: " + obj.byteVal);        // Default value 0
        System.out.println("short: " + obj.shortVal);      // Default value 0
        System.out.println("int: " + obj.intVal);          // Default value 0
        System.out.println("long: " + obj.longVal);        // Default value 0
        System.out.println("float: " + obj.floatVal);      // Default value 0.0
        System.out.println("double: " + obj.doubleVal);    // Default value 0.0
        System.out.println("char: " + obj.charVal);        // Default value '\u0000'
        System.out.println("boolean: " + obj.booleanVal);  // Default value false

        // Printing wrapper types
        System.out.println("\nWrapper Types:");
        System.out.println("Byte: " + obj.byteWrapper);    // Default value null
        System.out.println("Short: " + obj.shortWrapper);  // Default value null
        System.out.println("Integer: " + obj.intWrapper);  // Default value null
        System.out.println("Long: " + obj.longWrapper);    // Default value null
        System.out.println("Float: " + obj.floatWrapper);  // Default value null
        System.out.println("Double: " + obj.doubleWrapper);// Default value null
        System.out.println("Character: " + obj.charWrapper); // Default value null
        System.out.println("Boolean: " + obj.booleanWrapper); // Default value null
    }
}
