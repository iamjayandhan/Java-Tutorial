public class Palindrome {
    public static void main(String args[]){
        String str = "abcba";
        String str2 = "aA";
        String str3 = "@ab*cba#";
        String str4 = "  aba  ";
        System.out.println(checkPalindrome(str.toLowerCase()));
        System.out.println(checkPalindrome(str2.toLowerCase()));
        System.out.println(checkPalindrome(str3.toLowerCase()));
        System.out.println(checkPalindrome(str4.toLowerCase()));
    }

    public static boolean checkPalindrome(String str){
        int l = 0;
        int r = str.length() - 1;

        while(l<r){
            if(!Character.isAlphabetic(str.charAt(l))) l++;
            if(!Character.isAlphabetic(str.charAt(r))) r--;

            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
