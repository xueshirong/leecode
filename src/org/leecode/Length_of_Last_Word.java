package org.leecode;

public class Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = -1;
        int res = 0;
        for(int i = s.length() - 1; i > -1; i--){
            char c = s.charAt(i);
            if (c == ' '){
                index = i;
                break;
            }
        }
        if (index < 0)
            res = s.length();
        else
            res = s.length() - 1 - index;
        return res;
    }
}
