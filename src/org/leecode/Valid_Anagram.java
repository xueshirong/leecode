package org.leecode;

public class Valid_Anagram {
	//计数s中每个字母出现的次数到 数组[256] 中，然后将t中的字母次数从数组中减去。如果最后数组中全为0， 则true
    public boolean isAnagram(String s, String t) {
        int[] res = new int[256];
        for (int i = 0; i < s.length(); i++){
            res[s.charAt(i) - 'a'] = res[s.charAt(i) - 'a'] + 1;
        }
        for (int i = 0; i < t.length(); i++){
            res[t.charAt(i) - 'a'] = res[t.charAt(i) - 'a'] - 1;
        }
        for (int i : res){
            if (i != 0)
                return false;
        }
        return true;
    }
	
    //将s,t放入StringBuilder，逐一循环S到t中找对应index
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
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
