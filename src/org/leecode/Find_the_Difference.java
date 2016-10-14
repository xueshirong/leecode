package org.leecode;

public class Find_the_Difference {
	//a^b^c = c^b^a = b^c^a =...
	public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i ++){
            c ^= s.charAt(i) ^ t.charAt(i);
        }
        return c;
    }
}
