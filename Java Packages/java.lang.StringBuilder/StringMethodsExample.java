import java.util.Arrays;

public class StringMethodsExample {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String name = "Jayandhan Rajendran";

        System.out.println(Arrays.toString(name.toCharArray()));
        
        // 1. length()
        System.out.println("Length: " + str1.length()); // 5

        // 2. isEmpty()
        System.out.println("Is Empty: " + str1.isEmpty()); // false

        // 3. charAt()
        System.out.println("Char at index 0: " + str1.charAt(0)); // H

        // 4. codePointAt()
        System.out.println("Code point at index 0: " + str1.codePointAt(0)); // 72 (ASCII value of 'H')

        // 5. equals()
        System.out.println("Equals: " + str1.equals(str2)); // false

        // 6. compareTo()
        System.out.println("CompareTo: " + str1.compareTo(str2)); // negative number (str1 < str2)

        // 7. startsWith()
        System.out.println("Starts with 'He': " + str1.startsWith("He")); // true

        // 8. endsWith()
        System.out.println("Ends with 'lo': " + str1.endsWith("lo")); // true

        // 9. substring()
        System.out.println("Substring (1, 4): " + str1.substring(1, 4)); // ell

        // 10. replace()
        System.out.println("Replace 'l' with 'a': " + str1.replace('l', 'a')); // Hella

        // 11. toLowerCase()
        System.out.println("To Lower Case: " + str1.toLowerCase()); // hello

        // 12. toUpperCase()
        System.out.println("To Upper Case: " + str1.toUpperCase()); // HELLO

        // 13. trim()
        String str3 = "  Hello World  ";
        System.out.println("Trim: " + str3.trim()); // "Hello World"

        // 14. concat()
        System.out.println("Concat: " + str1.concat(str2)); // HelloWorld

        // 15. split()
        String sentence = "Java is awesome";
        String[] words = sentence.split(" ");
        System.out.println("Split:");
        for (String word : words) {
            System.out.println(word); // Java, is, awesome
        }

        // 16. valueOf()
        int number = 123;
        System.out.println("Value of number: " + String.valueOf(number)); // "123"

        // 17. join()
        String[] colors = {"Red", "Green", "Blue"};
        System.out.println("Join colors: " + String.join(", ", colors)); // Red, Green, Blue

        // 18. repeat()
        System.out.println("Repeat 'Hello' 3 times: " + str1.repeat(3)); //HelloHelloHello

        // 19. codePoints()
        System.out.print("Code Points: ");
        str1.codePoints().forEach(cp -> System.out.print(cp + " ")); // 72 101 108 108 111 //all letter's ascii values!
    }
}