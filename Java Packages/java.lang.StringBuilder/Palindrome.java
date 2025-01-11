public class Palindrome {

    public static boolean palindrome(StringBuilder s){
        int l=0;
        int r=s.length()-1;

        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("abcaxacba");
        System.out.printf("Palindrome check for %s: %b\n",s.toString(),palindrome(s));
    }
}
