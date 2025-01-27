/*
	Group Anagrams 
	https://leetcode.com/problems/group-anagrams/description/
 
	Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

	Input: strs = [""]
	Output: [[""]]

	Input: strs = ["a"]
	Output: [["a"]]

	1 <= strs.length <= 104
	0 <= strs[i].length <= 100
	strs[i] consists of lowercase English letters.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams{
	public static void main(String args[]){
		String strs[] = {"eat","tea","tan","ate","nat","bat"};

		Map<String,List<String>> map = new HashMap<>();
		for(String str : strs){
			char charArr[] = str.toCharArray();
			Arrays.sort(charArr);
			String key = new String(charArr);

			if(!map.containsKey(key)){
				map.put(key,new ArrayList<>());
				map.get(key).add(str);
			}
			else{
				map.get(key).add(str);
			}
		}
		for(List<String> lst : map.values()){
			System.out.print(lst.toString()+" ");
		}
	}
}


