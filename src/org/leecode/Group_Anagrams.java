package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
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
