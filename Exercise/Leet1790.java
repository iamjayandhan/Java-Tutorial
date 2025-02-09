import java.util.Arrays;

public class Leet1790{
	public static void main(String args[]){
		String s1 = "bank";
		String s2 = "kanb";

		if(StringSwap(s1,s2)){
			System.out.println("YES!");
		}
		else{
			System.out.println("NO");
		}
	}

	public static boolean StringSwap(String s1, String s2){
		int charsCheck[] = new int[26];
		for(int i=0;i<s1.length();i++){
			charsCheck[s1.charAt(i) - 'a'] +=1;
			charsCheck[s2.charAt(i) - 'a'] -=1;
		}
		for(int i=0;i<charsCheck.length;i++){
			if(charsCheck[i] !=0) {
				return false;
			}
		}

		int nePos = 0;

        for(int i=0;i<s1.length();i++){
        	int ind1 = s1.charAt(i) - 'a';
            int ind2 = s2.charAt(i) - 'a';
            if(ind1 != ind2) nePos+=1;
        }

        if(nePos == 0|| nePos == 2){
        	return true;
        }
        return false;
	}
}