package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Break_II {
	static Map<String, List<String>> cache = new HashMap<String, List<String>>();
	public static void main(String[] args){
        List<String> dict = new ArrayList<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        List<String> res = getSimpleWord("catsanddog",dict);
        System.out.print(res.size());
    }
    static List<String> getSimpleWord(String s,List<String> dict){
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0 || dict.size() == 0)
            return res;
        if (cache.containsKey(s))   return cache.get(s);
        if (dict.contains(s)) res.add(s);
        for (int i = 0; i < s.length(); i++){
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (dict.contains(left) && containSufix(right, dict)){
                for(String ss : getSimpleWord(right, dict)){
                    res.add(left + " " + ss);
                }
            }
        }
        cache.put(s, res);
        return res;
    }
    
    static boolean containSufix(String s, List<String> dict){
        for (int i = 0; i < s.length(); i++){
            if (dict.contains(s.substring(i)))
                return true;
        }
        return false;
    }
}
