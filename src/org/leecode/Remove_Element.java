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
	//refer to the 26 "Remove Duplicates from Sorted Array"
	public int removeElement2(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[len] = nums[i];
                len++;
            }
        }
        return len++;
    }
}
