package org.leecode;

public class Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length -1] = 1;
        for (int i = 1; i < length; i++)//record all left product value
            left[i] = left[i - 1] * nums[i - 1];
        for (int i = length -2; i > -1; i--)//record all right product value
            right[i] = right[i + 1] * nums[i + 1];
        
        for (int i = 0; i < length; i++)//calculate every element
            right[i] = right[i] * left[i];
        
        return right;
	}
	
	//1. get all product for all nums
    //2. use total product to divide each num
    public int[] productExceptSelf1(int[] nums) {
    	int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i > -1; i--){
            res[i] = res [i + 1] * nums[i + 1];
        }
        return res;
    }
}
