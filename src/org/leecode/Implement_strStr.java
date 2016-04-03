package org.leecode;

public class Implement_strStr {
    /**
     * Returns a index to the first occurrence of needle in haystack,
     * or -1  if needle is not part of haystack.
     * @param haystack string to be scanned.
     * @param needle string containing the sequence of characters to match.
     */
	/*Thinking
	1. Using the slide window method.
	2. From left to end, keep the window size is (i - j), 
	compare the window with the target
	Attention
	1. At the beginning, we shall consider about the corner, 
	such as "target is longer than source", "target or source is null"
	2. In the for loop, the ending condition is "i < source.length() + 1", 
	because in the method: String.substring(start, end), end is exclusive.
	*/
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        StringBuffer sbTemp = new StringBuffer();
        int j = 0;
        for (int i = 0; i < needle.length(); i++){
            sbTemp.append(haystack.charAt(i));
        }
        
        for (int i = needle.length() - 1; i < haystack.length(); i++){
            if (sbTemp.toString().equals(needle)){
                return j;
            }
            else if (i + 1 < haystack.length()){
                sbTemp.deleteCharAt(0);
                sbTemp.append(haystack.charAt(i + 1));
                j++;
            }
        }
        return -1;
    }
	
	public int strStr2(String source, String target) {
        if (source == null || target == null || source.length() < target.length()){
            return -1;
        }
        
        if (source.equals(target)){
        	return 0;
        }
        
        for(int i = 0; i <source.length(); i++){
        	int j = 0;
            for(j = 0; j <target.length(); j++){
                if(target.charAt(j) != source.charAt(i + j)){
                    break;
                }
            }
            
            if (j == target.length()){
                return i;
            }
        }
        return -1;
    }
}
