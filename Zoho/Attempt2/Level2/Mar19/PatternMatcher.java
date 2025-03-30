public class PatternMatcher {
    public static void main(String[] args) {
        System.out.println(findMatch("abcfbbbacbk", "bbk*ac+"));  // Expected: "bbac"
        System.out.println(findMatch("abcbbcabb", "cb*ab+"));      // Expected: "cbbcabb"
        System.out.println(findMatch("abcbbcabb", "cb*ab+b"));     // Expected: "cbbcabb"
    }

    public static String findMatch(String s, String p) {
        String result = dfs(s, p, 0, 0, "");
        return result.isEmpty() ? "No match found" : result;
    }

    private static String dfs(String s, String p, int i, int j, String currentMatch) {
        if (j == p.length()) {
            return (i == s.length()) ? currentMatch : "";
        }

        if (i > s.length()) {
            return "";
        }

        if (i == s.length() && j < p.length()) {
            if (j + 1 < p.length() && (p.charAt(j + 1) == '*' || p.charAt(j + 1) == '+')) {
                return dfs(s, p, i, j + 2, currentMatch);
            }
            return "";
        }

        if (i < s.length() && j < p.length()) {
            boolean isMatch = (s.charAt(i) == p.charAt(j));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                String skipStar = dfs(s, p, i, j + 2, currentMatch);
                String takeStar = "";
                int k = i;
                while (k <= s.length() && (k == i || isMatch)) {
                    String temp = dfs(s, p, k, j + 2, currentMatch + s.substring(i, k));
                    if (temp.length() > 0) {
                        return temp;
                    }
                    k++;
                    isMatch = (k < s.length() && (s.charAt(k - 1) == p.charAt(j)));
                }
                return skipStar;
            }

            if (j + 1 < p.length() && p.charAt(j + 1) == '+') {
                if (!isMatch) {
                    return "";
                }
                int k = i;
                while (k <= s.length() && (k == i || isMatch)) {
                    String temp = dfs(s, p, k, j + 2, currentMatch + s.substring(i, k));
                    if (temp.length() > 0) {
                        return temp;
                    }
                    k++;
                    isMatch = (k < s.length() && (s.charAt(k - 1) == p.charAt(j)));
                }
                return "";
            }

            if (isMatch) {
                return dfs(s, p, i + 1, j + 1, currentMatch + s.charAt(i));
            }
        }
        return "";
    }
}