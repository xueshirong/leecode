package org.leecode;

public class Search_for_a_Range {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0)
            return new int[]{-1,-1};
        int[] res = new int[2];
        int l = 0;
        int r = nums.length - 1;
        //left bound
        while(l + 1 < r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target)
                r = mid;
            else if (nums[mid] < target)
                l = mid;
            else
                r = mid;
        }
        if (nums[l] == target)
            res[0] = l;
        else if (nums[r] == target)
            res[0] = r;
        else
            return new int[]{-1,-1};
        //right bound
        l = 0;
        r = nums.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l)/2;
            if (nums[mid] == target)
                l = mid;
            else if (nums[mid] < target)
                l = mid;
            else
                r = mid;
        }
        if (nums[r] == target)
            res[1] = r;
        else if (nums[l] == target)
            res[1] = l;
        else
            return new int[]{-1,-1};
            
        return res;
    }
}
