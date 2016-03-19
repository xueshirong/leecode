package org.leecode;

public class Move_Zeroes {
	public int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++){//move all non-negative to front
        	if (nums[i] != 0){
            	Integer tem = nums[i];
            	nums[i] = nums[j];
            	nums[j] = tem;            	
                j++;
                
            }
        }
        return nums;
	}
}
