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
	
	//a[n] = a[n-1]+a[n-2];
    public int climbStairs2(int n) {//use DP
        if (n < 2)
            return 1;
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++){
            res[i] = res[i - 1] + res[i -2];
        }
        
        return res[n - 1];
    }
}
