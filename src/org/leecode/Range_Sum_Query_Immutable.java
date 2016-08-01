package org.leecode;

public class Range_Sum_Query_Immutable {
	int[] nums;

    public Range_Sum_Query_Immutable(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++){
            this.nums[i] = this.nums[i - 1] + this.nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return this.nums[j];
        return this.nums[j] - this.nums[i - 1];
    }
}
