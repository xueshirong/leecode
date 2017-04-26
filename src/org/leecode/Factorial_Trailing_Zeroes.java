package org.leecode;

public class Factorial_Trailing_Zeroes {
	//技巧在于，每5个数会产生一个0
    //iterator
    public int trailingZeroes1(int n) {
        int num = 0;
        while(n/5 >0){
            // 阶乘中有多少5，结果就有多少个0
            n = n/5;
            num += n;
        }
        
        return num;
    }
    
    //recursion
    public int trailingZeroes(int n) {
        if(n == 0)
            return 0;
        else
            return n/5 + trailingZeroes(n/5);
    }
}
