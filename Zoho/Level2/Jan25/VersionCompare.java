// https://www.geeksforgeeks.org/compare-two-version-numbers/
// https://leetcode.com/problems/compare-version-numbers/

public class VersionCompare{
	public static void main(String args[]){
		String V1 = "1.0.31";
		String V2 = "1.0.27";

		int res = compare(V1,V2);
		if(res == 1) System.out.println("Version1 is greater");
		else if(res == -1) System.out.println("Version2 is greater");
		else System.out.println("Both are equal");
	}

	public static int compare(String v1,String v2){
		
		for(int i=0,j=0;(i<v1.length() || j<v2.length());){
			int vnum1 = 0, vnum2 = 0;

			while(i<v1.length() && v1.charAt(i)!='.'){
				vnum1 = (vnum1 * 10) + (v1.charAt(i)-'0');
				i++;
			}

			while(j<v2.length() && v2.charAt(j)!='.'){
				vnum2 = (vnum2 * 10) + (v2.charAt(j)-'0');
				j++;
			}

			if(vnum1 > vnum2) return 1;
			else if(vnum1 < vnum2) return -1;

			i++;
			j++;
		}
		return 0;
	}
}


