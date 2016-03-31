package org.leecode;

public class Power_of_Two {
	public boolean isPowerOfTwo(int n) {
        int redundant = 0;
        while (n > 1 && redundant == 0){
            redundant = n%2;
            n = n/2;
        }
        if (n == 1 && redundant == 0)
            return true;
        return false;
    }
}
