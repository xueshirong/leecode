package org.leecode;

public class Reverse_Words_in_a_String {
	//思路： 用split将string切割开，然后倒序重组word
	//注意： word之间有多个space的情况
	public String reverseWords(String s) {
        s = s.trim();
        //corner case
        if (s == null || s.length() < 2)
            return s;
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i > -1; i--){
            if (!arr[i].equals(""))//" a   b   ", word之间有多个space
                sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }
}
