package org.leecode;

import java.util.Hashtable;

public class Isomorphic_Strings {
	//use map to save charater's mapping relation. e:a, g:d
	public boolean isIsomorphic(String s, String t) {
		Hashtable<Character, Character> table = new Hashtable<Character, Character>();
        for (int i = 0; i < s.length(); i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (table.containsKey(cS)){
                if (!table.get(cS).equals(cT)){
                    return false;
                }
            }else if (table.containsValue(cT)){//key point to check if t is in the value. N:1 (egg, aaa)
                return false;
            }else{
                table.put(cS,cT);
            }
        }
        return true;
    }
}
