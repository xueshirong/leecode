package org.leecode;

public class Reverse_Words_in_a_String_II {
	//Given an input string, reverse the string word by word. 
	//A word is defined as a sequence of non-space characters.

	//The input string does not contain leading or trailing spaces and the words are always separated by a single space.
	//Could you do it in-place without allocating extra space?
	public void reverseWords(char[] s) {
		//corner case
		if (s == null || s.length == 0)
			return;
		reverse(s, 0, s.length);
		int start = 0;
		for (int i = 0; i < s.length; i++){
			if (s[i] == ' '){
				reverse(s, start, i - 1);
				start = i + 1;
			}			
		}		
		return;
	}
	private void reverse(char[] c, int s, int e){
		while(s < e){
			char temp = c[s];
			c[s] = c[e];
			c[e] = temp;
			s++;
			e++;
		}
	}
}
