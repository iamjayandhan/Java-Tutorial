import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    public void backtrack(int n, int openN, int closeN, StringBuilder sb, List<String> res) {
        if (openN == n && closeN == n) {
            res.add(sb.toString());
            return;
        }
        if (openN < n) {
            sb.append('(');
            backtrack(n, openN + 1, closeN, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closeN < openN) {
            sb.append(')');
            backtrack(n, openN, closeN + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }
}
