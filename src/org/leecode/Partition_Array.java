package org.leecode;

public class Partition_Array {
	//Given an array nums of integers and an int k, 
	//partition the array (i.e move the elements in "nums") such that:
	//All elements < k are moved to the left
	//All elements >= k are moved to the right
	//Return the partitioning index, i.e the first index i nums[i] >= k.
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
	//similar to "sort color"
    public int partitionArray(int[] nums, int k) {
	    //corner case
	    if (nums == null || nums.length < 2)
	        return 0;
	    int left = 0, i = 0, r = nums.length - 1;
	    while(i <= r){
	        if (nums[i] >= k){
	            i++;
	        }else{
	            swap(nums, left, i);
	            left++;
	        }
	    }
	    return left;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //solution 2
    public int partitionArray2(int[] nums, int k) {
	    //corner case
	    if (nums == null || nums.length == 0)
	        return 0;
	    int left = 0, r = nums.length - 1;
	    while(left <= r){
	        while (left <= r && nums[left] < k)
	            left++;
	        while(left <= r && nums[r] >= k)
	            r--;
	        if (left <= r){
	            swap(nums, left, r);
	        }
	    }
	    return left;
    }
}
