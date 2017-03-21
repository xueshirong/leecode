package org.leecode;

import java.util.HashMap;
import java.util.Map;

public class Word_Pattern_II {
	Map<Character,String> map =new HashMap<Character, String>();
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0)
    	    return str.length() == 0;  
        if (map.containsKey(pattern.charAt(0))) {
        	String value = map.get(pattern.charAt(0));
        	if (value.length() > str.length() || !str.substring(0, value.length()).equals(value)) 
        		return false;
        	if (wordPatternMatch(pattern.substring(1), str.substring(value.length())))
        		return true;
        } else {
        	for (int i = 1; i <= str.length(); i ++) {
        		if (map.containsValue(str.substring(0, i))) 
        		    continue;
        		map.put(pattern.charAt(0), str.substring(0, i));
        		if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
        			return true;
        		} 
        		map.remove(pattern.charAt(0));
        	}
        }
        return false;
    }
}
