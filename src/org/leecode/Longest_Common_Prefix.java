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
	
	//From Jiu Zhang
	public String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0)
            return "";
        String res = strs[0];//take the first str as basic line
        
        for (int i = 1; i < strs.length; i++){//one by one to compare to bassic line, get common prefix
            String curStr = strs[i];
            if (curStr.equals(res))
                continue;
            int j = 0;
            //get common prefix between strs[i] and res
            while(j < curStr.length() && j < res.length() && res.charAt(j) == curStr.charAt(j)){
                j++;
            }
            res = res.substring(0, j);
        }
        return res;
    }
}
