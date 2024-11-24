package Exercise.Strings;

class HandleString{
    public String handleString(String s){
        String res = "";
        String resFinal = "";

        for(int i=0;i<s.length();i++){
            if(res.contains(""+s.charAt(i))){//contains only accept string! not char....
                if(res.length()>resFinal.length()){
                    resFinal=res;
                    res="";
                }
                res="";
            }
            else{
                res+=s.charAt(i);
            }
        }
        return resFinal;
    }

}
public class LongestSubstring {
    public static void main(String args[]){
        HandleString hs = new HandleString();
        System.out.println(hs.handleString("jayandhan"));
    }
}
