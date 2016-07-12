package org.leecode;

public class Palindrome_Number {
	public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int tmp = x;
        int newVal = 0;
        while (x != 0){
            newVal = newVal * 10 + x % 10;
            x = x/10;
        }
        if (tmp == newVal)
            return true;
        else
            return false;
    }
}
