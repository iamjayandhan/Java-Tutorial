import java.util.*;

public class NextGreaterNumberSimplified {
    public static void main(String[] args) {
        int input1 = 315;
        int input2 = 4321;

        System.out.println("Next greater number for " + input1 + " is: " + nextGreaterNumber(input1));
        System.out.println("Next greater number for " + input2 + " is: " + nextGreaterNumber(input2));
    }

    public static String nextGreaterNumber(int number) {
        char[] digits = String.valueOf(number).toCharArray();
        int n = digits.length;

        // Step 1: Find first decreasing element from right
        int i = n - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return "-1"; // no greater permutation possible
        }

        // Step 2: Find just larger digit than digits[i] from right
        int j = n - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap
        swap(digits, i, j);

        // Step 4: Reverse the suffix (to make it smallest possible)
        reverse(digits, i + 1, n - 1);

        return new String(digits);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}

/*
    Given an integer N, find the next greater number using the same digits as N. If no such number exists, return -1.

    Example 1: Input: N = 315 Output: 351
    Example 2: Input: N = 4321 Output: -1 (Since no greater number can be formed using the same digits)
*/