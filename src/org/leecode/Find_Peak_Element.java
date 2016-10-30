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
	
	public int findPeakElement2(int[] A) {
		int start = 0, end = A.length-1; // 1.答案在之间，2.不会出界 
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else { 
            return start;
        }
    }
}
