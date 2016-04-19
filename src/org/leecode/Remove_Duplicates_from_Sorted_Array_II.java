package org.leecode;

public class Remove_Duplicates_from_Sorted_Array_II {
	public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
        	return nums.length;
		int j = 1;
        for (int i = 2; i < nums.length; i++){
        	if (nums[j - 1] != nums[i]){
        		nums[j + 1] = nums[i];
        		j++;
        	}
        }
		return j + 1;
    }
}
