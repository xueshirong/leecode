package org.leecode;

public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (sum > 0){
                sum = sum + nums[i];
            }else{
                total = Math.max(total, sum);
                sum = nums[i];
            }
        }
        total = Math.max(total,sum);
        return total;
    }
	
	//-------------------
	//Given an array of integers, find a contiguous subarray which has the largest sum.
	/**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray3(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minsum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minsum);
            minsum = Math.min(minsum, sum);
        }
        return max;
    }
}
