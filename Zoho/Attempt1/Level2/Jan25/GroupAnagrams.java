import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/group-anagrams/description/

public class GroupAnagrams{
	public static void main(String args[]){
		String tc1[] = {"eat","tea","tan","ate","nat","bat"};
		String tc2[] = {""};
		String tc3[] = {"a"};

		ArrayList<ArrayList<String>> res = GroupIt(tc1);
		System.out.println(res);

	}

	public static ArrayList<ArrayList<String>> GroupIt(String words[]){
		ArrayList<ArrayList<String>> res = new ArrayList<>();

		HashMap<String,ArrayList<String>> map = new HashMap<>();

		for(String word : words){
			char key[] = word.toCharArray();
			Arrays.sort(key);
			String sortedKey = new String(key);

			if(map.containsKey(sortedKey)){
				map.get(sortedKey).add(word);
			}
			else{
				map.put(sortedKey,new ArrayList<>());
				map.get(sortedKey).add(word);		
			}
		}

		res.addAll(map.values());
		return res;
	}
}