import java.util.ArrayList;
import java.util.List;

public class PermCombi {

    //"abc"
    public static List<String> permstr = new ArrayList<>();
    public static List<String> combistr = new ArrayList<>();

    //{'a','b','c'}
    public static List<List<Character>> permlist = new ArrayList<>();
    public static List<List<Character>> combilist = new ArrayList<>();

    public static void main(String args[]){
        String inputStr = "abc";
        char inputArr[] = {'a','b','c'};

        //permstr
        System.out.print("String permutations: ");
        permStr("",inputStr);
        System.out.println();
        System.out.print("String combinations: ");
        combiStr("",inputStr);
        System.out.println();
        System.out.println();

        //str inside list
        System.out.println("INSIDE LIST!");
        System.out.print("String permutations: ");
        System.out.println(permstr);
        System.out.print("String combinations: ");
        System.out.println(combistr);


        System.out.println();
        System.out.println();

        //permArr
        System.out.println("INSIDE Array!");
        System.out.print("Array permutations: ");
        permArr(new ArrayList<>(),inputArr);
        System.out.println(permlist);

        System.out.print("Array combinations: ");
        combiArr(inputArr);
        System.out.println(combilist);

    }

    public static void permStr(String p,String input){
        if(input.isEmpty()){
            permstr.add(p);
            System.out.print(p+" ");
            return;
        }
        Character ch = input.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0, i);
            String l = p.substring(i,p.length());
            permStr(f+ch+l,input.substring(1));
        }
    }

    public static void combiStr(String p,String input){
        if(input.isEmpty()){
            if(!p.isEmpty()){
                combistr.add(p);
                System.out.print(p+" ");
            }
            return;
        }

        Character ch = input.charAt(0);
        combiStr(p+ch,input.substring(1));
        combiStr(p,input.substring(1));
    }

    public static void permArr(List<Character> temp, char input[]){
        if(temp.size() == input.length){
            permlist.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < input.length; i++){
            // Skip if the character is already in the temp list (used for backtracking)
            if(temp.contains(input[i])){
                continue;
            }
            temp.add(input[i]);
            permArr(temp, input);
            temp.remove(temp.size() - 1);
        }
    }


    public static void combiArr(char input[]){
        //combilist -- outer
        combilist.add(new ArrayList<>());

        for(char ch : input){
            int n = combilist.size();
            for(int i=0;i<n;i++){
                List<Character> temp = new ArrayList<>(combilist.get(i));
                temp.add(ch);
                combilist.add(temp);
            }
        }
    }
}
