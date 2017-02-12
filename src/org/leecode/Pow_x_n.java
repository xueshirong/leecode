package org.leecode;

public class Pow_x_n {
	// binary search. calculate the half power every time
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0)
            return 1.0 / pow(x, -1 * n);
        else
            return pow(x, n);
    }
    double pow(double x, int n){
    	if(n == 0)// end condition for recursive
    		return 1;
        double res = pow(x, n / 2);
        if (n % 2 == 0)
            return res * res;
        else
            return res * res * x;
    }
}
