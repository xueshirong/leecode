package org.leecode;

import java.util.Set;

public class Word_Break {
	//Given a string s and a dictionary of words dict, 
	//determine if s can be break into a space-separated sequence of one or more dictionary words.
	/**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
	public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.equals(""))
            return true;
        //state
        int max = getMaxLength(dict);
        boolean[] path = new boolean[s.length() + 1];
        
        //initial
        path[0] =  true;
        
        //function
        for(int i=1; i <= s.length(); i++){
            for(int j=1; j <= max && j <= i; j++){//j is from end to start
                if(path[i - j] && dict.contains(s.substring(i-j, i))){
                    path[i] = true;
                    break;
                }
            }
        }
        return path[path.length - 1];
    }
    //get the max length of word in dict
    private int getMaxLength(Set<String> dict){
        int max = 0;
        for(String word: dict){
            max = Math.max(max, word.length());
        }
        return max;
    }
}
