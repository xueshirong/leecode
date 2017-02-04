package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {
	//思路：先用map把所有的数字，字母映射关系存储好，再用DFS backtracking查找所有的组合
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		//corner case
		if (digits == null || digits == "")
		    return res;
		Map<Character, char[]> map = new HashMap<Character, char[]>();
		map.put('0', new char[] {});
		map.put('1', new char[] {});
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });
		
		StringBuilder sb = new StringBuilder();		
		helper(digits, sb, map, res);
		return res;
	}
	//DFS to get all possible combination
	private void helper(String digits, StringBuilder sb, Map<Character, char[]> map, List<String> res){
		if (sb.length() == digits.length()){
			res.add(sb.toString());
			return;
		}
		for (char c : map.get(digits.charAt(sb.length()))){
			sb.append(c);
			helper(digits, sb, map, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
