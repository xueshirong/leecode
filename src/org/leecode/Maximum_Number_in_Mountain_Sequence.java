package org.leecode;

public class Maximum_Number_in_Mountain_Sequence {
	//Given a mountain sequence of n integers which increase firstly and then decrease, 
	//find the mountain top.
	/**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int s = 0, e = nums.length - 1;
        while (s + 1 < e){
            int mid = s + (e -s)/2;
            if (nums[mid] < nums[mid + 1])
                s = mid;
            else if (nums[mid] > nums[mid + 1])
                e = mid;
            else
                e = mid;
        }
         if (nums[s] > nums[e])
            return nums[s];
        return nums[e];
    }
}
