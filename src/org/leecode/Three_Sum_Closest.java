package org.leecode;

import java.util.Arrays;

public class Three_Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if (nums.length <= 3){
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
            }
            return sum;
        }
        Arrays.sort(nums);
        sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target){
                    return temp;
                }else if (temp < target){
                    left++;
                }else{
                    right--;
                }
                
                if (Math.abs(target - temp) < Math.abs(target - sum)){
                    sum = temp;
                }
            }
        }
        return sum;
    }
	
	public int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target){
                    return temp;
                }else if (temp < target){
                    left++;
                }else{
                    right--;
                }
                
                if (Math.abs(target - temp) < Math.abs(target - sum)){
                    sum = temp;
                }
            }
        }
        return sum;
    }
	
	public int threeSumClosest3(int[] nums, int target) {
		if (nums == null || nums.length < 3)
            return -1;
        
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];//base line value
        for(int i = 0; i < nums.length; i++){
            //if (i != 0 && nums[i] == nums[i - 1])
            //    continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target){
                    return sum;
                }else if (sum > target){
                    r--;                    
                }else{
                    l++;                    
                }
                if (Math.abs(target - sum) < Math.abs(target - res))//compare current sum with base line
                	res = sum;
            }
        }
        return res;
    }
}
