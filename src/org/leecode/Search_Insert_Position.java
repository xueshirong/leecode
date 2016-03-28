package org.leecode;

public class Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
        int index = -1;
        boolean isFind = true;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                index = i;
                isFind = false;
                break;
            }
            if (isFind && nums[i] > target){
                index = i;
                isFind = false;
            }
        }
        if (isFind)
            index = nums.length;
        return index;
    }
}
