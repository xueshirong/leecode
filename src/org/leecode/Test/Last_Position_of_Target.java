package org.leecode.Test;

public class Last_Position_of_Target {
	/*Find the last position of a target number in a sorted array. 
	Return -1 if target does not exist.*/
	/**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0)
            return -1;
        int s = 0, e = nums.length - 1;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (nums[mid] <= target)
                s = mid;
            else
                e = mid;
        }
        if (nums[e] == target)
            return e;
        else if(nums[s] == target)
            return s;
        return -1;
    }
}
