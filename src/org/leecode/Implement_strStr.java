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
		if (haystack == null || needle == null){
            return -1;
        }
        if (needle.equals(haystack)){
            return 0;
        }
        int j = 0;
        for (int i = needle.length(); i < haystack.length() + 1; i++){
            String strTemp = haystack.substring(j, i);
            if (needle.equals(strTemp)){
                return j;
            }
            else{
                j++;
            }
        }
        return -1;
    }
}
