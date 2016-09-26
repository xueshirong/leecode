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
	
	//binary search
	public int searchInsert3(int[] nums, int target) {
		int l = 0;
        int r = nums.length-1;
        while(l <= r) {
            int mid = (l + r)/2; 
            if(target == nums[mid]) return mid;
            if(target < nums[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
