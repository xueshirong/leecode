package org.leecode;

public class Reverse_Vowels_of_a_String {
	public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        String temp = "aeiouAEIOU";
        char[] c = s.toCharArray();
        while(i < j){
            if (temp.indexOf(c[i]) < 0)
                i++;
            if (temp.indexOf(c[j]) < 0)
                j--;
            if (temp.indexOf(c[i]) > -1 && temp.indexOf(c[j]) > -1){
                c = swap(c, i, j);
                i++;
                j--;
            }
        }
        return String.valueOf(c);
    }
    private char[] swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return c;
    }
}
