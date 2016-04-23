package org.leecode;

public class Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0)
            return res;
        for (int i = 0; i < strs[0].length(); i++){
            char tem = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if (i > (strs[j].length() - 1) || tem != strs[j].charAt(i)){
                    return res;
                }
            }
            res = res + tem;
        }
        
        return res;
    }
}
