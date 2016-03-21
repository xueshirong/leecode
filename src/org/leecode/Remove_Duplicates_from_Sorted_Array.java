package org.leecode;

public class Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
        if (nums.length < 2){
            return 1;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[j] != nums[i]){
                nums[j+1] = nums[i];
                j++;
            }
        }
        return j+1;
    }
}
