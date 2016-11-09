package org.leecode;

public class Jump_Game {
	//Given an array of non-negative integers, 
	//you are initially positioned at the first index of the array.
	//Each element in the array represents your maximum jump length at that position.
	//Determine if you are able to reach the last index.
	/**
     * @param A: A list of integers
     * @return: The boolean answer
     */
	//Dynamic Programming. will cause time limit exceeded
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0)
            return true;
        boolean[] path = new boolean[A.length];
        path[0] = true;
        for (int i = 1; i < A.length; i++){
            for (int j = 0; j < i; j++){
                if (path[j] && j + A[j] >= i)
                    path[i] = true;
            }
        }
        return path[A.length - 1];
    }
    //greedy
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int index = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (index > i && index < nums[i] + i)
                index = nums[i] + i;
        }
        if (index >= nums.length - 1)
            return true;
        return false;
    }
}
