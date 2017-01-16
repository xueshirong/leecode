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
	//From Jiu Zhang
	public int strStr3(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        if (haystack.equals(needle))
            return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int k = 0;
            for (k = 0; k < needle.length(); k++){
                if (needle.charAt(k) != haystack.charAt(i + k))
                    break;
            }
            if (k == needle.length())
                return i;
        }
        return -1;
    }
	
	//slide window
    public int strStr4(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        if (haystack.equals(needle))
            return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needle.length(); i++){//add the first i node of harstack to builder
            sb.append(haystack.charAt(i));
        }
        for (int i = needle.length() - 1; i < haystack.length(); i++){
            if (sb.toString().equals(needle))
                return i - needle.length() + 1;
            else if (i + 1 < haystack.length()){//move i to i+1
                sb.deleteCharAt(0);
                sb.append(haystack.charAt(i + 1));//add i+1 char to builder
            }
        }
        return -1;
    }
    
    public int strStr5(String source, String target) {
        if (source == null || target == null || source.length() < target.length()){
            return -1;
        }
        if (source.equals(target)){
        	return 0;
        }
        int s = 0;
        int len = target.length();
        while(s + len - 1 < source.length()){
            int i = 0;
            for (; i < len; i++){
                if (target.charAt(i) != source.charAt(s + i)){
                    break;
                }
            }
            if (i == len){
                return s;
            }
            s++;
        }
        return -1;
    }
    
    //-------------solution
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr6(String source, String target) {
        if (source == null || target == null || source.length() < target.length()){
            return -1;
        }
        if (source.equals(target)){
        	return 0;
        }
        int start = 0;
        while (start + target.length() <= source.length()){
            int index = 0;
            for (int i = 0; i < target.length(); i++){
                if (target.charAt(i) != source.charAt(start + i))
                    break;
                index++;
            }
            if (index == target.length())
                return start;
            start++;
        }
        return -1;
    }
    
}
