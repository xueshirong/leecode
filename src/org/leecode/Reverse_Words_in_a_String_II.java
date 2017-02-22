package org.leecode;

public class Reverse_Words_in_a_String_II {
	//Given an input string, reverse the string word by word. 
	//A word is defined as a sequence of non-space characters.

	//The input string does not contain leading or trailing spaces and the words are always separated by a single space.
	//Could you do it in-place without allocating extra space?
	//思路：先reverse 整个s；再逐个单词reverse
	public void reverseWords1(char[] s) {
	    // Three step to reverse
	    // 1, reverse the whole sentence
	    reverse(s, 0, s.length - 1);
	    // 2, reverse each word
	    int start = 0;
	    for (int i = 0; i < s.length; i++) {
	        if (s[i] == ' ') {
	            reverse(s, start, i - 1);
	            start = i + 1;
	        }
	    }
	    // 3, reverse the last word, if there is only one word this will solve the corner case
	    reverse(s, start, s.length - 1);
	}

	public void reverse(char[] s, int start, int end) {
	    while (start < end) {
	        char temp = s[start];
	        s[start] = s[end];
	        s[end] = temp;
	        start++;
	        end--;
	    }
	}
}
