import java.util.ArrayList;
import java.util.List;

public class RecursionSubsets{
	public static void main(String args[]){
		String str = "abc";
		// strCombinations("",str);

		// ArrayList<String> res = new ArrayList<>();
		// strCombinations2(str,"",res);
		// System.out.println(res.toString());

		//recursive
		// ArrayList<String> res = strCombinations3(str,"");
		// System.out.println(res.toString());

		strCombinations3_ITER(str);
	}

	//strCombinations3 (Iterative approach)
	public static void strCombinations3_ITER(String str){
		ArrayList<String> org = new ArrayList<>();
		org.add("");

		ArrayList<String> allStuff = new ArrayList<>();


		int i=0;
		while(i<str.length()){
			allStuff.removeAll(allStuff);
			allStuff.addAll(org);
			char ch = str.charAt(i);
			for(int j=0;j<allStuff.size();j++){
				allStuff.set(j,allStuff.get(j)+ch);
				// allStuff.get(j)+str.charAt(i);
				org.add(allStuff.get(j));
			}
			// org.addAll(allStuff);
			i++;
		}

		for(String val : org){
			System.out.print(val+" ");
		}
	}



	//return ans in array (arraylist is inside body)
	public static ArrayList<String> strCombinations3(String str, String included){
		if(str.isEmpty()){
			ArrayList<String> res = new ArrayList<>();
			if(!included.isEmpty()){ 
				res.add(included);
			}
			return res;
		}

		ArrayList<String> left = strCombinations3(str.substring(1),included+str.charAt(0));
		ArrayList<String> right = strCombinations3(str.substring(1),included);
		left.addAll(right);
		return left;
	}

	//return ans in array (arraylist is outside!)
	public static void strCombinations2(String str, String included, ArrayList<String> res){
		if(str.isEmpty()){
			if(!included.isEmpty()) res.add(included);
			return;
		}

		strCombinations2(str.substring(1),included+str.charAt(0),res);
		strCombinations2(str.substring(1),included,res);
	}

	//simple print
	public static void strCombinations(String included,String str){
		if(str.isEmpty()){
			if(!included.isEmpty()) System.out.print(included+" ");
			return;
		}

		strCombinations(included+str.charAt(0), str.substring(1)); //include
		strCombinations(included,str.substring(1)); //ignore
	}
}