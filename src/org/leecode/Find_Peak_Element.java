package org.leecode;

public class Find_Peak_Element {
	//From Jiu Zhang
	public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int s = 0;
        int e = nums.length - 1;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (mid == 0 || mid == nums.length - 1)
                continue;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                e = mid;
            else if (nums[mid] < nums[mid - 1])
                e = mid;
            else
                s = mid;
        }
        
        if (nums[s] < nums[e])
            return e;
        else
            return s;
    }
}
