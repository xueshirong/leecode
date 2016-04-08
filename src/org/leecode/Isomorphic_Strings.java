package org.leecode;

import java.util.HashMap;
import java.util.Hashtable;

public class Isomorphic_Strings {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> table = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (table.containsKey(cS)){
                if (table.get(cS).equals(cT)){
                    continue;
                }else{
                    return false;
                }
            }else if (table.containsValue(cT)){
                return false;
            }else{
                table.put(cS,cT);
            }
        }
        return true;
    }
}
