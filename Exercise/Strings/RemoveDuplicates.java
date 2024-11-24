package Exercise.Strings;
 
class HandleDuplicates{
    public String handleDuplicates(String s){
        String res = "";

        for(int i=0;i<s.length();i++){
            if(res.contains(String.valueOf(s.charAt(i)))){
                continue;
            }
            else{
                res += s.charAt(i);
            }
        }
        return res;
    }
}


public class RemoveDuplicates {
    public static void main(String args[]){
        HandleDuplicates hd = new HandleDuplicates();
        System.out.println(hd.handleDuplicates("Hello World"));
    }
}
