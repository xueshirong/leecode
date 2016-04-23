package org.leecode.Test;

public class Reverse_String {
	public String reverseString(String s) {
        char[] c = s.toCharArray();
        String res = "";
        for (int i = 0; i < c.length; i++){
            res = res + c[i];
        }
        return res;
    }
	
	public String reverseString2(String s) {
        char[] c = s.toCharArray();
        String res = "";
        int i = 0;
        int j = c.length - 1;
        while (i < j){
            c = swap(c, i, j);
            i++;
            j--;
        }
        return res;
    }
    
    private char[] swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return c;
    }
}
