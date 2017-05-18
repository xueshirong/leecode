package org.leecode;

public class Reverse_Integer {
	//check overflow
	public int reverse(int x) {
		int res = 0;
        while (x != 0){
            int temp = res * 10 + x % 10;            
            
            if ((temp - x % 10)/10 != res)//check overflow
                return 0;
            x = x / 10;
            res = temp;
        }
        return res;
    }
	
	//09/03/2016  use long to store resule
	public int reverse3(int x) {
        int single = 1;
        if (x < 0){
            single = -1;
            x = -1 * x;
        }
        long res = 0;
        while (x > 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        res = single * res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int)res;
    }
}
