package org.leecode;

public class Find_Minimum_in_Rotated_Sorted_Array {
	/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	Find the minimum element.
	You may assume no duplicate exists in the array.*/
	public int findMin(int[] nums) {
		int start = 0;
        int end = nums.length - 1;
        while(start < end){
        	int mid = (start + end)/2;
        	if (nums[mid] < nums[end]){//mid < end, it means part2 is in order, should find min in part1
        		end = mid;
        	}else{//mid > end, it means part2 is not in order, should find min in this part
        		start = mid + 1;
        	}
        }
        return nums[start];
    }
	
	public int findMin2(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && i != nums.length - 1 && nums[i] < nums[i-1] && nums[i] < nums[i + 1])
                return nums[i];
        }
        if (nums[0] <= nums[nums.length -1])
            return nums[0];
        return nums[nums.length -1];
    }
}
