package org.leecode;

public class Search_in_Rotated_Sorted_Array {
	//From Jiu Zhang
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int s = 0;
        int e = nums.length - 1;
        while (s + 1 < e){
            int mid = s + (e - s)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[s] <= nums[mid]){
                if (nums[s] <= target && target <= nums[mid])
                    e = mid;
                else
                    s = mid;
            }else{
                if (nums[mid] <= target && nums[e] >= target)
                    s = mid;
                else 
                    e = mid;
            }
        }
        if (nums[s] == target)
            return s;
        else if (nums[e]== target)
            return e;
        return -1;
    }
}
