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

import java.util.List;
import java.util.ArrayList;

public class GroupAnagrams2{

	public static String hash(int freq[]){
		StringBuilder hashed = new StringBuilder();
		for(int f : freq){
			hashed.append(f+""+"$");
		}
		return new String(hashed);
	}

	public static String frequency(String str){
		int freq[] = new int[26];

		for(char ch : str.toCharArray()){
			freq[ch-'a'] +=1;
		}
		return hash(freq);
	}

	public static void main(String[] args) {
		String strs[] = {"eat","tea","tan","ate","nat","bat"};
			
		List<String> keys = new ArrayList<>();
		List<List<String>> values = new ArrayList<>();

		for(String s : strs){
			String returnedHash = frequency(s);
			if(!keys.contains(returnedHash)){
				keys.add(returnedHash);
				values.add(new ArrayList<>());
			}
			int ind = keys.indexOf(returnedHash);
			values.get(ind).add(s);
		}

		for(List<String> lst : values){
			System.out.println(lst);
		}
	}
}