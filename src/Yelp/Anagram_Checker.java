package Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram_Checker {

	public static void main(String[] args) {
		String[] strs = {"tea", "eta", "eat", "gab"};
		List<String> list = anagrams(strs);
		for(String str : list){
			System.out.println(str);
		}
	}
	
	public static List<String> anagrams(String[] strs) {
	    ArrayList<String> result = null;
	    if(strs == null || strs.length == 0)
	        return result;
	    HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	    for(int i=0; i<strs.length; i++){
	        char[] arr = strs[i].toCharArray();
	        Arrays.sort(arr);
	        String t = String.valueOf(arr);
	        if(map.get(t) == null){
	            ArrayList<Integer> l = new ArrayList<Integer>();
	            l.add(i);
	            map.put(t, l);
	        }else{
	            map.get(t).add(i);
	        }
	    }
	    for(int l: map.values()){
	        result = new ArrayList<String>();
	        if(l.size() >= 1){
	            for(Integer i: l){
	                result.add(strs[l]);

	            }
	            System.out.println(result);
	        }
	    }
	    return result;
	}

	
	public static boolean isAnagram(String s, String t) {
        int[] res = new int[256];
        for (int i = 0; i < s.length(); i++){
            res[s.charAt(i) - 'a'] = res[s.charAt(i) - 'a'] + 1;
        }
        for (int i = 0; i < t.length(); i++){
            res[t.charAt(i) - 'a'] = res[t.charAt(i) - 'a'] - 1;
        }
        for (int i : res){
            if (i != 0)
                return false;
        }
        return true;
    }


}
