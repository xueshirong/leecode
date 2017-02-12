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
	
	//binary search
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int s = 1, e = x;
        while (s + 1 < e){
            int mid = s + (e - s)/2;
            
            if (x/mid == mid){//use x/mid in order to avoid overflow
                return mid;
            }else if(x/mid > mid){
                s = mid;
            }else
                e = mid;
        }
        if (s <= x/s)
            return s;
        if (e <= x/e)
            return e;
        return 0;
    }
}
