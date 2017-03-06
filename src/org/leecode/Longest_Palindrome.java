package org.leecode;

import java.util.HashMap;
import java.util.Map;

public class Longest_Palindrome {
	public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        int res = 0;
        int even = 0;
        for (char c : map.keySet()){
            int count = map.get(c);
            if (count % 2 == 0)
                res += count;
            else
                even = Math.max(even, count);
        }
        
        return res + even;
    }
}
