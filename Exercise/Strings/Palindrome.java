package Exercise.Strings;

class CheckPalindrome{
    public boolean checkPalindrome(String s){
        String rev="";
        
        for(int i=s.length()-1;i>=0;i--){
            rev = rev+s.charAt(i);
        }
        if(s.equals(rev)){
            return true;
        }

        return false;
    }
}

public class Palindrome {
    public static void main(String args[]){
        CheckPalindrome cp = new CheckPalindrome();
        System.out.println(cp.checkPalindrome("radar"));
    }
}
