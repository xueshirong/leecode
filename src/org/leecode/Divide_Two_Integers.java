package org.leecode;

public class Divide_Two_Integers {
	/**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
	//brute force: 循环中，每次减去b,计算循环的次数。会超时。
    //注意corner case.
    public int divide2(int dividend, int divisor){
        if (dividend == 0)
            return 0;
        if (divisor == 0){
            if (dividend > 0)   return Integer.MAX_VALUE;
            if (dividend < 0)   return Integer.MIN_VALUE;
        }
        if (divisor == 1) return dividend;
        
        /*if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;*/
            
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            flag = -1;
        long res = 0;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);//key point. change to long
        while (a >= b){
            res++;
            a = a - b;
        }
        return (int)(flag * res);
    }
    
    //from jiu zhang: binary search. 每次讲b翻倍后，用a去减，直到找到离a最近的b的倍数。
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {//key corner case, hard to remember
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || 
                             (dividend > 0 && divisor < 0);
                             
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result: result;
    }
    
    public int divide1(int dividend, int divisor) {//note: Math.abs(Integer.MIN_VALUE) 仍是Integer.MIN_VALUE，负的
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
        while(a >= b){//向左移1位，相当于乘2
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
