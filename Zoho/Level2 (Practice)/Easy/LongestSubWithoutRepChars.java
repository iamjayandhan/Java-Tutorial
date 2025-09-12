public class LongestSubWithoutRepChars {
    public static void main(String args[]) {
        String str = "ababcdc";
        System.out.println(findLongestNonRepeatingSubstring(str));
    }

    private static int findLongestNonRepeatingSubstring(String str) {
        int start = 0; // left boundary of current window
        int maxLen = 0; // store maximum length found so far
        int[] lastSeen = new int[256]; // keeps last seen index (ASCII size)

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //if my curr char is already seen under my window boundary
            if(lastSeen[ch] > start){
                start = lastSeen[ch];
            }
            lastSeen[ch] = i+1;
            maxLen = Math.max(maxLen, i+1 - start);
        }
        return maxLen;
    }

}
