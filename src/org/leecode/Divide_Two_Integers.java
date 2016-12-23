package org.leecode;

public class Divide_Two_Integers {
	/**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        //corner case
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else if (dividend < 0)
                return Math.abs(dividend);
            else if (dividend > 0)
                return -1 * dividend;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = 0;
        while(a >= b){
            res++;
            a = a - b;
        }
        
        if (isNegative)
            res = -1 * res;
        
        return res;
    }
    //solution 2 from Jiu Zhang
    public int divide2(int dividend, int divisor) {
        //corner case
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else if (dividend < 0)
                return Math.abs(dividend);
            else if (dividend > 0)
                return -1 * dividend;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){//将b翻倍，直到最接近a，shift计算翻了多少倍。如100/9，shift=4,应该翻了2^(4-1)=8倍
                shift++;
            }
            res += 1 << (shift - 1);//保存翻得倍数。8
            a = a - (b << (shift - 1));//将b翻倍后的值从a中减掉，然后继续对a剩下的值循环
        }
        
        if (isNegative)
            res = -1 * res;
        
        return res;
    }
}
