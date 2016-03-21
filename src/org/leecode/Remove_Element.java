package org.leecode;

public class Remove_Element {
	//refer to the "Move Zeroes". almost the same
	//but I still can not remove the target value from array
	public int removeElement(int[] nums, int val) {
        Integer j = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                Integer tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
                j++;
            }
        }
        return j;
    }
}
