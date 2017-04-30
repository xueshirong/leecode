package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Encode_and_Decode_Strings {
	// Encodes a list of strings to a single string.
    //{"abc", "def"}    =>  "abc # def # "
    //{'abc', '#def'}   =>  "abc # ##def # "
	public String encode(List<String> strs) {
        /*if (strs == null)   return null;
        if (strs.size() == 0)   return "";*/
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s.replace("#", "##") + " # ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	/*List strs = new ArrayList();
        String[] array = s.split(" # ", -1);
        for (int i=0; i<array.length-1; ++i)
            strs.add(array[i].replace("##", "#"));
        return strs;*/
        List<String> res = new ArrayList<String>();
        
        String[] strs = s.split(" # ", -1);//key point
        for (int i = 0; i < strs.length - 1; i++){
            res.add(strs[i].replace("##", "#"));
        }
        return res;
    }
}
