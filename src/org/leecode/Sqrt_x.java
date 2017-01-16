package org.leecode;

public class Sqrt_x {
	public int sqrt(int x) {
		int left = 1, right = x;
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (mid * mid <= x)
                left = mid;
            else{
                right = mid;
            }
        }
        
        return left;
    }
}
