import java.util.ArrayList;

public class RecursionAscii{
	public static void main(String args[]){
		String str = "abc";

		//recursive way
		ArrayList<String> res = subsetAscii(str,"");
		System.out.println(res.toString());
	}

	//return ans in array (arraylist is inside body)
	public static ArrayList<String> subsetAscii(String str, String included){
		if(str.isEmpty()){
			ArrayList<String> res = new ArrayList<>();
			if(!included.isEmpty()){ 
				res.add(included);
			}
			return res;
		}

		ArrayList<String> left = subsetAscii(str.substring(1),included+str.charAt(0)+(str.charAt(0)+0)); //this is entry point of content!
		ArrayList<String> right = subsetAscii(str.substring(1),included);
		left.addAll(right);
		return left;
	}
}