package org.leecode;

import java.util.HashMap;
import java.util.Map;

public class First_Unique_Character_in_a_String {
	//two loops. 
    //use hashmap to save each char's index.
    //1st loop, if duplicated char, the index will be changed to max_value
    //2nd loop, get the min index
    public int firstUniqChar2(String s) {
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, Integer.MAX_VALUE);
            }else{
                map.put(c, i);
            }
        }
        for (char c : map.keySet()){
            res = Math.min(res, map.get(c));
        }
        if (res == Integer.MAX_VALUE)//corner case: if there is no unique char
            return -1;
        return res;
    }
    //...solution 2
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            chars[c - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (chars[c - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
