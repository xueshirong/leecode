package org.leecode;

public class Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		 int index = -1;
	        for(int i = 0; i < nums.length; i++){
	            if (nums[i] >= target){
	                index = i;
	                break;
	            }
	        }
	      return nums.length;
    }
	
	public int searchInsert2(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
