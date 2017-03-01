package org.leecode.Test;

public class Water_and_Jug_Problem {
	//思路: 1. z必须小于x, y的最大的一个. 2. z必须可以除尽x和y的最大公约数.
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if (x + y >= z && z % gcd(x, y) == 0) 
        	return true;
        
        return false;
    }
    private int gcd(int x, int y)
    {
        if (y == 0) return x;
        int res = gcd(y, x%y);
        return res;
    }
}
