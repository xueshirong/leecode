package org.leecode;

public class House_Robber {
	public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int lastMax = nums[0];
        int curMax = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            int temp = curMax;
            curMax = Math.max(lastMax + nums[i], curMax);
            lastMax = temp;
        }
        return curMax;
    }
}
