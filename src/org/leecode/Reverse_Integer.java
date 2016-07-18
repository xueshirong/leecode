package org.leecode;

public class Reverse_Integer {
	public int reverse(int x) {
        if(x == 0)
            return x;
        int sign = 1;
        if (x < 0){
            sign = -1;
            x = x * -1;
        }
        int temp = 0;
        while (x > 0){
            if (temp > (Integer.MAX_VALUE - x % 10)/10)//check overflow
                return 0;
            temp = temp * 10 + x % 10;
            x = x/10;
        }
        
        return temp * sign;
		
    }
	public int reverse2(int x){
		long tmp=0;
        while(x != 0)
        {
            tmp *=10;
            tmp += x%10;
            if(tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int)tmp;
	}
}
