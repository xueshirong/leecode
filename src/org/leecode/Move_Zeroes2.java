package org.leecode;

public class Move_Zeroes2 {
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
	
	public void moveZeroes2(int[] nums) {
        int l = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
        }
    }
}
