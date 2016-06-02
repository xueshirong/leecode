package org.leecode;

public class Power_of_Four {
	public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        if (num == 1)
            return true;
        while(num > 1){
            if (num % 4 != 0)
                return false;
            num = num / 4;
        }
        return true;
    }
}
