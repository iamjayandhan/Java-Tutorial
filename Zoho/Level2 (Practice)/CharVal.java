public class CharVal {
    public static void main(String args[]){
        String str = "AB";

        int res = 0;
        for(int i=0;i<str.length();i++){
            int charVal = str.charAt(i) - 'A' + 1;
            res+= charVal * Math.pow(26, str.length()-1-i);
        }
        System.out.println(res);
    }
}
