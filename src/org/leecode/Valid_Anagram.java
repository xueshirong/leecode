package org.leecode;

import java.util.Arrays;

public class Valid_Anagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
            return false;
		
//		char[] ss = s.toCharArray();
//		char[] tt = s.toCharArray();
//		
//		Arrays.sort(ss);
//		Arrays.sort(tt);
//		
//		s = new String(ss);
//		t = new String(tt);
//		
//		s.equals(t);
		
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		StringBuilder tb = new StringBuilder();
		tb.append(t);		
        
        for(int i = 0; i < s.length(); i++){
        	String tmp =  Character.toString(sb.charAt(i));
        	int index = tb.indexOf(tmp);
            if (index > -1)
                tb = tb.replace(index, index+1, "");
        }
        if (tb.length() == 0)
            return true;
        return false;
    }
}
