public class BaseConverter {
    public static void main(String[] args) {
        System.out.println(convertToBase(27, 17)); // Output: 1A
        System.out.println(convertToBase(13, 3));  // Output: 111
    }

    public static String convertToBase(int number, int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36.");
        }

        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            // Convert remainder to the appropriate character
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
            result.append(digit); // Add digit to the result
            number /= base; // Update number to the quotient
        }

        return result.reverse().toString(); // Reverse the result to get the final answer
    }
}
