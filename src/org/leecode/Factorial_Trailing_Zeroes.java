package org.leecode;

public class Factorial_Trailing_Zeroes {
	public int trailingZeroes(int n) {
		 int num = 0;
	        while(n/5 >0){
	            n = n/5;
	            num += n;
	        }
	        
	        return num;
    }
}
