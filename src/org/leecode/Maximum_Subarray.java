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
}
