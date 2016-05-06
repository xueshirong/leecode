package org.leecode;

import java.util.ArrayList;

public class Generate_Parentheses {
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        genP(n, n, new StringBuilder(), ret);
        return ret;
    }

    private void genP(int left, int right, StringBuilder tmp, ArrayList<String> result) {
        if (0 == left && left == right) {
            result.add(tmp.toString());
            return;
        }
        if (left > 0) {
            tmp.append('(');
            genP(left-1, right, tmp, result);
            tmp.deleteCharAt(tmp.length()-1);
        } 
        if (right > left) {
            tmp.append(')');
            genP(left, right-1, tmp, result);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
