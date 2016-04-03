package org.leecode;

import java.util.HashSet;

public class Palindrome_Permutation {
	public boolean canPermutePalindrome(String s) {
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
}
