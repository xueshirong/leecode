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
    
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int l = 0;
        int i =0;
        int r = nums.length - 1;
        while(i < r){
            if (nums[i] == 0){
                swap(nums, i, l);
                l++;
                i++;
            }
            else if(nums[i] == 2){
                swap(nums, i, r);
                r--;
            }else
            	i++;
            
        }        
    }
    
}
