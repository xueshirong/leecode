package org.leecode;

import java.util.HashMap;
import java.util.Map;

public class Ransom_Note {
	//use map to save each char and count for ransomeNote
    //then loop magazine string to deduct the map's value
    //if map size == 0, then return true;
    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        for (int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            if (map.containsKey(c)){
                if (map.get(c) > 1){
                    map.put(c, map.get(c) - 1);
                }else{
                    map.remove(c);
                }
            }
        }
        if (map.size() > 0)
            return false;
        return true;
    }
    
    //solution 2 use int[26]
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            hash[c - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            hash[c - 'a'] -= 1;
            if (hash[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
