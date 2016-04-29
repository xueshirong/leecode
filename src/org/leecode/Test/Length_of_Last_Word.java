package org.leecode.Test;

public class Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0)
            return 0;
        String[] arr = s.split(" ");
        int len = arr[arr.length - 1].trim().length();
        
        return len;
    }
}
