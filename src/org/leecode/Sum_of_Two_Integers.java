package org.leecode;

public class Sum_of_Two_Integers {
	//not understand
	public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;// carry now contains common set bits of x and y
            a = a ^ b;// Sum of bits of x and y where at least one of the bits is not set
            b = carry << 1;// Carry is shifted by one so that adding it to x gives the required sum
        }
        return a;
    }
}
