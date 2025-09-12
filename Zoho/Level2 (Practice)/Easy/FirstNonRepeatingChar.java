public class FirstNonRepeatingChar {
    public static void main(String args[]){
        String str = "abcdabd";
        System.out.println(findit(str));
    }    

    public static Character findit(String str){
        int length = str.length();

        if(length <= 1){
            return null;
        }

        int count[] = new int[256];
        for(int i=0;i<length;i++){
            count[str.charAt(i)]++;
        }

        for(int i=0;i<length;i++){
            if(count[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return null;
    }
}
