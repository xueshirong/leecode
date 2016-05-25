package org.leecode;

public class Climbing_Stairs {
	//a[n] = a[n-1]+a[n-2];
	public int climbStairs(int n) {
        if (n < 3) return n;
        
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
