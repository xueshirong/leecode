package org.leecode;

public class First_Position_of_Target {
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
	//From Jiu Zhang
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0)
            return -1;
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r){
        	int mid = l + (r - l)/2;
        	if (nums[mid] == target)
        		r = mid;//can't return mid here, should continue to find the 1st one
        	else if (nums[mid] > target)
        		r = mid;
        	else
        		l = mid;
        }
        if (nums[l] == target)
        	return l;
        return -1;
    }
}
