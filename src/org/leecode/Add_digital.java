package org.leecode;

public class Add_digital {
	//Congruence formula:dr(n) = 1 + ((n-1)mod 9)
    //To generalize the concept of digital roots to other bases b, one can simply change the 9 in the formula to b - 1.
	public int addDigits(int num) {
		int dr = 1 + ((num-1) % 9);
		return dr;
    }
}