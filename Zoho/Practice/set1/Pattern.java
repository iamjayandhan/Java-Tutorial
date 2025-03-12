public class Pattern{
	public static void main(String args[]){
		String str = "PROGRAM";
		patternX(str);
	}

	public static void patternX(String str){

		int l = 0;
		int r = str.length()-1;

		int mid = (str.length()-1)/2;

		for(int i=0;i<str.length();i++){
			for(int j=0;j<str.length();j++){
				//handle the special case!
				if(i == j && i == mid) {
					System.out.print(str.charAt(l++));
					r--;				
				}
				else if(i == j) System.out.print(str.charAt(l++)+" ");
				else if(i+j == str.length()-1) System.out.print(str.charAt(r--)+" ");
				else System.out.print("  ");
			}
			System.out.println();
		}
	}
}