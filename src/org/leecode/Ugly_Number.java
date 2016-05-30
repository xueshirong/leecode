package org.leecode;

public class Ugly_Number {
	public boolean isUgly(int num) {
        if (num <= 0)//0 is nether positive integer nor negative integer
            return false;
        while (num != 1){
            if (num % 2 == 0){
                num = num / 2;
            }else if (num % 3 == 0){
                num = num / 3;
            }else if (num % 5 == 0){
                num = num / 5;
            }else{
                return false;
            }
        }
        return true;
    }
}
