package org.leecode;

public class Move_Zeroes {
	public int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++){//make all non-zero number to the front
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
        for (int k = j; k < nums.length; k++){
            nums[k] = 0;
        }
        return nums;
	}
}
