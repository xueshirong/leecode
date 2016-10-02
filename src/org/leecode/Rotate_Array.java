package org.leecode;

public class Rotate_Array {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
        if (k % n == 0)
            return;
        k = k%n;
        int[] temps = new int[n];
        for(int i = k - 1; i > -1; i--){
            temps[i] = nums[n -1];
            n--;
        }
        for(int i = k; i < temps.length; i++){
            temps[i] = nums[i - k];
        }
        for(int i = 0; i < nums.length -1; i++){
            nums[i] = temps[i];
        }        
    }
	//From Jiu Zhang
	public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k%nums.length == 0)
            return;
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    private void reverse(int[] nums, int l, int r){
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
