package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        //corner case
        if (s == "")
            return res;
        List<String> path = new ArrayList<String>();
        helper(s, 0, path, res);
        return res;
    }
    private void helper(String s, int pos, List<String> path, List<List<String>> res){
        if (pos == s.length()){
            res.add(new ArrayList(path));//should be new array
            return;
        }
        
        for (int i = pos + 1; i <= s.length(); i++){//note: i <= s.length()
            String pre = s.substring(pos, i);//substring is subtract from pos to i (exclue i)
            if (!isPal(pre))
                continue;
            path.add(pre);
            helper(s, i, path, res);
            path.remove(path.size() - 1);
        }
    }
    
    private boolean isPal(String s){
        int beg = 0;
        int end = s.length() - 1;
        while(beg < end){
            if (s.charAt(beg) != s.charAt(end))
                return false;
            beg++;
            end--;
        }
        return true;
    }
}
