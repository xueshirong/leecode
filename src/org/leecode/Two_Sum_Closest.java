package org.leecode;

import java.util.Arrays;

public class Two_Sum_Closest {
	//Given an array nums of n integers, 
	//find two integers in nums such that the sum is closest to a given number, target.

	//Return the difference between the sum of the two integers and the target.
	/**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        int dif = Integer.MAX_VALUE;
        int i = 0, j = nums.length - 1;
        while (i < j){
            int sum = nums[i] + nums[j];
            if (sum < target){
                dif = Math.min(dif, target - sum);
                i++;
            }else if (sum > target){
                dif =  Math.min(dif, sum - target);
                j--;
            }else
                return 0;
        }
        return dif;
    }
}
