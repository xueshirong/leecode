package org.leecode;

public class Find_Minimum_in_Rotated_Sorted_Array {
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
}
