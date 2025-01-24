import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits)); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result; // Return empty list if no digits are provided
        }

        // Map digits to corresponding letters
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        // Start backtracking
        backtrack(result, phoneMap, digits, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuilder current) {
        // Base case: If the current combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters for the current digit
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        // Recursively explore all possibilities
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Add the current letter
            backtrack(result, phoneMap, digits, index + 1, current); // Move to the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
