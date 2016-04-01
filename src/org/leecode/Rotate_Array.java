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
}
