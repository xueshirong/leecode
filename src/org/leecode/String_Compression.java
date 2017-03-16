package org.leecode;

public class String_Compression {
	/*mplement a method to perform basic string compression using the counts of repeated characters. 
	 * For example, the string aabcccccaaa would become a2b1c5a3.
	If the “compressed” string would not become smaller than the original string, 
	your method should return the original string.
	You can assume the string has only upper and lower case letters (a-z).

	str=aabcccccaaa return a2b1c5a3
	str=aabbcc return aabbcc
	str=aaaa return a4*/
	public String compress(String str){
        if (str == null || str.equals(""))
            return str;
        char pre = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) != str.charAt(i - 1)){
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
                pre = str.charAt(i);
            }else{
                count++;
                continue;
            }
        }
        sb.append(pre);
        sb.append(count);
        
        if (sb.toString().length() >= str.length())
            return str;
        return sb.toString();
    }
}
