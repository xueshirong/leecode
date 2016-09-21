package org.leecode;

public class Sort_Colors {
	//From Jiu Zhang
	public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int l = 0;//left border of 1
        int r = nums.length - 1;//right border of 1
        int i = 0;//current index;
        while(i <= r){//watch "="
            if (nums[i] == 0){
                swap(nums, l, i);
                i++;
                l++;
            }else if (nums[i] == 2){
                swap(nums, r, i);
                r--;
            }else{
                i++;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
