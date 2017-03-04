package org.leecode;

import java.util.HashSet;
import java.util.Set;

public class Palindrome_Permutation {
	
	public boolean canPermutePalindrome1(String s) {
		HashSet<Character> hs = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++){
			if (hs.contains(s.charAt(i))){
				hs.remove(s.charAt(i));
			}
			else{
				hs.add(s.charAt(i));
			}
		}
		if (hs.size() / 2 <= 1)
			return true;		
		return false;
	}
	//set
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            set.add(c);
        }
        if (set.size() < 2)
            return true;
        return false;
    }
}
