package org.leecode;
/*
 * 当A[end-1] = A[end] = A[i]时，A[i]为重复元素需跳过。而实际只需要比较A[end-1]和A[i]，
 * 因为当A[end-1] = A[i]时，根据sorted arry特性必然也有A[end]=A[end-1]。
*/
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
