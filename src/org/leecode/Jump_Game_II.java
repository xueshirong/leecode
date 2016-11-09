package org.leecode;

public class Jump_Game_II {
	//Given an array of non-negative integers, 
	//you are initially positioned at the first index of the array.

	//Each element in the array represents your maximum jump length at that position.
	//Your goal is to reach the last index in the minimum number of jumps.
	/**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if(A == null || A.length == 0)
            return 0;
         int[] path = new int[A.length];
        path[0] = 0;
        for (int i = 1; i < A.length; i++){
            path[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i < A.length; i++){
            for (int j = 0; j < i; j++){
                if (path[j] != Integer.MAX_VALUE && A[j] + j >= i)
                    path[i] = Math.min(path[i], path[j] + 1);
            }
        }
        return path[A.length - 1];
        
    }
}
