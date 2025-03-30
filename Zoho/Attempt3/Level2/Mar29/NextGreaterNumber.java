import java.util.Arrays;

public class NextGreaterNumber {
    public static void main(String[] args) {
        int num = 315;
        System.out.println("Next greater number: " + nextGreater(num));
    }

    public static int nextGreater(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;

        // Step 1: Find the rightmost digit that is smaller than its next digit
        int i = n - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such digit is found, return -1 (no greater number possible)
        if (i == -1) return -1;

        // Step 2: Find the smallest digit on right side of 'i' that is larger than digits[i]
        int j = n - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the two digits
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Sort the digits after index i to get the smallest possible number
        Arrays.sort(digits, i + 1, n);

        return Integer.parseInt(new String(digits));
    }
}
