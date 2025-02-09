// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class RecursionTelephone{
	public static void main(String args[]){
		String tc1 = "23";
		String tc2 = "";
		String tc3 = "2";

		Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        //print those
		// combinations("",tc1,map);

		//combinations count
		System.out.println(combinationsCount("",tc1,map));

		//return as arraylist
		// ArrayList<String> res = combinationsList("",tc1,map);
		// System.out.println(res);
	}


	//returned as arraylist
	public static ArrayList<String> combinationsList(String unprocessed,String processed,Map<Integer,String> map){
		if(processed.isEmpty()){
			ArrayList<String> res = new ArrayList<>();
			res.add(unprocessed);
			return res;
		}

		char n = processed.charAt(0);
		String nValues = map.get(n-'0');

		ArrayList<String> res = new ArrayList<>();

		for(int i=0;i<nValues.length();i++){
			res.addAll(combinationsList(unprocessed+nValues.charAt(i),processed.substring(1),map));
		}
		return res;
	}


	//combinations are counted!
	public static int combinationsCount(String unprocessed,String processed,Map<Integer,String> map){
		if(processed.isEmpty()){
			return 1;
		}

		char n = processed.charAt(0);
		String nValues = map.get(n-'0');

		int count = 0;

		for(int i=0;i<nValues.length();i++){
			count += combinationsCount(unprocessed+nValues.charAt(i),processed.substring(1),map);
		}
		return count;
	}

	//combinations are printed!
	public static void combinations(String unprocessed,String processed,Map<Integer,String> map){
		if(processed.isEmpty()){
			System.out.println(unprocessed);
			return;
		}

		char n = processed.charAt(0);
		String nValues = map.get(n-'0');

		for(int i=0;i<nValues.length();i++){
			combinations(unprocessed+nValues.charAt(i),processed.substring(1),map);
		}
		return;
	}
}