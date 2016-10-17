package org.leecode;

public class Missing_Number {
	public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        int total = (nums.length + 1) * (0 + nums.length)/2;// n*(a1 + an)/2
        int mis = total - sum;
        return mis;
    }
	
	 //bitwise
    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }
    
    //arithmetic progression 
    public int missingNumber3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int newSum = nums.length * (nums.length + 1)/2;
        return newSum - sum;
    }
}
