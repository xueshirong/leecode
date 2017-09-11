package Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram_Checker {

	public static void main(String[] args) {
		String[] strs = {"tea", "eta", "eat", "gab"};
		List<String> list = groupAnagrams(strs);
		for(String str : list){
			System.out.println(str);
		}
	}
	
	public static List<String> groupAnagrams(String[] strs) {
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
	    for(ArrayList<Integer> l: map.values()){
	        result = new ArrayList<String>();
	        if(l.size() >= 1){
	            for(Integer i: l){
	                result.add(strs[i]);

	            }
	            System.out.println(result);
	        }
	    }
	    return result;
	}

	public static List<List<String>> groupAnagrams1(String[] strs) {
        //将所有字符串排序，排序后的结果作为key，原串作为value，将value放到map中对应的list里。
        List<List<String>> res = new ArrayList<List<String>>();
        //corner case
        if (strs == null || strs.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        //将map中所有的list取出来
        for (String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }


}
