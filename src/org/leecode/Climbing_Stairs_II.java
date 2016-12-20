package org.leecode;

public class Climbing_Stairs_II {
	//A child is running up a staircase with n steps, 
	//and can hop either 1 step, 2 steps, or 3 steps at a time. 
	//Implement a method to count how many possible ways the child can run up the stairs.
	/**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        //corner case
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;    
        if (n == 3)
            return 4;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        f[3] = 4;
        for (int i = 4; i < n+1; i++){
            f[i] = f[i-1] + f[i-2] + f[i-3];
        }
        return f[n];
    }
}
