package Exercise.Strings;
import java.util.Arrays;
import java.util.HashMap;

class CheckAnagram{
    boolean checkAnagramSort(String s1, String s2){

        boolean res = false;

        if(s1.length()!=s2.length()){
            return res;
        }
        else{
            char[] s1Array = s1.toLowerCase().toCharArray();
            char[] s2Array = s2.toLowerCase().toCharArray();
            Arrays.sort(s1Array);
            Arrays.sort(s2Array);
            res = Arrays.equals(s1Array, s2Array);

        }
        return res;
    }

    boolean checkAnagramDict(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        else{
            HashMap<Character,Integer> map = new HashMap<>();
            
            for(int i=0;i<s1.length();i++){
                char c = s1.toLowerCase().charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }
                else{
                    map.put(c,1);
                }
            }

            for(int i=0;i<s2.length();i++){
                char c = s2.toLowerCase().charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)-1);
                    if(map.get(c)<0){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return true;
     }
}

public class Anagram {
    public static void main(String args[]){
        CheckAnagram ca = new CheckAnagram();
        System.out.println(ca.checkAnagramSort("rsteam", "Master"));
        System.out.println(ca.checkAnagramDict("rsteam", "Master"));

    }
}
