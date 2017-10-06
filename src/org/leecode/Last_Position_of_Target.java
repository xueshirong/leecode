package org.leecode;

public class Last_Position_of_Target {

	public static void main(String[] args) {
		lastPosition(new int[]{1,2,2,4,5,5}, 5);
		
	}
	public static int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int s = 0, e = nums.length - 1;
        while (s + 1 < e){
            int mid = s + (e - s)/2;
            if (nums[mid] == target){
                s = mid;
            }else if (nums[mid] < target){
                s = mid;
            }else{
                e = mid;
            }
        }
        if (nums[e] == target)
            return e;
        if (nums[s] == target)
            return s;
        return -1;
    }
}
